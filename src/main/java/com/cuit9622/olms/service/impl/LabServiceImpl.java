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
    private LabScheduleMapper labScheduleMapper;

    @Override
    public Page<LabVo> listByPage(Page<LabVo> page, LabSelectModel model) {
        Page<LabVo> voPage = labMapper.page(page, model);
        List<LabVo> records = voPage.getRecords();
        records = records.stream().peek((item) -> {
            // 查询该实验室所对应的开放时间
            List<Integer> weekdays = labMapper.getWeekday(item.getId());
            item.setWeekdays(weekdays);
        }).collect(Collectors.toList());
        return voPage.setRecords(records);
    }

    @Override
    @Transactional
    public void deleteLab(Integer id) {
        // 删除实验室
        labMapper.deleteById(id);
        // 删除实验室对应的时间段
        LambdaQueryWrapper<LabSchedule> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(LabSchedule::getLabId, id);
        labScheduleMapper.delete(wrapper);
    }

    @Override
    @Transactional
    public void deleteLabs(List<Integer> id) {
        // 删除实验室
        labMapper.deleteBatchIds(id);
        // 删除实验室对应的时间段
        LambdaQueryWrapper<LabSchedule> wrapper = new LambdaQueryWrapper<>();
        wrapper.in(LabSchedule::getLabId, id);
        labScheduleMapper.delete(wrapper);
    }

    @Override
    public List<Integer> getLabSchedule(Long id) {
        return labMapper.getWeekday(id);
    }

    @Override
    @Transactional
    public Boolean updateLab(LabVo labVo) {
        try {
            // 修改实验室
            labMapper.updateById(labVo);
            // 删除该实验的开放时间，并将本次时间插入进去
            // 删除
            LambdaQueryWrapper<LabSchedule> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(LabSchedule::getLabId, labVo.getId());
            labScheduleMapper.delete(wrapper);
            List<Integer> weekdays = labVo.getWeekdays();
            if (weekdays.size() != 0){
                // 新增时间段
                Integer result = labScheduleMapper.insertSchedule(labVo.getId(), weekdays);
                if (result != weekdays.size()){
                    return false;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public Boolean addLab(LabVo labVo) {
        try {
            // 新增实验室
            labMapper.insert(labVo);
            // 新增时间段
            List<Integer> weekdays = labVo.getWeekdays();
            if (weekdays.size() != 0){
                Integer result = labScheduleMapper.insertSchedule(labVo.getId(), weekdays);
                if (result != weekdays.size()){
                    return false;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}




