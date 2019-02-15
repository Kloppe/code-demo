package com.ggj.platfrom.demo.common.exceptions;

import com.ggj.platform.gsf.exception.BusinessException;
import com.ggj.platform.gsf.result.CodeMsg;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
public class BaseException extends BusinessException {

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String messageTemplate, Object... params) {
        this(String.format(messageTemplate, params));
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Long code, String message) {
        super(code, message);
    }

    public BaseException(Long code, String messageTemplate, Object... params) {
        this(code, String.format(messageTemplate, params));
    }

    public BaseException(CodeMsg codeMsg) {
        this(codeMsg.getCode(), codeMsg.getMessage());
    }

    public BaseException(CodeMsg codeMsg, Object... params) {
        this(codeMsg.getCode(), codeMsg.getMessage(), params);
    }
}
