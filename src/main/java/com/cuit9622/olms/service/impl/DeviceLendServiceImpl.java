package com.cuit9622.olms.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cuit9622.olms.entity.DeviceLend;
import com.cuit9622.olms.service.DeviceLendService;
import com.cuit9622.olms.mapper.DeviceLendMapper;
import com.cuit9622.olms.vo.DeviceVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
* @author wzq
* @description 针对表【sys_device_lend(设备借阅表)】的数据库操作Service实现
*/
@Service
public class DeviceLendServiceImpl extends ServiceImpl<DeviceLendMapper, DeviceLend>
    implements DeviceLendService{

    @Resource
    private DeviceLendMapper deviceLendMapper ;
    @Override
    public List<Map<Long, String>> getAppointmentLab(Long id) {
        List<Map<Long, String>> labNames = deviceLendMapper.getAppointmentLab(id);
        return labNames;
    }

    @Override
    public Page<DeviceVo> getDevice(Integer pageSize, Integer page, String name, Long lagId) {
        Page<DeviceVo> pageInfo = new Page<>(page, pageSize);
        Page<DeviceVo> devicePage = deviceLendMapper.page( pageInfo, name, lagId);
        return devicePage;
    }

    @Override
    public Page<DeviceVo> getLendDevice(Integer pageSize, Integer page, String name, Long userId) {
        Page<DeviceVo> pageInfo = new Page<>(page, pageSize);
        Page<DeviceVo> devicePage = deviceLendMapper.pageInLend( pageInfo, name, userId);
        return devicePage;
    }

    @Override
    public Integer returnDeviceByModel(DeviceVo deviceVo) {
        //先得到要修改状态的设备id
        Long deviceId = deviceLendMapper.getDeviceIdLong(deviceVo);

        Integer count = 0;
        //修改sys_device_lend中的归还时间
        count = deviceLendMapper.updateReturnTime(deviceId);
        //修改sys_device中的status
        count += deviceLendMapper.returnDeviceById(deviceId);

        return count;
    }

    @Override
    public Integer lendDeviceByModel(DeviceVo deviceVo, Long userId) {
        //先查询当前时间是否在该实验室进行阶段 若是就返回预约id
        Long appointmentId = deviceLendMapper.checkTime(deviceVo, userId);

        // 不在当前实验时间直接返回0
        if(appointmentId == null){
            return 0;
        }

        //再查询当前用户考勤状态是否正常
        Integer flag = deviceLendMapper.cheekAttendance(appointmentId, userId);

        Integer count = 0;
        // 用户考勤状态为 '正常' 或者 '迟到' 可以进行借用设备
        if(flag == 1 || flag == 2){
            // 在此条件下用户才可以进行设备借用
            //拿到设备编号
            Long deviceId = deviceLendMapper.getDeviceId(deviceVo);
            //更新设备表
            count += deviceLendMapper.updateDeviceStatus(deviceId);
            //更新设备借用表
            count += deviceLendMapper.insertDeviceLend(deviceId, userId);
        }
        return count;
    }
}




