package com.cuit9622;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
@EnableAspectJAutoProxy
public class OLMSApplication {

    public static void main(String[] args) {
        SpringApplication.run(OLMSApplication.class, args);
    }

}
