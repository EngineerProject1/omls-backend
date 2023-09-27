package com.cuit9622.olms.UserService;

import com.cuit9622.common.utils.DigestsUtils;
import com.cuit9622.olms.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * Author: lsh
 * Version: 1.0
 * @Description: UserService的测试类
 */
@SpringBootTest
public class UserServiceTest {
    @Resource
    UserService userService;

    /**
     * @Description 测试加密工具类
     * @return
     */
    @Test
    public void testPwd() {
        String password = DigestsUtils.encrypt("123456").get("password");
        String salt = DigestsUtils.encrypt("123456").get("salt");
        System.out.println(password);
        System.out.println(salt);
        System.out.println(DigestsUtils.encrypt("123456"));
    }

    /**
     * @Description 测试mapper中的getUseRoleByName
     * @return
     */
    @Test
    public void testMapper(){
        System.out.println(userService.getUserRoleByName("2021001"));
    }
}
