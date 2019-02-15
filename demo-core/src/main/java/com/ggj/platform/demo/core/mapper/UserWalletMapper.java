package com.ggj.platform.demo.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ggj.platform.demo.core.entity.UserWalletEntity;

/**
 * 用户钱包
 *
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Repository
public interface UserWalletMapper {

    /**
     * 添加用户钱包
     *
     * @param userWallet
     * @return
     */
    int insert(UserWalletEntity userWallet);

    /**
     * 获取用户的钱包
     *
     * @param userId
     * @return
     */
    UserWalletEntity getByUserId(Long userId);

    /**
     * 更新余额
     *
     * @param userId
     * @param changeAmount
     * @return
     */
    int updateAmount(@Param("userId") Long userId, @Param("changeAmount") Integer changeAmount);

    /**
     * userIds查询
     *
     * @param userIds
     * @return
     */
    List<UserWalletEntity> listByUserIds(List<Long> userIds);
}
