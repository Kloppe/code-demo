package com.ggj.platform.demo.manager.converter;

import org.mapstruct.Mapper;

import com.ggj.platform.demo.core.entity.UserEntity;
import com.ggj.platform.demo.manager.param.UserUpdateDO;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Mapper(componentModel = "Spring")
public interface UserUpdateDOConverter {

    /**
     * from UserUpdateDO to UserEntity
     *
     * @param userUpdateDO
     * @return
     */
    UserEntity to(UserUpdateDO userUpdateDO);


}
