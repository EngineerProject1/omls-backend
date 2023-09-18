package com.cuit9622.olms.UserService;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.common.model.R;
import com.cuit9622.olms.entity.Notice;
import com.cuit9622.olms.service.NoticeService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * Author: lsh
 * Version: 1.0
 * @Description: 公告测试类
 */
@SpringBootTest
public class NoticeServiceTest {

    @Resource
    private NoticeService noticeService;

    /**
     * @Description 测试公告分页查询
     */
    @Test
    public void testPage(){
        R<Page<Notice>> pageR = noticeService.selectNotice(2, 1);
        System.out.println(pageR);
    }
}
