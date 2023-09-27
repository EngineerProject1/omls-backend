package com.cuit9622.olms.aop;

import com.cuit9622.olms.annotation.DateAutoFill;
import com.cuit9622.olms.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * Author: lsh
 * Version: 1.0
 * @Description: 日期创建人自动注入的切面
 */
@Aspect
@Component
@Slf4j
public class DateAutoFillAop {
    private static final String CREATE_TIME = "createTime";
    private static final String UPDATE_TIME = "updateTime";
    private static final String CREATOR = "creator";

    @Pointcut("@annotation(com.cuit9622.olms.annotation.DateAutoFill)")
    public void pointcut() {
    }

    /**
     * @Description 前置通知，用于自动填充时间和创建人员
     * @param point 切点
     * @return
     */
    @Before("pointcut()")
    public void before(JoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        DateAutoFill annotation = method.getAnnotation(DateAutoFill.class);
        DateAutoFill.Type type = annotation.value();

        if (type.compareTo(DateAutoFill.Type.INSERT) == 0) {
            beforeInsert(point);
        } else {
            beforeUpdate(point);
        }
    }

    private void beforeInsert(JoinPoint point) {
        log.info("进入beforeInsertAop");
        Object[] args = point.getArgs();
        if (args != null && args.length > 0) {
            Object arg = args[0];
            BeanWrapperImpl beanWrapper = new BeanWrapperImpl(arg);
            // 创建创建时间和修改时间
            if (beanWrapper.isWritableProperty(CREATE_TIME)) {
                beanWrapper.setPropertyValue(CREATE_TIME, new Date());
            }
            if (beanWrapper.isWritableProperty(UPDATE_TIME)) {
                beanWrapper.setPropertyValue(UPDATE_TIME, new Date());
            }

            // 设置创建人
            if (beanWrapper.isWritableProperty(CREATOR)){
                // 得到用户信息
                User user = (User) SecurityUtils.getSubject().getPrincipal();
                beanWrapper.setPropertyValue(CREATOR, user.getId());
            }
            log.info("完成时间和创建人的注入");
        }
    }

    private void beforeUpdate(JoinPoint point) {
        log.info("进入beforeUpdateAop");
        Object[] args = point.getArgs();
        if (args != null && args.length > 0) {
            Object arg = args[0];
            BeanWrapperImpl beanWrapper = new BeanWrapperImpl(arg);
            // 设置修改时间
            if (beanWrapper.isWritableProperty(UPDATE_TIME)) {
                beanWrapper.setPropertyValue(UPDATE_TIME, new Date());
            }
            log.info("完成修改时间注入");
        }
    }

}
