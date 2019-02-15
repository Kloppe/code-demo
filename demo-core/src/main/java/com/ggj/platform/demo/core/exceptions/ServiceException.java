package com.ggj.platform.demo.core.exceptions;

import com.ggj.platform.gsf.result.CodeMsg;
import com.ggj.platfrom.demo.common.exceptions.BaseException;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
public class ServiceException extends BaseException {

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String messageTemplate, Object... params) {
        super(messageTemplate, params);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Long code, String message) {
        super(code, message);
    }

    public ServiceException(Long code, String messageTemplate, Object... params) {
        super(code, messageTemplate, params);
    }

    public ServiceException(CodeMsg codeMsg) {
        super(codeMsg);
    }

    public ServiceException(CodeMsg codeMsg, Object... params) {
        super(codeMsg, params);
    }
}
