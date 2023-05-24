package com.cuit9622.olms.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cuit9622.olms.entity.Device;
import com.cuit9622.olms.entity.Lab;
import com.cuit9622.olms.mapper.DeviceMapper;
import com.cuit9622.olms.model.LabSelectModel;
import com.cuit9622.olms.service.LabService;
import com.cuit9622.olms.mapper.LabMapper;
import com.cuit9622.olms.vo.LabVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 刘世浩
 * @description 针对表【sys_lab(实验室表)】的数据库操作Service实现
 * @createDate 2023-05-15 15:38:57
 */
@Service
@Slf4j(topic = "LabServiceImpl")
public class LabServiceImpl extends ServiceImpl<LabMapper, Lab>
        implements LabService {

    @Resource
    private LabMapper labMapper;

    @Resource
    private DeviceMapper deviceMapper;

    @Override
    public Page<LabVo> listByPage(Page<LabVo> page, LabSelectModel model) {
        return labMapper.page(page, model);
    }

    @Override
    @Transactional
    public void deleteLab(Integer id) {
        labMapper.deleteById(id);
        LambdaUpdateWrapper<Device> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(Device::getLabId, id);
        deviceMapper.delete(wrapper);
    }

    @Override
    @Transactional
    public void deleteLabs(List<Integer> id) {
        labMapper.deleteBatchIds(id);
        LambdaUpdateWrapper<Device> wrapper = new LambdaUpdateWrapper<>();
        wrapper.in(Device::getLabId, id);
        deviceMapper.delete(wrapper);
    }
}




