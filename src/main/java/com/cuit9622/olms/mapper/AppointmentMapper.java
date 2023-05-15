package com.cuit9622.olms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.olms.vo.AppointVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AppointmentMapper extends BaseMapper<AppointVo> {
    Page<AppointVo> getTargetTypeAppointment(@Param("page") Page<AppointVo> page, @Param("slotId") Integer slotId, @Param("type") String type, @Param("offsetDay") Integer offsetDay);
}
