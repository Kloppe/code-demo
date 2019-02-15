package com.ggj.platform.demo.core.converter;

import com.ggj.platform.demo.core.bo.UserBO;
import com.ggj.platform.demo.core.entity.UserEntity;
import com.ggj.platform.demo.core.entity.UserWalletEntity;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
public class UserBOConverter {

    public static UserBO from(UserEntity user, UserWalletEntity wallet)
    {
        UserBO userBO = new UserBO();
        userBO.setId(user.getId());
        userBO.setUsername(user.getUsername());
        userBO.setPassword(user.getPassword());
        userBO.setMobileNumber(user.getMobileNumber());
        userBO.setCreateTime(user.getCreateTime());

        userBO.setWalletAmount(wallet.getAmount());
        return userBO;
    }
}
