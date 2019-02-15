package com.ggj.platform.demo.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * api向外层传输的数据格式
 *
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Data
public class UserDTO implements Serializable {

    private static final long serialVersionUID = -2458389006696386872L;

    private Long Id;

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
    private Integer walletAmount;

}
