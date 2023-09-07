package com.cuit9622.common.exception;

/**
 * Author: lsh
 * Version: 1.0
 * @Description: 自定义业务异常类
 */
public class BizException extends RuntimeException {
    private Integer code;

    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
