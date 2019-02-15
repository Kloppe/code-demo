package com.ggj.platform.demo.web.web;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.web.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

/**
 * mvc配置类
 *
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Configuration
public class WebConfiguration extends WebMvcAutoConfiguration.EnableWebMvcConfiguration {


    public WebConfiguration(ObjectProvider<WebMvcProperties> mvcPropertiesProvider,
        ObjectProvider<WebMvcRegistrations> mvcRegistrationsProvider, ListableBeanFactory beanFactory) {
        super(mvcPropertiesProvider, mvcRegistrationsProvider, beanFactory);
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);

        //TOOD 添加自定义的拦截器
    }
}
