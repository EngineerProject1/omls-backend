package com.cuit9622.olms.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.common.model.R;
import com.cuit9622.olms.annotation.DateAutoFill;
import com.cuit9622.olms.entity.Notice;
import com.cuit9622.olms.entity.dto.NoticeDto;
import com.cuit9622.olms.model.DeleteModel;
import com.cuit9622.olms.service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Author: lsh
 * Date: 2023/4/28 17:02
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
     * @Date 17:31 2023/4/28
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
     * @Date 21:07 2023/5/9
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
     * @param model
     * @return
     * @Date 21:07 2023/5/9
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
     * @Date 12:25 2023/5/10
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

    /**
     * @Description 通过id获取公告信息
     * @param id 公告的id
     * @return
     * @Date 15:30 2023/5/10
     */
    @GetMapping("/notice/{id}")
    @ApiOperation("通过id获取某个公告")
    public R<Notice> getNotice(@PathVariable Long id){
        LambdaQueryWrapper<Notice> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Notice::getId,id);
        Notice notice = noticeService.getOne(wrapper);
        log.info("获取的公告信息:{}",notice);
        return R.ok("获取公告信息成功", notice);
    }

    /**
     * @Description 根据id修改公告信息
     * @param notice 需要修改的公告信息
     * @return
     * @Date 15:36 2023/5/10
     */
    @PutMapping("/auth/notice")
    @ApiOperation("修改某个公告")
    @RequiresRoles("admin")
    @DateAutoFill(DateAutoFill.Type.UPDATE)
    public R<String> updateNotice(@RequestBody Notice notice){
        log.info("将要修改的公告信息为:{}",notice);
        noticeService.updateById(notice);
        return R.ok("修改成功");
    }
}
