package com.cuit9622.olms.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.olms.entity.Teacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cuit9622.olms.model.UserSelectModel;
import com.cuit9622.olms.vo.TeacherVo;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Description 教师Mapper
 */
@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {

    /**
     * @Description 根据用户名查询教师信息
     * @param username 用户名
     * @return
     */
    TeacherVo getTeacherInfoByUsername(String username);

    Page<TeacherVo> page(@Param("page") Page<TeacherVo> pageInfo, @Param("model") UserSelectModel model);

    void saveTeacher(@Param("teacherVo") TeacherVo teacherVo);

    void updateTeacher(@Param("teacherVo") TeacherVo teacherVo);

    void removeTeacherByTid(Long tid);

    List<TeacherVo> getTeacherVos();

    /**
     * @Description 获取所有教师的姓名和学号
     * @return
     */
    @MapKey("id")
    List<Map<Long, String>> selectTeacherNameAndId();
}




