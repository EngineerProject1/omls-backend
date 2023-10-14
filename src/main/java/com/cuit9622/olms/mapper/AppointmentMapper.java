package com.cuit9622.olms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.olms.model.AppointmentUpdateModel;
import com.cuit9622.olms.model.UserSelectModel;
import com.cuit9622.olms.vo.AppointRecordVo;
import com.cuit9622.olms.vo.AppointVo;
import com.cuit9622.olms.vo.AttendanceManagerVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AppointmentMapper extends BaseMapper<AppointVo> {
    Page<AppointVo> getTargetTypeAppointment(
            @Param("page") Page<AppointVo> page,
            @Param("userId") Long userId,
            @Param("timeSlotId") Integer timeSlotId,
            @Param("type") String type,
            @Param("offsetDay") Integer offsetDay
    );
    Integer addAppointmentForIndividual(@Param("data")AppointmentUpdateModel data);
    Integer addAppointmentForClass(@Param("data")AppointmentUpdateModel data);

    Page<AttendanceManagerVo> selectAppointmentUser(Long labId, Integer slotId, String day,Page<AttendanceManagerVo> page, @Param("model") UserSelectModel model);

    /**
     * @Description 查询个人预约
     * @param page
     * @param labId 要查询那个实验室的预约情况
     * @return
     */
    Page<AppointRecordVo> pageAppointRecordForPerson(@Param("page") Page<AppointRecordVo> page, @Param("labId") Integer labId);

    /**
     * @Description 查询班级预约
     * @param page
     * @param labId 要查询那个实验室的预约情况
     * @return
     */
    Page<AppointRecordVo> pageAppointRecordForClass(@Param("page") Page<AppointRecordVo> page, @Param("labId") Integer labId);
}
