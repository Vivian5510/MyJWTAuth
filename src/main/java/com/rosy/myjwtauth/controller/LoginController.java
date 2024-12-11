package com.rosy.myjwtauth.controller;

import com.rosy.myjwtauth.domain.ResponseResult;
import com.rosy.myjwtauth.domain.entity.User;
import com.rosy.myjwtauth.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping("/user/login")
    public ResponseResult<Map<String, String>> login(@RequestBody User user) {
        String jwt = loginService.login(user);
        return ResponseResult.okResult(Map.of("token", jwt));
    }

    @RequestMapping("user/logout")
    public ResponseResult<String> logout() {
        String username = loginService.logout();
        return ResponseResult.okResult(username);
    }
}
