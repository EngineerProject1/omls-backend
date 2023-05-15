package com.cuit9622.olms.mapper;

import com.cuit9622.olms.entity.TimeSlot;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Wed0n
* @description 针对表【sys_time_slot(实验室每天的开放时间段)】的数据库操作Mapper
* @createDate 2023-05-15 21:14:59
* @Entity com.cuit9622.olms.entity.TimeSlot
*/
@Mapper
public interface TimeSlotMapper extends BaseMapper<TimeSlot> {

}




