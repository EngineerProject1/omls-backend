package com.cuit9622.olms.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.olms.entity.Lab;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cuit9622.olms.model.LabSelectModel;
import com.cuit9622.olms.vo.LabVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 刘世浩
 * @description 针对表【sys_lab(实验室表)】的数据库操作Mapper
 * @createDate 2023-05-15 15:38:57
 * @Entity com.cuit9622.olms.entity.Lab
 */
@Mapper
public interface LabMapper extends BaseMapper<Lab> {

    /**
     * @Description 实验室的分页查询
     * @param page 分页管理器
     * @param model
     * @return
     * @Date 15:53 2023/5/15
     */
    Page<LabVo> page(@Param("page") Page<LabVo> page, @Param("model") LabSelectModel model);

}




