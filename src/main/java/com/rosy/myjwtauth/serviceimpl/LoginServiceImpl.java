package com.rosy.myjwtauth.serviceimpl;

import cn.hutool.jwt.JWTUtil;
import com.rosy.myjwtauth.domain.UserDetailsImpl;
import com.rosy.myjwtauth.domain.entity.User;
import com.rosy.myjwtauth.service.LoginService;
import com.rosy.myjwtauth.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private RedisUtils redisUtils;

    @Override
    public String login(User user) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
        if (authentication == null) {
            throw new UsernameNotFoundException("用户名或密码错误！");
        }
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        Long userId = userDetails.getUser().getId();
        String jwt = JWTUtil.createToken(
                Map.ofEntries(
                        Map.entry("sub", userId),
                        Map.entry("expire_time", System.currentTimeMillis() + 1000 * 60 * 60)
                ),
                "Rosy".getBytes()
        );
        redisUtils.setCacheObject("login:" + userId, userDetails);
        return jwt;
    }

    @Override
    public String logout() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long userId = userDetails.getUser().getId();
        redisUtils.deleteObject("login:" + userId);
        return userDetails.getUser().getUserName();
    }
}
