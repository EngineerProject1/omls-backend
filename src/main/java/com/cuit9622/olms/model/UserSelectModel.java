package com.cuit9622.olms.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("用户查询的搜索条件")
public class UserSelectModel {
    @ApiModelProperty("页码")
    Integer page;

    @ApiModelProperty("条数")
    Integer pageSize;

    @ApiModelProperty("姓名")
    String name;
}
