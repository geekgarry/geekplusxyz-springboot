package com.maike.webapp.function.controller;

import com.maike.common.annotation.Log;
import com.maike.common.core.controller.BaseController;
import com.maike.common.result.Result;
import com.maike.common.core.page.PageDataInfo;
import com.maike.common.enums.BusinessType;
import com.maike.webapp.function.domain.ProjectExperience;
import com.maike.webapp.function.service.IProjectExperienceService;
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
@RequestMapping("/function/projectexperience")
public class ProjectExperienceController extends BaseController
{
    @Autowired
    private IProjectExperienceService projectExperienceService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('function:experience:list')")
    @GetMapping("/list")
    public PageDataInfo list(ProjectExperience projectExperience)
    {
        startPage();
        List<ProjectExperience> list = projectExperienceService.selectProjectExperienceList(projectExperience);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
//    @PreAuthorize("@ss.hasPermi('function:experience:export')")
//    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
//    @GetMapping("/export")
//    public AjaxResult export(ProjectExperience projectExperience)
//    {
//        List<ProjectExperience> list = projectExperienceService.selectProjectExperienceList(projectExperience);
//        ExcelUtil<ProjectExperience> util = new ExcelUtil<ProjectExperience>(ProjectExperience.class);
//        return util.exportExcel(list, "experience");
//    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('function:experience:query')")
    @GetMapping(value = "/{id}")
    public Result getInfo(@PathVariable("id") Long id)
    {
        return Result.success(projectExperienceService.selectProjectExperienceById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('function:experience:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public Result add(@RequestBody ProjectExperience projectExperience)
    {
        return toAjax(projectExperienceService.insertProjectExperience(projectExperience));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('function:experience:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public Result edit(@RequestBody ProjectExperience projectExperience)
    {
        return toAjax(projectExperienceService.updateProjectExperience(projectExperience));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('function:experience:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public Result remove(@PathVariable Long[] ids)
    {
        return toAjax(projectExperienceService.deleteProjectExperienceByIds(ids));
    }
}
