package com.cuit9622.olms.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cuit9622.common.utils.DigestsUtils;
import com.cuit9622.olms.entity.Teacher;
import com.cuit9622.olms.entity.TeacherReadListener;
import com.cuit9622.olms.entity.User;
import com.cuit9622.olms.entity.UserRole;
import com.cuit9622.olms.mapper.UserMapper;
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
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description 教师接口实现类
 * @Date 16:33 2023/5/11
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
    @Resource
    private UserMapper userMapper;

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
            userRoleService.save(userRole);
        }
        // 取消管理员
        if(manager != null && teacherVo.getIsSetManager() == 0) {
            userRoleMapper.removeManagerByUserId(teacherVo.getId());
        }
    }

    @Override
    @Transactional
    public void deleteWithUserAndRole(TeacherVo teacherVo) {
        // 在教师表中删除
        teacherMapper.removeTeacherByTid(teacherVo.getTid());

        // 在用户表中删除
        userService.removeById((User) teacherVo);

        // 在角色表中删除
        userRoleMapper.removeUserRoleByUserId(teacherVo.getId());
    }

    @Override
    @Transactional
    public void deleteBatchWithUserAndRole(List<Integer> tids) {
        List<Long> ids = new ArrayList<>();

        for(int i = 0; i < tids.size(); i++) {
            long tid = tids.get(i);
            // 通过教师tid获取对应的用户id
            long id = userMapper.getUserIdBySid(tid);
            ids.add(id);

            // 在角色表中删除
            userRoleMapper.removeUserRoleByUserId(id);

            // 在教师表中删除
            teacherMapper.removeTeacherByTid(tid);
        }

        // 在用户表中批量删除
        userService.removeBatchByIds(ids);
    }
    @Transactional
    @Override
    public void importExcel(MultipartFile file, TeacherReadListener listener) throws IOException {
        // 读取文件的流
        InputStream is = file.getInputStream();
        EasyExcel.read(is, TeacherVo.class, listener).sheet(0) // 读第几个工作表
                .headRowNumber(1) // 列头占几行
                .doRead();
    }

}




