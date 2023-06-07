package com.cuit9622.olms.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.olms.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cuit9622.olms.model.StudentClass;
import com.cuit9622.olms.model.UserSelectModel;
import com.cuit9622.olms.vo.StudentVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Zxin
* @description 针对表【sys_user_student(学生表)】的数据库操作Mapper
* @createDate 2023-05-10 22:12:55
* @Entity com.cuit9622.olms.entity.Student
*/
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    /**
     * @Description 学生的分页查找
     * @param page 第几页
     * @return 学生信息
     * @Date 16:44 2023/5/11
     */
    Page<StudentVo> page(@Param("page") Page<StudentVo> page, @Param("model") UserSelectModel model);

    /**
     * @Description 通过username获取学生信息
     * @param username
     * @return
     * @Date 16:44 2023/5/11
     */
    StudentVo getStudentInfoByUsername(String username);

    /**
     * 在学生表、用户表和角色表中增添学生信息
     * @param studentVo 学生完整信息
     */
    void saveStudent(@Param("studentVo") StudentVo studentVo);

    /**
     * 在学生表、用户表和角色表中修改学生信息
     * @param studentVo 学生完整信息
     */
    void updateStudent(@Param("studentVo") StudentVo studentVo);

    /**
     * 通过学号在学生表、用户表和角色表中删除学生信息
     * @param sid 学号
     */
    void removeStudentBySid(Long sid);

    /**
     * 获取所有学生信息
     * @return 学生信息
     */
    List<Student> getStudents();

    /**
     * 获取学生完整信息
     * @return 学生在用户表与学生表中的信息
     */
    List<StudentVo> getStudentVos();

    List<StudentClass> getStudentClassVo(@Param("majorId") Integer majorId);
}