package com.rosy.myjwtauth.serviceimpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rosy.myjwtauth.domain.entity.User;
import com.rosy.myjwtauth.mapper.UserMapper;
import com.rosy.myjwtauth.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户表(User)表服务实现类
 *
 * @author rosy
 * @since 2024-12-09 15:21:22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

