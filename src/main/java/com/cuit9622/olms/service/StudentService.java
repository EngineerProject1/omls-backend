package com.cuit9622.olms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.olms.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cuit9622.olms.model.UserSelectModel;
import com.cuit9622.olms.vo.StudentVo;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

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
     Page<StudentVo> selectStudents(Integer pageSize, Integer page, UserSelectModel model);

    /**
     * @Description 得到学生的信息
     * @param username
     * @return
     */
     StudentVo getStudentInfoByUsername(String username);

     void saveWithUserAndRole(StudentVo studentVo);

    void updateWithUserAndRole(StudentVo studentVo);

    void deleteWithUserAndRole(StudentVo studentVo);

    void deleteBatchWithUserAndRole(List<Integer> sids);


    void exportExcel(HttpServletResponse response) throws IOException;


    void importExcel() throws FileNotFoundException;
}
