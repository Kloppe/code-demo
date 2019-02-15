package com.ggj.platform.demo.service.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;

import com.ggj.platform.demo.business.bo.UserBO;
import com.ggj.platform.demo.dto.UserDTO;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Mapper(componentModel = "Spring")
public interface UserDTOConverter {

    default List<UserDTO> from(List<UserBO> userBOS) {
        if(userBOS == null) {
            return null;
        }
        return userBOS.stream().map(e -> from(e)).filter(e -> e != null).collect(Collectors.toList());
    }

    UserDTO from(UserBO userBO);
}
