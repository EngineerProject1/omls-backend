package com.cuit9622.olms.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.olms.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cuit9622.olms.vo.StudentVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author Zxin
* @description 针对表【sys_user_student(学生表)】的数据库操作Mapper
* @Entity com.cuit9622.olms.entity.Student
*/
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    Page<StudentVo> page(@Param("page") Page<StudentVo> page);
}




