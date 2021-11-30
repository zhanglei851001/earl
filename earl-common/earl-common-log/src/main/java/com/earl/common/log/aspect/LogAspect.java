package com.earl.common.log.aspect;

import com.earl.admin.api.entity.SysLog;
import com.earl.common.core.enums.OperationType;
import com.earl.common.core.util.SpringContextHolder;
import com.earl.common.log.annotation.EarlOperationLog;
import com.earl.common.log.event.LogEvent;
import com.earl.common.log.util.LogUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


/**
 * @ClassName: LogAspect
 * @author: zhanglei
 * @Date: 2021/11/30 13:33
 * @Description: 操作日志使用spring event异步入库
 */
@Aspect
@Slf4j
@Component
public class LogAspect {

    @SneakyThrows
    @Around("@annotation(operationLog)")
    public Object around(ProceedingJoinPoint point, EarlOperationLog operationLog) {
        String className = point.getTarget().getClass().getName();
        String methodName = point.getSignature().getName();

        log.info("类名：{},方法名：{}", className, methodName);


        SysLog logVo = LogUtils.getSysLog();
        logVo.setTitle(operationLog.value());

        // 发送异步日志事件
        Long startTime = System.currentTimeMillis();
        Object obj;

        try {
            obj = point.proceed();
        } catch (Exception e) {
            logVo.setType(OperationType.ERROR.getType());
            logVo.setException(e.getMessage());
            throw e;
        } finally {
            Long endTime = System.currentTimeMillis();
            logVo.setTime(endTime - startTime);
            SpringContextHolder.publishEvent(new LogEvent(logVo));
        }

        return obj;

    }


}
