package com.cuit9622.olms.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cuit9622.olms.entity.Attendance;
import com.cuit9622.olms.mapper.AttendanceMapper;
import com.cuit9622.olms.service.AttendanceService;
import com.cuit9622.olms.vo.AttendanceForAppointmentVo;
import com.cuit9622.olms.vo.AttendanceForPersonVo;
import com.cuit9622.olms.vo.AttendanceForClassVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Wed0n
 * @description 针对表【sys_attendance(签到表)】的数据库操作Service实现
 */
@Service
public class AttendanceServiceImpl extends ServiceImpl<AttendanceMapper, Attendance>
        implements AttendanceService {
    @Resource
    private AttendanceMapper attendanceMapper;
    @Override
    public Page<AttendanceForPersonVo> getAttendanceForPerson(Integer page, Integer pageSize, Integer userId) {
        Page<AttendanceForPersonVo> pageInfo=new Page<>(page,pageSize);
        pageInfo=attendanceMapper.getTargetAttendanceForPerson(pageInfo,userId);
        return pageInfo;
    }

    @Override
    public Page<AttendanceForClassVo> getAttendanceForClass(Integer page, Integer pageSize, Integer userId) {
        Page<AttendanceForClassVo> pageInfo=new Page<>(page,pageSize);
        pageInfo=attendanceMapper.getTargetAttendanceForClass(pageInfo,userId);
        return pageInfo;
    }

    @Override
    public Page<AttendanceForAppointmentVo> getAttendanceForTargetAppointment(Integer page, Integer pageSize, Integer appointmentId) {
        Page<AttendanceForAppointmentVo> pageInfo=new Page<>(page,pageSize);
        pageInfo=attendanceMapper.getAttendanceForTargetAppointment(pageInfo,appointmentId);
        return pageInfo;
    }
}




