package com.cuit9622.olms.vo;

import com.cuit9622.olms.entity.Lab;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("实预约信息传输对象")
public class AppointVo extends Lab {
    @ApiModelProperty("实验室ID")
    Integer labId;
    @ApiModelProperty("预约当前实验室的当前时间段的人数")
    Integer cur;
}
