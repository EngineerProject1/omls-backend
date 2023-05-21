package com.cuit9622.olms.entity;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @TableName sys_user_teacher
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="sys_user_teacher")
@Data
@ApiModel("教师")
@ExcelIgnoreUnannotated
public class Teacher extends User implements Serializable {

    @ApiModelProperty("教师工号")
    @ExcelProperty(value="职工号",index = 1)
    @ColumnWidth(9)
    private Long tid;

    @ApiModelProperty("教师姓名")
    @ExcelProperty(value="姓名",index = 0)
    private String teacherName;

    @ApiModelProperty("学院id")
    private Long collegeId;

}