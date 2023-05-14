package com.cuit9622.olms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cuit9622.olms.entity.UserRole;
import com.cuit9622.olms.service.UserRoleService;
import com.cuit9622.olms.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author Zxin
* @description 针对表【sys_user_role(用户和角色的关系表)】的数据库操作Service实现
* @createDate 2023-05-13 00:25:42
*/
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole>
    implements UserRoleService{
    @Resource
    private UserRoleMapper userRoleMapper;

    /**
     * 通过userId查询该用户是否是管理员
     * @param userId
     * @return
     */
    @Override
    public UserRole getManagerByUserId(Long userId) {
        UserRole userRole = userRoleMapper.getManagerByUserId(userId);
        return userRole;
    }

    /**
     * 通过userId删除管理员角色
     * @param userId
     */
    @Override
    public void removeUserRoleByUserId(Long userId) {
        userRoleMapper.removeUserRoleByUserId(userId);
    }
}




