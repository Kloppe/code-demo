package com.ggj.platform.demo.core.entity;

import lombok.Data;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Data
public class UserWalletEntity extends BaseEntity {

    private static final long serialVersionUID = -2835233646948692891L;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 余额
     */
    private Integer amount;

    /**
     * 手机号码
     */
    private String mobileNumber;
}
