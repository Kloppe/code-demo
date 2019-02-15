package com.ggj.platform.demo.core.bo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 封装用户信息
 *
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Data
public class UserBO implements Serializable {

    private static final long serialVersionUID = -871694917210711104L;

    private Long id;

    private String username;

    private String password;

    private String mobileNumber;

    private Integer walletAmount;

    private Date createTime;
}
