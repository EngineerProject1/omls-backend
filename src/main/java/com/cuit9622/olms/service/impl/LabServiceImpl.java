package com.cuit9622.olms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cuit9622.olms.entity.Device;
import com.cuit9622.olms.entity.Lab;
import com.cuit9622.olms.entity.LabSchedule;
import com.cuit9622.olms.mapper.DeviceMapper;
import com.cuit9622.olms.mapper.LabScheduleMapper;
import com.cuit9622.olms.model.LabSelectModel;
import com.cuit9622.olms.service.LabService;
import com.cuit9622.olms.mapper.LabMapper;
import com.cuit9622.olms.vo.LabVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

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

    @Resource
    private LabScheduleMapper labScheduleMapper;

    @Override
    public Page<LabVo> listByPage(Page<LabVo> page, LabSelectModel model) {
        Page<LabVo> voPage = labMapper.page(page, model);
        List<LabVo> records = voPage.getRecords();
        records = records.stream().peek((item)->{
            // 查询该实验室所对应的开放时间
            List<Long> weekdays = labMapper.getWeekday(item.getId());
            item.setWeekdays(weekdays);
        }).collect(Collectors.toList());
        return voPage.setRecords(records);
    }

    @Override
    @Transactional
    public void deleteLab(Integer id) {
        labMapper.deleteById(id);
        LambdaUpdateWrapper<Device> wrapper = new LambdaUpdateWrapper<>();
        // 删除实验室
        wrapper.eq(Device::getLabId, id);
        // 删除实验室对应的时间段
        LambdaQueryWrapper<LabSchedule> labScheduleLambdaQueryWrapper = new LambdaQueryWrapper<>();
        labScheduleLambdaQueryWrapper.eq(LabSchedule::getLabId, id);
        labScheduleMapper.delete(labScheduleLambdaQueryWrapper);
        deviceMapper.delete(wrapper);
    }

    @Override
    @Transactional
    public void deleteLabs(List<Integer> id) {
        labMapper.deleteBatchIds(id);
        LambdaUpdateWrapper<Device> wrapper = new LambdaUpdateWrapper<>();
        // 删除实验室
        wrapper.in(Device::getLabId, id);
        deviceMapper.delete(wrapper);
        // 删除实验室对应的时间段
        LambdaQueryWrapper<LabSchedule> labScheduleLambdaQueryWrapper = new LambdaQueryWrapper<>();
        labScheduleLambdaQueryWrapper.in(LabSchedule::getLabId, id);
        labScheduleMapper.delete(labScheduleLambdaQueryWrapper);
    }
}




