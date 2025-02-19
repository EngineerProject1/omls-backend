package com.cuit9622.olms.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cuit9622.olms.entity.Notice;
import com.cuit9622.olms.model.NoticeSelectModel;
import com.cuit9622.olms.vo.NoticeVo;
import com.cuit9622.olms.service.NoticeService;
import com.cuit9622.olms.mapper.NoticeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description 公告业务实现类
 */
@Service
@Slf4j(topic = "NoticeServiceImpl")
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice>
        implements NoticeService {

    @Resource
    private NoticeMapper noticeMapper;

    @Override
    public Page<NoticeVo> selectNotice(Integer pageSize, Integer page, NoticeSelectModel model) {
        Page<NoticeVo> pageInfo = new Page<>(page, pageSize);
        pageInfo = noticeMapper.page(pageInfo, model);
        return pageInfo;
    }
}




