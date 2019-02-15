package com.ggj.platform.demo.manager.dataobject;

import java.io.Serializable;

import lombok.Data;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Data
public class UserDO implements Serializable {

    private static final long serialVersionUID = 7922086151931172996L;

    private Long id;

    private String username;

    private String password;

    private String mobileNumber;

    private Integer walletAmount;
}
