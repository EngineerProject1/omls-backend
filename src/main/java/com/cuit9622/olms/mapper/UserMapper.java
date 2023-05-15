package com.cuit9622.olms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cuit9622.olms.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author: lsh
 * Date: 2023/4/17 16:58
 * Version: 1.0
 * @Description: 用户mapper
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * @Description 通过用户名获取角色信息
     * @param username 用户名
     * @return
     * @Date 16:46 2023/5/11
     */
    List<String> getUserRoleInfoByUsername(@Param("username") String username);

    /**
     * @Description 通过用户名修改用户信息
     * @param username 用户名
     * @param phone    电话号码
     * @param email    邮箱
     * @param avatar   头像
     * @return Boolean
     */
    Boolean updateContactByUserName(@Param("username") String username, @Param("phone")String phone, @Param("email")String email, @Param("avatar")String avatar);

    /**
     * 通过学号sid获取用户id
     * @param sid
     * @return
     */

    Long getUserIdBySid(long sid);
}
