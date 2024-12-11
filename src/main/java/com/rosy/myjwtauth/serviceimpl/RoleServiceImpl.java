package com.rosy.myjwtauth.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rosy.myjwtauth.domain.entity.Menu;
import com.rosy.myjwtauth.domain.entity.Role;
import com.rosy.myjwtauth.mapper.RoleMapper;
import com.rosy.myjwtauth.service.MenuService;
import com.rosy.myjwtauth.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色表(Role)表服务实现类
 *
 * @author rosy
 * @since 2024-12-11 20:56:01
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Autowired
    MenuService menuService;

    @Override
    public List<String> getRolesPermissionsByRoleIds(List<Long> roleIds) {
        List<Long> permissionIds = baseMapper.getRolesPermissionIdsByRoleIds(roleIds);
        LambdaQueryWrapper<Menu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(Menu::getId, permissionIds);
        queryWrapper.select(Menu::getMenuName);
        return menuService.list(queryWrapper)
                .stream()
                .map(Menu::getMenuName)
                .collect(Collectors.toList());
    }
}

