package com.cuit9622.olms.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cuit9622.olms.entity.Lab;
import com.cuit9622.olms.model.LabSelectModel;
import com.cuit9622.olms.service.LabService;
import com.cuit9622.olms.mapper.LabMapper;
import com.cuit9622.olms.vo.LabVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author 刘世浩
* @description 针对表【sys_lab(实验室表)】的数据库操作Service实现
* @createDate 2023-05-15 15:38:57
*/
@Service
@Slf4j(topic = "LabServiceImpl")
public class LabServiceImpl extends ServiceImpl<LabMapper, Lab>
    implements LabService{

    @Resource
    private LabMapper labMapper;

    @Override
    public Page<LabVo> listByPage(Page<LabVo> page, LabSelectModel model) {
        return labMapper.page(page,model);
    }
}




