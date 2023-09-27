package com.cuit9622.olms.controller;

import com.cuit9622.common.exception.BizException;
import com.cuit9622.common.model.R;
import com.cuit9622.olms.entity.User;
import com.cuit9622.olms.service.UserService;
import com.cuit9622.olms.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Author: lsh
 * Version: 1.0
 *
 * @Description: 用户控制器
 */
@Slf4j(topic = "UserController")
@RestController
@Api(tags = "用户相关API")
@RequestMapping("/auth")
public class UserController {
    @Resource
    private UserService userService;
    @PutMapping("/info")
    @ApiOperation("用户自己修改联系信息")
    @RequiresRoles(value = {"admin","teacher","student"}, logical = Logical.OR)
    public R<String> updateContact(@RequestParam String phone, @RequestParam String email,@RequestParam String avatar) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String userName = user.getUsername();
        Boolean result =userService.updateUserContactInformationByUserName(userName, phone, email,avatar);
        if(!result){
            throw new BizException(402,"修改用户信息失败");
        }
        return R.ok("修改用户信息成功");
    }
    @PutMapping("/password")
    @ApiOperation("用户自己修改密码")
    @RequiresRoles(value = {"admin","teacher","student"}, logical = Logical.OR)
    public R<String> updatePassword(@RequestParam String oldPassword, @RequestParam String newPassword){
        if(userService.updatePassword(oldPassword,newPassword)==-1){
            throw new BizException(402,"旧密码有误");
        }
        return R.ok("用户密码修改成功");
    }
}
