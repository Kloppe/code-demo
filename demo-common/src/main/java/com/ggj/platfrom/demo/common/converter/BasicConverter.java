package com.ggj.platfrom.demo.common.converter;

import java.util.List;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
public interface BasicConverter<S, T> {
    T to(S source);

    List<T> to(List<S> source);

    S from(T target);

    List<S> from(List<T> target);
}
