package com.kweb.service;

import com.kweb.model.Board;
import com.kweb.model.Repository.BoardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by bjh970913 on 05/12/2016.
 * spring-board
 */
@Service
public class BoardService {
    private BoardRepo boardRepo;

    @Autowired
    public BoardService(BoardRepo boardRepo) {
        this.boardRepo = boardRepo;
    }

    public List<Board> getBoardList() {
        return boardRepo.findAll();
    }
}
