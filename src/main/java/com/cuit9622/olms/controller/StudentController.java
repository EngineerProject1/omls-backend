package com.cuit9622.olms.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.common.model.R;
import com.cuit9622.olms.service.StudentService;
import com.cuit9622.olms.vo.StudentVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j(topic = "StudentController")
@Api(tags = "学生信息相关Api")
public class StudentController {
    @Resource
    private StudentService studentService;
    @GetMapping("/student")
    @ApiOperation("公告信息分页查询的接口")
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
}
