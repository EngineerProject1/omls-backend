package com.cuit9622.olms.vo;

import com.cuit9622.olms.entity.Appointment;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Time;

/**
 * Author: lsh
 * Version: 1.0
 * @Description: 预约记录实体类
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("预约记录VO")
public class AppointRecordVo extends Appointment {

    @ApiModelProperty("预约人的学号或者工号")
    private String username;

    @ApiModelProperty("预约人")
    private String appointUsername;

    @ApiModelProperty("实验室名称")
    private String labName;

    @ApiModelProperty("专业")
    private String majorName;

    @ApiModelProperty("身份")
    private String role;

    @ApiModelProperty("预约时间段：开始时间")
    private Time startTime;

    @ApiModelProperty("预约时间段: 结束时间")
    private Time endTime;
}
