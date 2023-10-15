package com.cuit9622.olms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 实验室的每周的周几开放
 * @TableName sys_lab_schedule
 */
@TableName(value ="sys_lab_schedule")
@Data
@ApiModel("实验室开放时间实体类")
public class LabSchedule implements Serializable {
    /**
     * 实验室id
     */
    @TableId
    @ApiModelProperty("实验室id")
    private Integer labId;

    /**
     * 1代表周日，其余以此类推
     */
    @TableId
    @ApiModelProperty("1代表周日")
    private Object weekday;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}