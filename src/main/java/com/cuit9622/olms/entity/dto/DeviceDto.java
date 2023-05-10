package com.cuit9622.olms.entity.dto;

import com.cuit9622.olms.entity.Device;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@ApiModel("设备Dto")
@EqualsAndHashCode(callSuper = true)
public class DeviceDto extends Device {

    @ApiModelProperty("所属实验室名称")
    private String labName;
}
