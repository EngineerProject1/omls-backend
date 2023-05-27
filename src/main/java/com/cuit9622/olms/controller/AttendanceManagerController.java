package com.cuit9622.olms.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.common.model.R;
import com.cuit9622.olms.entity.Lab;
import com.cuit9622.olms.entity.User;
import com.cuit9622.olms.mapper.AppointmentMapper;
import com.cuit9622.olms.model.UserSelectModel;
import com.cuit9622.olms.service.AppointmentService;
import com.cuit9622.olms.service.LabService;
import com.cuit9622.olms.vo.AttendanceManagerVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;

@RestController
@Slf4j(topic = "AttendanceManagerController")
@Api(tags = "考勤管理相关Api")
public class AttendanceManagerController {
    @Resource
    private AppointmentMapper appointmentMapper;
    @Resource
    private AppointmentService appointmentService;
    @Resource
    private LabService labService;
    /**
     * 分页查询
     * @param
     * @param
     * @return
     */
    @GetMapping("/auth/attendanceManager")
    @ApiOperation("考勤信息分页查询的接口")
    public R<Page<AttendanceManagerVo>> getAppointments (UserSelectModel model) throws ParseException {
        // 拿到当前登录用户
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        Page<AttendanceManagerVo> info = appointmentService.selectAppointmentUser(user,model.getPageSize(),model.getPage(),model);
        return R.ok("查询考勤信息成功", info);
    }
    @GetMapping("/auth/getLabs")
    public R<List<Lab>> getLabs() {
        // 拿到当前登录用户
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        LambdaQueryWrapper<Lab> queryWrapper = new LambdaQueryWrapper<>();

        List<Lab> labs = labService.list(queryWrapper.eq(Lab::getMasterId, user.getId()));
        return R.ok("查询实验室信息成功",labs);
    }
}
