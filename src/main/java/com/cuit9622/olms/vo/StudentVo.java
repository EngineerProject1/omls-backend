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
}
