package com.cuit9622.olms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 实验室每天的开放时间段
 * @TableName sys_time_slot
 */
@TableName(value ="sys_time_slot")
@Data
public class TimeSlot implements Serializable {
    @ApiModelProperty("主键")
    private Integer id;
    @ApiModelProperty("开始时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm",timezone = "GMT+8")
    private Date startTime;
    @ApiModelProperty("结束时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm",timezone = "GMT+8")
    private Date endTime;
}