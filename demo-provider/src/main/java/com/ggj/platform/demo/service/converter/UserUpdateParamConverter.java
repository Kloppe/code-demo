package com.ggj.platform.demo.service.converter;

import org.mapstruct.Mapper;

import com.ggj.platform.demo.manager.param.UserUpdateDO;
import com.ggj.platform.demo.param.UserUpdateParam;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Mapper(componentModel = "Spring")
public interface UserUpdateParamConverter {

    UserUpdateDO to(UserUpdateParam param);
}
