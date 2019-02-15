package com.ggj.platform.demo.manager.param;

import java.io.Serializable;

import lombok.Data;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Data
public class UserUpdateDO implements Serializable {

    private static final long serialVersionUID = 5062925045675926088L;

    private Long id;

    private String username;

    private String mobileNumber;

    /**
     * 变更的余额
     * 增加：+
     * 减少：-
     */
    private Integer changeAmount;

    public boolean needUpdateUser() {
        return username != null || mobileNumber != null;
    }
}
