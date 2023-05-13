package com.cuit9622.olms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cuit9622.olms.entity.Major;
import com.cuit9622.olms.service.MajorService;
import com.cuit9622.olms.mapper.MajorMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author Zxin
* @description 针对表【sys_major】的数据库操作Service实现
* @createDate 2023-05-11 18:35:30
*/
@Service
public class MajorServiceImpl extends ServiceImpl<MajorMapper, Major>
    implements MajorService{
    @Resource
    private MajorMapper majorMapper;
    @Override
    public List<Major> selectMajorsByCollegeId(Long id) {
        List<Major> majors = majorMapper.selectListByCollegeId(id);
        return majors;
    }
}




