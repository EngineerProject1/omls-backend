package com.cuit9622.olms.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cuit9622.common.model.R;
import com.cuit9622.olms.entity.Notice;
import com.cuit9622.olms.entity.dto.NoticeDto;
import com.cuit9622.olms.service.NoticeService;
import com.cuit9622.olms.mapper.NoticeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description 公告业务实现类
 * @Date 17:01 2023/4/28
 */
@Service
@Slf4j(topic = "NoticeServiceImpl")
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice>
        implements NoticeService {

    @Resource
    private NoticeMapper noticeMapper;

    @Override
    public R<Page<NoticeDto>> selectNotice(Integer pageSize, Integer page) {
        Page<NoticeDto> pageInfo = new Page<>(page, pageSize);
        pageInfo = noticeMapper.page(pageInfo);
        return R.ok("查询公告信息成功", pageInfo);
    }
}




