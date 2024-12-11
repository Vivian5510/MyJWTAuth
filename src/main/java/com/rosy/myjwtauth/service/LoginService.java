package com.rosy.myjwtauth.service;

import com.rosy.myjwtauth.domain.entity.User;

public interface LoginService {
    String login(User user);

    String logout();
}
