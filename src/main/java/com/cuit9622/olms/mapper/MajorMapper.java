package com.cuit9622.olms.mapper;

import com.cuit9622.olms.entity.College;
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
    /**
     * 通过学院id获取该学院所对应的所有专业列表
     * @param id 学院id
     * @return
     */
    List<Major> selectListByCollegeId(@Param("id") Long id);

    /**
     * 通过专业名称获取学院对象
     * @param majorName 专业名
     * @return
     */
    College selectCollegeByMajorName(String majorName);
}




