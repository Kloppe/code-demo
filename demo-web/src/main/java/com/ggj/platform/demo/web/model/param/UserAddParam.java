package com.ggj.platform.demo.web.model.param;

import com.ggj.platform.adonis.validator.Mobile;
import com.ggj.platform.adonis.validator.NotBlank;
import com.ggj.platform.adonis.validator.Validator;
import com.ggj.platform.adonis.validator.ValidatorApi;

import lombok.Data;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Data
@Validator
public class UserAddParam implements ValidatorApi {

    @NotBlank
    private String username;

    @Mobile
    private String mobileNumber;

    @NotBlank
    private String password;
}
