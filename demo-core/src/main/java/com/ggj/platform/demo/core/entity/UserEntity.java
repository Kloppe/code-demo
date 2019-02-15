package com.ggj.platform.demo.core.entity;

import lombok.Data;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Data
public class UserEntity extends BaseEntity {

    private static final long serialVersionUID = -2835233646948692891L;

    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号码
     */
    private String mobileNumber;
}
