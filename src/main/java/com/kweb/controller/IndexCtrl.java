package com.kweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by bjh970913 on 05/12/2016.
 * spring-board
 */
@Controller
public class IndexCtrl {
    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "admin";
    }
}
