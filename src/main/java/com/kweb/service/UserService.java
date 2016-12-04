package com.kweb.service;

import com.kweb.config.constant.UserRoles;
import com.kweb.model.Repository.UserRepo;
import com.kweb.model.Role;
import com.kweb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.token.Sha512DigestUtils;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by bjh970913 on 05/12/2016.
 * spring-board
 */
@Service
public class UserService {
    private UserRepo userRepo;
    private RoleService roleService;

    @Autowired
    public UserService(UserRepo userRepo, RoleService roleService) {
        this.userRepo = userRepo;
        this.roleService = roleService;
    }

    public boolean createUser(String email, String password) {
        if (userRepo.findByEmail(email) != null) {
            return false;
        }

        password = Sha512DigestUtils.shaHex(password);

        User user = new User();
        user.setEmail(email);
        user.setPasswordHash(password);

        Set<Role> role = new HashSet<>();

        role.add(roleService.getRole(UserRoles.ROLE_USER));
        user.setUserRoles(role);

        userRepo.saveAndFlush(user);

        return true;
    }

    public User getUserByEmailAndPasswordHash(String email, String passwordHash) {
        return userRepo.findByEmailAndPasswordHash(email, passwordHash);
    }
}
