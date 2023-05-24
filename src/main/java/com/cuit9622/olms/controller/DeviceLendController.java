package com.cuit9622.olms.controller;

import com.cuit9622.common.model.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.olms.entity.User;
import com.cuit9622.olms.service.DeviceLendService;
import com.cuit9622.olms.vo.DeviceVo;
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

/**
 * @Description: 设备借用控制类
 */
@RestController
@Slf4j(topic = "DeviceLendController")
@Api(tags = "学生老师借用设备相关Api")
public class DeviceLendController {

    @Resource
    private DeviceLendService deviceLendService;


    @GetMapping("/auth/appointmentLab")
    @ApiOperation("获取当前用户预约的实验室")
    @RequiresRoles("teacher")
    public R<List<Map<Long, String>>> getAppointmentLab(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        List<Map<Long, String>> labNames = deviceLendService.getAppointmentLab(user.getId());
        System.out.println(labNames);
        return R.ok("查询成功", labNames);
    }

    @GetMapping("/auth/deviceByLab")
    @ApiOperation("根据实验室id和设备名称查询设备信息")
    @RequiresRoles("teacher")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize", value = "每页的条数", defaultValue = "5", required = true),
            @ApiImplicitParam(name = "page", value = "页码", defaultValue = "1", required = true),
            @ApiImplicitParam(name = "name", value = "名称", defaultValue = ""),
            @ApiImplicitParam(name = "labId", value = "实验室Id", defaultValue = "1")
    })
    public R<Page<DeviceVo>> getDeviceByLab(
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "labId", defaultValue = "1") Long labId){

        Page<DeviceVo> info = deviceLendService.getDevice(pageSize, page, name, labId);
        return R.ok("获取成功", info);
    }


    @GetMapping("/auth/deviceLend")
    @ApiOperation("根据用户id和设备名称查询借用设备信息")
    @RequiresRoles("teacher")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize", value = "每页的条数", defaultValue = "5", required = true),
            @ApiImplicitParam(name = "page", value = "页码", defaultValue = "1", required = true),
            @ApiImplicitParam(name = "name", value = "名称", defaultValue = ""),
    })
    public R<Page<DeviceVo>> getLendDevice(
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "name", defaultValue = "") String name
    ){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Page<DeviceVo> info = deviceLendService.getLendDevice(pageSize, page, name, user.getId());
        return R.ok("获取成功", info);
    }

    /**
     * @Description 逐一归还设备
     * @param deviceVo 需要归还的设备信息
     * @return
     */
    @PutMapping("/auth/deviceReturn")
    @ApiOperation("归还设备（单一）")
    @RequiresRoles("teacher")
    public R<String> returnDevice(@RequestBody DeviceVo deviceVo) {

        Integer count = deviceLendService.returnDeviceByModel(deviceVo);

        if (count == 2) {
            return R.ok("归还成功");
        } else {
            return R.ok("归还失败");
        }
    }

    /**
     * @Description 逐一归还设备
     * @param deviceVos 需要归还的设备信息
     * @return
     */
    @PutMapping("/auth/deviceReturnAll")
    @ApiOperation("一键归还")
    @RequiresRoles("teacher")
    public R<String> returnDeviceAll(@RequestBody List<DeviceVo> deviceVos) {

        for (int i = 0; i < deviceVos.size(); i++) {
            System.out.println(deviceVos.get(i));
        }
//        Integer count = deviceLendService.returnDeviceByModel(deviceVo);
//
//        if (count == 2) {
//            return R.ok("归还成功");
//        } else {
//            return R.ok("归还失败");
//        }
        return null;
    }
}
