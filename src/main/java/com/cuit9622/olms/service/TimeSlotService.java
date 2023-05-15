package com.cuit9622.olms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cuit9622.olms.entity.TimeSlot;

import java.util.List;

/**
 * @author Wed0n
 * @description 针对表【sys_time_slot(实验室每天的开放时间段)】的数据库操作Service
 * @createDate 2023-05-15 21:14:59
 */
public interface TimeSlotService extends IService<TimeSlot> {

    List<TimeSlot> getAllTimeSlots();
}
