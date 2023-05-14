package com.cuit9622.olms.vo;
import com.cuit9622.olms.entity.Student;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("学生Vo")
public class StudentVo extends Student{
    @ApiModelProperty("专业名称")
    private String majorName;
    @ApiModelProperty("学院名称")
    private String collegeName;
    @ApiModelProperty("学院id")
    private Long collegeId;
    /**
     * 1:管理员 0:非管理员
     */
    @ApiModelProperty("是否设置为管理员")
    private int isSetManager;
}
