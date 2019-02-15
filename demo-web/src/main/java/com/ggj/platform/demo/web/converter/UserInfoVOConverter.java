package com.ggj.platform.demo.web.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ggj.platform.demo.business.bo.UserBO;
import com.ggj.platform.demo.web.model.vo.UserInfoVO;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Mapper(componentModel = "Spring")
public interface UserInfoVOConverter {

    default List<UserInfoVO> convert(List<UserBO> userBOS) {
        if(userBOS == null) {
            return null;
        }

        return userBOS.stream().map(e -> convert(e)).filter(e -> e != null).collect(Collectors.toList());
    }

    default UserInfoVO convert(UserBO userBO) {
        UserInfoVO userInfoVO = from(userBO);

        if(userInfoVO != null) {
            userInfoVO.setWalletAmount(String.valueOf(userBO.getWalletAmount() / 100));
        }

        return userInfoVO;
    }

    /**
     * from UserBO to UserInfoVO
     *
     * @param userBO
     * @return
     */
    UserInfoVO from(UserBO userBO);
}
