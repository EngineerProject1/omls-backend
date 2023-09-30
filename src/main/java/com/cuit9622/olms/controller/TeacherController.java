package com.cuit9622.olms.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.common.model.R;
import com.cuit9622.olms.annotation.DateAutoFill;
import com.cuit9622.olms.entity.Student;
import com.cuit9622.olms.entity.Teacher;
import com.cuit9622.olms.entity.User;
import com.cuit9622.olms.model.UserSelectModel;
import com.cuit9622.olms.service.TeacherService;
import com.cuit9622.olms.service.UserService;
import com.cuit9622.olms.vo.StudentVo;
import com.cuit9622.olms.vo.TeacherVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j(topic = "TeacherController")
@Api(tags = "教师信息相关Api")
public class TeacherController {
    @Resource
    private TeacherService teacherService;
    @Resource
    private UserService userService;

    @GetMapping("/teacher")
    @ApiOperation("教师信息分页查询的接口")
    public R<Page<TeacherVo>> getTeachers(UserSelectModel model) {
        Page<TeacherVo> info = teacherService.selectTeachers(model.getPageSize(), model.getPage(), model);
        return R.ok("查询教师信息成功", info);
    }

    /**
     * 查询指定tid教师信息
     * @param tid
     * @return
     */
    @GetMapping("/teacher/{tid}")
    @ApiOperation("通过tid获取教师信息")
    public R<Teacher> getTeacher(@PathVariable String tid) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, tid);
        User user = userService.getOne(wrapper);
        if(user == null) {
            return R.ok("未查询到该教师");
        }
        else {
            TeacherVo teacher = teacherService.getTeacherInfoByUsername(tid);
            return R.ok("查询教师信息成功",teacher);
        }
    }

    /**
     * 添加教师信息至教师表、用户表、角色表
     * @param teacherVo
     * @return
     */
    @PostMapping("/teacher")
    @DateAutoFill(DateAutoFill.Type.INSERT)
    public R<String> addTeacher(@RequestBody TeacherVo teacherVo) {
        teacherService.saveWithUserAndRole(teacherVo);
        return R.ok("添加教师信息成功");
    }
}
