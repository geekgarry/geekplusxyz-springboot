package com.maike.webapp.function.controller;

import com.maike.common.annotation.Log;
import com.maike.common.core.controller.BaseController;
import com.maike.common.result.AjaxResult;
//import com.maike.common.core.domain.model.LoginUser;
import com.maike.common.core.page.PageDataInfo;
import com.maike.common.enums.BusinessType;
import com.maike.common.utils.ServletUtils;
//import com.maike.framework.web.service.TokenService;
import com.maike.webapp.function.domain.PersonalResume;
import com.maike.webapp.function.service.IPersonalResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * 【请填写功能名称】Controller
 *
 * @author 佚名
 * @date 2021-01-08
 */
@RestController
@RequestMapping("/function/resume")
public class PersonalResumeController extends BaseController
{
    @Autowired
    private IPersonalResumeService personalResumeService;
//    @Resource
//    private TokenService tokenService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('function:resume:list')")
    @GetMapping("/list")
    public PageDataInfo list(PersonalResume personalResume)
    {
        startPage();
        List<PersonalResume> list = personalResumeService.selectPersonalResumeList(personalResume);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
//    @PreAuthorize("@ss.hasPermi('function:resume:export')")
//    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
//    @GetMapping("/export")
//    public AjaxResult export(PersonalResume personalResume)
//    {
//        List<PersonalResume> list = personalResumeService.selectPersonalResumeList(personalResume);
//        ExcelUtil<PersonalResume> util = new ExcelUtil<PersonalResume>(PersonalResume.class);
//        return util.exportExcel(list, "resume");
//    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('function:resume:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(personalResumeService.selectPersonalResumeById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('function:resume:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PersonalResume personalResume)
    {
        return toAjax(personalResumeService.insertPersonalResume(personalResume));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('function:resume:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PersonalResume personalResume)
    {
        return toAjax(personalResumeService.updatePersonalResume(personalResume));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('function:resume:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(personalResumeService.deletePersonalResumeByIds(ids));
    }

    @GetMapping("/getPersonalResumeInfo")
    public AjaxResult getPersonalResumeInfoByResumeId(Long resumeId){
        return AjaxResult.success(personalResumeService.getPersonalResumeInfo(resumeId));
    }
    /**
     * 获取导入模板
     * @return
     */
//    @GetMapping("/importTemplate")
//    public AjaxResult importTemplate(){
//        ExcelUtil<PersonalResume> excelUtil=new ExcelUtil<>(PersonalResume.class);
//        return excelUtil.importTemplateExcel("简历信息");
//    }

//    @Log(title = "出租房管理", businessType = BusinessType.IMPORT)
//    @PreAuthorize("@ss.hasPermi('function:resume:import')")
//    @PostMapping("/importData")
//    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
//        ExcelUtil<PersonalResume> util = new ExcelUtil<>(PersonalResume.class);
//        List<PersonalResume> fireCompanies = util.importExcel(file.getInputStream());
//        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
//        String message = personalResumeService.importPersonalResume(fireCompanies, updateSupport, loginUser);
//        return AjaxResult.success(message);
//    }
}
