package com.cuit9622.olms.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.common.model.R;
import com.cuit9622.olms.annotation.DateAutoFill;
import com.cuit9622.olms.entity.Notice;
import com.cuit9622.olms.entity.dto.NoticeDto;
import com.cuit9622.olms.model.DeleteModel;
import com.cuit9622.olms.service.NoticeService;
import com.cuit9622.olms.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Author: lsh
 * Version: 1.0
 * @Description: 公告控制类
 */
@RestController
@Slf4j(topic = "NoticeController")
@Api(tags = "公告相关Api")
public class NoticeController {

    @Resource
    private NoticeService noticeService;

    /**
     * @Description 分页查询公告
     * @param pageSize 条数
     * @param page 当前页
     * @return
     */
    @GetMapping("/notice")
    @ApiOperation("公告信息分页查询的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize", value = "每页的条数", defaultValue = "5", required = true),
            @ApiImplicitParam(name = "page", value = "页码", defaultValue = "1", required = true)
    })
    public R<Page<NoticeDto>> getNotice(
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "page", defaultValue = "1") Integer page) {
        R<Page<NoticeDto>> info = noticeService.selectNotice(pageSize, page);
        log.info(info.getMsg());
        return info;
    }

    /**
     * @Description 根据id删除信息
     * @param id 需要删除的id
     * @return
     */
    @DeleteMapping("/auth/notice/{id}")
    @ApiOperation("根据id删除公告信息")
    @RequiresRoles("admin")
    @ApiImplicitParam(name = "id", value = "要删除的id", required = true)
    public R<String> deleteNoticeById(@PathVariable("id") Integer id) {
        noticeService.removeById(id);
        log.info("删除id为{}的公告成功", id);
        return R.ok("删除成功");
    }

    /**
     * @Description 根据ids删除公告
     * @param ids
     * @return
     */
    @DeleteMapping("/auth/notice")
    @ApiOperation("根据ids删除公告信息")
    @RequiresRoles("admin")
    @ApiImplicitParam(name = "model", value = "要删除的id数组", required = true)
    public R<String> deleteNoticeByIds(@RequestBody DeleteModel model) {
        noticeService.removeBatchByIds(model.getIds());
        log.info("删除id为{}的公告成功", model.getIds().toString());
        return R.ok("删除成功");
    }

    /**
     * @Description 新增公告
     * @param notice
     * @return
     */
    @PostMapping("/auth/notice")
    @ApiOperation("新增公告信息")
    @RequiresRoles("admin")
    @DateAutoFill(DateAutoFill.Type.INSERT)
    public R<String> addNotice(@RequestBody Notice notice){
        noticeService.save(notice);
        log.info("新增的公告为{}",notice);
        return R.ok("新增公告成功");
    }
}
