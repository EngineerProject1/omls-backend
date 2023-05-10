package com.cuit9622.olms.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.common.model.R;
import com.cuit9622.olms.vo.DeviceVo;
import com.cuit9622.olms.service.DeviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
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
            @ApiImplicitParam(name = "page", value = "页码", defaultValue = "1", required = true)
    })
    public R<Page<DeviceVo>> getNotice(
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "page", defaultValue = "1") Integer page) {
        R<Page<DeviceVo>> info = deviceService.selectDevice(pageSize, page);
        log.info(info.getMsg());
        return info;
    }
}
