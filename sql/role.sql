CREATE DATABASE IF NOT EXISTS myjwtauth;
USE myjwtauth;

/*Table structure for table `sys_role` */
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT,
    `name`        varchar(128) DEFAULT NULL,
    `role_key`    varchar(100) DEFAULT NULL COMMENT '角色权限字符串',
    `status`      char(1)      DEFAULT '0' COMMENT '角色状态（0正常 1停用）',
    `del_flag`    int(1)       DEFAULT '0' COMMENT 'del_flag',
    `create_by`   bigint(200)  DEFAULT NULL,
    `create_time` datetime     DEFAULT NULL,
    `update_by`   bigint(200)  DEFAULT NULL,
    `update_time` datetime     DEFAULT NULL,
    `remark`      varchar(500) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8mb4 COMMENT ='角色表';


-- 插入 sys_role 测试数据
INSERT INTO `sys_role` (`name`, `role_key`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`,
                        `update_time`, `remark`)
VALUES ('管理员', 'ROLE_ADMIN', '0', '0', NULL, '2022-01-01 08:00:00', NULL, NULL, '系统管理员'),
       ('用户', 'ROLE_USER', '0', '0', NULL, '2022-02-01 09:00:00', NULL, NULL, '普通用户'),
       ('访客', 'ROLE_GUEST', '1', '0', NULL, '2022-03-01 10:00:00', NULL, NULL, '访客角色');