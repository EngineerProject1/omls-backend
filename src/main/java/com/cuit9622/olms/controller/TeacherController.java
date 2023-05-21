package com.cuit9622.olms.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.common.model.R;
import com.cuit9622.olms.annotation.DateAutoFill;
import com.cuit9622.olms.entity.Student;
import com.cuit9622.olms.entity.Teacher;
import com.cuit9622.olms.entity.User;
import com.cuit9622.olms.mapper.TeacherMapper;
import com.cuit9622.olms.model.DeleteModel;
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
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@RestController
@Slf4j(topic = "TeacherController")
@Api(tags = "教师信息相关Api")
public class TeacherController {
    @Resource
    private TeacherService teacherService;
    @Resource
    private UserService userService;
    @Resource
    private TeacherMapper teacherMapper;

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

    /**
     * 在教师表、用户表、角色表中修改教师信息
     * @param teacherVo
     * @return
     */
    @PutMapping("/teacher")
    @DateAutoFill(DateAutoFill.Type.UPDATE)
    public R<String> updateStudent(@RequestBody TeacherVo teacherVo) {
        teacherService.updateWithUserAndRole(teacherVo);
        return R.ok("修改教师信息成功");
    }

    /**
     * 在教师表、用户表、角色表中删除教师信息
     * @param teacherVo
     * @return
     */
    @DeleteMapping("/teacher")
    @DateAutoFill(DateAutoFill.Type.UPDATE)
    public R<String> deleteTeacher(@RequestBody TeacherVo teacherVo) {
        teacherService.deleteWithUserAndRole(teacherVo);
        return R.ok("删除教师信息成功");
    }

    /**
     * 在教师表、用户表、角色表中批量删除教师信息
     * @param model
     * @return
     */
    @DeleteMapping("/teachers")
    @DateAutoFill(DateAutoFill.Type.UPDATE)
    public R<String> deleteTeachersByids(@RequestBody DeleteModel model) {
        teacherService.deleteBatchWithUserAndRole(model.getIds());
        return R.ok("批量删除教师信息成功");
    }

    /**
     * 导出教师信息为excel供用户下载
     * @param response
     * @throws IOException
     */
    @GetMapping ("/teacher/export")
    public void exportExcel(HttpServletResponse response) throws IOException {
        List<TeacherVo> list = teacherMapper.getTeacherVos();
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("教师信息表","UTF-8").replaceAll("\\+","%20");
        response.setHeader("Content-disposition","attachment;filename="+fileName+".xlsx");

        EasyExcel.write(response.getOutputStream())
                .head(TeacherVo.class)
                .excelType(ExcelTypeEnum.XLSX)
                .sheet("教师信息表")
                .doWrite(list);
    }
}
