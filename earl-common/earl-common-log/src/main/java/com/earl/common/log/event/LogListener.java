package com.earl.common.log.event;

import com.earl.admin.api.entity.SysLog;
import com.earl.admin.api.feign.RemoteLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import sun.security.util.SecurityConstants;

/**
 * @ClassName: LogListener
 * @author: zhanglei
 * @Date: 2021/11/30 15:05
 * @Description:日志监听类
 */
@RequiredArgsConstructor
@Slf4j
public class LogListener {

    private final RemoteLogService remoteLogService;

    @Async
    @Order
    @EventListener(LogEvent.class)
    public void saveSysLog(LogEvent event) {
        SysLog sysLog = (SysLog) event.getSource();
        remoteLogService.saveLog(sysLog, SecurityConstants.FROM_IN);
    }


}
