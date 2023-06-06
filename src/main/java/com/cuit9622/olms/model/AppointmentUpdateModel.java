package com.cuit9622.olms.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("预约更新模型")
public class AppointmentUpdateModel {
    @ApiModelProperty("用户id")
    private Long userId;
    @ApiModelProperty("实验室id")
    private Integer labId;
    @ApiModelProperty("实验名字")
    private String experimentName;
    @ApiModelProperty("目的")
    private String purpose;
    @ApiModelProperty("偏移天数")
    private Integer offsetDay;
    @ApiModelProperty("时间段")
    private Integer timeSlotId;
    @ApiModelProperty("\"0\"代表学生预约，\"1\"代表教师预约")
    private String type;
    @ApiModelProperty("年级")
    private Integer grade;
    @ApiModelProperty("学院id")
    private Integer collegeId;
    @ApiModelProperty("专业id")
    private Integer majorId;
    @ApiModelProperty("班级")
    private Integer classNumber;
}
