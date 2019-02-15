package com.ggj.platform.demo.business.bo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Data
public class CommentBO implements Serializable {

    private static final long serialVersionUID = 1496235177327390135L;


    private Long id;

    private Long articleId;

    private String content;

    private Date createTime;

    /**
     * 评论人
     */
    private Critic critic;


    @Data
    public static class Critic implements Serializable {
        private Long userId;

        private String username;
    }
}
