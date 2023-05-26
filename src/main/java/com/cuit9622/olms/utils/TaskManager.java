package com.cuit9622.olms.utils;

import com.cuit9622.olms.entity.TimeSlot;
import com.cuit9622.olms.mapper.AttendanceMapper;
import com.cuit9622.olms.service.TimeSlotService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

@Slf4j(topic = "自动签到缺勤任务")
@Component
public class TaskManager {
    @Resource
    private TaskScheduler taskScheduler;
    @Resource
    private TimeSlotService timeSlotService;
    @Resource
    private AttendanceMapper attendanceMapper;

    @PostConstruct
    void init() {
        List<TimeSlot> result = timeSlotService.getAllTimeSlots();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("0 mm HH * * ?");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+08:00");
        simpleDateFormat.setTimeZone(timeZone);
        Calendar targetTime = Calendar.getInstance(timeZone);
        for (TimeSlot item : result) {
            targetTime.setTime(item.getStartTime());
            targetTime.add(Calendar.MINUTE, 25);
            String cronExpression = simpleDateFormat.format(targetTime.getTime());
            taskScheduler.schedule(() -> {
                Integer count = attendanceMapper.autoAttendance();
                log.info("已为 " + count + " 人自动签到缺勤");
            }, new CronTrigger(cronExpression));
        }
    }
}
