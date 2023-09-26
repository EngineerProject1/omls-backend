package com.cuit9622.olms.entity.dto;

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
@ApiModel("公告Dto")
public class NoticeDto extends Notice {

    @ApiModelProperty("发布公告的人(只有老师和管理员)")
    private String name;
}
