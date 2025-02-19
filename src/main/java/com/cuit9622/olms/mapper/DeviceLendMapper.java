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

    /**
     * @Description 设备信息的分页查找
     * @param page 分页信息
     * @param  name 设备名称
     * @param  userId 用户id
     * @return
     */
    Page<DeviceVo> pageInLend(@Param("page") Page<DeviceVo> page, @Param("name") String name, @Param("userId") Long userId);

    /**
     * @Description 根据型号归还设备(逐一归还) 将设备状态改为可用
     * @param id 设备id
     * @return
     */
    Integer returnDeviceById(@Param("id") Long id);

    /**
     * @Description 对应sys_device_lend中应该改变时间状态
     * @param id 设备id
     * @return
     */
    Integer updateReturnTime(@Param("id") Long id);


    /**
     * @Description 获取休要修改的设备id
     * @param deviceVo 设备信息
     * @return
     */
    Long getDeviceIdLong(@Param("deviceVo") DeviceVo deviceVo);

    /**
     * @Description 检查当前时间是否在实验进行时间内
     * @param deviceVo 设备信息
     * @Param userId 用户id
     * @return
     */
    Long checkTime(@Param("deviceVo") DeviceVo deviceVo, @Param("userId") Long userId);

    /**
     * @Description 查询考勤状态
     * @param appointmentId 预约id
     * @Param userId 用户id
     * @return
     */
    Integer cheekAttendance(@Param("appointmentId") Long appointmentId, @Param("userId") Long userId);

    /**
     * @Description 拿到要借用的设备id
     * @param deviceVo 设备信息
     * @return
     */
    Long getDeviceId(@Param("deviceVo") DeviceVo deviceVo);

    /**
     * @Description 更新要借用的设备的status
     * @param deviceId 设备id
     * @return
     */
    Integer updateDeviceStatus(@Param("deviceId") Long deviceId);

    /**
     * @Description 添加设备借用记录
     * @param deviceId 设备id
     * @param userId 用户id
     * @return
     */
    Integer insertDeviceLend(@Param("deviceId") Long deviceId, @Param("userId") Long userId);
}




