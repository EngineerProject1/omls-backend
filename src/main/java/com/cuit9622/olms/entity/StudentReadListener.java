package com.cuit9622.olms.entity;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.cuit9622.olms.vo.StudentVo;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class StudentReadListener implements ReadListener<StudentVo> {
    List<StudentVo> list = new ArrayList<>();

    @Override
    public void invoke(StudentVo studentVo, AnalysisContext analysisContext) {
        System.out.println("读取到"+studentVo);
        System.out.println(studentVo.getSid());
        list.add(studentVo);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // 入库
        System.out.println(list);
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getStudentName());
        }
    }
}
