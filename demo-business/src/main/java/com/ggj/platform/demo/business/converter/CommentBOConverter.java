package com.ggj.platform.demo.business.converter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ggj.platform.demo.business.bo.CommentBO;
import com.ggj.platform.demo.core.entity.CommentEntity;
import com.ggj.platform.demo.core.entity.UserEntity;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Mapper(componentModel = "Spring")
public interface CommentBOConverter {

    /**
     * from List<CommentEntity> && List<UserEntity> to List<CommentBO>
     *
     * @param comments
     * @param users
     * @return
     */
    default List<CommentBO> from(List<CommentEntity> comments, List<UserEntity> users) {
        if(comments == null || users == null) {
            return null;
        }
        Map<Long, UserEntity> userMap = users.stream().collect(Collectors.toMap(UserEntity::getId, e -> e));
        return comments.stream().map(e -> from(e, userMap.get(e.getUserId()))).filter(e -> e != null).collect(Collectors.toList());
    }

    /**
     * from CommentEntity && UserEntity to CommentBO
     *
     * @param comment
     * @param user
     * @return
     */
    @Mapping(source = "comment.id", target = "id")
    @Mapping(source = "comment.articleId", target = "articleId")
    @Mapping(source = "comment.content", target = "content")
    @Mapping(source = "comment.createTime", target = "createTime")
    @Mapping(source = "user.id", target = "critic.userId")
    @Mapping(source = "user.username", target = "critic.username")
    CommentBO from(CommentEntity comment, UserEntity user);
}
