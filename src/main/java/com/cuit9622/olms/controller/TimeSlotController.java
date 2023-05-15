package com.cuit9622.olms.controller;

import com.cuit9622.common.model.R;
import com.cuit9622.olms.entity.TimeSlot;
import com.cuit9622.olms.service.TimeSlotService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j(topic = "TimeSlotController")
@Api(tags = "开放时间段相关Api")
public class TimeSlotController {
    @Resource
    private TimeSlotService timeSlotService;
    @GetMapping("/timeSlot")
    @ApiOperation("获取所有开放时间段")
    public R<List<TimeSlot>> getTimeSlots(){
        return R.ok("成功查询开放时间断",timeSlotService.getAllTimeSlots());
    }
}
