package com.ggj.platform.demo.param;

import java.io.Serializable;

import lombok.Data;

/**
 * 添加用户
 *
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Data
public class UserAddParam implements Serializable {

    private static final long serialVersionUID = -8729761792806984410L;

    private String username;

    private String password;

    private String mobileNumber;
}
