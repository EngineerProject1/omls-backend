package com.cuit9622.common.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: lsh
 * Date: 2023/4/10 17:42
 * Version: 1.0
 * @Description: 业务响应对象
 */
@ApiModel("业务响应对象")
@Data
@Accessors(chain = true)
public class R<T> {

    @ApiModelProperty(value = "响应状态码", name = "code", example = "200", required = true)
    private Integer code;

    @ApiModelProperty(value = "错误信息说明", name = "error", example = "error")
    private String error;

    @ApiModelProperty(value = "响应状态码说明", name = "msg", example = "success")
    private String msg;

    @ApiModelProperty("数据")
    private T data;

    @ApiModelProperty("动态数据")
    private Map<String, Object> map = new HashMap<>();


    public R(Integer code, String error, String msg, T data) {
        this.code = code;
        this.error = error;
        this.msg = msg;
        this.data = data;
    }

    public static <T> R<T> ok() {
        return new R<>(200, null, "success", null);
    }

    public static <T> R<T> ok(String msg) {
        return new R<>(200, null, msg, null);
    }

    public static <T> R<T> ok(String msg, T data) {
        return new R<>(200, null, msg, data);
    }

    public static <T> R<T> error(int code, String error) {
        return new R<>(code, error, null, null);
    }

    public static <T> R<T> error(int code, String error, String msg) {
        return new R<>(code, error, msg, null);
    }

    public R<T> add(String key, Object value) {
        map.put(key, value);
        return this;
    }
}
