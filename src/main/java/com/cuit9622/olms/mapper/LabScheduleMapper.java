package com.cuit9622.olms.mapper;

import com.cuit9622.olms.entity.LabSchedule;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 刘世浩
* @description 针对表【sys_lab_schedule(实验室的每周的周几开放)】的数据库操作Mapper
* @createDate 2023-06-07 17:11:58
* @Entity com.cuit9622.olms.entity.LabSchedule
*/
@Mapper
public interface LabScheduleMapper extends BaseMapper<LabSchedule> {

    /**
     * @Description 插入开放时间
     * @param labId
     * @param weekdays
     * @return
     * @Date 20:53 2023/6/7
     */
    Integer insertSchedule(@Param("labId") Long labId, @Param("weekdays")List<Integer> weekdays);
}




