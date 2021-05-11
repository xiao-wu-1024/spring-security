package com.wujia.demo_security.consts;

/**
 * 通用枚举
 * @author xiao-_-wu
 * @date 2021/4/8 17:54
 */
public enum CommonEnum {

    /**
     * 用户角色
     */
    ADMIN_ROLE(0, "admin"),
    USER_ROLE(1, "user")
    ;

    private final int code;
    private final String message;

    CommonEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
