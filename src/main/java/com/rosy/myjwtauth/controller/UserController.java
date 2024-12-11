package com.rosy.myjwtauth.controller;


import com.rosy.myjwtauth.domain.entity.User;
import com.rosy.myjwtauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/test")
    @PreAuthorize("hasAuthority('用户管理')")
    public List<User> UserControllerTest() {
        return userService.list();
    }
}
