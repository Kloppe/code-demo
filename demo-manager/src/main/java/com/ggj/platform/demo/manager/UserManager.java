package com.ggj.platform.demo.manager;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.ggj.platform.demo.core.entity.UserEntity;
import com.ggj.platform.demo.core.entity.UserWalletEntity;
import com.ggj.platform.demo.core.mapper.UserMapper;
import com.ggj.platform.demo.core.mapper.UserWalletMapper;
import com.ggj.platform.demo.core.query.UserQuery;
import com.ggj.platform.demo.manager.converter.UserAddDOConverter;
import com.ggj.platform.demo.manager.converter.UserDOConverter;
import com.ggj.platform.demo.manager.converter.UserUpdateDOConverter;
import com.ggj.platform.demo.manager.dataobject.UserDO;
import com.ggj.platform.demo.manager.param.UserAddDO;
import com.ggj.platform.demo.manager.param.UserUpdateDO;
import com.ggj.platfrom.demo.common.constants.ErrorCode;
import com.ggj.platfrom.demo.common.exceptions.BaseException;
import com.ggj.platfrom.demo.common.model.PageQuery;
import com.ggj.platfrom.demo.common.model.PageResult;

/**
 * 对User、UserWallet做聚合操作
 *
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Component
public class UserManager {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserWalletMapper userWalletMapper;

    @Resource
    private UserAddDOConverter userAddDOConverter;

    @Resource
    private UserDOConverter userDOConverter;

    @Resource
    private UserUpdateDOConverter userUpdateDOConverter;

    public UserDO getUser(Long userId) {
        UserEntity user = userMapper.getById(userId);
        if (user != null) {
            throw new BaseException(ErrorCode.DB_ERROR.getCode(), "查询用户失败，用户不存在，用户id=" + userId);
        }

        UserWalletEntity userWallet = userWalletMapper.getByUserId(userId);
        return userDOConverter.from(user, userWallet);
    }

    public List<UserDO> listUser(UserQuery query) {
        List<UserEntity> users = userMapper.list(query);
        if(CollectionUtils.isEmpty(users))
        {
            return Collections.emptyList();
        }

        List<Long> userIds = users.stream().map(UserEntity::getId).collect(Collectors.toList());
        List<UserWalletEntity> userWallets = userWalletMapper.listByUserIds(userIds);

        return userDOConverter.from(users, userWallets);
    }

    @Transactional(rollbackFor = Exception.class)
    public void addUser(UserAddDO param) {
        UserEntity user = userAddDOConverter.to(param);
        userMapper.insert(user);

        UserWalletEntity userWallet = new UserWalletEntity();
        userWallet.setUserId(user.getId());
        userWallet.setAmount(0);
        userWalletMapper.insert(userWallet);
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateUser(UserUpdateDO param) {
        if(param.needUpdateUser()) {
            UserEntity user = userUpdateDOConverter.to(param);
            userMapper.update(user);
        }

        if (param.getChangeAmount() != null)
        {
            userWalletMapper.updateAmount(param.getId(), param.getChangeAmount());
        }
    }


    public PageResult<UserDO> listUserByPage(PageQuery<UserQuery> pageQuery) {
        int count = userMapper.count(pageQuery.getParam());

        if(count == 0) {
            return PageResult.build();
        }

        List<UserEntity> users = userMapper.listByPage(pageQuery);
        List<Long> userIds = users.stream().map(UserEntity::getId).collect(Collectors.toList());
        List<UserWalletEntity> userWallets = userWalletMapper.listByUserIds(userIds);

        return PageResult.build(count, userDOConverter.from(users, userWallets));
    }
}
