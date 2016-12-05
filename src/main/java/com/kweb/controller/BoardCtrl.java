package com.kweb.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.kweb.config.jsonView.BoardOV;
import com.kweb.config.jsonView.PostOV;
import com.kweb.model.Board;
import com.kweb.model.Post;
import com.kweb.service.BoardService;
import com.kweb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * Created by bjh970913 on 05/12/2016.
 * spring-board
 */
@RestController
public class BoardCtrl {
    private BoardService boardService;
    private PostService postService;

    @Autowired
    public BoardCtrl(BoardService boardService, PostService postService) {
        this.boardService = boardService;
        this.postService = postService;
    }

    @GetMapping(value = "/board/list", produces = "application/json")
    @ResponseBody
    @JsonView(BoardOV.list.class)
    public List<Board> getBoards() {
        return boardService.getBoardList();
    }

    @GetMapping(value = "/board/post/{boardId}", produces = "application/json")
    @ResponseBody
    @JsonView(PostOV.postSet.class)
    public Set<Post> getBoardPosts(@PathVariable("boardId") long boardId) {
        return postService.getPostsByBoardId(boardId);
    }
}
