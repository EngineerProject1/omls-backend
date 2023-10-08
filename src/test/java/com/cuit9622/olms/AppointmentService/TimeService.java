package com.cuit9622.olms.AppointmentService;

import cn.hutool.core.date.DateUtil;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeService {
    @Test
    public void Test() throws ParseException {
        String format = "HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format);

        if(DateUtil.isIn(sdf.parse(DateUtil.now().substring(11)), sdf.parse("15:00:00"),sdf.parse("16:00:00"))) {
            System.out.println("in");
        }
        else System.out.println("out");
        format = "yyyy-MM-dd";
        sdf = new SimpleDateFormat(format);
        System.out.println(DateUtil.now().substring(0,10));
        System.out.println(sdf.parse("2023-05-26").equals(sdf.parse(DateUtil.now().substring(0,10))));
    }
}
