package com.kweb.service;

import com.kweb.model.Board;
import com.kweb.model.Repository.BoardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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

    public Board getBoardById(long id) {
        return boardRepo.findById(id);
    }

    public boolean addBoard(String name) {
        Board board = boardRepo.findByName(name);
        if (board != null) {
            return false;
        }

        board = new Board();
        board.setName(name);

        boardRepo.saveAndFlush(board);

        return true;
    }

    public boolean removeBoard(long id) {
        Board board = boardRepo.findById(id);
        if (board != null) {
            return false;
        }

        boardRepo.delete(board);

        return true;
    }
}
