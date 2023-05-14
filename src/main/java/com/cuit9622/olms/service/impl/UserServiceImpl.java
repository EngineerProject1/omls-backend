package com.cuit9622.olms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cuit9622.common.utils.DigestsUtils;
import com.cuit9622.olms.entity.User;
import com.cuit9622.olms.mapper.UserMapper;
import com.cuit9622.olms.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Author: lsh
 * Date: 2023/4/17 17:00
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

    @Override
    public Boolean updateUserContactInformationByUserName(String username, String phone, String email,String avatar) {
        return mapper.updateContactByUserName(username, phone, email, avatar);
    }

    @Override
    public Integer updatePassword(String oldPassword,String newPassword){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String oldHash=DigestsUtils.sha1(oldPassword,user.getSalt());
        if(!StringUtils.equals(oldHash,user.getPassword())){
            return -1;
        }
        Map<String,String> map=DigestsUtils.encrypt(newPassword);
        user.setPassword(map.get("password"));
        user.setSalt(map.get("salt"));
        mapper.updateById(user);
        return 1;
    }
}
