package com.kweb.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.kweb.config.jsonView.PostOV;
import com.kweb.model.Post;
import com.kweb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by bjh970913 on 05/12/2016.
 * spring-board
 */
@RestController
public class PostCtrl {
    private PostService postService;

    @Autowired
    public PostCtrl(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value = "/post/{id}", produces = "application/json")
    @ResponseBody
    @JsonView(PostOV.postView.class)
    public Post getPost(@PathVariable("id") long id) {
        return postService.getPostById(id);
    }

    @PostMapping(value = "/post/write", produces = "application/json")
    @ResponseBody
    @JsonView(PostOV.postView.class)
    public Post postPost(@RequestParam("boardId") long boardId, @RequestParam("title") String title, @RequestParam("content") String content) {
        return postService.writePost(boardId, title, content);
    }
}
