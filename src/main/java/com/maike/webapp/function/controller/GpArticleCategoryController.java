package com.maike.webapp.function.controller;

import com.maike.common.annotation.Log;
import com.maike.common.core.controller.BaseController;
import com.maike.common.result.Result;
import com.maike.common.enums.BusinessType;
import com.maike.webapp.function.domain.GpArticleCategory;
import com.maike.webapp.function.service.IGpArticleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文章类型目录Controller
 *
 * @author 佚名
 * @date 2023-03-12
 */
@RestController
@RequestMapping("/geekplus/category")
public class GpArticleCategoryController extends BaseController
{
    @Autowired
    private IGpArticleCategoryService gpArticleCategoryService;

    /**
     * 查询文章类型目录列表
     */
    @PreAuthorize("@ss.hasPermi('function:category:list')")
    @GetMapping("/list")
    public Result list(GpArticleCategory gpArticleCategory)
    {
        //startPage();
        List<GpArticleCategory> list = gpArticleCategoryService.selectGpArticleCategoryList(gpArticleCategory);
        return Result.success(list);
    }

    /**
     * 导出文章类型目录列表
     */
//    @PreAuthorize("@ss.hasPermi('function:category:export')")
//    @Log(title = "文章类型目录", businessType = BusinessType.EXPORT)
//    @GetMapping("/export")
//    public AjaxResult export(GpArticleCategory gpArticleCategory)
//    {
//        List<GpArticleCategory> list = gpArticleCategoryService.selectGpArticleCategoryList(gpArticleCategory);
//        ExcelUtil<GpArticleCategory> util = new ExcelUtil<GpArticleCategory>(GpArticleCategory.class);
//        return util.exportExcel(list, "category");
//    }

    /**
     * 获取文章类型目录详细信息
     */
    @PreAuthorize("@ss.hasPermi('function:category:query')")
    @GetMapping(value = "/{id}")
    public Result getInfo(@PathVariable("id") Integer id)
    {
        return Result.success(gpArticleCategoryService.selectGpArticleCategoryById(id));
    }

    /**
     * 新增文章类型目录
     */
    @PreAuthorize("@ss.hasPermi('function:category:add')")
    @Log(title = "文章类型目录", businessType = BusinessType.INSERT)
    @PostMapping
    public Result add(@RequestBody GpArticleCategory gpArticleCategory)
    {
        return toAjax(gpArticleCategoryService.insertGpArticleCategory(gpArticleCategory));
    }

    /**
     * 修改文章类型目录
     */
    @PreAuthorize("@ss.hasPermi('function:category:edit')")
    @Log(title = "文章类型目录", businessType = BusinessType.UPDATE)
    @PutMapping
    public Result edit(@RequestBody GpArticleCategory gpArticleCategory)
    {
        return toAjax(gpArticleCategoryService.updateGpArticleCategory(gpArticleCategory));
    }

    /**
     * 删除文章类型目录
     */
    @PreAuthorize("@ss.hasPermi('function:category:remove')")
    @Log(title = "文章类型目录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public Result remove(@PathVariable Integer[] ids)
    {
        return toAjax(gpArticleCategoryService.deleteGpArticleCategoryByIds(ids));
    }

    /**
     * 获取父目录类型列表
     */
    @PreAuthorize("@ss.hasPermi('function:category:list')")
    //@Log(title = "文章类型目录", businessType = BusinessType.DELETE)
    @GetMapping("/listParentCategory")
    public Result listParentCategory()
    {
        return Result.success(gpArticleCategoryService.selectParentCategory());
    }

    /**
     * 获取父目录子菜单循环递归目录菜单
     */
    @PreAuthorize("@ss.hasPermi('function:category:list')")
    //@Log(title = "文章类型目录", businessType = BusinessType.DELETE)
    @GetMapping("/listSubParentCategory")
    public Result listSubParentCategory()
    {
        return Result.success(gpArticleCategoryService.selectSubParentCategory());
    }

    /**
     * 获取父目录子菜单循环递归目录菜单，sql子查询方式
     */
    //@Log(title = "文章类型目录", businessType = BusinessType.DELETE)
    @GetMapping("/listSubCategory")
    public Result listSubCategory()
    {
        GpArticleCategory gpArticleCategory=new GpArticleCategory();
        gpArticleCategory.setMenuType("1");
        return Result.success(gpArticleCategoryService.selectArticleCategoryList(gpArticleCategory));
    }
}
