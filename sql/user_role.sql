CREATE DATABASE IF NOT EXISTS myjwtauth;
USE myjwtauth;

/*Table structure for table `sys_user_role` */
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`
(
    `user_id` bigint(200) NOT NULL AUTO_INCREMENT COMMENT '用户id',
    `role_id` bigint(200) NOT NULL DEFAULT '0' COMMENT '角色id',
    PRIMARY KEY (`user_id`, `role_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

-- 插入 sys_user_role 测试数据
INSERT INTO `sys_user_role` (`user_id`, `role_id`)
VALUES (1, 1), -- admin 用户拥有 admin 角色
       (2, 2), -- johndoe 用户拥有 user 角色
       (3, 3), -- janedoe 用户拥有 guest 角色
       (4, 2), -- alice 用户拥有 user 角色
       (5, 2); -- bob 用户拥有 user 角色