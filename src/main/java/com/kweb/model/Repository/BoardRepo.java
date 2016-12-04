package com.kweb.model.Repository;

import com.kweb.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by bjh970913 on 05/12/2016.
 * spring-board
 */
public interface BoardRepo extends JpaRepository<Board, Long> {
    Board findByName(String name);
}
