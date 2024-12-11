CREATE DATABASE IF NOT EXISTS myjwtauth;
USE myjwtauth;

/*Table structure for table `sys_menu` */
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`
(
    `id`          bigint(20)  NOT NULL AUTO_INCREMENT,
    `menu_name`   varchar(64) NOT NULL DEFAULT 'NULL' COMMENT '菜单名',
    `path`        varchar(200)         DEFAULT NULL COMMENT '路由地址',
    `component`   varchar(255)         DEFAULT NULL COMMENT '组件路径',
    `visible`     char(1)              DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
    `status`      char(1)              DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
    `perms`       varchar(100)         DEFAULT NULL COMMENT '权限标识',
    `icon`        varchar(100)         DEFAULT '#' COMMENT '菜单图标',
    `create_by`   bigint(20)           DEFAULT NULL,
    `create_time` datetime             DEFAULT NULL,
    `update_by`   bigint(20)           DEFAULT NULL,
    `update_time` datetime             DEFAULT NULL,
    `del_flag`    int(11)              DEFAULT '0' COMMENT '是否删除（0未删除 1已删除）',
    `remark`      varchar(500)         DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8mb4 COMMENT ='菜单表';

-- 插入 sys_menu 测试数据
INSERT INTO `sys_menu` (`menu_name`, `path`, `component`, `visible`, `status`, `perms`, `icon`, `create_by`,
                        `create_time`, `update_by`, `update_time`, `del_flag`, `remark`)
VALUES ('首页', '/home', 'HomePage', '0', '0', 'home:view', 'home-icon', NULL, '2022-01-01 08:00:00', NULL, NULL, 0,
        '主页菜单'),
       ('用户管理', '/user', 'UserManagement', '0', '0', 'user:manage', 'user-icon', NULL, '2022-02-01 09:00:00', NULL,
        NULL, 0, '管理用户'),
       ('系统设置', '/settings', 'SystemSettings', '0', '0', 'settings:config', 'settings-icon', NULL,
        '2022-03-01 10:00:00', NULL, NULL, 0, '系统配置');