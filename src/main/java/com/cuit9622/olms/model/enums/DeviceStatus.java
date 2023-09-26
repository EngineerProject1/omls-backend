package com.cuit9622.olms.model.enums;


public enum DeviceStatus {
    UN_LEND(1,"未被借用"), LENDED(2, "已被借用"), DAMAGE(4, "损坏"),ABLE_USE(0, "可用"), REPAIRING(3, "维修中");


    private final Integer code;
    private final String message;
    DeviceStatus(Integer code, String message){
            this.code = code;
            this.message = message;
    }

    public Integer getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
