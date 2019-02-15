package com.ggj.platfrom.demo.common.model;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

import lombok.Data;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Data
public class PageResult<T> {

    private int count = 0;

    private List<T> data;

    public static <T> PageResult<T> build(int count, List<T> data) {
        PageResult<T> result = new PageResult<>();
        result.setCount(count);
        result.setData(data);
        return result;
    }

    public static <T> PageResult<T> build() {
        return build(0, Collections.emptyList());
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public <V> PageResult<V> convert(Callable<List<V>> callable) {

        if(this.count == 0)
        {
            return PageResult.build();
        }

        PageResult<V> pageResult = new PageResult<>();
        pageResult.setCount(this.count);
        try {
            pageResult.setData(callable.call());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        return pageResult;
    }
}
