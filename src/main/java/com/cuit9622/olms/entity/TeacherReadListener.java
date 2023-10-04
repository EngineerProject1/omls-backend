package com.cuit9622.olms.entity;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cuit9622.olms.mapper.TeacherMapper;
import com.cuit9622.olms.service.CollegeService;
import com.cuit9622.olms.service.TeacherService;
import com.cuit9622.olms.vo.StudentVo;
import com.cuit9622.olms.vo.TeacherVo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeacherReadListener implements ReadListener<TeacherVo> {
    // 封装教师信息列表
    List<TeacherVo> list = new ArrayList<>();
    // 错误信息列表
    private List<String> info = new ArrayList<>();
    // 校验通过标识
    private boolean flag = true;

    private TeacherService teacherService;

    private TeacherMapper teacherMapper;

    private CollegeService collegeService;

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

    public TeacherReadListener(TeacherService teacherService,TeacherMapper teacherMapper, CollegeService collegeService) {
        this.teacherService = teacherService;
        this.teacherMapper = teacherMapper;
        this.collegeService = collegeService;
    }
    @Override
    public void invoke(TeacherVo teacherVo, AnalysisContext analysisContext) {
        String error = teacherVo.getTeacherName()+":";
        boolean singleFlag = true;

        // 校验姓名
        String name = teacherVo.getTeacherName();
        // 姓名是否存在
        if(name == null || name.equals("")) {
            flag = false;
            singleFlag = false;
            error += "  [姓名不存在]";
        }
        else {
            // 校验姓名格式
            if(!name.matches("^([\\u4e00-\\u9fa5]{2,4}|[a-zA-Z]{2,16})$")) {
                flag = false;
                singleFlag = false;
                error += "  [姓名(" + name+")格式错误]";
            }
        }

        // 校验职工号
        Long tid = teacherVo.getTid();
        if(tid == null) {
            flag = false;
            singleFlag = false;
            error += "  [职工号不存在]";
        }
        else {
            // 检验职工号格式
            if(!String.valueOf(tid).matches("\\d{7}")) {
                flag = false;
                singleFlag = false;
                error += "  [职工号(" + tid+")格式错误]";
            }
            else {
                // 检验职工号是否存在
                TeacherVo teacher = teacherMapper.getTeacherInfoByUsername(tid.toString());
                // 如果该学号已存在
                if(teacher != null) {
                    singleFlag = false;
                    flag = false;
                    error += "  [职工号(" + tid+")已存在]";
                }
            }
        }

        // 校验性别
        String sex = teacherVo.getSex();
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

        // 校验学院
        String collegeName = teacherVo.getCollegeName();
        LambdaQueryWrapper<College> queryWrapper = new LambdaQueryWrapper<>();
        College college = collegeService.getOne(queryWrapper.eq(College::getCollegeName, collegeName));
        if(college == null) {
            singleFlag = false;
            flag = false;
            error += "  [学院(" + collegeName+")不存在]";
        }

        // 如果校验不成功，将错误信息添加
        if(!singleFlag) {
            info.add(error);
        }

        // 如果校验成功增加教师至列表
        else {
            teacherVo.setUsername(tid.toString());
            teacherVo.setRealName(name);
            teacherVo.setCollegeId(college.getId());
            // 设置创建以及修改时间
            Date date = new Date();
            teacherVo.setCreateTime(date);
            teacherVo.setUpdateTime(date);
            list.add(teacherVo);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // 入库
        if(flag) {
            for(TeacherVo teacherVo : list) {
                teacherService.saveWithUserAndRole(teacherVo);
            }
        }
    }
}
