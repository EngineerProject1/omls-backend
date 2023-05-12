package com.cuit9622.auth.config;

import com.cuit9622.auth.jwt.JwtFilter;
import com.cuit9622.auth.jwt.JwtRealm;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Author: lsh
 * Date: 2023/4/17 16:51
 * Version: 1.0
 * @Description:
 */
@Slf4j(topic = "shiro配置类")
@Configuration
public class ShiroConfig {
    @Resource
    private JwtRealm jwtRealm;

    // 配置SecurityManager
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager() {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(jwtRealm);

        // 关闭Shiro的会话功能
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator  = new DefaultSessionStorageEvaluator();
        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);

        manager.setSubjectDAO(subjectDAO);
        return manager;
    }

    // 配置权限过滤器
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean filter = new ShiroFilterFactoryBean();
        // 注入安全管理器
        filter.setSecurityManager(defaultWebSecurityManager());

        // 如果用户未登录，跳转到认证的接口
        filter.setLoginUrl("/un-auth");

        // 设置自定义的过滤器
        Map<String, Filter> filters = new LinkedHashMap<>();
        filters.put("jwtFilter", new JwtFilter());
        filter.setFilters(filters);

        // 设置拦截规则链
        Map<String, String> chain = new LinkedHashMap<>();
        // 设置login不需要拦截
        chain.put("/login", "anon");
        // 路径中含有auth的全部拦截
        chain.put("/auth/**", "jwtFilter");

        filter.setFilterChainDefinitionMap(chain);
        return filter;
    }

    // 添加注解支持
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }
}
