package com.cuit9622.olms.annotation;

import java.lang.annotation.*;

/**
 * Author: lsh
 * Version: 1.0
 * @Description: 自定义注解，用于aop自动注入时间
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DateAutoFill {
    enum Type{
        INSERT,UPDATE
    }
    // 操作类型
    Type value();

}
