package com.cuit9622.olms.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.common.exception.BizException;
import com.cuit9622.common.model.R;
import com.cuit9622.olms.entity.Appointment;
import com.cuit9622.olms.entity.User;
import com.cuit9622.olms.model.AppointmentModel;
import com.cuit9622.olms.model.AppointmentSelectModel;
import com.cuit9622.olms.model.AppointmentUpdateModel;
import com.cuit9622.olms.service.AppointmentService;
import com.cuit9622.olms.vo.AppointRecordVo;
import com.cuit9622.olms.vo.AppointVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
        return R.ok("成功获取预约", targetTypeAppointment);
    }

    @PostMapping("/auth/addAppointment")
    @ApiOperation("新增预约")
    public R<String> addAppointment(@RequestBody AppointmentUpdateModel appointmentUpdateModel) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        appointmentService.addAppointment(user, appointmentUpdateModel);
        return R.ok("成功预约实验室");
    }

    /**
     * @Description 根据model查询预约记录
     * @param model
     * @return
     * @Description 根据model查询预约记录
     * @Date 15:57 2023/6/6
     */
    @GetMapping("/auth/appointment")
    @RequiresRoles("admin")
    @ApiOperation("查询预约记录")
    public R<Page<AppointRecordVo>> pageAppointment(AppointmentModel model) {
        Page<AppointRecordVo> appointRecordVoPage = appointmentService.pageAppointRecord(model);
        return R.ok("查询预约记录成功", appointRecordVoPage);
    }

    /**
     * @Description 根据预约类型查询有预约记录的实验室
     * @param type 预约类型
     * @return
     * @Date 19:27 2023/6/6
     */
    @GetMapping("/auth/appointment/lab/{type}")
    @RequiresRoles("admin")
    @ApiOperation("根据预约类型查询有预约记录的实验室")
    public R<List<Map<String, String>>> getAppointLabs(@PathVariable String type){
        List<Map<String, String>> appointLabs = appointmentService.getAppointLabs(type);
        log.info("有预约记录的实验室{}", appointLabs.toString());
        return R.ok("查询实验室成功", appointLabs);
    }

    @PutMapping("/auth/auditAppointment")
    @ApiOperation("审核预约")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "预约ID", paramType = "Query", required = true),
            @ApiImplicitParam(name = "status", value = "审核结果", paramType = "Query", required = true)})
    public R<String> auditAppointment(@RequestParam("id") Long id, @RequestParam("status") String status) {
        Integer result = appointmentService.auditAppointment(id, status);
        if (result != 1) {
            throw new BizException("审核预约失败");
        }
        return R.ok("成功审核预约");
    }

    @GetMapping("/auth/getUnauditedAppointment")
    @ApiOperation("获取没有审核的预约")
    public R<Page<Appointment>> getUnauditedAppointment(Integer current, Integer pageSize) {
        Page<Appointment> result = appointmentService.getUnauditedAppointment(current, pageSize);
        return R.ok("成功获取未审核预约", result);
    }
}
