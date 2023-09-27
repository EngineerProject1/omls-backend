package com.cuit9622.olms.service;

import com.cuit9622.olms.entity.Major;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Zxin
* @description 针对表【sys_major】的数据库操作Service
*/
public interface MajorService extends IService<Major> {

    /**
     * 通过学院id获取对应的专业
     * @param id 学院id
     * @return 专业列表
     */
    List<Major> selectMajorsByCollegeId(Long id);
}
