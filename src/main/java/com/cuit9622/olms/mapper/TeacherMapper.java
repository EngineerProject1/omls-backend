package com.cuit9622.olms.mapper;

import com.cuit9622.olms.entity.Teacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cuit9622.olms.vo.TeacherVo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description 教师Mapper
 * @Date 16:32 2023/5/11
 */
@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {

    /**
     * @Description 根据用户名查询教师信息
     * @param username 用户名
     * @return
     * @Date 17:28 2023/5/11
     */
    TeacherVo getTeacherInfoByUsername(String username);
}




