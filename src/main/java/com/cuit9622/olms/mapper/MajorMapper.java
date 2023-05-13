package com.cuit9622.olms.mapper;

import com.cuit9622.olms.entity.Major;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Zxin
* @description 针对表【sys_major】的数据库操作Mapper
* @createDate 2023-05-11 18:35:30
* @Entity com.cuit9622.olms.entity.Major
*/
@Mapper
public interface MajorMapper extends BaseMapper<Major> {

    List<Major> selectListByCollegeId(@Param("id") Long id);
}




