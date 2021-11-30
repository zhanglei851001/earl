package com.earl.common.log.event;

import com.earl.admin.api.entity.SysLog;
import org.springframework.context.ApplicationEvent;

/**
 * @ClassName: SysLogEvent
 * @author: zhanglei
 * @Date: 2021/11/30 15:00
 * @Description: 日志事件
 */
public class LogEvent extends ApplicationEvent {
    public LogEvent(SysLog log) {
        super(log);
    }
}
