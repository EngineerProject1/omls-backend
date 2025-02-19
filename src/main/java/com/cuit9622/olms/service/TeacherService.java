package com.cuit9622.olms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.olms.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cuit9622.olms.entity.TeacherReadListener;
import com.cuit9622.olms.model.UserSelectModel;
import com.cuit9622.olms.vo.TeacherVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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

    /**
     * 教师分页查询
     * @param pageSize 条数
     * @param page 第几页
     * @param model 搜索条件
     * @return 教师分页信息
     */
    Page<TeacherVo> selectTeachers(Integer pageSize, Integer page, UserSelectModel model);

    /**
     * 在教师表、用户表、角色表中添加教师信息
     * @param teacherVo TeacherVo对象
     */
    void saveWithUserAndRole(TeacherVo teacherVo);

    /**
     * 在教师表、用户表、角色表中修改教师信息
     * @param teacherVo TeacherVo对象
     */
    void updateWithUserAndRole(TeacherVo teacherVo);

    /**
     * 在教师表、用户表、角色表中删除教师信息
     * @param teacherVo TeacherVo对象
     */
    void deleteWithUserAndRole(TeacherVo teacherVo);

    /**
     * 通过tid在教师表、用户表、角色表中批量删除教师信息
     * @param tids 教师tid列表
     */
    void deleteBatchWithUserAndRole(List<Integer> tids);

    /**
     * 从用户传入的excel表中导入教师信息
     * @param file excel文件
     * @param listener 教师监听器
     * @throws IOException
     */
    void importExcel(MultipartFile file, TeacherReadListener listener) throws IOException;


    /**
     * @Description 获取所有教师的名字和姓名
     * @return
     */
    List<Map<Long, String>> getStudentNameAndId();
}
