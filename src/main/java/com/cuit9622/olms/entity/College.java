package com.cuit9622.olms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * @TableName sys_college
 */
@TableName(value ="sys_college")
@Data
public class College implements Serializable {
    /**
     * id
     */
    @ApiModelProperty("id")
    private Long id;

    /**
     * 学院名称
     */
    @ApiModelProperty("学院名称")
    private String collegeName;

}