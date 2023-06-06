package com.cuit9622.olms.vo;

import lombok.Data;

import java.util.List;

@Data
public class StudentClassVo {
    private Integer grade;
    private List<Integer> classNumber;
}
