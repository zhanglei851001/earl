package com.earl.admin.api.feign;

import com.earl.admin.api.entity.SysLog;
import com.earl.admin.api.feign.fallback.RemoteLogServiceFallback;
import com.earl.common.core.constant.ServiceNameConstants;
import com.earl.common.core.util.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = ServiceNameConstants.ADMIN_SERVICE, fallback = RemoteLogServiceFallback.class)
public interface RemoteLogService {

    /**
     * @param sysLog
     * @return com.earl.common.core.util.Result<java.lang.Boolean>
     * @Description //TODO
     * @Author zhanglei
     * @Date 2021/11/30 18:38
     */
    @PostMapping("/log")
    Result<Boolean> saveLog(@RequestBody SysLog sysLog);


}
