package com.kweb.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.kweb.config.jsonView.BoardOV;
import com.kweb.model.Board;
import com.kweb.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @Autowired
    public BoardCtrl(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping(name="/board", produces = "application/json")
    @ResponseBody
    @JsonView(BoardOV.list.class)
    public List<Board> getBoards() {
        return boardService.getBoardList();
    }
}
