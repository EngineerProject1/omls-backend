package com.cuit9622.olms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cuit9622.olms.entity.Device;
import com.cuit9622.olms.vo.DeviceVo;

import java.util.List;

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
    Page<DeviceVo> selectDevice(Integer pageSize, Integer page, String name, String status);

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
     * @param device
     * @return
     */
    Integer insertOne(Device device);

    /**
     * @Description 得到所有设备
     * @param
     * @return
     * @Date 17:08 2023/5/29
     */
    List<DeviceVo> getAllDevice();

}
