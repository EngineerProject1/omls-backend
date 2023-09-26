package com.cuit9622.olms.DeviceService;

import com.cuit9622.olms.model.enums.DeviceStatus;
import org.junit.jupiter.api.Test;

public class TestEnumStatus {

    DeviceStatus status = DeviceStatus.ABLE_USE;
    @Test
    public void test01(){
        System.out.println(status.getCode());
    }
}
