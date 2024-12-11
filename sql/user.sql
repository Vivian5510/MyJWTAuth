CREATE DATABASE IF NOT EXISTS myjwtauth;
USE myjwtauth;

CREATE TABLE `sys_user`
(
    `id`          BIGINT(20)  NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_name`   VARCHAR(64) NOT NULL DEFAULT 'NULL' COMMENT '用户名',
    `nick_name`   VARCHAR(64) NOT NULL DEFAULT 'NULL' COMMENT '昵称',
    `password`    VARCHAR(64) NOT NULL DEFAULT 'NULL' COMMENT '密码',
    `status`      CHAR(1)              DEFAULT '0' COMMENT '账号状态（0正常 1停用）',
    `email`       VARCHAR(64)          DEFAULT NULL COMMENT '邮箱',
    `phonenumber` VARCHAR(32)          DEFAULT NULL COMMENT '手机号',
    `sex`         CHAR(1)              DEFAULT NULL COMMENT '用户性别（0男，1女，2未知）',
    `avatar`      VARCHAR(128)         DEFAULT NULL COMMENT '头像',
    `user_type`   CHAR(1)     NOT NULL DEFAULT '1' COMMENT '用户类型（0管理员，1普通用户）',
    `create_by`   BIGINT(20)           DEFAULT NULL COMMENT '创建人的用户id',
    `create_time` DATETIME             DEFAULT NULL COMMENT '创建时间',
    `update_by`   BIGINT(20)           DEFAULT NULL COMMENT '更新人',
    `update_time` DATETIME             DEFAULT NULL COMMENT '更新时间',
    `del_flag`    INT(11)              DEFAULT '0' COMMENT '删除标志（0代表未删除，1代表已删除）',
    PRIMARY KEY (`id`)
) ENGINE = INNODB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户表';


-- 插入测试数据
INSERT INTO `sys_user` (`user_name`, `nick_name`, `password`, `status`, `email`, `phone_number`, `sex`, `avatar`,
                        `user_type`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`)
VALUES ('admin', '管理员', '{noop}admin123', '0', 'admin@example.com', '1234567890', '0',
        'https://example.com/avatar/admin.png', '0', NULL, '2022-01-01 08:00:00', NULL, NULL, 0),
       ('johndoe', 'John Doe', '{noop}password123', '0', 'johndoe@example.com', '9876543210', '0',
        'https://example.com/avatar/johndoe.png', '1', NULL, '2022-01-10 09:00:00', NULL, NULL, 0),
       ('janedoe', 'Jane Doe', '{noop}password456', '1', 'janedoe@example.com', '1122334455', '1',
        'https://example.com/avatar/janedoe.png', '1', NULL, '2022-01-15 10:00:00', NULL, NULL, 0),
       ('alice', 'Alice Wonderland', '{noop}alice123', '0', 'alice@example.com', '2233445566', '2',
        'https://example.com/avatar/alice.png', '1', NULL, '2022-02-01 11:00:00', NULL, NULL, 0),
       ('bob', 'Bob Builder', '{noop}bob123', '0', 'bob@example.com', '3344556677', '0',
        'https://example.com/avatar/bob.png', '1', NULL, '2022-03-01 12:00:00', NULL, NULL, 0);

-- 插入 sys_user 测试数据
INSERT INTO `sys_user` (`user_name`, `nick_name`, `password`, `status`, `email`, `phone_number`, `sex`, `avatar`,
                        `user_type`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`)
VALUES ('admin', '管理员', '{noop}admin123', '0', 'admin@example.com', '1234567890', '0',
        'https://example.com/avatar/admin.png', '0', NULL, '2022-01-01 08:00:00', NULL, NULL, 0),
       ('johndoe', 'John Doe', '{noop}password123', '0', 'johndoe@example.com', '9876543210', '0',
        'https://example.com/avatar/johndoe.png', '1', NULL, '2022-01-10 09:00:00', NULL, NULL, 0),
       ('janedoe', 'Jane Doe', '{noop}password456', '1', 'janedoe@example.com', '1122334455', '1',
        'https://example.com/avatar/janedoe.png', '1', NULL, '2022-01-15 10:00:00', NULL, NULL, 0),
       ('alice', 'Alice Wonderland', '{noop}alice123', '0', 'alice@example.com', '2233445566', '2',
        'https://example.com/avatar/alice.png', '1', NULL, '2022-02-01 11:00:00', NULL, NULL, 0),
       ('bob', 'Bob Builder', '{noop}bob123', '0', 'bob@example.com', '3344556677', '0',
        'https://example.com/avatar/bob.png', '1', NULL, '2022-03-01 12:00:00', NULL, NULL, 0);