package com.cuit9622.olms.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.olms.entity.Notice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cuit9622.olms.vo.NoticeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author 刘世浩
* @description 针对表【sys_notice(公告表)】的数据库操作Mapper
* @Entity com.cuit9622.olms.entity.Notice
*/
@Mapper
public interface NoticeMapper extends BaseMapper<Notice> {

    Page<NoticeVo> page(@Param("page") Page<NoticeVo> page);

}




