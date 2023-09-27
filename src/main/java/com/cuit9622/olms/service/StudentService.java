package com.cuit9622.olms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.olms.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cuit9622.olms.entity.StudentReadListener;
import com.cuit9622.olms.model.UserSelectModel;
import com.cuit9622.olms.vo.StudentVo;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

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
     * @param username 用户名
     * @return
     */
     StudentVo getStudentInfoByUsername(String username);

    /**
     * 添加学生信息至学生表、用户表和角色表
     * @param studentVo StudentVo对象
     */
    void saveWithUserAndRole(StudentVo studentVo);

    /**
     * 在学生表、用户表和角色表中修改学生信息
     * @param studentVo StudentVo对象
     */
    void updateWithUserAndRole(StudentVo studentVo);

    /**
     * 在学生表、用户表和角色表中删除学生信息
     * @param studentVo StudentVo对象
     */
    void deleteWithUserAndRole(StudentVo studentVo);

    /**
     * 通过sid在学生表、用户表和角色表中批量删除学生信息
     * @param sids 学生sid列表
     */
    void deleteBatchWithUserAndRole(List<Integer> sids);

    /**
     * 从excel中导入学生信息
     * @param file excel文件
     * @param listener 学生监听器
     * @throws IOException
     */
    void importExcel(MultipartFile file, StudentReadListener listener) throws IOException;
}
