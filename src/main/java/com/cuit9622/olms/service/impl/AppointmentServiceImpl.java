package com.cuit9622.olms.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cuit9622.common.exception.BizException;
import com.cuit9622.olms.entity.Student;
import com.cuit9622.olms.entity.User;
import com.cuit9622.olms.mapper.AppointmentMapper;
import com.cuit9622.olms.mapper.StudentMapper;
import com.cuit9622.olms.mapper.TeacherMapper;
import com.cuit9622.olms.mapper.UserMapper;
import com.cuit9622.olms.model.AppointmentUpdateModel;
import com.cuit9622.olms.service.AppointmentService;
import com.cuit9622.olms.vo.AppointVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AppointmentServiceImpl extends ServiceImpl<AppointmentMapper, AppointVo> implements AppointmentService {
    @Resource
    AppointmentMapper appointmentMapper;
    @Resource
    UserMapper userMapper;
    @Resource
    TeacherMapper teacherMapper;
    @Resource
    StudentMapper studentMapper;

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
        String role = userMapper.getUserRoleInfoByUsername(user.getUsername()).get(0);
        if (role.equals("teacher")) {
            data.setMajorId(null);
            if (data.getType().equals("1")) {
                count = appointmentMapper.addAppointmentForClass(data);
            }else {
                count = appointmentMapper.addAppointmentForIndividual(data);
            }
        } else if (role.equals("student")) {
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
}
