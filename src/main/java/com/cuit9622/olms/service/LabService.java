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
* @createDate 2023-05-15 15:38:57
*/
public interface LabService extends IService<Lab> {


    /**
     * @Description 分页查询实验室
     * @param page 分页数据
     * @param model 查询条件
     * @return
     * @Date 16:08 2023/5/15
     */
    Page<LabVo> listByPage(Page<LabVo> page, LabSelectModel model);

    /**
     * @Description 删除实验室
     * @param id 根据id删除实验室
     * @return
     * @Date 14:44 2023/5/24
     */
    void deleteLab(Integer id);

    /**
     * @Description 批量删除实验室
     * @param id
     * @return
     * @Date 14:57 2023/5/24
     */
    void deleteLabs(List<Integer> id);
}
