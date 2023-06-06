package com.cuit9622.olms.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Author: lsh
 * Date: 2023/6/6 15:39
 * Version: 1.0
 * @Description: 预约记录查询模型
 */
@Data
public class AppointmentModel {
    @ApiModelProperty("页码")
    Integer page;
    @ApiModelProperty("条数")
    Integer pageSize;
    @ApiModelProperty("预约类型0为个人预约，1为班级预约")
    Integer type;
    @ApiModelProperty("实验室id")
    Integer labId;
}
