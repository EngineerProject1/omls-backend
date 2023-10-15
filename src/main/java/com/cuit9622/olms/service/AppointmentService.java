package com.cuit9622.olms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cuit9622.olms.entity.Appointment;
import com.cuit9622.olms.entity.User;
import com.cuit9622.olms.model.AppointmentModel;
import com.cuit9622.olms.model.AppointmentUpdateModel;
import com.cuit9622.olms.model.UserSelectModel;
import com.cuit9622.olms.vo.AppointRecordVo;
import com.cuit9622.olms.vo.AppointVo;
import com.cuit9622.olms.vo.AttendanceManagerVo;

import java.text.ParseException;
import java.util.List;
import java.util.Map;


public interface AppointmentService extends IService<Appointment> {
    Page<AppointVo> getTargetTypeAppointment(Integer page, Integer pageSize, Long userId, Integer slotId, String type, Integer offsetDay);

    Boolean addAppointment(User user, AppointmentUpdateModel data);

    /**
     * 通过实验室id查询考勤信息
     * @param labId 实验室id
     * @param pageSize 页面大小
     * @param page 页数
     * @param model Model
     * @return
     * @throws ParseException
     */
    Page<AttendanceManagerVo> selectAppointmentUser(Long labId,Integer pageSize, Integer page, UserSelectModel model) throws ParseException;

    /**
     * @Description 根据model条件查询预约记录
     * @param model
     * @return
     */
    Page<AppointRecordVo> pageAppointRecord(AppointmentModel model);

    /**
     * @Description 得到有预约记录的实验室
     * @param type 预约类型
     * @return
     */
    List<Map<String, String>> getAppointLabs(String type);
    Integer auditAppointment(Long id,String status);
}
