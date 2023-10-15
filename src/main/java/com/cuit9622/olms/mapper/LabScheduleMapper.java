package com.cuit9622.olms.mapper;

import com.cuit9622.olms.entity.LabSchedule;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 刘世浩
* @description 针对表【sys_lab_schedule(实验室的每周的周几开放)】的数据库操作Mapper
* @Entity com.cuit9622.olms.entity.LabSchedule
*/
@Mapper
public interface LabScheduleMapper extends BaseMapper<LabSchedule> {

}




