package com.ggj.platform.demo.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ggj.platform.demo.core.bo.UserBO;
import com.ggj.platform.demo.core.converter.UserBOConverter;
import com.ggj.platform.demo.core.entity.UserEntity;
import com.ggj.platform.demo.core.entity.UserWalletEntity;
import com.ggj.platform.demo.core.exceptions.ServiceException;
import com.ggj.platform.demo.core.mapper.UserMapper;
import com.ggj.platform.demo.core.mapper.UserWalletMapper;

/**
 * user srevice
 *
 * 对mapper做一个简单的封装
 *
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserWalletMapper userWalletMapper;

    /**
     * 添加一个新用户
     *
     * @param user
     */
    @Transactional(rollbackFor = Exception.class)
    public void addUser(UserEntity user){
        //添加用户
        userMapper.insert(user);

        //添加钱包
        UserWalletEntity wallet = new UserWalletEntity();
        wallet.setUserId(user.getId());
        wallet.setAmount(0);
        userWalletMapper.insert(wallet);
    }

    public UserBO getUser(Long userId)
    {
        UserEntity user = userMapper.getById(userId);

        if(user == null)
        {
            throw new ServiceException(-1L, "用户信息不存在，userId={}", userId);
        }

        UserWalletEntity wallet = userWalletMapper.getByUserId(userId);
        return UserBOConverter.from(user, wallet);
    }
}
