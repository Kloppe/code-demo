package com.ggj.platform.demo.business;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.ggj.platform.demo.business.bo.CommentBO;
import com.ggj.platform.demo.business.converter.CommentBOConverter;
import com.ggj.platform.demo.core.entity.CommentEntity;
import com.ggj.platform.demo.core.entity.UserEntity;
import com.ggj.platform.demo.core.mapper.CommentMapper;
import com.ggj.platform.demo.core.mapper.UserMapper;
import com.ggj.platform.demo.core.query.UserQuery;

/**
 * 评论
 *
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Component
public class CommentBusiness {

    @Autowired
    public CommentMapper commentMapper;

    @Autowired
    private UserMapper userMapper;

    @Resource
    private CommentBOConverter commentBOConverter;

    public List<CommentBO> listComment(Long articleId) {
        List<CommentEntity> comments = commentMapper.listByArticleId(articleId);
        if(CollectionUtils.isEmpty(comments)) {
            return Collections.emptyList();
        }

        List<Long> userIds = comments.stream().map(e -> e.getUserId()).distinct().collect(Collectors.toList());

        UserQuery userQuery = new UserQuery();
        userQuery.setUserIds(userIds);
        List<UserEntity> users = userMapper.list(userQuery);

        return commentBOConverter.from(comments, users);
    }
}
