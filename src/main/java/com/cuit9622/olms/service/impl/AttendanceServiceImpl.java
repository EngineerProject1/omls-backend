package com.cuit9622.olms.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cuit9622.olms.entity.Attendance;
import com.cuit9622.olms.mapper.AttendanceMapper;
import com.cuit9622.olms.service.AttendanceService;
import com.cuit9622.olms.vo.AttendanceVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Wed0n
 * @description 针对表【sys_attendance(签到表)】的数据库操作Service实现
 * @createDate 2023-05-20 19:58:21
 */
@Service
public class AttendanceServiceImpl extends ServiceImpl<AttendanceMapper, Attendance>
        implements AttendanceService {
    @Resource
    private AttendanceMapper attendanceMapper;
    @Override
    public Page<AttendanceVo> getAttendanceByUserId(Integer page, Integer pageSize,Integer userId) {
        Page<AttendanceVo> pageInfo=new Page<>(page,pageSize);
        pageInfo=attendanceMapper.getTargetAttendance(pageInfo,userId);
        return pageInfo;
    }
}




