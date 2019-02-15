package com.ggj.platform.demo.web.model.param;

import com.ggj.platform.adonis.validator.*;

import lombok.Data;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Data
@Validator
public class UserUpdateParam implements ValidatorApi {

    @NotNull
    private Long id;

    private String username;

    @Mobile(allowNull = true)
    private String mobileNumber;

    private String changeAmount;
}
