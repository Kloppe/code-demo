package com.ggj.platform.demo.web.model.query;

import com.ggj.platform.adonis.validator.NotBlank;
import com.ggj.platform.adonis.validator.Validator;
import com.ggj.platform.adonis.validator.ValidatorApi;
import com.ggj.platfrom.demo.common.model.PageQuery;

import lombok.Data;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Data
@Validator
public class UserInfoQuery extends PageQuery implements ValidatorApi {

    private String name;

    @NotBlank
    private String mobileNumber;
}
