package com.cuit9622.olms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cuit9622.olms.entity.College;
import com.cuit9622.olms.service.CollegeService;
import com.cuit9622.olms.mapper.CollegeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
* @author Zxin
* @description 针对表【sys_college】的数据库操作Service实现
* @createDate 2023-05-11 16:25:53
*/
@Service
@Slf4j(topic = "CollegeServiceImpl")
public class CollegeServiceImpl extends ServiceImpl<CollegeMapper, College>
    implements CollegeService{

}




