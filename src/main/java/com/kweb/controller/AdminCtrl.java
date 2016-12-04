package com.kweb.controller;

import com.kweb.model.Board;
import com.kweb.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bjh970913 on 05/12/2016.
 * spring-board
 */
@RestController
public class AdminCtrl {
    private BoardService boardService;

    @Autowired
    public AdminCtrl(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping(value = "/admin/board/add", produces = "application/json")
    @ResponseBody
    public Boolean boardAdd(@RequestParam("name") String name) {
        return boardService.addBoard(name);
    }
}
