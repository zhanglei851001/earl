package com.earl.common.log.annotation;


import com.earl.common.core.enums.OperationType;

import java.lang.annotation.*;

/**
 * @ClassName: EarlOperationLog
 * @author: zhanglei
 * @Date: 2021/11/30 10:45
 * @Description: 日志操作注解类
 */
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface EarlOperationLog {

    /**
     * @Description 方法描述
     * @Author zhanglei
     * @Date 2021/11/30 10:58
     * @Param
     */
    String value() default "";

    /**
     * @Description 日志等级:自己定，此处分为1-9
     * @Author zhanglei
     * @Date 2021/11/30 10:59
     * @Param
     */
    int level() default 0;

    /**
     * @Description 操作类型(enum):主要是select,insert,update,delete
     * @Author zhanglei
     * @Date 2021/11/30 11:01
     * @Param
     */
    OperationType operationType() default OperationType.UNKNOWN;

}
