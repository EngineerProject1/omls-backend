package com.cuit9622.olms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户和角色的关系表
 * @TableName sys_user_role
 */
@TableName(value ="sys_user_role")
@Data
public class UserRole implements Serializable {
    /**
     * id
     */
    @ApiModelProperty("id")
    private Long id;

    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Long userId;

    /**
     * 角色id
     */
    @ApiModelProperty("角色id")
    private Long roleId;


}