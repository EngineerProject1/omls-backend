package com.cuit9622.common.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Author: lsh
 * Version: 1.0
 *
 * @Description: Swagger接口文档配置类
 */
@Slf4j(topic = "Swagger")
@EnableSwagger2
@EnableKnife4j
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        RequestParameterBuilder tokenBuilder = new RequestParameterBuilder();
        // 添加token请求头
        RequestParameter build = tokenBuilder
                .name("token")
                .description("token")
                .required(false)
                .in("header")
                .accepts(Collections.singleton(MediaType.APPLICATION_JSON))
                .build();
        List<RequestParameter> requestParameters = new ArrayList<>();
        requestParameters.add(build);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .globalRequestParameters(requestParameters)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build();

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("接口文档")
                .contact(new Contact("9622", "https://www.9622.com", "3040114965@@qq.com"))
                .version("V1.0")
                .description("开放实验管理平台接口文档")
                .build();
    }
}
