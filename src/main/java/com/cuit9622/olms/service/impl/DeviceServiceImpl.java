package com.cuit9622.olms.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cuit9622.common.model.R;
import com.cuit9622.olms.entity.Device;
import com.cuit9622.olms.entity.dto.DeviceDto;
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
    public R<Page<DeviceDto>> selectDevice(Integer pageSize, Integer page) {
        Page<DeviceDto> pageInfo = new Page<>(page, pageSize);
        pageInfo = deviceMapper.page(pageInfo);
        return R.ok("查询设备信息成功", pageInfo);
    }
}
