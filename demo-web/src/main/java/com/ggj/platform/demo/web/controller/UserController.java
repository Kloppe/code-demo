package com.ggj.platform.demo.web.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ggj.platform.adonis.springboot.validator.AutoValidated;
import com.ggj.platform.demo.business.UserBusiness;
import com.ggj.platform.demo.business.bo.UserBO;
import com.ggj.platform.demo.core.query.UserQuery;
import com.ggj.platform.demo.manager.param.UserAddDO;
import com.ggj.platform.demo.manager.param.UserUpdateDO;
import com.ggj.platform.demo.web.converter.UserAddParamConverter;
import com.ggj.platform.demo.web.converter.UserInfoQueryConverter;
import com.ggj.platform.demo.web.converter.UserInfoVOConverter;
import com.ggj.platform.demo.web.converter.UserUpdateParamConverter;
import com.ggj.platform.demo.web.model.param.UserAddParam;
import com.ggj.platform.demo.web.model.param.UserUpdateParam;
import com.ggj.platform.demo.web.model.query.UserInfoQuery;
import com.ggj.platform.demo.web.protocol.Result;
import com.ggj.platfrom.demo.common.model.PageResult;
import com.ggj.platfrom.demo.common.model.PageQuery;

/**
 * user controller
 *
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@RestController
public class UserController {

    @Autowired
    private UserBusiness userBusiness;

    @Resource
    private UserAddParamConverter userAddParamConverter;

    @Resource
    private UserInfoVOConverter userInfoVOConverter;

    @Resource
    private UserUpdateParamConverter userUpdateParamConverter;

    @RequestMapping("/user")
    public Result getUser(Long id) {
        UserBO userBO = userBusiness.getUser(id);

        return Result.success(userInfoVOConverter.convert(userBO));
    }

    @RequestMapping("/users")
    @AutoValidated
    public Result listUser(UserInfoQuery userInfoQuery) {
        PageQuery<UserQuery> pageQuery = UserInfoQueryConverter.toPageQuery(userInfoQuery);
        PageResult<UserBO> pageResult = userBusiness.listByPage(pageQuery);

        return Result.success(pageResult.convert(() -> userInfoVOConverter.convert(pageResult.getData())));
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @AutoValidated
    public Result addUser(UserAddParam param) {

        UserAddDO userAddDO = userAddParamConverter.to(param);
        userBusiness.addUser(userAddDO);
        return Result.success();
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @AutoValidated
    public Result updateUser(UserUpdateParam param) {
        UserUpdateDO userUpdateDO = userUpdateParamConverter.convert(param);
        userBusiness.updateUser(userUpdateDO);
        return Result.success();
    }
}
