package com.ggj.platform.demo.service.api.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.ggj.platform.demo.api.UserApi;
import com.ggj.platform.demo.business.UserBusiness;
import com.ggj.platform.demo.business.bo.UserBO;
import com.ggj.platform.demo.dto.UserDTO;
import com.ggj.platform.demo.param.UserAddParam;
import com.ggj.platform.demo.param.UserQueryParam;
import com.ggj.platform.demo.param.UserUpdateParam;
import com.ggj.platform.demo.service.converter.UserAddParamConverter;
import com.ggj.platform.demo.service.converter.UserDTOConverter;
import com.ggj.platform.demo.service.converter.UserQueryParamConverter;
import com.ggj.platform.demo.service.converter.UserUpdateParamConverter;
import com.ggj.platform.gsf.result.PlainResult;
import com.ggj.platform.gsf.utils.PlainResultUtil;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Service
public class UserApiImpl implements UserApi {

    @Autowired
    private UserBusiness userBusiness;

    @Resource
    private UserAddParamConverter userAddParamConverter;

    @Resource
    private UserDTOConverter userDTOConverter;

    @Resource
    private UserQueryParamConverter userQueryParamConverter;

    @Resource
    private UserUpdateParamConverter userUpdateParamConverter;

    @Override
    public PlainResult<UserDTO> getUser(Long userId) {
        return PlainResultUtil.buildSuccessResult(userDTOConverter.from(userBusiness.getUser(userId)));
    }

    @Override
    public PlainResult<List<UserDTO>> listUser(UserQueryParam param) {
        List<UserBO> userBOS = userBusiness.listUser(userQueryParamConverter.to(param));
        return PlainResultUtil.buildSuccessResult(userDTOConverter.from(userBOS));
    }

    @Override
    public PlainResult addUser(UserAddParam param) {
        userBusiness.addUser(userAddParamConverter.to(param));
        return PlainResultUtil.buildSuccessResult(null);
    }

    @Override
    public PlainResult updateUser(UserUpdateParam param) {
        userBusiness.updateUser(userUpdateParamConverter.to(param));
        return PlainResultUtil.buildSuccessResult(null);
    }
}
