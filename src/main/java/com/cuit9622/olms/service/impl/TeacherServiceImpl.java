package com.cuit9622.olms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cuit9622.olms.entity.Teacher;
import com.cuit9622.olms.service.TeacherService;
import com.cuit9622.olms.mapper.TeacherMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Description 教师接口实现类
 * @Date 16:33 2023/5/11
 */
@Service
@Slf4j(topic = "TeacherServiceImpl")
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher>
    implements TeacherService{

}




