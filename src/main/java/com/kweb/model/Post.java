package com.kweb.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by bjh970913 on 05/12/2016.
 * spring-board
 */
@Data
@Entity
public class Post {
    @Id
    @Column(name = "PostId")
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "boardId")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User author;

    @Column
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;
}
