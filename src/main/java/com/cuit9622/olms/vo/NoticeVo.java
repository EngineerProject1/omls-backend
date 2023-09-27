package com.cuit9622.olms.vo;

import com.cuit9622.olms.entity.Notice;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Author: lsh
 * Version: 1.0
 * @Description: 公告的数据传输对象
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("公告Vo")
public class NoticeVo extends Notice {

    @ApiModelProperty("发布公告的人(管理员)")
    private String name;
}
