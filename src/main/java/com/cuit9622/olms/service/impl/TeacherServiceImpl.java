package com.cuit9622.olms.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cuit9622.common.utils.DigestsUtils;
import com.cuit9622.olms.entity.Teacher;
import com.cuit9622.olms.entity.User;
import com.cuit9622.olms.entity.UserRole;
import com.cuit9622.olms.mapper.UserRoleMapper;
import com.cuit9622.olms.model.UserSelectModel;
import com.cuit9622.olms.service.TeacherService;
import com.cuit9622.olms.mapper.TeacherMapper;
import com.cuit9622.olms.service.UserRoleService;
import com.cuit9622.olms.service.UserService;
import com.cuit9622.olms.vo.StudentVo;
import com.cuit9622.olms.vo.TeacherVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

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
    @Resource
    private UserService userService;
    @Resource
    private UserRoleService userRoleService;

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

    /**
     * 添加教师的同时，添加用户以及用户角色
     * @param teacherVo
     */
    @Transactional
    @Override
    public void saveWithUserAndRole(TeacherVo teacherVo) {
        // 设置密码盐值
        Map<String,String> map = DigestsUtils.encrypt("olms123456");
        String password = map.get("password");
        String salt = map.get("salt");
        teacherVo.setPassword(password);
        teacherVo.setSalt(salt);

        // 添加至教师表
        teacherMapper.saveTeacher(teacherVo);

        // 添加至用户表
        userService.save(teacherVo);

        // 添加至角色表
        // 获取userId
        User userInfo = userService.getUserInfoByName(teacherVo.getUsername());
        Long userId = userInfo.getId();
        // 判断是否设置为管理员
        int flag = teacherVo.getIsSetManager();
        // 如果为1，设为管理员
        if(flag == 1) {
            UserRole userRole = new UserRole();
            userRole.setUserId(userId);
            userRole.setRoleId(1L);
            userRoleService.save(userRole);
        }
        // 添加教师角色记录
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        userRole.setRoleId(2L);
        userRoleService.save(userRole);
    }

    @Transactional
    @Override
    public void updateWithUserAndRole(TeacherVo teacherVo) {
        // 修改教师表信息
        teacherMapper.updateTeacher(teacherVo);

        // 修改用户表信息
        // 重置密码
        if(teacherVo.getIsResetPwd() == 1) {
            Map<String,String> map = DigestsUtils.encrypt("olms123456");
            String password = map.get("password");
            String salt = map.get("salt");
            teacherVo.setPassword(password);
            teacherVo.setSalt(salt);
        }
        userService.updateById(teacherVo);

        //修改角色表信息
        UserRole manager = userRoleMapper.getManagerByUserId(teacherVo.getId());
        // 设置为管理员
        if(manager == null && teacherVo.getIsSetManager() == 1) {
            UserRole userRole = new UserRole();
            userRole.setUserId(teacherVo.getId());
            userRole.setRoleId(1L);
        }
        // 取消管理员
        if(manager != null && teacherVo.getIsSetManager() == 0) {
            userRoleMapper.removeManagerByUserId(teacherVo.getId());
        }
    }
}




