package com.ggj.platform.demo.manager.converter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ggj.platform.demo.core.entity.UserEntity;
import com.ggj.platform.demo.core.entity.UserWalletEntity;
import com.ggj.platform.demo.manager.dataobject.UserDO;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Mapper(componentModel = "Spring")
public interface UserDOConverter {

    default List<UserDO> from(List<UserEntity> users, List<UserWalletEntity> userWallets) {
        if(users == null || userWallets == null) {
            return null;
        }

        Map<Long, UserWalletEntity> userWalletMap = userWallets.stream()
            .collect(Collectors.toMap(e -> e.getUserId(), e -> e));
        return users.stream().map(e -> from(e, userWalletMap.get(e.getId()))).filter(e -> e!= null).collect(Collectors.toList());
    }

    /**
     * from user && wallet to UserDO
     *
     * @param user
     * @param wallet
     * @return
     */
    @Mapping(source = "user.id", target = "id")
    @Mapping(source = "user.username", target = "username")
    @Mapping(source = "user.mobileNumber", target = "mobileNumber")
    @Mapping(source = "user.password", target = "password")
    @Mapping(source = "wallet.amount", target = "walletAmount", defaultValue = "0")
    UserDO from(UserEntity user, UserWalletEntity wallet);
}
