package com.cuit9622.olms.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.common.model.R;
import com.cuit9622.olms.entity.User;
import com.cuit9622.olms.service.AttendanceService;
import com.cuit9622.olms.vo.AttendanceVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j(topic = "AttendanceController")
@Api(tags = "考勤相关Api")
public class AttendanceController {
    @Resource
    AttendanceService attendanceService;
    @GetMapping("/auth/attendance")
    @ApiOperation("查询该用户的考勤记录")
    public R<Page<AttendanceVo>> getAttendance(Integer page,Integer pageSize){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Page<AttendanceVo> result = attendanceService.getAttendanceByUserId(page, pageSize, Math.toIntExact(user.getId()));
        return R.ok("成功获取考勤记录",result);
    }
}
