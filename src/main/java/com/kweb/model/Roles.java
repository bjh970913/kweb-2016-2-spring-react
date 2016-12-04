package com.kweb.model;

import com.kweb.config.security.ROLES;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by bjh970913 on 05/12/2016.
 * spring-board
 */
@Data
@Entity
public class Roles {
    @Id
    private long id;

    @Column
    @Enumerated(EnumType.STRING)
    private ROLES nameOfRole;
}
