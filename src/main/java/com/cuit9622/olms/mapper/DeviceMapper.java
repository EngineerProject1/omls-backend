package com.cuit9622.olms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.olms.entity.Device;
import com.cuit9622.olms.entity.dto.DeviceDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @description 针对表【sys_device(设备表)】的数据库操作Mapper
 * @Entity com.cuit9622.olms.entity.Device
 */
@Mapper
public interface DeviceMapper extends BaseMapper<Device> {
    Page<DeviceDto> page(@Param("page") Page<DeviceDto> page);
}
