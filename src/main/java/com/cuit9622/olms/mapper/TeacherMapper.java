package com.cuit9622.olms.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.olms.entity.Teacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cuit9622.olms.model.UserSelectModel;
import com.cuit9622.olms.vo.TeacherVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    Page<TeacherVo> page(@Param("page") Page<TeacherVo> pageInfo, @Param("model") UserSelectModel model);

    void saveTeacher(@Param("teacherVo") TeacherVo teacherVo);

    void updateTeacher(@Param("teacherVo") TeacherVo teacherVo);
}




