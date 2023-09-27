package com.cuit9622.common.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: lsh
 * Version: 1.0
 * @Description: mybatis配置类
 */
@Slf4j(topic = "mybatis配置类")
@Configuration
public class MyBatisConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
        // 设置请求的页面大于最大页后的操作，true调回到首页，false继续请求
        paginationInnerInterceptor.setOverflow(true);
        // 设置最大但也限制数量，默认500条，-1不受限制
        paginationInnerInterceptor.setMaxLimit(-1L);

        paginationInnerInterceptor.setDbType(DbType.MYSQL);
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(paginationInnerInterceptor);
        return interceptor;
    }
}
