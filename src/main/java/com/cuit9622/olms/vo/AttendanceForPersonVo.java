package com.cuit9622.olms.vo;

import com.cuit9622.olms.entity.Attendance;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Date;
import java.sql.Time;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("个人考勤数据传输对象")
public class AttendanceForPersonVo extends Attendance {
    @ApiModelProperty("实验名称")
    private String experimentName;
    @ApiModelProperty("实验室名字")
    private String labName;
    @ApiModelProperty("预约时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date bookTime;
    @ApiModelProperty("预约时间段的开始时间")
    private Time startTime;
    @ApiModelProperty("预约时间段的结束时间")
    private Time endTime;
}
