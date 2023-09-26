package com.cuit9622.olms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cuit9622.common.model.R;
import com.cuit9622.olms.entity.Device;
import com.cuit9622.olms.entity.dto.DeviceDto;
import com.cuit9622.olms.entity.dto.NoticeDto;

/**
 * @Description:设备接口
 */
public interface DeviceService extends IService<Device> {
    R<Page<DeviceDto>> selectDevice(Integer pageSize, Integer page);
}
