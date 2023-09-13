package com.cuit9622.auth.controller;

import com.cuit9622.auth.util.JWTUtils;
import com.cuit9622.common.exception.BizException;
import com.cuit9622.common.model.R;
import com.cuit9622.common.utils.DigestsUtils;
import com.cuit9622.common.utils.RedisUtils;
import com.cuit9622.olms.entity.User;
import com.cuit9622.olms.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Author: lsh
 * Version: 1.0
 * @Description: 认证控制器
 */
@RestController
@Slf4j(topic = "AuthController")
@Api(tags = "认证相关API")
public class AuthController {

    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * @Description 执行登录操作
     * @param user 用户对象
     * @return R
     */
    @PostMapping("/login")
    @ApiOperation("用户登录的接口")
    public R<Map<String, Object>> auth(@RequestBody User user) {
        User userOne = userService.getUserInfoByName(user.getUsername());
        if (userOne == null) {
            throw new BizException(401, "用户名或密码错误");
        }

        String passwordByDigests = DigestsUtils.sha1(user.getPassword(), userOne.getSalt());
        if (!userOne.getPassword().equals(passwordByDigests)) {
            throw new BizException(401, "用户名或密码错误");
        }
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 2);
        String token = JWTUtils.creatToken(user.getUsername(), instance.getTime());
        // 将token存到redis中
        redisTemplate.opsForValue().set(RedisUtils.JWT_TOKEN + user.getUsername(), token);
        redisTemplate.expireAt(RedisUtils.JWT_TOKEN, instance.getTime());

        // 拿到用户的角色信息
        List<String> roles = userService.getUserRoleByName(user.getUsername());
        Map<String, Object> data = new HashMap<>();
        data.put("roles", roles);
        data.put("token", token);
        log.info("{}的角色为{}", user.getUsername(), roles.toString());
        return R.ok("登录成功", data);
    }

}
