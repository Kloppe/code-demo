package com.ggj.platform.demo.business;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ggj.platform.demo.business.bo.UserBO;
import com.ggj.platform.demo.business.converter.UserBOConverter;
import com.ggj.platform.demo.core.query.UserQuery;
import com.ggj.platform.demo.manager.UserManager;
import com.ggj.platform.demo.manager.dataobject.UserDO;
import com.ggj.platform.demo.manager.param.UserAddDO;
import com.ggj.platform.demo.manager.param.UserUpdateDO;
import com.ggj.platfrom.demo.common.model.PageResult;
import com.ggj.platfrom.demo.common.model.PageQuery;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Component
public class UserBusiness {

    @Autowired
    private UserManager userManager;

    @Resource
    private UserBOConverter userBOConverter;

    public UserBO getUser(Long userId) {
        UserDO userDO = userManager.getUser(userId);
        return userBOConverter.from(userDO);
    }

    public List<UserBO> listUser(UserQuery query) {
        List<UserDO> userDOS = userManager.listUser(query);
        return userBOConverter.from(userDOS);
    }

    public PageResult<UserBO> listByPage(PageQuery<UserQuery> pageQuery) {
        PageResult<UserDO> pageResult = userManager.listUserByPage(pageQuery);
        return pageResult.convert(() -> userBOConverter.from(pageResult.getData()));
    }

    public void addUser(UserAddDO userAddDO) {
        userManager.addUser(userAddDO);
    }

    public void updateUser(UserUpdateDO userUpdateDO) {
        userManager.updateUser(userUpdateDO);
    }


}
