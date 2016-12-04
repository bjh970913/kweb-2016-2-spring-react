package com.kweb.service;

import com.kweb.config.constant.UserRoles;
import com.kweb.model.Repository.RoleRepo;
import com.kweb.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by bjh970913 on 05/12/2016.
 * spring-board
 */
@Service
public class RoleService {
    private RoleRepo roleRepo;

    @Autowired
    public RoleService(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    public Role getRole(UserRoles userRoles) {
        Role role = roleRepo.findByName(userRoles);

        if (role == null) {
            role = new Role(userRoles);
            roleRepo.saveAndFlush(role);
            return role;
        }

        return role;
    }
}
