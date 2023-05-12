package com.cuit9622.olms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cuit9622.olms.entity.Device;
import com.cuit9622.olms.vo.DeviceVo;

/**
 * @Description:设备接口
 */
public interface DeviceService extends IService<Device> {
    /**
     * @Description 分页查找设备信息
     * @param pageSize 页面大小
     * @param page 页码
     * @return
     * @Date 16:47 2023/5/11
     */
    Page<DeviceVo> selectDevice(Integer pageSize, Integer page);

    /**
     * @Description 通过id获取设备信息
     * @param id
     * @return
     * @Date 16:47 2023/5/11
     */
    DeviceVo getById(Long id);

    /**
     * @Description 通过id更新设备信息
     * @param deviceVo
     * @return
     */
    Integer updateById(DeviceVo deviceVo);

    /**
     * @Description 新增设备信息
     * @param deviceVo
     * @return
     */
    Integer insertOne(DeviceVo deviceVo);
}
