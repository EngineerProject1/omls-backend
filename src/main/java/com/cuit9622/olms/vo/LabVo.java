package com.cuit9622.olms.vo;

import com.cuit9622.olms.entity.Lab;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Author: lsh
 * Version: 1.0
 * @Description: 实验室Vo
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("LabVo")
public class LabVo extends Lab {

    @ApiModelProperty("负责人姓名")
    public String masterName;
}
