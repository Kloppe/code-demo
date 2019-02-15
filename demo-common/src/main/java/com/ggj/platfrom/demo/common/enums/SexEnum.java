package com.ggj.platfrom.demo.common.enums;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
public enum SexEnum {

    MAN(0, "男"),
    WOMAN(1, "女"),

    ;

    private Integer code;
    private String msg;

    SexEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
