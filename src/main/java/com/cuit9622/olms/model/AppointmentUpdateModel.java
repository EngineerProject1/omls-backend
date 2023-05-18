package com.cuit9622.olms.model;

import lombok.Data;

@Data
public class AppointmentUpdateModel {
    private Long userId;
    private Integer labId;
    private String experimentName;
    private String purpose;
    private Integer offsetDay;
    private Integer timeSlotId;
    private String type;//"0"代表学生预约，"1"代表教师预约
    private Integer majorId;
    private Integer classNumber;
}
