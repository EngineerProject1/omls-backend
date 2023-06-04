package com.cuit9622.olms.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cuit9622.common.exception.BizException;
import com.cuit9622.olms.entity.Lab;
import com.cuit9622.olms.entity.Student;
import com.cuit9622.olms.entity.TimeSlot;
import com.cuit9622.olms.entity.User;
import com.cuit9622.olms.mapper.AppointmentMapper;
import com.cuit9622.olms.mapper.StudentMapper;
import com.cuit9622.olms.mapper.TeacherMapper;
import com.cuit9622.olms.mapper.UserMapper;
import com.cuit9622.olms.model.AppointmentUpdateModel;
import com.cuit9622.olms.model.UserSelectModel;
import com.cuit9622.olms.service.AppointmentService;
import com.cuit9622.olms.service.LabService;
import com.cuit9622.olms.service.TimeSlotService;
import com.cuit9622.olms.vo.AppointVo;
import com.cuit9622.olms.vo.AttendanceManagerVo;
import com.cuit9622.olms.vo.StudentVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AppointmentServiceImpl extends ServiceImpl<AppointmentMapper, AppointVo> implements AppointmentService {
    @Resource
    AppointmentMapper appointmentMapper;
    @Resource
    UserMapper userMapper;
    @Resource
    StudentMapper studentMapper;
    @Resource
    private TimeSlotService timeSlotService;

    @Override
    public Page<AppointVo> getTargetTypeAppointment(Integer page, Integer pageSize, Long userId, Integer slotId, String type, Integer offsetDay) {
        Page<AppointVo> pageInfo = new Page<>(page, pageSize);
        pageInfo = appointmentMapper.getTargetTypeAppointment(pageInfo, userId, slotId, type, offsetDay);
        return pageInfo;
    }

    @Override
    public Boolean addAppointment(User user, AppointmentUpdateModel data) {
        Integer count = -1;
        data.setUserId(user.getId());
        if (data.getOffsetDay() <= 0 || data.getOffsetDay() > 7) {
            throw new BizException("预约失败");
        }
        List<String> roles = userMapper.getUserRoleInfoByUsername(user.getUsername());
        if (roles.contains("teacher")) {
            data.setMajorId(null);
            if (data.getType().equals("1")) {
                count = appointmentMapper.addAppointmentForClass(data);
            }else {
                count = appointmentMapper.addAppointmentForIndividual(data);
            }
        } else if (roles.contains("student")) {
            Student student = studentMapper.getStudentInfoByUsername(user.getUsername());
            data.setClassNumber(null);
            data.setMajorId(Integer.parseInt(student.getMajorId().toString()));
            data.setType("0");
            count = appointmentMapper.addAppointmentForIndividual(data);
        } else {
            throw new BizException("服务器内部错误");
        }
        if (count == 0) {
            throw new BizException("预约该时间段的实验室失败");
        } else if (count > 1) {
            throw new BizException("服务器内部错误");
        }
        return true;
    }

    @Override
    public Page<AttendanceManagerVo> selectAppointmentUser(Long id,Integer pageSize, Integer page, UserSelectModel model) throws ParseException {
        Page<AttendanceManagerVo> pageInfo = new Page<>(page,pageSize);
        // 获取需要查询的时间段
        Integer slotId = null;
        // 判定当前时间范围
        List<TimeSlot> timeSlots = timeSlotService.getAllTimeSlots();
        String format = "HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        for(TimeSlot timeSlot:timeSlots) {
            if(DateUtil.isIn(sdf.parse(DateUtil.now().substring(11)),timeSlot.getStartTime(),timeSlot.getEndTime())) {
                // 得到当前时间段
                slotId = timeSlot.getId();
                break;
            }
        }

//        pageInfo = appointmentMapper.selectAppointmentUser(id, slotId, DateUtil.now().substring(0,10), pageInfo, model);
        // 测试
        pageInfo = appointmentMapper.selectAppointmentUser(id, 1, "2023-05-17", pageInfo, model);
        return pageInfo;
    }
}
