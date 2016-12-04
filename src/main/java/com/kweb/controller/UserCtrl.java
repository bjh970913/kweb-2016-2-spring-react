package com.kweb.controller;

import com.kweb.form.UserJoinForm;
import com.kweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * Created by bjh970913 on 05/12/2016.
 * spring-board
 */
@Controller
public class UserCtrl {
    private UserService userService;

    @Autowired
    public UserCtrl(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLoginForm() {
        return "login";
    }

    @GetMapping("join")
    public String getJoin(UserJoinForm userJoinForm) {
        return "join";
    }

    @PostMapping("join")
    public String generalRegisterHandler(@Valid UserJoinForm userJoinForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "join";
        }

        String email = userJoinForm.getEmail();
        String password = userJoinForm.getPassword();

        if (userService.createUser(email, password)) {
            return "redirect:/login";
        } else {
            bindingResult.addError(new ObjectError("EmailDup", "Email already registed!!"));
            System.out.println("Email duplicated!");
            return "join";
        }
    }
}
