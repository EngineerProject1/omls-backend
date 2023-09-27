package com.cuit9622.olms.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Author: lsh
 * Version: 1.0
 * @Description: 用于查询实验室的Model
 */
@Data
@ApiModel("实验室查询的排序条件")
public class LabSelectModel {

    @ApiModelProperty("容量的排序条件")
    private String capacity;

    @ApiModelProperty("实验室名字")
    private String name;

    @ApiModelProperty("页码")
    private Integer page;

    @ApiModelProperty("条数")
    private Integer pageSize;

    @ApiModelProperty("实验室状态")
    private String status;
}
