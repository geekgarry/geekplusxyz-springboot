package com.maike.webapp.function.controller;

import com.maike.common.annotation.Log;
import com.maike.common.core.controller.BaseController;
import com.maike.common.result.AjaxResult;
import com.maike.common.core.page.PageDataInfo;
import com.maike.common.enums.BusinessType;
import com.maike.webapp.function.domain.ResumeWorkExperience;
import com.maike.webapp.function.service.IResumeWorkExperienceService;
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
@RequestMapping("/function/workexperience")
public class ResumeWorkExperienceController extends BaseController
{
    @Autowired
    private IResumeWorkExperienceService resumeWorkExperienceService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('function:experience:list')")
    @GetMapping("/list")
    public PageDataInfo list(ResumeWorkExperience resumeWorkExperience)
    {
        startPage();
        List<ResumeWorkExperience> list = resumeWorkExperienceService.selectResumeWorkExperienceList(resumeWorkExperience);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
//    @PreAuthorize("@ss.hasPermi('function:experience:export')")
//    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
//    @GetMapping("/export")
//    public AjaxResult export(ResumeWorkExperience resumeWorkExperience)
//    {
//        List<ResumeWorkExperience> list = resumeWorkExperienceService.selectResumeWorkExperienceList(resumeWorkExperience);
//        ExcelUtil<ResumeWorkExperience> util = new ExcelUtil<ResumeWorkExperience>(ResumeWorkExperience.class);
//        return util.exportExcel(list, "experience");
//    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('function:experience:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(resumeWorkExperienceService.selectResumeWorkExperienceById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('function:experience:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ResumeWorkExperience resumeWorkExperience)
    {
        return toAjax(resumeWorkExperienceService.insertResumeWorkExperience(resumeWorkExperience));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('function:experience:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ResumeWorkExperience resumeWorkExperience)
    {
        return toAjax(resumeWorkExperienceService.updateResumeWorkExperience(resumeWorkExperience));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('function:experience:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(resumeWorkExperienceService.deleteResumeWorkExperienceByIds(ids));
    }
}
