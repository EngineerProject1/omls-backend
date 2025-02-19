package com.cuit9622.olms.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("预约实验室的数据传输模型")
public class AppointmentSelectModel {
    @ApiModelProperty("页码")
    Integer page;
    @ApiModelProperty("条数")
    Integer pageSize;
    @ApiModelProperty("开放时间段")
    Integer timeSlotId;
    @ApiModelProperty("偏移天数")
    Integer offSetDay;
    @ApiModelProperty("实验室类型")
    String type;
}
