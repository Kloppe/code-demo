package com.ggj.platform.demo.core.entity;

import lombok.Data;

/**
 * 评论
 *
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Data
public class CommentEntity extends BaseEntity {

    /**
     * 文章id
     */
    private Long articleId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 文章
     */
    private String content;
}
