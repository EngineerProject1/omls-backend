package com.cuit9622.olms.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.common.model.R;
import com.cuit9622.olms.entity.User;
import com.cuit9622.olms.service.AttendanceService;
import com.cuit9622.olms.vo.AttendanceForAppointmentVo;
import com.cuit9622.olms.vo.AttendanceForPersonVo;
import com.cuit9622.olms.vo.AttendanceForClassVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j(topic = "AttendanceController")
@Api(tags = "考勤相关Api")
public class AttendanceController {
    @Resource
    AttendanceService attendanceService;
    @GetMapping("/auth/attendanceForPerson")
    @RequiresRoles(value={"student","teacher"},logical = Logical.OR)
    @ApiOperation("查询个人的考勤记录")
    public R<Page<AttendanceForPersonVo>> getAttendanceForPerson(Integer page, Integer pageSize){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Page<AttendanceForPersonVo> result = attendanceService.getAttendanceForPerson(page, pageSize, Math.toIntExact(user.getId()));
        return R.ok("成功获取考勤记录",result);
    }
    @GetMapping("/auth/attendanceForClass")
    @RequiresRoles("teacher")
    @ApiOperation("教师查询班级的考勤记录")
    public R<Page<AttendanceForClassVo>> getAttendanceForClass(Integer page, Integer pageSize){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Page<AttendanceForClassVo> result = attendanceService.getAttendanceForClass(page, pageSize, Math.toIntExact(user.getId()));
        return R.ok("成功获取考勤记录",result);
    }

    @GetMapping("/auth/getAttendanceForTargetAppointment")
    @RequiresRoles("teacher")
    @ApiOperation("教师查询单个班级具体考勤记录")
    public R<Page<AttendanceForAppointmentVo>> getAttendanceForTargetAppoint(Integer page,Integer pageSize,Integer appointmentId){
        Page<AttendanceForAppointmentVo> result = attendanceService.getAttendanceForTargetAppointment(page, pageSize, appointmentId);
        return R.ok("成功获取考勤记录",result);
    }
}
