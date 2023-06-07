package com.cuit9622.olms.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.common.exception.BizException;
import com.cuit9622.common.model.R;
import com.cuit9622.olms.annotation.DateAutoFill;
import com.cuit9622.olms.entity.*;
import com.cuit9622.olms.mapper.MajorMapper;
import com.cuit9622.olms.mapper.StudentMapper;
import com.cuit9622.olms.model.DeleteModel;
import com.cuit9622.olms.model.StudentClass;
import com.cuit9622.olms.model.UserSelectModel;
import com.cuit9622.olms.service.CollegeService;
import com.cuit9622.olms.service.MajorService;
import com.cuit9622.olms.service.StudentService;
import com.cuit9622.olms.service.UserService;
import com.cuit9622.olms.vo.StudentClassVo;
import com.cuit9622.olms.vo.StudentVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;

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

    @Resource
    private MajorMapper majorMapper;

    /**
     * 分页查询
     *
     * @param
     * @param
     * @return 学生信息
     */
    @GetMapping("/student")
    @ApiOperation("学生信息分页查询的接口")
    public R<Page<StudentVo>> getStudents(UserSelectModel model) {
        Page<StudentVo> info = studentService.selectStudents(model.getPageSize(), model.getPage(), model);
        return R.ok("查询学生信息成功", info);
    }

    /**
     * 查询指定id学生信息
     *
     * @param sid 学号
     * @return 指定学生id的信息
     */
    @GetMapping("/student/{sid}")
    @ApiOperation("通过id获取学生信息的接口")
    public R<Student> getStudent(@PathVariable String sid) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, sid);
        User user = userService.getOne(wrapper);
        if (user == null) {
            return R.ok("未查询到该学生");
        } else {
            StudentVo student = studentService.getStudentInfoByUsername(sid);
            return R.ok("查询学生信息成功", student);
        }
    }

    /**
     * 查询学院信息
     *
     * @return 学院列表
     */
    @GetMapping("/student/college")
    @ApiOperation("获取学院信息的接口")
    public R<List<College>> getColleges() {
        return R.ok("学院信息查询成功", collegeService.list());
    }

    /**
     * 查询所选学院对应的专业信息
     *
     * @return 学院所对应的专业列表
     */
    @GetMapping("/student/major/{id}")
    @ApiOperation("通过id获取学院所对应的专业信息的接口")
    public R<List<Major>> getMajors(@PathVariable Long id) {
        List<Major> majors = majorService.selectMajorsByCollegeId(id);
        if (majors == null) {
            throw new BizException(404, "查询专业信息失败");
        }
        return R.ok("查询专业信息成功", majors);
    }

    /**
     * 查询用户角色
     *
     * @param id 学号
     * @return 用户角色列表
     */
    @GetMapping("/student/role/{id}")
    @ApiOperation("通过学号获取用户角色的接口")
    public R<List<String>> getRoleId(@PathVariable Long id) {
        List<String> roles = userService.getUserRoleByName(id.toString());
        return R.ok("查询角色信息成功", roles);
    }

    /**
     * 添加学生信息至学生表、用户表、角色表
     *
     * @param studentVo 学生信息
     * @return
     */
    @PostMapping("/student")
    @ApiOperation("添加学生信息的接口")
    @DateAutoFill(DateAutoFill.Type.INSERT)
    public R<String> addStudent(@RequestBody StudentVo studentVo) {
        studentService.saveWithUserAndRole(studentVo);
        return R.ok("添加学生信息成功");
    }

    /**
     * 在学生表、用户表、角色表中修改学生信息
     *
     * @param studentVo 学生信息
     * @return
     */
    @PutMapping("/student")
    @ApiOperation("修改学生信息的接口")
    @DateAutoFill(DateAutoFill.Type.UPDATE)
    public R<String> updateStudent(@RequestBody StudentVo studentVo) {
        studentService.updateWithUserAndRole(studentVo);
        return R.ok("修改学生信息成功");
    }

    /**
     * 在学生表、用户表、角色表中删除学生信息
     *
     * @param studentVo 学生信息
     * @return
     */
    @DeleteMapping("/student")
    @ApiOperation("删除学生信息的接口")
    @DateAutoFill(DateAutoFill.Type.UPDATE)
    public R<String> deleteStudent(@RequestBody StudentVo studentVo) {
        studentService.deleteWithUserAndRole(studentVo);
        return R.ok("删除学生信息成功");
    }

    /**
     * 在学生表、用户表、角色表中批量删除学生信息
     *
     * @param model
     * @return
     */
    @DeleteMapping("/students")
    @ApiOperation("批量删除学生信息的接口")
    @DateAutoFill(DateAutoFill.Type.UPDATE)
    public R<String> deleteStudentsByids(@RequestBody DeleteModel model) {
        studentService.deleteBatchWithUserAndRole(model.getIds());
        return R.ok("批量删除学生信息成功");
    }

    /**
     * 从用户上传的Excel文件导入学生信息
     *
     * @param file excel文件
     * @return
     * @throws IOException
     */
    @PostMapping("/student/import")
    @ApiOperation("从excel导入学生信息的接口")
    public R<List<String>> importExcel(MultipartFile file) throws IOException {
        // 创建监听器
        StudentReadListener listener = new StudentReadListener(studentService, studentMapper, majorMapper, majorService);
        studentService.importExcel(file, listener);
        // 如果有错误信息
        if (listener.isFlag() == false) {
            return R.ok("校验错误", listener.getInfo());
        }
        // 无错误信息
        else return R.ok("校验通过");
    }

    /**
     * 导出学生信息为excel供用户下载
     *
     * @param response
     * @throws IOException
     */
    @GetMapping("/student/export")
    @ApiOperation("导出学生信息为excel的接口")
    public void exportExcel(HttpServletResponse response) throws IOException {
        List<StudentVo> list = studentMapper.getStudentVos();
        // 设置相应数据格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("学生信息表", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");

        // 导出excel
        EasyExcel.write(response.getOutputStream())
                .head(StudentVo.class)
                .excelType(ExcelTypeEnum.XLSX)
                .sheet("学生信息表")
                .doWrite(list);
    }

    @GetMapping("/studentClass")
    @ApiOperation("通过专业ID获取学生班级信息")
    public R<List<StudentClassVo>> getStudentClass(Integer majorId) {
        List<StudentClass> result = studentMapper.getStudentClassVo(majorId);
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (StudentClass item : result) {
            List<Integer> list = map.get(item.getGrade());
            if (list != null) {
                list.add(item.getClassNumber());
            } else {
                LinkedList<Integer> tmpList = new LinkedList<>();
                tmpList.add(item.getClassNumber());
                map.put(item.getGrade(), tmpList);
            }
        }
        List<StudentClassVo> finalResult = new LinkedList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            StudentClassVo studentClassVo = new StudentClassVo();
            studentClassVo.setGrade(entry.getKey());
            List<Integer> resultList = entry.getValue();
            resultList.sort(Comparator.comparingInt(x -> x)); //按升序排序
            studentClassVo.setClassNumber(resultList);
            finalResult.add(studentClassVo);
        }
        finalResult.sort(Comparator.comparingInt(StudentClassVo::getGrade)); //按升序排序
        return R.ok("成功获取学生班级信息", finalResult);
    }
}
