package com.cuit9622.olms.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.auth.util.JWTUtils;
import com.cuit9622.common.exception.BizException;
import com.cuit9622.common.model.R;
import com.cuit9622.olms.annotation.DateAutoFill;
import com.cuit9622.olms.entity.*;
import com.cuit9622.olms.service.CollegeService;
import com.cuit9622.olms.service.MajorService;
import com.cuit9622.olms.service.StudentService;
import com.cuit9622.olms.service.UserService;
import com.cuit9622.olms.vo.StudentVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

    /**
     * 分页查询
     * @param pageSize
     * @param page
     * @return
     */
    @GetMapping("/student")
    @ApiOperation("学生信息分页查询的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize", value = "每页的条数", defaultValue = "5", required = true),
            @ApiImplicitParam(name = "page", value = "页码", defaultValue = "1", required = true)
    })
    public R<Page<StudentVo>> getStudents
            ( @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
              @RequestParam(value = "page", defaultValue = "1") Integer page) {
        R<Page<StudentVo>> info = studentService.selectStudents(pageSize,page);
        log.info(info.getMsg());
        return info;
    }

    /**
     * 查询指定id学生信息
     * @param id
     * @return
     */
    @GetMapping("/student/{id}")
    @ApiOperation("通过id获取学生信息")
    public R<Student> getStudent(@PathVariable String id) {
        StudentVo student = studentService.getStudentInfoByUsername(id);
        if(student == null) {
            return R.ok("未查找到对应学号学生信息");
        }
        return R.ok("查询学生信息成功",student);
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

    @DeleteMapping("/students")
    @DateAutoFill(DateAutoFill.Type.UPDATE)
    public R<String> deleteStudentsByids(@RequestBody List<StudentVo> studentVos) {
        System.out.println(studentVos);
        return null;
    }
}
