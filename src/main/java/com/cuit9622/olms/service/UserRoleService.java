package com.cuit9622.olms.service;

import com.cuit9622.olms.entity.UserRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Zxin
* @description 针对表【sys_user_role(用户和角色的关系表)】的数据库操作Service
*/
public interface UserRoleService extends IService<UserRole> {
    /**
     * 通过userId查询该用户是否是管理员
     * @param userId 用户id
     * @return 角色实体
     */
    UserRole getManagerByUserId(Long userId);

    /**
     * 通过用户id移除角色表中的信息
     * @param userId 用户id
     */
    void removeUserRoleByUserId(Long userId);
}
