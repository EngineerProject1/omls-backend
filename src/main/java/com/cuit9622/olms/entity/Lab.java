package com.cuit9622.olms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 实验室表
 * @TableName sys_lab
 */
@TableName(value ="sys_lab")
@Data
@ApiModel("实验室")
public class Lab implements Serializable {
    /**
     * 实验室id
     */
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("id")
    private Long id;

    /**
     * 实验室名字
     */
    @ApiModelProperty("实验室名字")
    private String name;

    /**
     * 管理人id
     */
    @ApiModelProperty("负责人id")
    private Long masterId;

    /**
     * 实验室介绍
     */
    @ApiModelProperty("实验室介绍")
    private String description;

    /**
     * 实验室最多被借用人数
     */
    @ApiModelProperty("容量")
    private Long capacity;

    /**
     * 实验室位置
     */
    @ApiModelProperty("实验室位置")
    private String location;

    /**
     * 实验室类型
     */
    @ApiModelProperty("类型")
    private String type;

    /**
     * 实验室图片
     */
    @ApiModelProperty("图片")
    private String images;

    /**
     * 实验室状态(0:可用,1:暂不可用,2:维修中)
     */
    @ApiModelProperty("实验室状态(0:可用,1:暂不可用,2:维修中)")
    private Integer status;
}