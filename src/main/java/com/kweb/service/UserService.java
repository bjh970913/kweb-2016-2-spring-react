package com.kweb.service;

import com.kweb.model.Repository.UserRepo;
import com.kweb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.token.Sha512DigestUtils;
import org.springframework.stereotype.Service;

/**
 * Created by bjh970913 on 05/12/2016.
 * spring-board
 */
@Service
public class UserService {
    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public boolean createUser(String email, String password) {
        if (userRepo.findByEmail(email) != null) {
            return false;
        }

        password = Sha512DigestUtils.shaHex(password);

        User user = new User();
        user.setEmail(email);
        user.setPasswordHash(password);
        userRepo.saveAndFlush(user);

        return true;
    }

    public User getUserByEmailAndPasswordHash(String email, String passwordHash) {
        return userRepo.findByEmailAndPasswordHash(email, passwordHash);
    }
}
