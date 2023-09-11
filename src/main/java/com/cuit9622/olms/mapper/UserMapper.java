package com.cuit9622.olms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cuit9622.olms.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author: lsh
 * Version: 1.0
 * @Description: 用户mapper
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<String> getUserRoleInfoByUsername(@Param("username") String username);
}
