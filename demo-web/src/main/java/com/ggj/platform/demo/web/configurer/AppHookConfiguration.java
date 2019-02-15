package com.ggj.platform.demo.web.configurer;

import org.springframework.stereotype.Component;

import com.ggj.platform.sentry.devops.hook.AppHookIF;

import lombok.extern.slf4j.Slf4j;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2018/4/12
 * @since 1.0
 */
@Component
@Slf4j
public class AppHookConfiguration implements AppHookIF {

    @Override
    public Boolean checkAppFuncAfterStart() {
        log.info("启动后检测..............................");
        return true;
    }

    @Override
    public Boolean appShutDownBeforeForceKill() {
        log.info("关闭前检测..............................");
        return true;
    }
}
