package com.ggj.platform.demo.param;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Data
public class UserQueryParam implements Serializable {

    private static final long serialVersionUID = -3690989970190029601L;

    private List<Integer> userIds;

    private String mobileNumber;

    private String username;
}
