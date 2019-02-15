package com.ggj.platform.demo.business.bo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Data
public class UserBO implements Serializable {

    private static final long serialVersionUID = -6273985639815813032L;

    private Long id;

    private String username;

    private String mobileNumber;

    private Integer walletAmount;

    private Date createTime;
}
