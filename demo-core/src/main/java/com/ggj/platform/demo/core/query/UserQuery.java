package com.ggj.platform.demo.core.query;

import java.util.List;

import lombok.Data;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Data
public class UserQuery {

    /**
     * 根据用户名，查询user信息
     */
    private String username;

    /**
     * 手机号码
     */
    private String mobileNumber;

    private List<Long> userIds;
}
