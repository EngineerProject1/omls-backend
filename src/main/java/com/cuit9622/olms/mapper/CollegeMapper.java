package com.cuit9622.olms.mapper;

import com.cuit9622.olms.entity.College;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Zxin
* @description 针对表【sys_college】的数据库操作Mapper
* @Entity com.cuit9622.olms.entity.College
*/
@Mapper
public interface CollegeMapper extends BaseMapper<College> {

}




