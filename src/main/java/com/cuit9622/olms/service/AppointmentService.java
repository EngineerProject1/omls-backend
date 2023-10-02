package com.cuit9622.olms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cuit9622.olms.entity.User;
import com.cuit9622.olms.model.AppointmentUpdateModel;
import com.cuit9622.olms.vo.AppointVo;


public interface AppointmentService extends IService<AppointVo> {
    Page<AppointVo> getTargetTypeAppointment(Integer page, Integer pageSize, Long userId, Integer slotId, String type, Integer offsetDay);

    Boolean addAppointment(User user, AppointmentUpdateModel data);
}
