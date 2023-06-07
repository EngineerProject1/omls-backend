package com.cuit9622.olms.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cuit9622.common.exception.BizException;
import com.cuit9622.olms.entity.Appointment;
import com.cuit9622.olms.entity.TimeSlot;
import com.cuit9622.olms.entity.User;
import com.cuit9622.olms.mapper.AppointmentMapper;
import com.cuit9622.olms.mapper.StudentMapper;
import com.cuit9622.olms.mapper.UserMapper;
import com.cuit9622.olms.model.AppointmentModel;
import com.cuit9622.olms.model.AppointmentUpdateModel;
import com.cuit9622.olms.model.UserSelectModel;
import com.cuit9622.olms.service.AppointmentService;
import com.cuit9622.olms.service.TimeSlotService;
import com.cuit9622.olms.vo.AppointRecordVo;
import com.cuit9622.olms.vo.AppointVo;
import com.cuit9622.olms.vo.AttendanceManagerVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl extends ServiceImpl<AppointmentMapper, Appointment> implements AppointmentService {
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
            if (data.getType().equals("1")) {
                count = appointmentMapper.addAppointmentForClass(data);
                if(count==0) {
                    if (appointmentMapper.testIsBookedOnTargetTime(data).getCount()>0) {
                        throw new BizException("同一时间段只能预约一个实验室");
                    }
                    if (appointmentMapper.testIsBookedByPerson(data).getCount()>0) {
                        throw new BizException("该实验室已被个人预约");
                    }
                    if(appointmentMapper.testIsBookedByClass(data).getCount()>0) {
                        throw new BizException("该实验室已被班级预约");
                    }
                    if (appointmentMapper.testTargetClassIsBooked(data).getCount()>0) {
                        throw new BizException("该班级在该时间段已预约实验室");
                    }
                    return true;
                }
            } else {
                count = appointmentMapper.addAppointmentForIndividual(data);
            }
        } else if (roles.contains("student")) {
            data.setClassNumber(null);
            data.setMajorId(null);
            data.setGrade(null);
            data.setType("0");
            count = appointmentMapper.addAppointmentForIndividual(data);
        } else {
            throw new BizException("服务器内部错误");
        }
        if (count == 0) {
            if (appointmentMapper.testIsBookedOnTargetTime(data).getCount()>0) {
                throw new BizException("同一时间段只能预约一个实验室");
            }
            if(appointmentMapper.testIsBookedByClass(data).getCount()>0) {
                throw new BizException("该实验室已被班级预约");
            }
            if(appointmentMapper.testIsFull(data).getCount()>0) {
                throw new BizException("该实验室可预约人数已满");
            }
            throw new BizException("预约该时间段的实验室失败");
        } else if (count > 1) {
            throw new BizException("服务器内部错误");
        }
        return true;
    }

    @Override
    public Page<AttendanceManagerVo> selectAppointmentUser(Long id, Integer pageSize, Integer page, UserSelectModel model) throws ParseException {
        Page<AttendanceManagerVo> pageInfo = new Page<>(page, pageSize);
        // 获取需要查询的时间段
        Integer slotId = null;
        // 判定当前时间范围
        List<TimeSlot> timeSlots = timeSlotService.getAllTimeSlots();
        String format = "HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        for (TimeSlot timeSlot : timeSlots) {
            if (DateUtil.isIn(sdf.parse(DateUtil.now().substring(11)), timeSlot.getStartTime(), timeSlot.getEndTime())) {
                // 得到当前时间段
                slotId = timeSlot.getId();
            }
        }

        pageInfo = appointmentMapper.selectAppointmentUser(id, slotId, DateUtil.now().substring(0, 10), pageInfo, model);
        return pageInfo;
    }

    @Override

    public Page<AppointRecordVo> pageAppointRecord(AppointmentModel model) {
        // 个人预约
        Page<AppointRecordVo> page = new Page<>(model.getPage(), model.getPageSize());
        if (model.getType() == 0) {
            appointmentMapper.pageAppointRecordForPerson(page, model.getLabId());
        } else {
            appointmentMapper.pageAppointRecordForClass(page, model.getLabId(),model.getOnly());
        }
        // 分配角色
        List<AppointRecordVo> records = page.getRecords();
        List<AppointRecordVo> newRecords;
        // 过滤每一条数据修改用户角色
        newRecords = records.stream().map((item) -> {
            AppointRecordVo appointRecordVo = new AppointRecordVo();
            // 复制基本属性
            BeanUtils.copyProperties(item, appointRecordVo);
            // 查询角色信息并修改
            String username = item.getUsername();
            List<String> roles = userMapper.getUserRoleInfoByUsername(username);
            if (roles.contains("teacher")) {
                appointRecordVo.setRole("teacher");
            } else if (roles.contains("student")) {
                appointRecordVo.setRole("student");
            }

            return appointRecordVo;
        }).collect(Collectors.toList());
        page.setRecords(newRecords);
        return page;
    }

    @Override
    public List<Map<String, String>> getAppointLabs(String type) {
        return appointmentMapper.getAppointLabs(type);
    }

    public Integer auditAppointment(Long id, String status) {
        LambdaUpdateWrapper<Appointment> wrapper = new LambdaUpdateWrapper<>();
        wrapper.set(Appointment::getStatus, status)
                .eq(Appointment::getStatus, "0")
                .eq(Appointment::getId, id);
        return appointmentMapper.update(null, wrapper);
    }
}
