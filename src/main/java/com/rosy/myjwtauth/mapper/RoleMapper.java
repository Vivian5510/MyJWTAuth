package com.rosy.myjwtauth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rosy.myjwtauth.domain.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 角色表(Role)表数据库访问层
 *
 * @author rosy
 * @since 2024-12-11 20:56:01
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    List<Long> getRolesPermissionIdsByRoleIds(List<Long> roleIds);
}

