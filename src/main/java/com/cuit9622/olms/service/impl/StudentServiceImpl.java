package com.cuit9622.olms.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cuit9622.common.model.R;
import com.cuit9622.olms.entity.Student;
import com.cuit9622.olms.service.StudentService;
import com.cuit9622.olms.mapper.StudentMapper;
import com.cuit9622.olms.vo.NoticeVo;
import com.cuit9622.olms.vo.StudentVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author Zxin
* @description 针对表【sys_user_student(学生表)】的数据库操作Service实现
* @createDate 2023-05-10 22:12:55
*/
@Service
@Slf4j(topic = "StudentServiceImpl")
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService{
    @Resource
    private StudentMapper studentMapper;

    @Override
    public R<Page<StudentVo>> selectStudents(Integer pageSize, Integer page) {
        Page<StudentVo> pageInfo = new Page<>(page,pageSize);
        pageInfo = studentMapper.page(pageInfo);
        return R.ok("查询学生信息成功", pageInfo);
    }
}




