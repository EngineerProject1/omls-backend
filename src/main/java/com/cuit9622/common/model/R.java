package com.cuit9622.common.model;

import io.swagger.annotations.ApiModel;
import org.springframework.http.HttpStatus;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Author: lsh
 * Date: 2023/4/10 17:42
 * Version: 1.0
 * @Description: 业务响应对象
 */
@ApiModel("业务响应对象")
public class R extends ConcurrentHashMap<String, Object> {

    public R() {
        this.put("code", HttpStatus.OK.value());
        this.put("msg", "success");
    }

    public static R ok() {
        return new R();
    }

    public static R ok(String msg) {
        if (msg == null) msg = "";
        return R.ok().put("msg", msg);
    }

    public static R ok(Object data) {
        if (data == null) data = "[]";
        return R.ok().put("data", data);
    }

    public static R ok(String msg, Object data) {
        if (data == null) data = "[]";
        return R.ok(msg).put("data", data);
    }

    public static R error(int code, String error) {
        if (error == null) error = "[]";
        return R.ok()
                .put("code", code)
                .put("error", error)
                .put("msg", "");
    }

    public static R error(int code, String error, String msg) {
        if (msg == null) msg = "";
        if (error == null) error = "";
        return R.ok()
                .put("code", code)
                .put("error", error)
                .put("msg", msg);
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }


}
