package com.earl.common.core.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @ClassName: OperationType
 * @author: zhanglei
 * @Date: 2021/11/30 11:05
 * @Description: 日志操作类型
 */
@Getter
@RequiredArgsConstructor
public enum OperationType {

    UNKNOWN(-1, "UNKNOWN", "未知错误"),
    DELETE(1, "DELETE", "删除操作"),
    SELECT(1, "SELECT", "查询操作"),
    UPDATE(1, "UPDATE", "更新操作"),
    INSERT(1, "INSERT", "插入操作"),
    ERROR(0, "ERROR", "操作失败"),
    SUCCESS(200, "SUCCESS", "成功"),
    FAIL(500, "ERROR", "失败");

    private final int num;

    private final String type;

    private final String desc;
}
