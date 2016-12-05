package com.kweb.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.kweb.config.jsonView.PostOV;
import com.kweb.model.Abstract.UserDetailsAbstract;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by bjh970913 on 05/12/2016.
 * spring-board
 */
@Data
@Entity
public class User extends UserDetailsAbstract {
    @Id
    @GeneratedValue
    @JsonView(PostOV.postView.class)
    private long id;

    @Column
    @JsonView(PostOV.postView.class)
    private String email;

    @Column
    private String passwordHash;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            joinColumns = {@JoinColumn(table = "User")},
            inverseJoinColumns = {@JoinColumn(table = "Role")}
    )
    private Set<Role> userRoles = new HashSet<>();
}
