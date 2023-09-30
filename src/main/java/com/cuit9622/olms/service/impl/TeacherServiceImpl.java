package com.cuit9622.olms.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cuit9622.olms.entity.Teacher;
import com.cuit9622.olms.entity.UserRole;
import com.cuit9622.olms.mapper.UserRoleMapper;
import com.cuit9622.olms.model.UserSelectModel;
import com.cuit9622.olms.service.TeacherService;
import com.cuit9622.olms.mapper.TeacherMapper;
import com.cuit9622.olms.vo.StudentVo;
import com.cuit9622.olms.vo.TeacherVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description 教师接口实现类
 */
@Service
@Slf4j(topic = "TeacherServiceImpl")
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher>
    implements TeacherService{

    @Resource
    private TeacherMapper teacherMapper;
    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public TeacherVo getTeacherInfoByUsername(String username) {
        TeacherVo teacher = teacherMapper.getTeacherInfoByUsername(username);
        // 如果存在该教师
        if(teacher != null) {
            Long userId = teacher.getId();
            // 查询该教师是否为管理员
            UserRole userRole = userRoleMapper.getManagerByUserId(userId);
            // 如果是管理员，管理员标志设为1
            if(userRole != null) {
                teacher.setIsSetManager(1);
            }
            else teacher.setIsSetManager(0);
        }
        log.info("用户名为{}的教师的信息为{}",username, teacher);
        return teacher;
    }

    @Override
    public Page<TeacherVo> selectTeachers(Integer pageSize, Integer page, UserSelectModel model) {
        Page<TeacherVo> pageInfo = new Page<>(page,pageSize);
        pageInfo = teacherMapper.page(pageInfo,model);
        return pageInfo;
    }
}




