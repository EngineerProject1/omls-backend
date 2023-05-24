package com.cuit9622.olms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.olms.entity.Device;
import com.cuit9622.olms.vo.DeviceVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @description 针对表【sys_device(设备表)】的数据库操作Mapper
 * @Entity com.cuit9622.olms.entity.Device
 */
@Mapper
public interface DeviceMapper extends BaseMapper<Device> {
    /**
     * @Description 设备的分页查找
     * @param page 分页数据
     * @return
     * @Date 16:45 2023/5/11
     */
    Page<DeviceVo> page(@Param("page") Page<DeviceVo> page, @Param("name") String name, @Param("status") String status);

    /**
     * @Description 通过id获取设备信息
     * @param id
     * @return
     * @Date 16:46 2023/5/11
     */
    DeviceVo getOne(@Param("id") Long id);

    /**
     * @Description 通过id更新设备信息
     * @param deviceVo
     * @return
     */
    Integer updateById(@Param("deviceVo") DeviceVo deviceVo);

    /**
     * @Description 新增设备信息
     * @param device
     * @return
     */
    Integer insertOne(@Param("device") Device device);

}
