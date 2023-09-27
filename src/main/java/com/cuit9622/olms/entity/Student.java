package com.cuit9622.olms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 学生表
 * @TableName sys_user_student
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="sys_user_student")
@Data
@ApiModel("学生")
public class Student extends User implements Serializable {
    /**
     * 学号
     */
    @ApiModelProperty("学号")
    private Long sid;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String studentName;

    /**
     * 专业id
     */
    @ApiModelProperty("专业id")
    private Long majorId;

    /**
     * 年级
     */
    @ApiModelProperty("年级")
    private Integer grade;

    /**
     * 班级
     */
    @ApiModelProperty("班级")
    private Integer classNumber;

}