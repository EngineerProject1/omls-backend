package com.cuit9622.olms.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Author: lsh
 * Date: 2023/5/12 19:23
 * Version: 1.0
 * @Description: 公告查询的排序条件
 */
@Data
@ApiModel("公告查询的排序条件")
public class NoticeSelectModel {
    @ApiModelProperty("页码")
    Integer page;

    @ApiModelProperty("条数")
    Integer pageSize;

    @ApiModelProperty("标题")
    String title;

    @ApiModelProperty("等级排序条件")
    String level;

    @ApiModelProperty("创建时间排序条件")
    String createTime;
}
