package com.rosy.myjwtauth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rosy.myjwtauth.domain.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

/**
 * 菜单表(Menu)表数据库访问层
 *
 * @author rosy
 * @since 2024-12-11 21:14:49
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

}

