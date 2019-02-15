package com.ggj.platform.demo.web.converter;

import org.mapstruct.Mapper;

import com.ggj.platform.demo.manager.param.UserAddDO;
import com.ggj.platform.demo.manager.param.UserUpdateDO;
import com.ggj.platform.demo.web.model.param.UserAddParam;
import com.ggj.platform.demo.web.model.param.UserUpdateParam;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Mapper(componentModel = "Spring")
public interface UserUpdateParamConverter {

    default UserUpdateDO convert(UserUpdateParam param) {
        UserUpdateDO userUpdateDO = to(param);

        if(userUpdateDO != null) {
            int changeAmount = (int) (Double.valueOf(param.getChangeAmount()) * 100.0);
            userUpdateDO.setChangeAmount(changeAmount);
        }

        return userUpdateDO;
    }

    /**
     * from UserUpdateParam to UserUpdateDO
     *
     * @param param
     * @return
     */
    UserUpdateDO to(UserUpdateParam param);
}
