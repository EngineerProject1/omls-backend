package com.cuit9622.olms.vo;

import com.cuit9622.olms.entity.Appointment;
import com.cuit9622.olms.entity.Attendance;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AttendanceManagerVo extends Appointment {
    @ApiModelProperty("用户姓名")
    private String realName;
    @ApiModelProperty("学号/职工号")
    private String userName;
    @ApiModelProperty("考勤状态")
    private Integer status;
}
