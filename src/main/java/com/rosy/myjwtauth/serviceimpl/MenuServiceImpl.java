package com.rosy.myjwtauth.serviceimpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rosy.myjwtauth.domain.entity.Menu;
import com.rosy.myjwtauth.mapper.MenuMapper;
import com.rosy.myjwtauth.service.MenuService;
import org.springframework.stereotype.Service;

/**
 * 菜单表(Menu)表服务实现类
 *
 * @author rosy
 * @since 2024-12-11 21:14:49
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
}

