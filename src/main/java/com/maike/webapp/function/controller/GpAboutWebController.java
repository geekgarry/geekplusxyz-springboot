package com.maike.webapp.function.controller;

import com.maike.common.annotation.Log;
import com.maike.common.core.controller.BaseController;
import com.maike.common.result.Result;
import com.maike.common.core.page.PageDataInfo;
import com.maike.common.enums.BusinessType;
import com.maike.webapp.function.domain.GpAboutWeb;
import com.maike.webapp.function.service.IGpAboutWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息Controller
 *
 * @author 佚名
 * @date 2023-03-15
 */
@RestController
@RequestMapping("/geekplus/webInfo")
public class GpAboutWebController extends BaseController
{
    @Autowired
    private IGpAboutWebService gpAboutWebService;

    /**
     * 查询关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息列表
     */
    @PreAuthorize("@ss.hasPermi('function:web:list')")
    @GetMapping("/list")
    public PageDataInfo list(GpAboutWeb gpAboutWeb)
    {
        startPage();
        List<GpAboutWeb> list = gpAboutWebService.selectGpAboutWebList(gpAboutWeb);
        return getDataTable(list);
    }

    /**
     * 导出关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息列表
     */
//    @PreAuthorize("@ss.hasPermi('function:web:export')")
//    @Log(title = "关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息", businessType = BusinessType.EXPORT)
//    @GetMapping("/export")
//    public AjaxResult export(GpAboutWeb gpAboutWeb)
//    {
//        List<GpAboutWeb> list = gpAboutWebService.selectGpAboutWebList(gpAboutWeb);
//        ExcelUtil<GpAboutWeb> util = new ExcelUtil<GpAboutWeb>(GpAboutWeb.class);
//        return util.exportExcel(list, "web");
//    }

    /**
     * 获取关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('function:web:query')")
    @GetMapping(value = "/{id}")
    public Result getInfo(@PathVariable("id") Integer id)
    {
        return Result.success(gpAboutWebService.selectGpAboutWebById(id));
    }

    /**
     * 新增关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息
     */
    @PreAuthorize("@ss.hasPermi('function:web:add')")
    @Log(title = "关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息", businessType = BusinessType.INSERT)
    @PostMapping
    public Result add(@RequestBody GpAboutWeb gpAboutWeb)
    {
        return toAjax(gpAboutWebService.insertGpAboutWeb(gpAboutWeb));
    }

    /**
     * 修改关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息
     */
    @PreAuthorize("@ss.hasPermi('function:web:edit')")
    @Log(title = "关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public Result edit(@RequestBody GpAboutWeb gpAboutWeb)
    {
        return toAjax(gpAboutWebService.updateGpAboutWeb(gpAboutWeb));
    }

    /**
     * 删除关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息
     */
    @PreAuthorize("@ss.hasPermi('function:web:remove')")
    @Log(title = "关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public Result remove(@PathVariable Integer[] ids)
    {
        return toAjax(gpAboutWebService.deleteGpAboutWebByIds(ids));
    }
}
