package com.maike.webapp.function.controller;

import com.maike.common.annotation.Log;
import com.maike.common.core.controller.BaseController;
import com.maike.common.result.AjaxResult;
import com.maike.common.core.page.PageDataInfo;
import com.maike.common.enums.BusinessType;
import com.maike.webapp.function.domain.GpUserComment;
import com.maike.webapp.function.service.IGpUserCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户评论回复留言Controller
 *
 * @author 佚名
 * @date 2023-03-12
 */
@RestController
@RequestMapping("/geekplus/comment")
public class GpUserCommentController extends BaseController
{
    @Autowired
    private IGpUserCommentService gpUserCommentService;

    /**
     * 查询用户评论回复留言列表
     */
    @PreAuthorize("@ss.hasPermi('function:comment:list')")
    @GetMapping("/list")
    public PageDataInfo list(GpUserComment gpUserComment)
    {
        startPage();
        gpUserComment.setParentId(Long.parseLong("0"));
        List<GpUserComment> list = gpUserCommentService.getUserComment(gpUserComment);//selectGpUserCommentList(gpUserComment);
        return getDataTable(list);
    }

    /**
     * 查询用户评论回复留言列表
     */
    @PreAuthorize("@ss.hasPermi('function:comment:list')")
    @GetMapping("/userComment")
    public AjaxResult userComment(GpUserComment gpUserComment)
    {
        List<GpUserComment> list = gpUserCommentService.selectGpUserCommentList(gpUserComment);
        return AjaxResult.success(list);
    }

    /**
     * 导出用户评论回复留言列表
     */
//    @PreAuthorize("@ss.hasPermi('function:comment:export')")
//    @Log(title = "用户评论回复留言", businessType = BusinessType.EXPORT)
//    @GetMapping("/export")
//    public AjaxResult export(GpUserComment gpUserComment)
//    {
//        List<GpUserComment> list = gpUserCommentService.selectGpUserCommentList(gpUserComment);
//        ExcelUtil<GpUserComment> util = new ExcelUtil<GpUserComment>(GpUserComment.class);
//        return util.exportExcel(list, "comment");
//    }

    /**
     * 获取用户评论回复留言详细信息
     */
    @PreAuthorize("@ss.hasPermi('function:comment:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(gpUserCommentService.selectGpUserCommentById(id));
    }

    /**
     * 新增用户评论回复留言
     */
    @PreAuthorize("@ss.hasPermi('function:comment:add')")
    @Log(title = "用户评论回复留言", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GpUserComment gpUserComment)
    {
        return toAjax(gpUserCommentService.insertGpUserComment(gpUserComment));
    }

    /**
     * 修改用户评论回复留言
     */
    @PreAuthorize("@ss.hasPermi('function:comment:edit')")
    @Log(title = "用户评论回复留言", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GpUserComment gpUserComment)
    {
        return toAjax(gpUserCommentService.updateGpUserComment(gpUserComment));
    }

    /**
     * 删除用户评论回复留言
     */
    @PreAuthorize("@ss.hasPermi('function:comment:remove')")
    @Log(title = "用户评论回复留言", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(gpUserCommentService.deleteGpUserCommentByIds(ids));
    }
}
