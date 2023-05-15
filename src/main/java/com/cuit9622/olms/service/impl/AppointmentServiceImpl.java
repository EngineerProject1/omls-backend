package com.cuit9622.olms.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cuit9622.olms.mapper.AppointmentMapper;
import com.cuit9622.olms.service.AppointmentService;
import com.cuit9622.olms.vo.AppointVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AppointmentServiceImpl extends ServiceImpl<AppointmentMapper, AppointVo> implements AppointmentService {
    @Resource
    AppointmentMapper appointmentMapper;

    @Override
    public Page<AppointVo> getTargetTypeAppointment(Integer page, Integer pageSize, Integer slotId, String type, Integer offsetDay) {
        Page<AppointVo> pageInfo = new Page<>(page, pageSize);
        pageInfo = appointmentMapper.getTargetTypeAppointment(pageInfo, slotId, type, offsetDay);
        return pageInfo;
    }
}
