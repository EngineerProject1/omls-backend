package com.cuit9622.olms.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.common.exception.BizException;
import com.cuit9622.common.model.R;
import com.cuit9622.olms.annotation.DateAutoFill;
import com.cuit9622.olms.entity.*;
import com.cuit9622.olms.mapper.StudentMapper;
import com.cuit9622.olms.mapper.UserMapper;
import com.cuit9622.olms.model.DeleteModel;
import com.cuit9622.olms.model.UserSelectModel;
import com.cuit9622.olms.service.CollegeService;
import com.cuit9622.olms.service.MajorService;
import com.cuit9622.olms.service.StudentService;
import com.cuit9622.olms.service.UserService;
import com.cuit9622.olms.vo.StudentVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.statement.select.Wait;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@RestController
@Slf4j(topic = "StudentController")
@Api(tags = "学生信息相关Api")
public class StudentController {
    @Resource
    private StudentService studentService;

    @Resource
    private CollegeService collegeService;

    @Resource
    private MajorService majorService;

    @Resource
    private UserService userService;

    @Resource
    private StudentMapper studentMapper;

    /**
     * 分页查询
     * @param pageSize
     * @param page
     * @return
     */
    @GetMapping("/student")
    @ApiOperation("学生信息分页查询的接口")
    public R<Page<StudentVo>> getStudents (UserSelectModel model) {
        Page<StudentVo> info = studentService.selectStudents(model.getPageSize(),model.getPage(),model);
        return R.ok("查询学生信息成功", info);
    }

    /**
     * 查询指定id学生信息
     * @param sid
     * @return
     */
    @GetMapping("/student/{sid}")
    @ApiOperation("通过id获取学生信息")
    public R<Student> getStudent(@PathVariable String sid) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, sid);
        User user = userService.getOne(wrapper);
        if(user == null) {
            return R.ok("未查询到该学生");
        }
        else {
            StudentVo student = studentService.getStudentInfoByUsername(sid);
            return R.ok("查询学生信息成功",student);
        }
    }

    /**
     * 查询学院信息
     * @return
     */
    @GetMapping("/student/college")
    @ApiOperation("获取学院信息")
    public R<List<College>> getColleges(){
        return R.ok("学院信息查询成功",collegeService.list());
    }

    /**
     * 查询所选学院对应的专业信息
     * @return
     */
    @GetMapping("/student/major/{id}")
    @ApiOperation("通过id获取学院所对应的专业信息")
    public R<List<Major>> getMajors(@PathVariable Long id) {
        List<Major> majors = majorService.selectMajorsByCollegeId(id);
        if(majors == null) {
            throw new BizException(404,"查询专业信息失败");
        }
        return R.ok("查询专业信息成功",majors);
    }

    /**
     * 查询用户角色
     * @param id
     * @return
     */
    @GetMapping("/student/role/{id}")
    public R<List<String>> getRoleId(@PathVariable Long id) {
        List<String> roles = userService.getUserRoleByName(id.toString());
        return R.ok("查询角色信息成功",roles);
    }

    /**
     * 添加学生信息至学生表、用户表、角色表
     * @param studentVo
     * @return
     */
    @PostMapping("/student")
    @DateAutoFill(DateAutoFill.Type.INSERT)
    public R<String> addStudent(@RequestBody StudentVo studentVo) {
        studentService.saveWithUserAndRole(studentVo);
        return R.ok("添加学生信息成功");
    }

    /**
     * 在学生表、用户表、角色表中修改学生信息
     * @param studentVo
     * @return
     */
    @PutMapping("/student")
    @DateAutoFill(DateAutoFill.Type.UPDATE)
    public R<String> updateStudent(@RequestBody StudentVo studentVo) {
        studentService.updateWithUserAndRole(studentVo);
        return R.ok("修改学生信息成功");
    }

    /**
     * 在学生表、用户表、角色表中删除学生信息
     * @param studentVo
     * @return
     */
    @DeleteMapping("/student")
    @DateAutoFill(DateAutoFill.Type.UPDATE)
    public R<String> deleteStudent(@RequestBody StudentVo studentVo) {
        studentService.deleteWithUserAndRole(studentVo);
        return R.ok("删除学生信息成功");
    }

    /**
     * 在学生表、用户表、角色表中批量删除学生信息
     * @param model
     * @return
     */
    @DeleteMapping("/students")
    @DateAutoFill(DateAutoFill.Type.UPDATE)
    public R<String> deleteStudentsByids(@RequestBody DeleteModel model) {
        studentService.deleteBatchWithUserAndRole(model.getIds());
        return R.ok("批量删除学生信息成功");
    }
    @GetMapping("/import")
    public R<String> importExcel() throws FileNotFoundException {
        studentService.importExcel();
        return R.ok("导入学生信息成功");
    }

    @GetMapping ("/export")
    public R<String> exportExcel(HttpServletResponse response) throws IOException {
        List<StudentVo> list = studentMapper.getStudentVos();
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("学生信息表","UTF-8").replaceAll("\\+","%20");
        response.setHeader("Content-disposition","attachment;filename="+fileName+".xlsx");

        EasyExcel.write(response.getOutputStream())
                .head(StudentVo.class)
                .excelType(ExcelTypeEnum.XLSX)
                .sheet("学生信息表")
                .doWrite(list);
        return R.ok("导出学生信息成功");
    }
}
