package com.earl.common.core.util;

import com.earl.common.core.enums.OperationType;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName: Result
 * @author: zhanglei
 * @Date: 2021/11/30 14:42
 * @Description:返回数据封装
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private int code;

    @Getter
    @Setter
    private String msg;

    @Getter
    @Setter
    private T data;

    public static <T> Result<T> ok() {
        return restResult(null, OperationType.SUCCESS.getNum(), OperationType.SUCCESS.getDesc());
    }

    public static <T> Result<T> ok(T data) {
        return restResult(data, OperationType.SUCCESS.getNum(), OperationType.SUCCESS.getDesc());
    }

    public static <T> Result<T> ok(T data, String msg) {
        return restResult(data, OperationType.SUCCESS.getNum(), msg);
    }

    public static <T> Result<T> failed() {
        return restResult(null, OperationType.FAIL.getNum(), OperationType.FAIL.getDesc());
    }

    public static <T> Result<T> failed(String msg) {
        return restResult(null, OperationType.FAIL.getNum(), msg);
    }

    public static <T> Result<T> failed(T data) {
        return restResult(data, OperationType.FAIL.getNum(), OperationType.FAIL.getDesc());
    }

    public static <T> Result<T> failed(T data, String msg) {
        return restResult(data, OperationType.FAIL.getNum(), msg);
    }

    private static <T> Result<T> restResult(T data, int code, String msg) {
        Result<T> apiResult = new Result<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }

}
