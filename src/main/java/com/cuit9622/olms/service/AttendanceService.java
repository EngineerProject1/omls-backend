package com.cuit9622.olms.service;

import com.cuit9622.olms.entity.Attendance;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.olms.vo.AttendanceVo;

/**
* @author Wed0n
* @description 针对表【sys_attendance(签到表)】的数据库操作Service
* @createDate 2023-05-20 19:58:22
*/
public interface AttendanceService extends IService<Attendance> {
    Page<AttendanceVo> getAttendanceByUserId(Integer page, Integer pageSize, Integer userId);
}
