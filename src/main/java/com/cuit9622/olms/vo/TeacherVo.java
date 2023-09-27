package com.cuit9622.olms.vo;

import com.cuit9622.olms.entity.Teacher;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: lsh
 * Version: 1.0
 * @Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Slf4j
public class TeacherVo extends Teacher{

    @ApiModelProperty("学院名称")
    private String collegeName;
}
