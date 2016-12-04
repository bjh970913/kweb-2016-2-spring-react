package com.kweb.model;

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
public class Board {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @OneToMany(targetEntity = Post.class)
    private Set<Post> posts = new HashSet<>();
}
