package com.cuit9622.olms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 设备借阅表
 * @TableName sys_device_lend
 */
@TableName(value ="sys_device_lend")
@Data
@ApiModel("设备借用")
public class DeviceLend implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("主键")
    private Long id;

    /**
     * 借用者的id
     */
    @ApiModelProperty("用户id")
    private Long userId;

    /**
     * 借用的设备id
     */
    @ApiModelProperty("设备id")
    private Long deviceId;


    /**
     * 借用时间
     */
    @ApiModelProperty("借用时间")
    private Date lendTime;

    /**
     * 归还时间
     */
    @ApiModelProperty("归还时间")
    private Date returnTime;
}