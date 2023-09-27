package com.cuit9622.olms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cuit9622.olms.entity.TimeSlot;
import com.cuit9622.olms.service.TimeSlotService;
import com.cuit9622.olms.mapper.TimeSlotMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author Wed0n
* @description 针对表【sys_time_slot(实验室每天的开放时间段)】的数据库操作Service实现
*/
@Service
@Slf4j(topic = "TimeSlotServiceImpl")
public class TimeSlotServiceImpl extends ServiceImpl<TimeSlotMapper, TimeSlot>
    implements TimeSlotService{
    @Resource
    private TimeSlotMapper timeSlotMapper;
    @Override
    public List<TimeSlot> getAllTimeSlots(){
       return timeSlotMapper.selectList(null);
    }
}