package com.ggj.platform.demo.web.converter;

import org.mapstruct.Mapper;

import com.ggj.platform.demo.manager.param.UserAddDO;
import com.ggj.platform.demo.web.model.param.UserAddParam;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Mapper(componentModel = "Spring")
public interface UserAddParamConverter {

    /**
     * from UserAddParam to UserAddDO
     *
     * @param param
     * @return
     */
    UserAddDO to(UserAddParam param);
}
