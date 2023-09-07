package com.cuit9622.common.controller;

import com.cuit9622.common.exception.BizException;
import com.cuit9622.common.model.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Author: lsh
 * Version: 1.0
 * @Description: 全局异常处理器
 */
@Slf4j(topic = "全局异常处理器")
@RestControllerAdvice(annotations = {RestController.class, Controller.class})
public class GlobalExceptionHandler {

    /**
     * @Description 捕捉自定义业务异常
     * @param e 异常信息
     */
    @ExceptionHandler(BizException.class)
    public R handlerBizException(BizException e) {
        log.error("操作失败，请联系系统管理员", e);
        return R.error(e.getCode(), "操作失败，请联系系统管理员", e.getMessage());
    }

    /**
     * @Description 捕捉其他异常
     * @param e 其他异常
     */
    @ExceptionHandler(Throwable.class)
    public R handlerException(Throwable e) {
        log.error("服务器内部错误,{}", e.getMessage());
        return R.error(500, "服务器内部错误", e.getMessage());
    }
}
