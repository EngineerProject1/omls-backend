package com.cuit9622.olms.mapper;

import com.cuit9622.olms.entity.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Zxin
* @description 针对表【sys_user_role(用户和角色的关系表)】的数据库操作Mapper
* @createDate 2023-05-13 00:25:42
* @Entity com.cuit9622.olms.entity.UserRole
*/
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {

}




