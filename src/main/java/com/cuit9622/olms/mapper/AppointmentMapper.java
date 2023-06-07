package com.cuit9622.olms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.olms.entity.Appointment;
import com.cuit9622.olms.model.AppointmentUpdateModel;
import com.cuit9622.olms.model.Count;
import com.cuit9622.olms.model.UserSelectModel;
import com.cuit9622.olms.vo.AppointRecordVo;
import com.cuit9622.olms.vo.AppointVo;
import com.cuit9622.olms.vo.AttendanceManagerVo;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface AppointmentMapper extends BaseMapper<Appointment> {
    Page<AppointVo> getTargetTypeAppointment(
            @Param("page") Page<AppointVo> page,
            @Param("userId") Long userId,
            @Param("timeSlotId") Integer timeSlotId,
            @Param("type") String type,
            @Param("offsetDay") Integer offsetDay
    );

    Integer addAppointmentForIndividual(@Param("data") AppointmentUpdateModel data);

    Integer addAppointmentForClass(@Param("data") AppointmentUpdateModel data);

    Count testIsBookedOnTargetTime(@Param("data") AppointmentUpdateModel data);
    Count testIsBookedByPerson(@Param("data") AppointmentUpdateModel data);
    Count testTargetClassIsBooked(@Param("data") AppointmentUpdateModel data);
    Count testIsBookedByClass(@Param("data") AppointmentUpdateModel data);
    Count testIsFull(@Param("data") AppointmentUpdateModel data);

    Page<AttendanceManagerVo> selectAppointmentUser(Long labId, Integer slotId, String day, Page<AttendanceManagerVo> page, @Param("model") UserSelectModel model);

    /**
     * @Description 查询个人预约
     * @param page
     * @param labId 要查询那个实验室的预约情况
     * @return
     * @Date 17:01 2023/6/6
     */
    Page<AppointRecordVo> pageAppointRecordForPerson(@Param("page") Page<AppointRecordVo> page, @Param("labId") Integer labId);

    /**
     * @Description 查询班级预约
     * @param page
     * @param labId 要查询那个实验室的预约情况
     * @return
     * @Date 17:01 2023/6/6
     */
    Page<AppointRecordVo> pageAppointRecordForClass(@Param("page") Page<AppointRecordVo> page, @Param("labId") Integer labId,@Param("only")Integer only);

    /**
     * @Description 得到有预约记录的实验室
     * @param type 预约类型
     * @return
     * @Date 19:12 2023/6/6
     */
    @MapKey("id")
    List<Map<String, String>> getAppointLabs(String type);
}
