package com.ggj.platform.demo.manager.converter;

import org.mapstruct.Mapper;

import com.ggj.platform.demo.core.entity.UserEntity;
import com.ggj.platform.demo.manager.param.UserAddDO;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Mapper(componentModel = "Spring")
public interface UserAddDOConverter {

    UserEntity to(UserAddDO userAddDO);
}
