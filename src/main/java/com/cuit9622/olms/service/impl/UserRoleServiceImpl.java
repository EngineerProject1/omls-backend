package com.cuit9622.olms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cuit9622.olms.entity.UserRole;
import com.cuit9622.olms.service.UserRoleService;
import com.cuit9622.olms.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

/**
* @author Zxin
* @description 针对表【sys_user_role(用户和角色的关系表)】的数据库操作Service实现
*/
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole>
    implements UserRoleService{

}




