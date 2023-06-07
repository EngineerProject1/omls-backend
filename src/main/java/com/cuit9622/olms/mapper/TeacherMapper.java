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

    /**
     * 教师信息分页查询你
     * @param pageInfo 分页信息
     * @param model Model
     * @return
     */
    Page<TeacherVo> page(@Param("page") Page<TeacherVo> pageInfo, @Param("model") UserSelectModel model);

    /**
     * 在教师表、用户表和角色表中增添教师信息
     * @param teacherVo 教师完整信息
     */
    void saveTeacher(@Param("teacherVo") TeacherVo teacherVo);

    /**
     * 在教师表、用户表和角色表中修改教师信息
     * @param teacherVo 教师完整信息
     */
    void updateTeacher(@Param("teacherVo") TeacherVo teacherVo);

    /**
     * 通过职工号在教师表、用户表和角色表中删除教师信息
     * @param tid 职工号
     */
    void removeTeacherByTid(Long tid);

    /**
     * 获取所有教师在用户表和教师表中的信息
     * @return 教师列表
     */
    List<TeacherVo> getTeacherVos();

    /**
     * @Description 获取所有教师的姓名和学号
     * @return
     * @Date 21:00 2023/5/22
     */
    @MapKey("id")
    List<Map<Long, String>> selectTeacherNameAndId();
}




