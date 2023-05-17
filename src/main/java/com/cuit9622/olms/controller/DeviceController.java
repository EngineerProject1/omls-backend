package com.cuit9622.olms.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.common.model.R;
import com.cuit9622.olms.model.DeleteModel;
import com.cuit9622.olms.vo.DeviceVo;
import com.cuit9622.olms.service.DeviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @Description: 设备控制类
 */
@RestController
@Slf4j(topic = "DeviceController")
@Api(tags = "设备相关Api")
public class DeviceController {

    @Resource
    private DeviceService deviceService;


    @GetMapping("/device")
    @ApiOperation("设备信息分页查询的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize", value = "每页的条数", defaultValue = "5", required = true),
            @ApiImplicitParam(name = "page", value = "页码", defaultValue = "1", required = true),
            @ApiImplicitParam(name = "name", value = "名称", defaultValue = ""),
            @ApiImplicitParam(name = "status", value = "状态", defaultValue = "1")
    })
    public R<Page<DeviceVo>> getDeviceByPage(
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "status", defaultValue = "1") String status) {

        Page<DeviceVo> info = deviceService.selectDevice(pageSize, page, name, status);
        return R.ok("获取设备信息成功", info);
    }

    /**
     * @Description 通过id获取设备信息
     * @param id 设备的id
     * @return
     */
    @GetMapping("/device/{id}")
    @ApiOperation("通过id获取某个设备")
    public R<DeviceVo> getDeviceById(@PathVariable("id") Long id){

        DeviceVo deviceDto = deviceService.getById(id);
        System.out.println(deviceDto);
        return R.ok("获取设备信息成功", deviceDto);
    }

    /**
     * @Description 根据id修改设备信息
     * @param deviceVo 需要修改的设备信息
     * @return
     * @Date 15:36 2023/5/10
     */
    @PutMapping("/auth/device")
    @ApiOperation("修改某个设备")
    @RequiresRoles("admin")
    public R<String> updateDevice(@RequestBody DeviceVo deviceVo) {
        Integer count = deviceService.updateById(deviceVo);
        if (count > 0) {
            return R.ok("修改成功");
        } else {
            return R.ok("修改失败");
        }
    }


    @PostMapping("/auth/device")
    @ApiOperation("添加设备")
    @RequiresRoles("admin")
    public R<String> addDevice(@RequestBody DeviceVo deviceVo) {
        Integer count = deviceService.insertOne(deviceVo);
        if (count > 0) {
            return R.ok("添加成功");
        } else {
            return R.ok("添加失败");
        }
    }

    @DeleteMapping("/auth/device/{id}")
    @ApiOperation("根据id删除设备信息")
    @RequiresRoles("admin")
    @ApiImplicitParam(name = "id", value = "要删除的id", required = true)
    public R<String> deleteDeviceById(@PathVariable("id") Integer id) {
        deviceService.removeById(id);
        log.info("删除id为{}的设备信息成功", id);
        return R.ok("删除成功");
    }

    @DeleteMapping("/auth/device")
    @ApiOperation("根据ids删除设备信息")
    @RequiresRoles("admin")
    @ApiImplicitParam(name = "model", value = "要删除的id数组", required = true)
    public R<String> deleteDeviceByIds(@RequestBody DeleteModel model) {
        deviceService.removeBatchByIds(model.getIds());
        log.info("删除id为{}的公告成功", model.getIds().toString());
        return R.ok("删除成功");
    }
}
