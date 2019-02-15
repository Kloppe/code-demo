package com.ggj.platfrom.demo.common.model;

import lombok.Data;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Data
public class PageQuery<T> {

    /**
     * 当前页码
     */
    private int page;

    /**
     * 每页数据大小
     */
    private int pageSize;

    /**
     * 游标
     */
    private Object cursor;

    /**
     * 扩展查询参数
     */
    private T param;

    /**
     * 索引方式查询数据
     * 根据传入 当前页码、每页数据大小等查询索引当前页面数据
     *
     * @param page          当前页码
     * @param pageSize      当前页数据条数
     * @param param        查询参数
     * @return
     */
    public static <T> PageQuery<T> buildByIndex(int page, int pageSize, T param) {
        if(page <= 0) {
            throw new IllegalArgumentException("the page must greater than 0");
        }

        if(pageSize <= 0) {
            throw new IllegalArgumentException("the pageSize must greater than 0");
        }

        PageQuery<T> pageQuery = new PageQuery();

        pageQuery.page = page;
        pageQuery.pageSize = pageSize;
        pageQuery.param = param;

        return pageQuery;
    }

    /**
     * 索引方式查询数据
     * 根据传入 当前页码、每页数据大小等查询索引当前页面数据
     *
     * @param page          当前页码
     * @param pageSize      当前页数据条数
     * @return
     */
    public static <T> PageQuery<T> buildByIndex(int page, int pageSize) {
        return buildByIndex(page, pageSize, null);
    }


    /**
     * 游标方式查询数据
     * 根据传入 游标、每页数据大小等查询索引当前页面数据
     *
     * @param cursor        游标（上一页：最后一条数据的排序条件）
     * @param pageSize      当前页数据条数
     * @param param        查询参数
     * @return
     */
    public static <T> PageQuery<T> buildByCursor(Object cursor, int pageSize, T param) {
        if(pageSize <= 0) {
            throw new IllegalArgumentException("the pageSize must greater than 0");
        }

        PageQuery<T> pageQuery = new PageQuery();
        pageQuery.pageSize = pageSize;
        pageQuery.cursor = cursor;
        pageQuery.param = param;
        return pageQuery;
    }

    /**
     * 游标方式查询数据
     * 根据传入 游标、每页数据大小等查询索引当前页面数据
     *
     * @param cursor        游标（上一页：最后一条数据的排序条件）
     * @param pageSize      当前页数据条数
     * @return
     */
    public static <T> PageQuery<T> buildByCursor(Object cursor, int pageSize) {
        return buildByCursor(cursor, pageSize, null);
    }

    public int getOffset() {
        return (page - 1) * pageSize;
    }

    public int getLimit() {
        return pageSize;
    }
}
