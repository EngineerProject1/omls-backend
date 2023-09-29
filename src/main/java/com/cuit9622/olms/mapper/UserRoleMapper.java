package com.cuit9622.olms.mapper;

import com.cuit9622.olms.entity.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author Zxin
* @description 针对表【sys_user_role(用户和角色的关系表)】的数据库操作Mapper
* @Entity com.cuit9622.olms.entity.UserRole
*/
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {
    /**
     * 通过userId查询该用户是否是管理员
     * @param userId
     * @return
     */
    UserRole getManagerByUserId(Long userId);
}




