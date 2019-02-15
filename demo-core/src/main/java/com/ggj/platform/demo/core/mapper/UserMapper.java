package com.ggj.platform.demo.core.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ggj.platform.demo.core.entity.UserEntity;
import com.ggj.platform.demo.core.query.UserQuery;
import com.ggj.platform.onecache.support.annotation.OneCache;
import com.ggj.platform.onecache.support.annotation.OneCacheEvict;
import com.ggj.platfrom.demo.common.model.PageQuery;

/**
 * User Mapper
 *
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Repository
public interface UserMapper {

    /**
     * 根据id获取User
     *
     * @param id 用户id
     * @return
     */
    @OneCache(group = "user")
    UserEntity getById(Long id);

    /**
     * 多条件查询
     *
     * @param query
     * @return
     */
    List<UserEntity> list(UserQuery query);

    /**
     * 多条件查询用户信息，返回集合。分页查询
     *
     * @return
     */
    List<UserEntity> listByPage(PageQuery<UserQuery> query);

    /**
     * 获取总条数
     *
     * @param userQuery
     * @return
     */
    int count(UserQuery userQuery);

    /**
     * 添加用户
     *
     * @param user 用户数据
     * @return
     */
    int insert(UserEntity user);

    /**
     * 根据id修改用户信息
     *
     * @param user 用户数据
     * @return
     */
    @OneCacheEvict(group = "user")
    int update(UserEntity user);

    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     */
    @OneCacheEvict(group = "user")
    int delete(Integer id);

    /**
     * 批量添加用户信息
     *
     * @param users 用户数据集合
     * @return
     */
    int insertBatch(List<UserEntity> users);
}
