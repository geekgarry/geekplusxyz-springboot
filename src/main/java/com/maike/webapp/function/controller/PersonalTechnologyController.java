package com.maike.webapp.function.controller;

import com.maike.common.annotation.Log;
import com.maike.common.core.controller.BaseController;
import com.maike.common.result.AjaxResult;
import com.maike.common.core.page.PageDataInfo;
import com.maike.common.enums.BusinessType;
import com.maike.webapp.function.domain.PersonalTechnology;
import com.maike.webapp.function.service.IPersonalTechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 【请填写功能名称】Controller
 *
 * @author 佚名
 * @date 2021-01-08
 */
@RestController
@RequestMapping("/function/technology")
public class PersonalTechnologyController extends BaseController
{
    @Autowired
    private IPersonalTechnologyService personalTechnologyService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('function:technology:list')")
    @GetMapping("/list")
    public PageDataInfo list(PersonalTechnology personalTechnology)
    {
        startPage();
        List<PersonalTechnology> list = personalTechnologyService.selectPersonalTechnologyList(personalTechnology);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
//    @PreAuthorize("@ss.hasPermi('function:technology:export')")
//    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
//    @GetMapping("/export")
//    public AjaxResult export(PersonalTechnology personalTechnology)
//    {
//        List<PersonalTechnology> list = personalTechnologyService.selectPersonalTechnologyList(personalTechnology);
//        ExcelUtil<PersonalTechnology> util = new ExcelUtil<PersonalTechnology>(PersonalTechnology.class);
//        return util.exportExcel(list, "technology");
//    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('function:technology:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(personalTechnologyService.selectPersonalTechnologyById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('function:technology:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PersonalTechnology personalTechnology)
    {
        return toAjax(personalTechnologyService.insertPersonalTechnology(personalTechnology));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('function:technology:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PersonalTechnology personalTechnology)
    {
        return toAjax(personalTechnologyService.updatePersonalTechnology(personalTechnology));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('function:technology:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(personalTechnologyService.deletePersonalTechnologyByIds(ids));
    }
}
