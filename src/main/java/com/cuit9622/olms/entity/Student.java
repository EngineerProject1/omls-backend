package com.cuit9622.olms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

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
public class Student extends User implements Serializable {
    /**
     * id和user表中id保持一致
     */
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("主键")
    private Long id;

    /**
     * 学号
     */
    @ApiModelProperty("学号")
    private Integer sid;

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