package com.ggj.platform.demo.web.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;

import com.ggj.platform.demo.business.bo.CommentBO;
import com.ggj.platform.demo.web.model.vo.CommentVO;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Mapper(componentModel = "Spring")
public interface CommentVOConverter {

    /**
     * from List<CommentBO> to List<CommentVO>
     *
     * @param commentBOS
     * @return
     */
    default List<CommentVO> from(List<CommentBO> commentBOS) {
        if (commentBOS == null) {
            return null;
        }

        return commentBOS.stream().map(e -> from(e)).filter(e -> e != null).collect(Collectors.toList());
    }

    /**
     * from CommentBO to CommentVO
     *
     * @param commentBO
     * @return
     */
    CommentVO from(CommentBO commentBO);
}
