package com.cuit9622.olms.entity;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

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
@ExcelIgnoreUnannotated
public class Student extends User implements Serializable {
    /**
     * 学号
     */
    @ApiModelProperty("学号")
    @ExcelProperty(value="学号",index = 1)
    private Long sid;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    @ExcelProperty(value = "姓名",index = 0)
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
    @ExcelProperty(value = "年级",index = 5)
    private Integer grade;

    /**
     * 班级
     */
    @ApiModelProperty("班级")
    @ExcelProperty(value="班级",index = 6)
    private Integer classNumber;

//    @ExcelProperty("专业")
//    private String major;
//    @ExcelProperty("学院")
//    private String college;

}