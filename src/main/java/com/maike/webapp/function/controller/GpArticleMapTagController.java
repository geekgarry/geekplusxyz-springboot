package com.maike.webapp.function.controller;

import com.maike.common.annotation.Log;
import com.maike.common.core.controller.BaseController;
import com.maike.common.result.AjaxResult;
import com.maike.common.core.page.PageDataInfo;
import com.maike.common.enums.BusinessType;
import com.maike.webapp.function.domain.GpArticleMapTag;
import com.maike.webapp.function.service.IGpArticleMapTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文章标签映射Controller
 *
 * @author 佚名
 * @date 2023-03-12
 */
@RestController
@RequestMapping("/geekplus/articlemaptag")
public class GpArticleMapTagController extends BaseController
{
    @Autowired
    private IGpArticleMapTagService gpArticleMapTagService;

    /**
     * 查询文章标签映射列表
     */
    @PreAuthorize("@ss.hasPermi('function:tag:list')")
    @GetMapping("/list")
    public PageDataInfo list(GpArticleMapTag gpArticleMapTag)
    {
        startPage();
        List<GpArticleMapTag> list = gpArticleMapTagService.selectGpArticleMapTagList(gpArticleMapTag);
        return getDataTable(list);
    }

    /**
     * 导出文章标签映射列表
     */
//    @PreAuthorize("@ss.hasPermi('function:tag:export')")
//    @Log(title = "文章标签映射", businessType = BusinessType.EXPORT)
//    @GetMapping("/export")
//    public AjaxResult export(GpArticleMapTag gpArticleMapTag)
//    {
//        List<GpArticleMapTag> list = gpArticleMapTagService.selectGpArticleMapTagList(gpArticleMapTag);
//        ExcelUtil<GpArticleMapTag> util = new ExcelUtil<GpArticleMapTag>(GpArticleMapTag.class);
//        return util.exportExcel(list, "tag");
//    }

    /**
     * 获取文章标签映射详细信息
     */
    @PreAuthorize("@ss.hasPermi('function:tag:query')")
    @GetMapping(value = "/{aticleId}")
    public AjaxResult getInfo(@PathVariable("aticleId") Long aticleId)
    {
        return AjaxResult.success(gpArticleMapTagService.selectGpArticleMapTagById(aticleId));
    }

    /**
     * 新增文章标签映射
     */
    @PreAuthorize("@ss.hasPermi('function:tag:add')")
    @Log(title = "文章标签映射", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GpArticleMapTag gpArticleMapTag)
    {
        return toAjax(gpArticleMapTagService.insertGpArticleMapTag(gpArticleMapTag));
    }

    /**
     * 修改文章标签映射
     */
    @PreAuthorize("@ss.hasPermi('function:tag:edit')")
    @Log(title = "文章标签映射", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GpArticleMapTag gpArticleMapTag)
    {
        return toAjax(gpArticleMapTagService.updateGpArticleMapTag(gpArticleMapTag));
    }

    /**
     * 删除文章标签映射
     */
    @PreAuthorize("@ss.hasPermi('function:tag:remove')")
    @Log(title = "文章标签映射", businessType = BusinessType.DELETE)
	@DeleteMapping("/{aticleIds}")
    public AjaxResult remove(@PathVariable Long[] aticleIds)
    {
        return toAjax(gpArticleMapTagService.deleteGpArticleMapTagByIds(aticleIds));
    }
}
