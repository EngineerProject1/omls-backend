package com.cuit9622.olms.vo;

import com.cuit9622.olms.entity.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserVo extends User {
    @ApiModelProperty("CloudFlare token")
    private String token;
}
