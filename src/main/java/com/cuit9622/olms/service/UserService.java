package com.cuit9622.olms.service;

import com.cuit9622.olms.entity.User;

import java.util.List;

/**
 * Author: lsh
 * Date: 2023/4/17 16:56
 * Version: 1.0
 * @Description: 用户服务接口
 */
public interface UserService {

    /**
     * @Description 根据用户名查询角色信息的列表
     * @param username 用户名
     * @return 角色信息列表
     * @Date 17:15 2023/4/17
     */
    List<String> getUserRoleByName(String username);

    /**
     * @Description 根据用户名查询用户信息
     * @param username 用户名
     * @return
     * @Date 18:20 2023/4/17
     */
    User getUserInfoByName(String username);
}
