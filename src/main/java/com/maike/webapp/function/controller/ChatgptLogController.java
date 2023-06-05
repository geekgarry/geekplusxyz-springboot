package com.maike.webapp.function.controller;

import com.maike.common.annotation.Log;
import com.maike.common.core.controller.BaseController;
import com.maike.common.result.AjaxResult;
import com.maike.common.core.page.PageDataInfo;
import com.maike.common.enums.BusinessType;
import com.maike.webapp.function.domain.ChatgptLog;
import com.maike.webapp.function.service.IChatgptLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Chatgpt聊天记录日志
Controller
 *
 * @author 佚名
 * @date 2023-02-25
 */
@RestController
@RequestMapping("/geekplus/chatgptlog")
public class ChatgptLogController extends BaseController
{
    @Autowired
    private IChatgptLogService chatgptLogService;

    /**
     * 查询Chatgpt聊天记录日志
列表
     */
    @PreAuthorize("@ss.hasPermi('function:chatgptlog:list')")
    @GetMapping("/list")
    public PageDataInfo list(ChatgptLog chatgptLog)
    {
        startPage();
        List<ChatgptLog> list = chatgptLogService.selectChatgptLogList(chatgptLog);
        return getDataTable(list);
    }

    /**
     * 导出Chatgpt聊天记录日志
列表
     */
//    @PreAuthorize("@ss.hasPermi('function:chatgptlog:export')")
//    @Log(title = "Chatgpt聊天记录日志", businessType = BusinessType.EXPORT)
//    @GetMapping("/export")
//    public AjaxResult export(ChatgptLog chatgptLog)
//    {
//        List<ChatgptLog> list = chatgptLogService.selectChatgptLogList(chatgptLog);
//        ExcelUtil<ChatgptLog> util = new ExcelUtil<ChatgptLog>(ChatgptLog.class);
//        return util.exportExcel(list, "log");
//    }

    /**
     * 获取Chatgpt聊天记录日志
详细信息
     */
    @PreAuthorize("@ss.hasPermi('function:chatgptlog:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(chatgptLogService.selectChatgptLogById(id));
    }

    /**
     * 新增Chatgpt聊天记录日志

     */
    @PreAuthorize("@ss.hasPermi('function:chatgptlog:add')")
    @Log(title = "Chatgpt聊天记录日志", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ChatgptLog chatgptLog)
    {
        return toAjax(chatgptLogService.insertChatgptLog(chatgptLog));
    }

    /**
     * 修改Chatgpt聊天记录日志

     */
    @PreAuthorize("@ss.hasPermi('function:chatgptlog:edit')")
    @Log(title = "Chatgpt聊天记录日志", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ChatgptLog chatgptLog)
    {
        return toAjax(chatgptLogService.updateChatgptLog(chatgptLog));
    }

    /**
     * 删除Chatgpt聊天记录日志

     */
    @PreAuthorize("@ss.hasPermi('function:chatgptlog:remove')")
    @Log(title = "Chatgpt聊天记录日志", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(chatgptLogService.deleteChatgptLogByIds(ids));
    }
}
