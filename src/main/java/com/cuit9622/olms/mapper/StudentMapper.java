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
     * @param page
     * @return
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

    void saveStudent(@Param("studentVo") StudentVo studentVo);

    void updateStudent(@Param("studentVo") StudentVo studentVo);

    void removeStudentBySid(Long sid);

    List<Student> getStudents();

    List<StudentVo> getStudentVos();
    List<StudentClass> getStudentClassVo(@Param("majorId") Integer majorId);
}