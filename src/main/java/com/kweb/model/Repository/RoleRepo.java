package com.kweb.model.Repository;

import com.kweb.config.constant.UserRoles;
import com.kweb.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by bjh970913 on 05/12/2016.
 * spring-board
 */
public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(UserRoles name);
}
