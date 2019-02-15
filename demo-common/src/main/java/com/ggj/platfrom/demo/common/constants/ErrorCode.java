package com.ggj.platfrom.demo.common.constants;

import com.ggj.platform.gsf.result.CodeMsg;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
public class ErrorCode {

    public static CodeMsg UNKNOW = new CodeMsg(10010000L, "未知异常");

    public static CodeMsg DB_ERROR = new CodeMsg(10010001L, "数据库执行异常");

}
