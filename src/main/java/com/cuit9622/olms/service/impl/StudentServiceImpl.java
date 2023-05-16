package com.cuit9622.olms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cuit9622.common.utils.DigestsUtils;
import com.cuit9622.olms.entity.Student;
import com.cuit9622.olms.entity.User;
import com.cuit9622.olms.entity.UserRole;
import com.cuit9622.olms.mapper.UserMapper;
import com.cuit9622.olms.mapper.UserRoleMapper;
import com.cuit9622.olms.model.UserSelectModel;
import com.cuit9622.olms.service.StudentService;
import com.cuit9622.olms.mapper.StudentMapper;
import com.cuit9622.olms.service.UserRoleService;
import com.cuit9622.olms.service.UserService;
import com.cuit9622.olms.vo.StudentVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    @Resource
    private UserService userService;
    @Resource
    private UserRoleService userRoleService;
    @Resource
    private UserRoleMapper userRoleMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    public Page<StudentVo> selectStudents(Integer pageSize, Integer page, UserSelectModel model) {
        Page<StudentVo> pageInfo = new Page<>(page,pageSize);
        pageInfo = studentMapper.page(pageInfo,model);
        return pageInfo;
    }

    @Override
    public StudentVo getStudentInfoByUsername(String username) {
        StudentVo student = studentMapper.getStudentInfoByUsername(username);
        // 如果存在该学生
        if(student != null) {
            Long userId = student.getId();
            // 查询该学生是否为管理员
            UserRole userRole = userRoleMapper.getManagerByUserId(userId);
            // 如果是管理员，管理员标志设为1
            if(userRole != null) {
                student.setIsSetManager(1);
            }
            else student.setIsSetManager(0);
        }
        log.info("用户名为{}的学生的信息为{}",username, student);
        return student;
    }

    /**
     * 添加学生的同时，添加用户以及用户角色
     * @param studentVo
     */
    @Transactional
    @Override
    public void saveWithUserAndRole(StudentVo studentVo) {
        // 设置密码盐值
        Map<String,String> map = DigestsUtils.encrypt("olms123456");
        String password = map.get("password");
        String salt = map.get("salt");
        studentVo.setPassword(password);
        studentVo.setSalt(salt);

        // 添加至学生表
        studentMapper.saveStudent(studentVo);

        // 添加至用户表
        userService.save(studentVo);

        // 添加至角色表
        // 获取userId
        User userInfo = userService.getUserInfoByName(studentVo.getUsername());
        Long userId = userInfo.getId();
        // 判断是否设置为管理员
        int flag = studentVo.getIsSetManager();
        // 如果为1，设为管理员
        if(flag == 1) {
            UserRole userRole = new UserRole();
            userRole.setUserId(userId);
            userRole.setRoleId(1L);
            userRoleService.save(userRole);
        }
        // 添加学生角色记录
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        userRole.setRoleId(3L);
        userRoleService.save(userRole);
    }
    @Transactional
    @Override
    public void updateWithUserAndRole(StudentVo studentVo) {
        // 修改学生表信息
        studentMapper.updateStudent(studentVo);

        // 修改用户表信息
        // 重置密码
        if(studentVo.getIsResetPwd() == 1) {
            Map<String,String> map = DigestsUtils.encrypt("olms123456");
            String password = map.get("password");
            String salt = map.get("salt");
            studentVo.setPassword(password);
            studentVo.setSalt(salt);
        }
        userService.updateById(studentVo);

        //修改角色表信息
        UserRole manager = userRoleMapper.getManagerByUserId(studentVo.getId());
        // 设置为管理员
        if(manager == null && studentVo.getIsSetManager() == 1) {
            UserRole userRole = new UserRole();
            userRole.setUserId(studentVo.getId());
            userRole.setRoleId(1L);
        }
        // 取消管理员
        if(manager != null && studentVo.getIsSetManager() == 0) {
            userRoleMapper.removeManagerByUserId(studentVo.getId());
        }
    }

    @Override
    @Transactional
    public void deleteWithUserAndRole(StudentVo studentVo) {
        // 在学生表中删除
        studentMapper.removeStudentBySid(studentVo.getSid());

        // 在用户表中删除
        userService.removeById((User) studentVo);

        // 在角色表中删除
        userRoleMapper.removeUserRoleByUserId(studentVo.getId());
    }

    @Override
    @Transactional
    public void deleteBatchWithUserAndRole(List<Integer> sids) {
        List<Long> ids = new ArrayList<>();

        for(int i = 0; i < sids.size(); i++) {
            long sid = sids.get(i);
            // 通过学生sid获取对应的用户id
            long id = userMapper.getUserIdBySid(sid);
            ids.add(id);

            // 在角色表中删除
            userRoleMapper.removeUserRoleByUserId(id);

            // 在学生表中批量删除
            studentMapper.removeStudentBySid(sid);
        }

        // 在用户表中批量删除
        userService.removeBatchByIds(ids);
    }
}




