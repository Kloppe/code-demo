package com.ggj.platform.demo.web.model.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Data
public class UserInfoVO implements Serializable {
    private static final long serialVersionUID = 7213194650544111740L;

    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 手机号码
     */
    private String mobileNumber;

    /**
     * 钱包余额
     */
    private String walletAmount;

    /**
     * 注册时间
     */
    private Date createTime;
}
