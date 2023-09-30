package com.cuit9622.olms.vo;

import com.cuit9622.olms.entity.Lab;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AppointVo extends Lab {
    @ApiModelProperty("实验室ID")
    Integer labId;
    @ApiModelProperty("预约当前实验室的当前时间段的人数")
    Integer cur;
}
