package com.cuit9622.olms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cuit9622.olms.entity.User;
import com.cuit9622.olms.model.AppointmentModel;
import com.cuit9622.olms.model.AppointmentUpdateModel;
import com.cuit9622.olms.model.UserSelectModel;
import com.cuit9622.olms.vo.AppointRecordVo;
import com.cuit9622.olms.vo.AppointVo;
import com.cuit9622.olms.vo.AttendanceManagerVo;

import java.text.ParseException;


public interface AppointmentService extends IService<AppointVo> {
    Page<AppointVo> getTargetTypeAppointment(Integer page, Integer pageSize, Long userId, Integer slotId, String type, Integer offsetDay);

    Boolean addAppointment(User user, AppointmentUpdateModel data);

    Page<AttendanceManagerVo> selectAppointmentUser(Long labId,Integer pageSize, Integer page, UserSelectModel model) throws ParseException;

    /**
     * @Description 根据model条件查询预约记录
     * @param model
     * @return
     * @Date 17:59 2023/6/6
     */
    Page<AppointRecordVo> pageAppointRecord(AppointmentModel model);
}
