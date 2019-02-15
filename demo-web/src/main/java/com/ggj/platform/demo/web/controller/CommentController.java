package com.ggj.platform.demo.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ggj.platform.demo.business.CommentBusiness;
import com.ggj.platform.demo.business.bo.CommentBO;
import com.ggj.platform.demo.web.converter.CommentVOConverter;
import com.ggj.platform.demo.web.protocol.Result;

import lombok.extern.slf4j.Slf4j;

/**
 * 评论
 *
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@RestController
@Slf4j
public class CommentController {

    @Autowired
    private CommentBusiness commentBusiness;

    @Resource
    private CommentVOConverter commentVOConverter;

    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    public Result<?> comments(Long articleId) {
        List<CommentBO> commentBOS = commentBusiness.listComment(articleId);
        return Result.success(commentVOConverter.from(commentBOS));
    }
}
