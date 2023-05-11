package com.cuit9622.olms.entity;

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
@ApiModel("教室")
public class Teacher extends User implements Serializable {

    @ApiModelProperty("教师工号")
    private Long tid;

    @ApiModelProperty("教师姓名")
    private String teacherName;

    @ApiModelProperty("学院id")
    private Long collegeId;

}