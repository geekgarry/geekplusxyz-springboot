package com.maike.webapp.function.controller;

import com.maike.common.annotation.Log;
import com.maike.common.core.controller.BaseController;
import com.maike.common.result.Result;
import com.maike.common.core.page.PageDataInfo;
import com.maike.common.enums.BusinessType;
import com.maike.webapp.function.domain.GpArticleMapTag;
import com.maike.webapp.function.domain.GpArticleTags;
import com.maike.webapp.function.service.IGpArticleMapTagService;
import com.maike.webapp.function.service.IGpArticleTagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 文章标签Controller
 *
 * @author 佚名
 * @date 2023-03-12
 */
@RestController
@RequestMapping("/geekplus/articletags")
public class GpArticleTagsController extends BaseController
{
    @Autowired
    private IGpArticleTagsService gpArticleTagsService;

    @Resource
    private IGpArticleMapTagService gpArticleMapTagService;

    /**
     * 查询文章标签列表
     */
    @PreAuthorize("@ss.hasPermi('function:tags:list')")
    @GetMapping("/list")
    public PageDataInfo list(GpArticleTags gpArticleTags)
    {
        startPage();
        List<GpArticleTags> list = gpArticleTagsService.selectGpArticleTagsList(gpArticleTags);
        return getDataTable(list);
    }

    /**
     * 导出文章标签列表
     */
//    @PreAuthorize("@ss.hasPermi('function:tags:export')")
//    @Log(title = "文章标签", businessType = BusinessType.EXPORT)
//    @GetMapping("/export")
//    public AjaxResult export(GpArticleTags gpArticleTags)
//    {
//        List<GpArticleTags> list = gpArticleTagsService.selectGpArticleTagsList(gpArticleTags);
//        ExcelUtil<GpArticleTags> util = new ExcelUtil<GpArticleTags>(GpArticleTags.class);
//        return util.exportExcel(list, "tags");
//    }

    /**
     * 获取文章标签详细信息
     */
    @PreAuthorize("@ss.hasPermi('function:tags:query')")
    @GetMapping(value = "/{id}")
    public Result getInfo(@PathVariable("id") Long id)
    {
        return Result.success(gpArticleTagsService.selectGpArticleTagsById(id));
    }

    /**
     * 新增文章标签
     */
    @PreAuthorize("@ss.hasPermi('function:tags:add')")
    @Log(title = "文章标签", businessType = BusinessType.INSERT)
    @PostMapping
    public Result add(@RequestBody GpArticleTags gpArticleTags)
    {
        return toAjax(gpArticleTagsService.insertGpArticleTags(gpArticleTags));
    }

    /**
     * 修改文章标签
     */
    @PreAuthorize("@ss.hasPermi('function:tags:edit')")
    @Log(title = "文章标签", businessType = BusinessType.UPDATE)
    @PutMapping
    public Result edit(@RequestBody GpArticleTags gpArticleTags)
    {
        return toAjax(gpArticleTagsService.updateGpArticleTags(gpArticleTags));
    }

    /**
     * 删除文章标签
     */
    @PreAuthorize("@ss.hasPermi('function:tags:remove')")
    @Log(title = "文章标签", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public Result remove(@PathVariable Long[] ids)
    {
        return toAjax(gpArticleTagsService.deleteGpArticleTagsByIds(ids));
    }

    /**
      * @Author geekplus
      * @Description //通过文章ID查询所属标签
      * @Param
      * @Throws
      * @Return {@link }
      */
    @GetMapping("/getTagByArticleId")
    public Result getTagByArticleId(String articleId){
        List<GpArticleTags> list=gpArticleTagsService.selectTagByArticleId(articleId);
        return Result.success(list);
    }

    /**
      * @Author geekplus
      * @Description //插入文章的标签,在写文章后提交的时候插入
      * @Param
      * @Throws
      * @Return {@link }
      */
    @PostMapping("/insertGpArticleMapTag")
    public Result insertGpArticleMapTag(@RequestBody Map<String,Object> map){
//        Map<String,Long> tagMap=new HashMap();
//        tagMap.put("articleId",Long.parseLong(map.get("articleId").toString()));
//        tagMap.put("articleTag",Long.parseLong(map.get("articleTag").toString()));
//        System.out.println("显示传输的数据："+tagMap.get("articleId")+"标签："+tagMap.get("articleTag"));
        List<GpArticleMapTag> listMapTag=gpArticleTagsService.selectGpArticleMapTagList(map);
        //System.out.println(listMapTag);
        if(listMapTag.isEmpty()){
            return toAjax(gpArticleTagsService.insertGpArticleMapTag(map));
        }else{
            return Result.error();
        }
    }

    /**
      * @Author geekplus
      * @Description //删除文章标签映射表，通过文章ID和标签ID一起判断删除
      * @Param
      * @Throws
      * @Return {@link }
      */
    @GetMapping("/deleteGpArticleMapTag")
    public Result deleteGpArticleMapTagByIdTag(Map<String,Object> map){
        return toAjax(gpArticleTagsService.deleteGpArticleMapTagByIdTag(map));
    }
}
