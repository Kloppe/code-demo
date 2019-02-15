package com.ggj.platfrom.demo.common.utils;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
public final class StringUtils {

    /**
     * 判空
     *
     * @param str
     * @return
     */
    public boolean isBlank(String str)
    {
        return str == null || str.isEmpty();
    }
}
