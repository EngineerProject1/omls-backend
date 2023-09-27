package com.cuit9622.olms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.olms.entity.Lab;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cuit9622.olms.model.LabSelectModel;
import com.cuit9622.olms.vo.LabVo;

import java.util.List;

/**
* @author 刘世浩
* @description 针对表【sys_lab(实验室表)】的数据库操作Service
*/
public interface LabService extends IService<Lab> {


    /**
     * @Description 分页查询实验室
     * @param page 分页数据
     * @param model 查询条件
     * @return
     */
    Page<LabVo> listByPage(Page<LabVo> page, LabSelectModel model);

    /**
     * @Description 删除实验室
     * @param id 根据id删除实验室
     * @return
     */
    void deleteLab(Integer id);

    /**
     * @Description 批量删除实验室
     * @param id
     * @return
     */
    void deleteLabs(List<Integer> id);

    /**
     * @Description 查询该实验室对应的开放时间段
     * @param id
     * @return
     */
    List<Integer> getLabSchedule(Long id);

    /**
     * @Description 修改实验室
     * @param labVo
     * @return
     */
    Boolean updateLab(LabVo labVo);

    /**
     * @Description 新增实验室
     * @param labVo
     * @return
     */
    Boolean addLab(LabVo labVo);
}
