package com.rosy.myjwtauth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rosy.myjwtauth.domain.entity.Role;

import java.util.List;

/**
 * 角色表(Role)表服务接口
 *
 * @author rosy
 * @since 2024-12-11 20:56:01
 */

public interface RoleService extends IService<Role> {
    List<String> getRolesPermissionsByRoleIds(List<Long> roleIds);
}

