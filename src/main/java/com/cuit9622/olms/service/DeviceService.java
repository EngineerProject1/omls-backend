package com.cuit9622.olms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cuit9622.common.model.R;
import com.cuit9622.olms.entity.Device;
import com.cuit9622.olms.vo.DeviceVo;

/**
 * @Description:设备接口
 */
public interface DeviceService extends IService<Device> {
    R<Page<DeviceVo>> selectDevice(Integer pageSize, Integer page);

    DeviceVo getById(Long id);
}
