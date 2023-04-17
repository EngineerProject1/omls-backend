package com.cuit9622.olms.UserService;

import com.cuit9622.common.utils.DigestsUtils;
import com.cuit9622.olms.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Author: lsh
 * Date: 2023/4/17 17:04
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
     * @Date 18:15 2023/4/17
     */
    @Test
    public void testPwd() {
        System.out.println(DigestsUtils.encrypt("123456"));
    }

    /**
     * @Description 测试mapper中的getUseRoleByName
     * @return
     * @Date 18:17 2023/4/17
     */
    @Test
    public void testMapper(){
        System.out.println(userService.getUserRoleByName("2021001"));
    }
}
