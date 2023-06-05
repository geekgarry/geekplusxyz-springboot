package com.maike.webapp.function.controller;

import com.maike.common.annotation.Log;
import com.maike.common.core.controller.BaseController;
import com.maike.common.result.AjaxResult;
import com.maike.common.core.page.PageDataInfo;
import com.maike.common.enums.BusinessType;
import com.maike.webapp.function.domain.GpNotice;
import com.maike.webapp.function.service.IGpNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 网站通知Controller
 *
 * @author 佚名
 * @date 2023-03-18
 */
@RestController
@RequestMapping("/geekplus/notice")
public class GpNoticeController extends BaseController
{
    @Autowired
    private IGpNoticeService gpNoticeService;

    /**
     * 查询网站通知列表
     */
    @PreAuthorize("@ss.hasPermi('function:notice:list')")
    @GetMapping("/list")
    public PageDataInfo list(GpNotice gpNotice)
    {
        startPage();
        List<GpNotice> list = gpNoticeService.selectGpNoticeList(gpNotice);
        return getDataTable(list);
    }

    /**
     * 导出网站通知列表
     */
//    @PreAuthorize("@ss.hasPermi('function:notice:export')")
//    @Log(title = "网站通知", businessType = BusinessType.EXPORT)
//    @GetMapping("/export")
//    public AjaxResult export(GpNotice gpNotice)
//    {
//        List<GpNotice> list = gpNoticeService.selectGpNoticeList(gpNotice);
//        ExcelUtil<GpNotice> util = new ExcelUtil<GpNotice>(GpNotice.class);
//        return util.exportExcel(list, "notice");
//    }

    /**
     * 获取网站通知详细信息
     */
    @PreAuthorize("@ss.hasPermi('function:notice:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(gpNoticeService.selectGpNoticeById(id));
    }

    /**
     * 新增网站通知
     */
    @PreAuthorize("@ss.hasPermi('function:notice:add')")
    @Log(title = "网站通知", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GpNotice gpNotice)
    {
        return toAjax(gpNoticeService.insertGpNotice(gpNotice));
    }

    /**
     * 修改网站通知
     */
    @PreAuthorize("@ss.hasPermi('function:notice:edit')")
    @Log(title = "网站通知", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GpNotice gpNotice)
    {
        return toAjax(gpNoticeService.updateGpNotice(gpNotice));
    }

    /**
     * 删除网站通知
     */
    @PreAuthorize("@ss.hasPermi('function:notice:remove')")
    @Log(title = "网站通知", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(gpNoticeService.deleteGpNoticeByIds(ids));
    }
}
