package com.cuit9622.olms.service;

import com.cuit9622.olms.entity.Major;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Zxin
* @description 针对表【sys_major】的数据库操作Service
*/
public interface MajorService extends IService<Major> {

    List<Major> selectMajorsByCollegeId(Long id);
}
