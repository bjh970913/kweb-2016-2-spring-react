package com.kweb.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.kweb.config.jsonView.BoardOV;
import com.kweb.config.jsonView.PostOV;
import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnore;

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
    @JsonView({BoardOV.list.class, PostOV.postView.class})
    private long id;

    @Column
    @JsonView({BoardOV.list.class, PostOV.postView.class})
    private String name;
}
