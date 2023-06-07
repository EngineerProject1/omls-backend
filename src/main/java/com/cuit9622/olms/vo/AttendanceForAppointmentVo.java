package com.cuit9622.olms.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("考勤数据传输对象")
public class AttendanceForAppointmentVo {
    @ApiModelProperty("状态")
    private String status;
    @ApiModelProperty("姓名")
    private String realName;
    @ApiModelProperty("学号/工号")
    private String username;
    @ApiModelProperty("更新时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
}
