package com.kweb.model.Repository;

import com.kweb.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by bjh970913 on 05/12/2016.
 * spring-board
 */
public interface PostRepo extends JpaRepository<Post, Long> {

}