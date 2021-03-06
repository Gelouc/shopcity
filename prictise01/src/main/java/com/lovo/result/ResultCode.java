package com.lovo.result;


public enum ResultCode {
    SUCCESS(1, "成功"),
    // 参数错误1001-1999
    PARAM_IS_INVALID(1001, "参数无效"),
    PARAM_IS_BLANK(1002, "参数为空"),
    PARAM_TYPE_BAND_ERROR(1003, "参数类型错误"),
    PARAM_NOT_COMPLETE(1004, "参数缺失"),
    // 用户错误2001-2999
    USER_NOT_LOGGED_IN(2001, "用户未登录"),
    USER_LOGIN_ERROR(2002, "账户不存在或密码错误"),
    USER_ACCOUNT_FORBIDDEN(2003, "账户已被禁用"),
    USER_NOT_EXIST(2004, "用户不存在"),
    USER_HAS_EXISTED(2005, "用户已存在"),
    USER_PASS_ERROR(2006, "密码错误"),
    USER_AUTHENTICATION_ERROR(2007, "认证失败"),
    USER_AUTHORIZATION_ERROR(2008, "没有权限"),
    TOKEN_EXPIRED(2009,"token过期"),
    // 服务器错误3001-3999
    SERVER_OPTIMISTIC_LOCK_ERROR(3001, "操作冲突"),
    SERVER_INNER_ERROR(3002, "服务器内部错误"),
    SERVER_UNKNOW_ERROR(3003, "服务器未知错误"),
    SERVER_EMPTY_RESULT_DATA_ACCESS_ERROR(3004, "没有找到对应的数据");

    private Integer status;
    private String message;

    ResultCode(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer status() {
        return this.status;
    }

    public String message() {
        return this.message;
    }

}
