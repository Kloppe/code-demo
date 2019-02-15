package com.ggj.platform.demo.web.protocol;

import com.ggj.platfrom.demo.common.exceptions.BaseException;

import lombok.Data;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Data
public class Result<T> {

    /**
     * 错误码
     */
    private Long code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 数据对象
     */
    private T data;

    public static <T> Result<T> success() {
        Result<T> result = gen(0L, "success");
        return result;
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = success();
        result.data = data;
        return result;
    }

    public static Result failure(Long code, String msg) {
        return gen(code, msg);
    }

    public static Result failure(Exception ex) {
        if (ex instanceof BaseException) {
            return failure(((BaseException) ex).getCode(), ex.getMessage());
        } else {
            return failure(-1L, ex.getMessage());
        }
    }

    private static Result gen(Long code, String msg) {
        Result result = new Result();
        result.code = code;
        result.msg = msg;
        return result;
    }
}
