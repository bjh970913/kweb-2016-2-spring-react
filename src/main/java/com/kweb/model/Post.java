package com.kweb.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.kweb.config.jsonView.PostOV;
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
    @JsonView({PostOV.postSet.class, PostOV.postView.class})
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @JsonView(PostOV.postView.class)
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @JsonView({PostOV.postSet.class, PostOV.postView.class})
    private User author;

    @Column
    @JsonView({PostOV.postSet.class, PostOV.postView.class})
    private String title;

    @Column(columnDefinition = "TEXT")
    @JsonView({PostOV.postView.class})
    private String content;
}
