package com.cuit9622.olms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cuit9622.olms.entity.User;
import com.cuit9622.olms.mapper.UserMapper;
import com.cuit9622.olms.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author: lsh
 * Version: 1.0
 * @Description: 用户服务接口实现类
 */
@Service
@Slf4j(topic = "UserServiceImpl")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper mapper;

    @Override
    @Cacheable(value = "rolesCache", key = "#username", unless = "#result == null")
    public List<String> getUserRoleByName(String username) {
        return mapper.getUserRoleInfoByUsername(username);
    }

    @Override
    public User getUserInfoByName(String username) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, username);
        return mapper.selectOne(wrapper);
    }
}
