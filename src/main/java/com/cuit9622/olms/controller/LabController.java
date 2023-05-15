package com.cuit9622.olms.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.common.model.R;
import com.cuit9622.olms.model.LabSelectModel;
import com.cuit9622.olms.service.LabService;
import com.cuit9622.olms.vo.LabVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Author: lsh
 * Date: 2023/5/15 15:42
 * Version: 1.0
 * @Description: 实验室控制器
 */
@RestController
@Slf4j(topic = "LabController")
@Api("实验室相关接口")
public class LabController {

    @Resource
    private LabService labService;

    /**
     * @Description 分页查询实验室的接口
     * @param model
     * @return
     * @Date 16:09 2023/5/15
     */
    @GetMapping("/lab")
    @ApiOperation("实验室查询分页查询的接口")
    public R<Page<LabVo>> getLab(LabSelectModel model){
        Page<LabVo> page = new Page<>(model.getPage(), model.getPageSize());
        labService.listByPage(page,model);
        log.info("分页查询的实验室信息为{}",page);
        return R.ok("查询实验室信息成功", page);
    }
}
