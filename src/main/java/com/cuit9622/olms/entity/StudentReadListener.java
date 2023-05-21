package com.cuit9622.olms.entity;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cuit9622.olms.mapper.MajorMapper;
import com.cuit9622.olms.mapper.StudentMapper;
import com.cuit9622.olms.service.MajorService;
import com.cuit9622.olms.service.StudentService;
import com.cuit9622.olms.vo.StudentVo;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
public class StudentReadListener implements ReadListener<StudentVo> {
    // 封装学生信息列表
    List<StudentVo> list = new ArrayList<>();
    private StudentMapper studentMapper;

    private MajorMapper majorMapper;

    private StudentService studentService;

    private MajorService majorService;
    // 错误信息列表
    private List<String> info = new ArrayList<>();
    // 校验通过标识
    private boolean flag = true;



    public List<String> getInfo() {
        return this.info;
    }

    public void setInfo(List<String> info) {
        this.info = info;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public StudentReadListener(StudentService studentService,StudentMapper studentMapper, MajorMapper majorMapper, MajorService majorService) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
        this.majorMapper = majorMapper;
        this.majorService = majorService;
    }

    @Override
    public void invoke(StudentVo studentVo, AnalysisContext analysisContext) {
        System.out.println("读取到"+studentVo);
        String error = studentVo.getStudentName()+":";
        boolean singleFlag = true;

        // 检验姓名
        String name = studentVo.getStudentName();
        if(name == null || name.equals("")) {
            flag = false;
            singleFlag = false;
            error += "  [姓名不存在]";
        }
        else {
            // 检验姓名格式
            if(!name.matches("^([\\u4e00-\\u9fa5]{2,4}|[a-zA-Z]{2,16})$")) {
                flag = false;
                singleFlag = false;
                error += "  [姓名(" + name+")格式错误]";
            }
        }

        // 校验学号
        Long sid = studentVo.getSid();
        if(sid == null) {
            flag = false;
            singleFlag = false;
            error += "  [学号不存在]";
        }
        else {
            // 检验学号格式
            if(!String.valueOf(sid).matches("\\d{7}")) {
                flag = false;
                singleFlag = false;
                error += "  [学号(" + sid+")格式错误]";
            }
            else {
                // 检验学号是否存在
                StudentVo student = studentMapper.getStudentInfoByUsername(sid.toString());
                // 如果该学号已存在
                if(student != null) {
                    singleFlag = false;
                    flag = false;
                    error += "  [学号(" + sid+")已存在]";
                }
            }
        }

        // 检验性别
        String sex = studentVo.getSex();
        if(sex == null || sex.equals("")) {
            singleFlag = false;
            flag = false;
            error += "  [性别不存在]";
        }
        else {
            if(!sex.equals("男") && !sex.equals("女")) {
                singleFlag = false;
                flag = false;
                error += "  [性别(" + sex+")格式错误]";
            }
        }

        // 校验学院与专业是否匹配
        College college = majorMapper.selectCollegeByMajorName(studentVo.getMajorName());
        // 如果不匹配
        if(college == null) {
            singleFlag = false;
            flag = false;
            error += "  [专业("+studentVo.getMajorName()+")与学院("+studentVo.getCollegeName()+")不匹配或不存在]";
        }

        // 检验年级格式
        Integer grade = studentVo.getGrade();
        if(grade == null) {
            singleFlag = false;
            flag = false;
            error += "  [年级不存在]";
        }
        else {
            if(!String.valueOf(studentVo.getGrade()).matches("\\d{4}")) {
                singleFlag = false;
                flag = false;
                error += "  [年级(" + grade+")格式错误]";
            }
        }

        // 检验班级格式
        Integer classNumber = studentVo.getClassNumber();
        if(classNumber == null) {
            singleFlag = false;
            flag = false;
            error += "  [班级不存在]";
        }
        else {
            if(!String.valueOf(classNumber).matches("\\d{1}")) {
                singleFlag = false;
                flag = false;
                error += "  [班级(" + classNumber+")格式错误]";
            }
        }

        // 如果校验不成功，将错误信息添加
        if(!singleFlag) {
            info.add(error);
        }

        // 如果校验成功增加学生至列表
        else {
            LambdaQueryWrapper<Major> queryWrapper = new LambdaQueryWrapper<>();
            Major major = majorService.getOne(queryWrapper.eq(Major::getMajorName,studentVo.getMajorName()));
            studentVo.setMajorId(major.getId());
            studentVo.setUsername(String.valueOf(sid));
            studentVo.setRealName(name);
            // 设置创建以及修改时间
            Date date = new Date();
            studentVo.setCreateTime(date);
            studentVo.setUpdateTime(date);
            list.add(studentVo);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // 入库
        if(flag) {
            for (StudentVo studentVo:list) {
                studentService.saveWithUserAndRole(studentVo);
            }
        }
    }
}
