package com.ggj.platform.demo.api;

import java.util.List;

import com.ggj.platform.demo.dto.UserDTO;
import com.ggj.platform.demo.param.UserAddParam;
import com.ggj.platform.demo.param.UserQueryParam;
import com.ggj.platform.demo.param.UserUpdateParam;
import com.ggj.platform.gsf.result.PlainResult;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
public interface UserApi {

    /**
     * 查询用户
     *
     * @param userId
     * @return
     */
    PlainResult<UserDTO> getUser(Long userId);

    /**
     * 查询多用户
     *
     * @param param
     * @return
     */
    PlainResult<List<UserDTO>> listUser(UserQueryParam param);

    /**
     * 添加用户
     *
     * @param param
     * @return
     */
    PlainResult addUser(UserAddParam param);

    /**
     * 更新用户的信息
     *
     * @param param
     * @return
     */
    PlainResult updateUser(UserUpdateParam param);
}

