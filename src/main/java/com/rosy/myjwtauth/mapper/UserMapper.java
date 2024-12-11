package com.rosy.myjwtauth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rosy.myjwtauth.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户表(User)表数据库访问层
 *
 * @author rosy
 * @since 2024-12-09 15:21:24
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<Long> getRoleIdsByUserId(Long userId);
}

