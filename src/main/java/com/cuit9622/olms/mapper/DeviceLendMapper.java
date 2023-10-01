package com.cuit9622.olms.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.olms.entity.DeviceLend;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cuit9622.olms.vo.DeviceVo;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
* @author HP
* @description 针对表【sys_device_lend(设备借阅表)】的数据库操作Mapper
* @Entity com.cuit9622.olms.entity.DeviceLend
*/
@Mapper
public interface DeviceLendMapper extends BaseMapper<DeviceLend> {
    /**
     * @Description 获取预约实验室
     * @param id  用户id
     * @return
     */
    @MapKey("id")
    List<Map<Long, String>> getAppointmentLab(@Param("id") Long id);

    /**
     * @Description 设备信息的分页查找
     * @param page 分页信息
     * @param  name 设备名称
     * @param  labId 实验室id
     * @return
     */
    Page<DeviceVo> page(@Param("page") Page<DeviceVo> page, @Param("name") String name, @Param("labId") Long labId);
}




