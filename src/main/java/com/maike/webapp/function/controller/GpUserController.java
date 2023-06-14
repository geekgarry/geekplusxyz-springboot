package com.maike.webapp.function.controller;
import com.maike.common.result.Result;
import com.maike.common.result.ResultGenerator;
import com.maike.webapp.function.domain.GpUser;
import com.maike.webapp.function.service.GpUserService;
import com.maike.common.core.page.PageDataInfo;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户信息表 用户信息表
 * Created by CodeGenerator on 2023/06/14.
 */
@RestController
@RequestMapping("/gp/user")
public class GpUserController {
    @Resource
    private GpUserService gpUserService;

    /*
     * 增加 用户信息表
     */
    @PostMapping("/add")
    public Result add(GpUser gpUser) {
        gpUserService.insertGpUser(gpUser);
        return ResultGenerator.genSuccessResult();
    }

    /*
    * 删除 用户信息表
    */
    @GetMapping("/delete")
    public Result remove(@RequestParam Long userId) {
        gpUserService.deleteGpUserById(userId);
        return ResultGenerator.genSuccessResult();
    }

    /*
    * 批量删除 用户信息表
    */
    @DeleteMapping("/{userIds}")
    public Result remove(@PathVariable Long[] userIds) {
        gpUserService.deleteGpUserByIds(userIds);
        return ResultGenerator.genSuccessResult();
    }

    /*
    * 更新 用户信息表
    */
    @PostMapping("/update")
    public Result edit(GpUser gpUser) {
        gpUserService.updateGpUser(gpUser);
        return ResultGenerator.genSuccessResult();
    }

    /*
    * 单条数据详情 用户信息表
    */
    @GetMapping("/detail")
    public Result detail(@RequestParam Long userId) {
        GpUser gpUser = gpUserService.selectGpUserById(userId);
        return ResultGenerator.genSuccessResult(gpUser);
    }

    /*
    * 条件查询所有 用户信息表
    */
    @GetMapping("/listAll")
    public PageDataInfo list(GpUser gpUser) {
        //PageHelper.startPage(page, size);
        List<GpUser> list = gpUserService.selectGpUserList(gpUser);
        //PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.getPageData(list);
    }

    /*
    * 条件查询所有 用户信息表
    */
    @GetMapping("/list")
    public PageDataInfo list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size,GpUser gpUser) {
        PageHelper.startPage(page, size);
        List<GpUser> list = gpUserService.selectGpUserList(gpUser);
        //PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.getPageData(list);
    }
}
