package com.cuit9622.olms.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Author: lsh
 * Version: 1.0
 * @Description: 删除数据时接收的实体类
 */
@Data
@ApiModel("删除数据时用来接收数据的实体类，通用的")
public class DeleteModel {

    @ApiModelProperty("id数组")
    private List<Integer> ids;
}
