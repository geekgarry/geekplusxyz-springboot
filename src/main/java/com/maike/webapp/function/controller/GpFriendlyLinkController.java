package com.maike.webapp.function.controller;

import com.maike.common.annotation.Log;
import com.maike.common.core.controller.BaseController;
import com.maike.common.result.AjaxResult;
import com.maike.common.core.page.PageDataInfo;
import com.maike.common.enums.BusinessType;
import com.maike.webapp.function.domain.GpFriendlyLink;
import com.maike.webapp.function.service.IGpFriendlyLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 网站友情链接Controller
 *
 * @author 佚名
 * @date 2023-03-12
 */
@RestController
@RequestMapping("/geekplus/link")
public class GpFriendlyLinkController extends BaseController
{
    @Autowired
    private IGpFriendlyLinkService gpFriendlyLinkService;

    /**
     * 查询网站友情链接列表
     */
    @PreAuthorize("@ss.hasPermi('function:link:list')")
    @GetMapping("/list")
    public PageDataInfo list(GpFriendlyLink gpFriendlyLink)
    {
        startPage();
        List<GpFriendlyLink> list = gpFriendlyLinkService.selectGpFriendlyLinkList(gpFriendlyLink);
        return getDataTable(list);
    }

    /**
     * 导出网站友情链接列表
     */
//    @PreAuthorize("@ss.hasPermi('function:link:export')")
//    @Log(title = "网站友情链接", businessType = BusinessType.EXPORT)
//    @GetMapping("/export")
//    public AjaxResult export(GpFriendlyLink gpFriendlyLink)
//    {
//        List<GpFriendlyLink> list = gpFriendlyLinkService.selectGpFriendlyLinkList(gpFriendlyLink);
//        ExcelUtil<GpFriendlyLink> util = new ExcelUtil<GpFriendlyLink>(GpFriendlyLink.class);
//        return util.exportExcel(list, "link");
//    }

    /**
     * 获取网站友情链接详细信息
     */
    @PreAuthorize("@ss.hasPermi('function:link:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(gpFriendlyLinkService.selectGpFriendlyLinkById(id));
    }

    /**
     * 新增网站友情链接
     */
    @PreAuthorize("@ss.hasPermi('function:link:add')")
    @Log(title = "网站友情链接", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GpFriendlyLink gpFriendlyLink)
    {
        return toAjax(gpFriendlyLinkService.insertGpFriendlyLink(gpFriendlyLink));
    }

    /**
     * 修改网站友情链接
     */
    @PreAuthorize("@ss.hasPermi('function:link:edit')")
    @Log(title = "网站友情链接", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GpFriendlyLink gpFriendlyLink)
    {
        return toAjax(gpFriendlyLinkService.updateGpFriendlyLink(gpFriendlyLink));
    }

    /**
     * 删除网站友情链接
     */
    @PreAuthorize("@ss.hasPermi('function:link:remove')")
    @Log(title = "网站友情链接", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(gpFriendlyLinkService.deleteGpFriendlyLinkByIds(ids));
    }
}
