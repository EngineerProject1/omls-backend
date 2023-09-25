package com.cuit9622.olms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cuit9622.olms.entity.User;

import java.util.List;

/**
 * Author: lsh
 * Version: 1.0
 * @Description: 用户服务接口
 */
public interface UserService extends IService<User> {

    /**
     * @Description 根据用户名查询角色信息的列表
     * @param username 用户名
     * @return 角色信息列表
     */
    List<String> getUserRoleByName(String username);

    /**
     * @Description 根据用户名查询用户信息
     * @param username 用户名
     * @return
     */
    User getUserInfoByName(String username);
}
