package com.cuit9622.auth.jwt;

import com.alibaba.fastjson.JSON;
import com.cuit9622.common.model.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Author: lsh
 * Version: 1.0
 * @Description: jwt的过滤链
 */
@Slf4j(topic = "JwtFilter")
@Component
public class JwtFilter extends AccessControlFilter {

    /**
     * @Description 请求到来以后响应的方法
     * @return
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        return false;
    }

    /**
     * @Description 认证未通过执行的方法
     * @return
     */
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 统一异常处理
        try {
            String token = request.getHeader("token");
            JwtToken jwtToken = new JwtToken(token);
            // 对该token进行认证
            // 在login中进行token的认证也就是在jwtRealm进行认证
            Subject subject = SecurityUtils.getSubject();
            subject.login(jwtToken);
        } catch (Exception e) {
            log.info("令牌错误" + e.getMessage());
            String json = JSON.toJSONString(R.error(401, e.getMessage(), "token异常"));
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(json);
            return false;
        }
        return true;
    }
}
