package com.cuit9622.olms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.olms.entity.Attendance;
import com.cuit9622.olms.vo.AttendanceVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Wed0n
 * @description 针对表【sys_attendance(签到表)】的数据库操作Mapper
 * @Entity com.cuit9622.olms.entity.Attendance
 */
@Mapper
public interface AttendanceMapper extends BaseMapper<Attendance> {
    Page<AttendanceVo> getTargetAttendance(@Param("page") Page<AttendanceVo> page, @Param("userId") Integer userId);
}
