package com.cuit9622.olms.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cuit9622.common.model.R;
import com.cuit9622.olms.entity.Device;
import com.cuit9622.olms.vo.DeviceVo;
import com.cuit9622.olms.mapper.DeviceMapper;
import com.cuit9622.olms.service.DeviceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j(topic = "DeviceServiceImpl")
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements DeviceService {
    @Resource
    private DeviceMapper deviceMapper;

    @Override
    public Page<DeviceVo> selectDevice(Integer pageSize, Integer page, String name, String status) {
        Page<DeviceVo> pageInfo = new Page<>(page, pageSize);
        pageInfo = deviceMapper.page(pageInfo, name, status);
        return pageInfo;
    }

    @Override
    public DeviceVo getById(Long id) {
        DeviceVo deviceVo;
        deviceVo = deviceMapper.getOne(id);
        return deviceVo;
    }

    @Override
    public Integer updateById(DeviceVo deviceVo) {
        return deviceMapper.updateById(deviceVo);
    }

    @Override
    public Integer insertOne(DeviceVo deviceVo) {
        return deviceMapper.insertOne(deviceVo);
    }


}
