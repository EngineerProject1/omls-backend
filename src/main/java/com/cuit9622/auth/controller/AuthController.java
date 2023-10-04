package com.cuit9622.auth.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cuit9622.auth.util.JWTUtils;
import com.cuit9622.common.exception.BizException;
import com.cuit9622.common.model.R;
import com.cuit9622.common.utils.DigestsUtils;
import com.cuit9622.common.utils.RedisUtils;
import com.cuit9622.olms.entity.User;
import com.cuit9622.olms.service.StudentService;
import com.cuit9622.olms.service.TeacherService;
import com.cuit9622.olms.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * Author: lsh
 * Version: 1.0
 * @Description: 认证控制器
 */
@RestController
@Slf4j(topic = "AuthController")
@Api(tags = "认证相关API")
public class AuthController {

    private final Integer expireDate = 7;

    @Resource
    private UserService userService;

    @Resource
    private TeacherService teacherService;

    @Resource
    private StudentService studentService;

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
        instance.add(Calendar.DATE, expireDate);
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

    /**
     * @Description 用户登出
     */
    @GetMapping ("/auth/logout")
    @ApiOperation("用户登出的接口")
    public R<String> logout(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        redisTemplate.delete(RedisUtils.JWT_TOKEN + user.getUsername());
        return R.ok("退出登录成功");
    }

    /**
     * @Description 根据用户选择的用户，重新签发token
     * @param role
     * @return
     */
    @PostMapping("/auth/roleToken")
    @ApiOperation("根据用户选择的用户，重新签发token")
    public R<String> selectRole(String role){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        // 加入用户选择的角色
        Map<String, Object> map = new HashMap<>();
        map.put("selectedRole", role);
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, expireDate);

        String token = JWTUtils.creatToken(map,user.getUsername(), instance.getTime());
        // 将token存到redis中
        redisTemplate.opsForValue().set(RedisUtils.JWT_TOKEN + user.getUsername(), token);
        redisTemplate.expireAt(RedisUtils.JWT_TOKEN, instance.getTime());
        return R.ok("选择身份成功", token);
    }

    /**
     * @Description 根据请求头中token信息获取用户信息
     * @return 用户信息
     */
    @GetMapping("/auth/token")
    @ApiOperation("根据token获取用户信息")
    public R<User> getUserInfoByToken(HttpServletRequest request) {
        String token = request.getHeader("token");
        String username = null;
        try {
            username = JWTUtils.verify(token).getSubject();
        } catch (Exception e) {
            throw new BizException(401, "token异常");
        }

        // 查询用户的角色信息
        List<String> roles = userService.getUserRoleByName(username);
        for (String role : roles) {
            if ("teacher".equals(role)) {
                return R.ok("获取用户信息成功", teacherService.getTeacherInfoByUsername(username));
            }
            if ("student".equals(role)) {
                return R.ok("获取用户信息成功", studentService.getStudentInfoByUsername(username));
            }
        }
        // 条件构造器，根据用户名查询用户信息
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(User::getId, User::getUsername, User::getRealName,
                User::getSex, User::getAvatar, User::getPhone,
                User::getEmail, User::getCreateTime, User::getUpdateTime);
        wrapper.eq(username != null, User::getUsername, username);

        return R.ok("获取用户信息成功", userService.getOne(wrapper));
    }
}
