package com.ggj.platform.demo.web.converter;

import com.ggj.platform.demo.core.query.UserQuery;
import com.ggj.platform.demo.web.model.query.UserInfoQuery;
import com.ggj.platfrom.demo.common.model.PageQuery;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
public class UserInfoQueryConverter {

    public static PageQuery<UserQuery> toPageQuery(UserInfoQuery query) {
        PageQuery<UserQuery> pageQuery = new PageQuery<>();
        pageQuery.setPage(query.getPage());
        pageQuery.setPageSize(query.getPageSize());

        UserQuery userQuery = new UserQuery();
        userQuery.setUsername(query.getName());
        userQuery.setMobileNumber(query.getMobileNumber());

        pageQuery.setParam(userQuery);
        return pageQuery;
    }
}
