package com.cuit9622.olms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.olms.entity.Attendance;
import com.cuit9622.olms.vo.AttendanceForAppointmentVo;
import com.cuit9622.olms.vo.AttendanceForPersonVo;
import com.cuit9622.olms.vo.AttendanceForClassVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Wed0n
 * @description 针对表【sys_attendance(签到表)】的数据库操作Mapper
 * @Entity com.cuit9622.olms.entity.Attendance
 */
@Mapper
public interface AttendanceMapper extends BaseMapper<Attendance> {
    Page<AttendanceForPersonVo> getTargetAttendanceForPerson(@Param("page") Page<AttendanceForPersonVo> page, @Param("userId") Integer userId);
    Page<AttendanceForClassVo> getTargetAttendanceForClass(@Param("page") Page<AttendanceForClassVo> page, @Param("userId") Integer userId);
    Page<AttendanceForAppointmentVo> getAttendanceForTargetAppointment(@Param("page") Page<AttendanceForAppointmentVo> page,@Param("appointmentId") Integer appointmentId);

}
