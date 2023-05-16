package com.cuit9622.olms.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.common.model.R;
import com.cuit9622.olms.entity.User;
import com.cuit9622.olms.model.AppointmentSelectModel;
import com.cuit9622.olms.service.AppointmentService;
import com.cuit9622.olms.vo.AppointVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j(topic = "AppointmentController")
@Api(tags = "预约相关Api")
public class AppointmentController {
    @Resource
    AppointmentService appointmentService;

    @GetMapping("/auth/getTargetTypeAppointment")
    @ApiOperation("查询该用户能选的预约预约")
    public R<Page<AppointVo>> getTargetTypeAppointment(AppointmentSelectModel appointmentSelectModel) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Page<AppointVo> targetTypeAppointment = appointmentService.getTargetTypeAppointment(appointmentSelectModel.getPage(),
                appointmentSelectModel.getPageSize(),
                user.getId(),
                appointmentSelectModel.getTimeSlotId(),
                appointmentSelectModel.getType(),
                appointmentSelectModel.getOffSetDay());
        return R.ok("成功获取预约",targetTypeAppointment);
    }
}
