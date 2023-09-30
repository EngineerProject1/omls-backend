package com.cuit9622.olms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.olms.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cuit9622.olms.model.UserSelectModel;
import com.cuit9622.olms.vo.TeacherVo;

import java.util.List;

/**
 * @Description 教师接口
 * @return
 */
public interface TeacherService extends IService<Teacher> {

    /**
     * @Description 根据用户名查询教师信息
     * @param username 用户名
     * @return
     */
    TeacherVo getTeacherInfoByUsername(String username);

    Page<TeacherVo> selectTeachers(Integer pageSize, Integer page, UserSelectModel model);

    void saveWithUserAndRole(TeacherVo teacherVo);

    void updateWithUserAndRole(TeacherVo teacherVo);

    void deleteWithUserAndRole(TeacherVo teacherVo);

    void deleteBatchWithUserAndRole(List<Integer> ids);
}
