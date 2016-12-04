package com.kweb.model.Repository;

import com.kweb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by bjh970913 on 05/12/2016.
 * spring-board
 */
public interface UserRepo extends JpaRepository<User, Long>{
    User findByEmail(String email);
    User findByEmailAndPasswordHash(String email, String passwordHash);
}
