CREATE DATABASE IF NOT EXISTS myjwtauth;
USE myjwtauth;

/*Table structure for table `sys_role_menu` */
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`
(
    `role_id` bigint(200) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
    `menu_id` bigint(200) NOT NULL DEFAULT '0' COMMENT '菜单id',
    PRIMARY KEY (`role_id`, `menu_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8mb4;

-- 插入 sys_role_menu 测试数据
INSERT INTO sys_role_menu (role_id, menu_id)
VALUES (1, 1), -- 管理员角色可以查看首页
       (1, 2), -- 管理员角色可以管理用户
       (1, 3), -- 管理员角色可以配置系统
       (2, 1), -- 普通用户可以查看首页
       (3, 1); -- 访客角色可以查看首页