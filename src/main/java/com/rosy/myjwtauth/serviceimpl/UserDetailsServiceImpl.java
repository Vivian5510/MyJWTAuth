package com.rosy.myjwtauth.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rosy.myjwtauth.domain.UserDetailsImpl;
import com.rosy.myjwtauth.domain.entity.User;
import com.rosy.myjwtauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username:" + username);
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName, username);
        User loginUser = userService.getOne(queryWrapper);
        if (loginUser == null) {
            throw new UsernameNotFoundException("用户名或者密码错误！");
        }
        //TODO 根据用户信息查询对应的权限信息

        return new UserDetailsImpl(loginUser);
    }
}
