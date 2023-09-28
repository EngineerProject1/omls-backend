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
 * @TableName sys_major
 */
@TableName(value ="sys_major")
@Data
public class Major implements Serializable {
    /**
     * id
     */
    @ApiModelProperty("id")
    private Long id;

    /**
     * 专业名称
     */
    @ApiModelProperty("专业名称")
    private String majorName;

    /**
     * 所属学院
     */
    @ApiModelProperty("所属id")
    private Long collegeId;

}