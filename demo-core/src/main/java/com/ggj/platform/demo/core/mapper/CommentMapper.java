package com.ggj.platform.demo.core.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ggj.platform.demo.core.entity.CommentEntity;

/**
 * 评论
 *
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Repository
public interface CommentMapper {

    /**
     * 查询用户的评论
     * @param articleId
     * @return
     */
    List<CommentEntity> listByArticleId(Long articleId);

    /**
     * 添加评论
     *
     * @param comment
     * @return
     */
    int insert(CommentEntity comment);
}
