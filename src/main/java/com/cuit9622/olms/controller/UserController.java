package com.cuit9622.olms.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: lsh
 * Date: 2023/4/17 17:32
 * Version: 1.0
 * @Description: 用户控制器
 */
@Slf4j(topic = "UserController")
@RestController
@Api(tags = "用户相关API")
@RequestMapping("/auth")
public class UserController {

}
