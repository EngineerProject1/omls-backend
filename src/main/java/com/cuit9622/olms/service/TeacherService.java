package com.cuit9622.olms.service;

import com.cuit9622.olms.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cuit9622.olms.vo.TeacherVo;

/**
 * @Description 教师接口
 * @return
 * @Date 16:32 2023/5/11
 */
public interface TeacherService extends IService<Teacher> {

    /**
     * @Description 根据用户名查询教师信息
     * @param username 用户名
     * @return
     * @Date 18:23 2023/5/11
     */
    TeacherVo getTeacherInfoByUsername(String username);
}
