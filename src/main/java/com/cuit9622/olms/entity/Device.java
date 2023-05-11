package com.cuit9622.olms.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("设备")
public class Device implements Serializable {

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("设备名称")
    private String name;

    @ApiModelProperty("设备价格")
    private double price;

    @ApiModelProperty("设备所属实验室")
    private Long labId;

    @ApiModelProperty("设备型号")
    private String model;

    @ApiModelProperty("设备图片的文件名")
    private String images;

    @ApiModelProperty("设备状态")
    private Integer status;

}
