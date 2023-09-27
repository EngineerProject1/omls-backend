package com.cuit9622.olms.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuit9622.common.exception.BizException;
import com.cuit9622.common.model.R;
import com.cuit9622.olms.entity.Lab;
import com.cuit9622.olms.model.DeleteModel;
import com.cuit9622.olms.model.LabSelectModel;
import com.cuit9622.olms.service.LabService;
import com.cuit9622.olms.vo.LabVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author: lsh
 * Date: 2023/5/15 15:42
 * Version: 1.0
 * @Description: 实验室控制器
 */
@RestController
@Slf4j(topic = "LabController")
@Api(tags = "实验室相关接口")
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
    public R<Page<LabVo>> getLab(LabSelectModel model) {
        Page<LabVo> page = new Page<>(model.getPage(), model.getPageSize());
        labService.listByPage(page, model);
        log.info("分页查询的实验室信息为{}", page);
        return R.ok("查询实验室信息成功", page);
    }

    /**
     * @Description 查询所有实验室
     * @return
     */
    @GetMapping("/allLab")
    @ApiOperation("实验室查询分页查询的接口")
    public R<List<Lab>> getAllLab() {
        List<Lab> labs = labService.getBaseMapper().selectList(null);
        return R.ok("查询实验室信息成功", labs);
    }
    /**
     * @Description 根据id删除实验室信息
     * @param id
     * @return
     * @Date 21:44 2023/5/18
     */
    @DeleteMapping("/auth/lab/{id}")
    @RequiresRoles("admin")
    @ApiOperation("根据id删除实验室")
    public R<String> deleteLab(@PathVariable("id") Integer id) {
        try{
            labService.deleteLab(id);
        }catch (Exception e){
            throw new BizException("删除失败");
        }
        return R.ok("删除成功");
    }

    /**
     * @Description 批量删除实验室
     * @param model
     * @return
     * @Date 21:47 2023/5/18
     */
    @DeleteMapping("/auth/lab")
    @RequiresRoles("admin")
    @ApiOperation("批量删除实验室")
    public R<String> deleteLabs(@RequestBody DeleteModel model) {
        try{
            labService.deleteLabs(model.getIds());
        }catch (Exception e){
            throw new BizException("删除失败");
        }
        return R.ok("批量删除成功");
    }

    /**
     * @Description 根据id获取实验室
     * @param id
     * @return
     * @Date 11:18 2023/5/20
     */
    @GetMapping("/lab/{id}")
    @ApiOperation("根据id获取实验室")
    public R<LabVo> getLabById(@PathVariable("id") Long id) {
        Lab lab = labService.getById(id);
        // 查询该实验室对应的开放时间段
        if (lab == null) {
            throw new BizException("根据id获取实验室失败");
        }
        List<Integer> labSchedule = labService.getLabSchedule(id);
        LabVo labVo = new LabVo();
        BeanUtils.copyProperties(lab,labVo);
        labVo.setWeekdays(labSchedule);
        return R.ok("获取实验室数据成功", labVo);
    }

    /**
     * @Description 添加实验室
     * @param lab
     * @return
     * @Date 21:41 2023/5/22
     */
    @PostMapping("/auth/lab")
    @RequiresRoles("admin")
    @ApiOperation("增加实验室")
    public R<String> addLab(@RequestBody LabVo lab) {
        Boolean isSuccess = labService.addLab(lab);
        if (isSuccess){
            return R.ok("实验室添加成功");
        }
        return R.error(500,"实验室添加失败");
    }

    /**
     * @Description 修改实验室
     * @param lab
     * @return
     * @Date 21:41 2023/5/22
     */
    @PutMapping("/auth/lab")
    @RequiresRoles("admin")
    @ApiOperation("修改实验室")
    public R<String> updateLab(@RequestBody LabVo lab) {
        Boolean isSuccess = labService.updateLab(lab);
        if (isSuccess){
            return R.ok("实验室修改成功");
        }
        return R.error(500,"实验室修改失败");
    }

    /**
     * @Description 根据地址查询实验室
     * @param location
     * @return String
     * @Date 21:44 2023/5/22
     */
    @GetMapping("/lab/location")
    @ApiOperation("根据地址查询实验室")
    public R<String> selectLabByAddress(@Param("address") String location){
        LambdaQueryWrapper<Lab> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Lab::getLocation, location);
        Lab lab = labService.getOne(wrapper);
        if (lab != null){
            return R.ok("已存在实验室");
        }
        return R.ok("未存在实验室");
    }
}
