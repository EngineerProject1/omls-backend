package com.cuit9622.olms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Author: lsh
 * Date: 2023/4/17 16:57
 * Version: 1.0
 * @Description: 用户实体类
 */
@Data
@ApiModel("用户表对应的实体类")
public class User {
    @TableId
    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("盐值")
    private String salt;

    @ApiModelProperty("真实姓名")
    private String realName;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("头像地址")
    private String avatar;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;
}
