package com.cuit9622.olms.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.common.model.R;
import com.cuit9622.olms.annotation.DateAutoFill;
import com.cuit9622.olms.entity.Attendance;
import com.cuit9622.olms.entity.Lab;
import com.cuit9622.olms.entity.User;
import com.cuit9622.olms.mapper.AppointmentMapper;
import com.cuit9622.olms.model.UserSelectModel;
import com.cuit9622.olms.service.AppointmentService;
import com.cuit9622.olms.service.AttendanceService;
import com.cuit9622.olms.service.LabService;
import com.cuit9622.olms.vo.AttendanceManagerVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;

@RestController
@Slf4j(topic = "AttendanceManagerController")
@Api(tags = "考勤管理相关Api")
public class AttendanceManagerController {
    @Resource
    private AppointmentService appointmentService;
    @Resource
    private LabService labService;
    @Resource
    private AttendanceService attendanceService;
    /**
     * 分页查询
     * @param
     * @param
     * @return 用户信息
     */
    @GetMapping("/attendanceManager/{id}")
    @ApiOperation("通过实验室id分页查询考勤信息的接口")
    public R<Page<AttendanceManagerVo>> getAppointments (@PathVariable Long id,UserSelectModel model) throws ParseException {
        Page<AttendanceManagerVo> info = appointmentService.selectAppointmentUser(id,model.getPageSize(),model.getPage(),model);
        return R.ok("查询考勤信息成功", info);
    }

    /**
     * 获取当前教师管理的实验室
     * @return 实验室列表
     */
    @GetMapping("/auth/getLabs")
    @ApiOperation("获取教师所管理的实验室的接口")
    public R<List<Lab>> getLabs() {
        // 拿到当前登录用户
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        LambdaQueryWrapper<Lab> queryWrapper = new LambdaQueryWrapper<>();

        List<Lab> labs = labService.list(queryWrapper.eq(Lab::getMasterId, user.getId()));
        return R.ok("查询实验室信息成功",labs);
    }

    /**
     * 添加一条考勤信息
     * @param attendance 要增添的考勤信息
     * @return
     */
    @PostMapping("/attendanceManager")
    @ApiOperation("添加考勤信息的接口")
    @DateAutoFill(DateAutoFill.Type.INSERT)
    public R<String> addAttendance(@RequestBody Attendance attendance) {
        attendanceService.save(attendance);
        return R.ok("添加考勤信息成功");
    }

    /**
     * 修改考勤状态
     * @param attendance 所接收的考勤信息
     * @return
     */
    @PutMapping("/attendanceManager")
    @ApiOperation("修改考勤状态的接口")
    @DateAutoFill(DateAutoFill.Type.UPDATE)
    public R<String> updateAttendance(@RequestBody Attendance attendance) {
        LambdaQueryWrapper<Attendance> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Attendance::getUserId,attendance.getUserId());
        queryWrapper.eq(Attendance::getAppointmentId,attendance.getAppointmentId());
        attendanceService.update(attendance,queryWrapper);
        return R.ok("修改考勤信息成功");
    }
}
