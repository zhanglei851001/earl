
package com.earl.admin.api.feign.fallback;

import com.earl.admin.api.entity.SysLog;
import com.earl.admin.api.feign.RemoteLogService;
import com.earl.common.core.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class RemoteLogServiceFallback implements RemoteLogService {

    /**
     * @param sysLog 日志实体
     * @return com.earl.common.core.util.Result<java.lang.Boolean>
     * @Description //TODO  保存日志
     * @Author zhanglei
     * @Date 2021/11/30 18:45
     */
    @Override
    public Result<Boolean> saveLog(SysLog sysLog) {
        log.error("feign 插入日志失败");
        return null;
    }

}
