package com.ggj.platform.demo.business.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;

import com.ggj.platform.demo.business.bo.UserBO;
import com.ggj.platform.demo.manager.dataobject.UserDO;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Mapper(componentModel = "Spring")
public interface UserBOConverter {

    /**
     * from List<UserDO> to List<UserBO>
     *
     * @param userDOS
     * @return
     */
    default List<UserBO> from(List<UserDO> userDOS) {
        if (userDOS == null) {
            return null;
        }

        return userDOS.stream().map(e -> from(e)).filter(e -> e != null).collect(Collectors.toList());
    }

    /**
     * from UserDO to UserBo
     *
     * @param userDO
     * @return
     */
    UserBO from(UserDO userDO);
}
