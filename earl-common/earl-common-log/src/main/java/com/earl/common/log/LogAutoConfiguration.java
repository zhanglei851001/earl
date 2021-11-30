package com.earl.common.log;

import com.earl.admin.api.feign.RemoteLogService;
import com.earl.common.log.aspect.LogAspect;
import com.earl.common.log.event.LogListener;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @ClassName LogAutoConfiguration
 * @Description TODO 日志自动配置类
 * @Author zhanglei
 * @Date 2021/11/30 18:49
 * @Version 1.0
 */
@EnableAsync
@RequiredArgsConstructor
@ConditionalOnWebApplication
@Configuration(proxyBeanMethods = false)
public class LogAutoConfiguration {

    @Bean
    public LogListener sysLogListener(RemoteLogService remoteLogService) {
        return new LogListener(remoteLogService);
    }

    @Bean
    public LogAspect sysLogAspect() {
        return new LogAspect();
    }

}
