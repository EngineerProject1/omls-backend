package com.cuit9622.olms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.common.model.R;
import com.cuit9622.olms.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cuit9622.olms.vo.NoticeVo;
import com.cuit9622.olms.vo.StudentVo;

/**
* @author Zxin
* @description 针对表【sys_user_student(学生表)】的数据库操作Service
*/
public interface StudentService extends IService<Student> {
    /**
     * @Description 分页查询公告
     * @param pageSize 条数
     * @param page 第几页
     * @return
     */
     R<Page<StudentVo>> selectStudents(Integer pageSize, Integer page);

    /**
     * @Description 得到学生的信息
     * @param username
     * @return
     */
     StudentVo getStudentInfoByUsername(String username);

     void saveWithUserAndRole(StudentVo studentVo);
}
