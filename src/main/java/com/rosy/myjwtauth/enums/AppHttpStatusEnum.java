package com.rosy.myjwtauth.enums;

import com.rosy.myjwtauth.constant.AppHttpStatusConstant;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AppHttpStatusEnum {
    SUCCESS(AppHttpStatusConstant.SUCCESS, "操作成功"),
    NEED_LOGIN(AppHttpStatusConstant.NEED_LOGIN, "需要登录后操作"),
    NO_OPERATOR_AUTH(AppHttpStatusConstant.NO_OPERATOR_AUTH, "无操作权限"),
    SYSTEM_ERROR(AppHttpStatusConstant.SYSTEM_ERROR, "出现错误"),
    USERNAME_EXIST(AppHttpStatusConstant.USERNAME_EXIST, "用户名已注册"),
    PHONE_NUMBER_EXIST(AppHttpStatusConstant.PHONE_NUMBER_EXIST, "手机号已注册"),
    EMAIL_EXIST(AppHttpStatusConstant.EMAIL_EXIST, "邮箱已注册"),
    REQUIRE_USERNAME(AppHttpStatusConstant.REQUIRE_USERNAME, "必须填写用户名"),
    LOGIN_ERROR(AppHttpStatusConstant.LOGIN_ERROR, "用户名或密码错误"),
    PARAM_ERROR(AppHttpStatusConstant.PARAM_INVALID, "传递参数错误");

    private final Integer code;
    private final String msg;
}
