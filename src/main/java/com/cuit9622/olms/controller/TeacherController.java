package com.cuit9622.olms.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.common.model.R;
import com.cuit9622.olms.entity.Student;
import com.cuit9622.olms.entity.Teacher;
import com.cuit9622.olms.model.UserSelectModel;
import com.cuit9622.olms.service.TeacherService;
import com.cuit9622.olms.vo.StudentVo;
import com.cuit9622.olms.vo.TeacherVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j(topic = "TeacherController")
@Api(tags = "教师信息相关Api")
public class TeacherController {
    @Resource
    private TeacherService teacherService;

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
        TeacherVo teacher = teacherService.getTeacherInfoByUsername(tid);
        if(teacher == null) {
            return R.ok("未查找到对应职工号教师信息");
        }
        return R.ok("查询教师信息成功",teacher);
    }
}
