package com.maike.webapp.function.controller;

import com.maike.common.annotation.Log;
import com.maike.common.config.MaikeConfig;
import com.maike.common.constant.Constants;
import com.maike.common.core.controller.BaseController;
import com.maike.common.core.page.PageDataInfo;
import com.maike.common.result.AjaxResult;
import com.maike.common.enums.BusinessType;
import com.maike.common.utils.time.DateUtils;
import com.maike.common.utils.file.FileUploadUtils;
import com.maike.common.utils.file.FileUtils;
import com.maike.common.utils.uuid.IdUtils;
import com.maike.framework.config.ServerConfig;
import com.maike.webapp.function.domain.GpArticleTags;
import com.maike.webapp.function.domain.GpArticles;
import com.maike.webapp.function.service.IGpArticleTagsService;
import com.maike.webapp.function.service.IGpArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.jvm.hotspot.debugger.Page;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文章Controller
 *
 * @author 佚名
 * @date 2023-03-12
 */
@RestController
@RequestMapping("/geekplus/articles")
public class GpArticlesController extends BaseController
{
    @Autowired
    private IGpArticlesService gpArticlesService;
    @Resource
    IGpArticleTagsService gpArticleTagsService;
    @Resource
    private ServerConfig serverConfig;

    /**
     * 查询文章列表
     */
    @PreAuthorize("@ss.hasPermi('function:articles:list')")
    @GetMapping("/list")
    public PageDataInfo list(GpArticles gpArticles)
    {
        startPage();
        List<GpArticles> list = gpArticlesService.selectGpArticlesList(gpArticles);
        return getDataTable(list);
    }

    /**
     * 导出文章列表
     */
//    @PreAuthorize("@ss.hasPermi('function:articles:export')")
//    @Log(title = "文章", businessType = BusinessType.EXPORT)
//    @GetMapping("/export")
//    public AjaxResult export(GpArticles gpArticles)
//    {
//        List<GpArticles> list = gpArticlesService.selectGpArticlesList(gpArticles);
//        ExcelUtil<GpArticles> util = new ExcelUtil<GpArticles>(GpArticles.class);
//        return util.exportExcel(list, "articles");
//    }

    /**
     * 获取文章详细信息
     */
    @PreAuthorize("@ss.hasPermi('function:articles:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(gpArticlesService.selectGpArticlesById(id));
    }

    /**
     * 新增文章
     */
    @PreAuthorize("@ss.hasPermi('function:articles:add')")
    @Log(title = "文章", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GpArticles gpArticles)
    {
        AjaxResult ajaxResult=toAjax(gpArticlesService.insertGpArticles(gpArticles));
        //System.out.println("controller返回主键ID："+gpArticles.getId());
        ajaxResult.put("articleId",gpArticles.getId());
        return ajaxResult;
    }

    /**
     * 修改文章
     */
    @PreAuthorize("@ss.hasPermi('function:articles:edit')")
    @Log(title = "文章", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GpArticles gpArticles)
    {
        return toAjax(gpArticlesService.updateGpArticles(gpArticles));
    }

    /**
     * 删除文章
     */
    @PreAuthorize("@ss.hasPermi('function:articles:remove')")
    @Log(title = "文章", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        int rows=gpArticlesService.deleteGpArticlesByIds(ids);
        List<GpArticleTags> list=new ArrayList<>();
        if(rows>0){
            List<Map> mapTag=new ArrayList<>();
            for (Long id:ids) {
                list = gpArticleTagsService.selectTagByArticleId(String.valueOf(id));
                if(list.size()>0) {
                    for (GpArticleTags articleTag : list) {
                        Map map = new HashMap();
                        map.put("aticleId", id);
                        map.put("articleTag", articleTag.getId());
                        gpArticleTagsService.deleteGpArticleMapTagByIdTag(map);
                    }
                }
                //map.put("articleId", id)
            }
            return AjaxResult.success();
        }else{
            return AjaxResult.error();
        }
        //return toAjax(rows);
    }

    /**
     * 通用上传文件请求
     */
    @PostMapping("/uploadFile")
    public AjaxResult uploadFile(@RequestPart("file") MultipartFile file) throws Exception
    {
//        if(!checkFormats(file.getOriginalFilename())){
//            return AjaxResult.error("上传图片格式不是png,jpg或jpeg！");
//        }
        try
        {
            // 上传文件路径,加上以日期为路径的一个目录
            //String filePath = MaikeConfig.getUploadPath();
            String realFilePath="/article/"+ DateUtils.dateTime();
            String uploadDir= MaikeConfig.getUploadPath()+realFilePath;
            // 上传并获取文件名称
            String fileName = "";//file.getOriginalFilename();
            String extension = FileUploadUtils.getExtension(file);
            //String uuidFileName = UUID.randomUUID().toString() + ".png";
            //目标文件
            //File dest = new File(uploadDir + "head_img" ,uuidFileName);
            //保存文件
            //file.transferTo(dest);
            fileName = IdUtils.fastUUID() + "." + extension;

            // 上传并返回新文件名称
            //String fileName = FileUploadUtils.upload(filePath, file);
            //File desc = new File(uploadDir + File.separator + fileName);
            File desc =FileUtils.getExistFileCategory(uploadDir + File.separator + fileName);
            file.transferTo(desc);
            //String pathFileName = getPathFileName(baseDir, fileName);
            String resultFileName= Constants.RESOURCE_PREFIX+realFilePath+File.separator+fileName;
            String url = serverConfig.getUrl() + resultFileName;
            //log.info("用户请求URL信息："+serverConfig.getUrl());
            AjaxResult ajax = AjaxResult.success();
            ajax.put("fileName", fileName);
            ajax.put("url", resultFileName);
            return ajax;
        }
        catch (Exception e)
        {
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 查询文件里的所有图片，批量删除某个图片文件
     */
    @PreAuthorize("@ss.hasPermi('function:articles:remove')")
    @Log(title = "删除文件夹里的图片文件", businessType = BusinessType.DELETE)
    @PostMapping("/deleteFileList")
    public AjaxResult deleteFile(@RequestBody List<Map> filePaths)
    {
        int length=filePaths.size();
        for (int i = 0; i < filePaths.size(); i++) {
            String filePath=filePaths.get(i).get("filePath").toString();
            String profile=Constants.RESOURCE_PREFIX;//profile
            String allFilePath=MaikeConfig.getFilePath()+filePath.replace(profile,"");
            int ds=FileUtils.deleteFileCategory(allFilePath);
            length-=ds;
        }
        if(length==0){
            return AjaxResult.success("删除文件成功！");
        }else{
            return AjaxResult.success("删除文件失败！");
        }
    }

    /**
     * 查询文件里的所有图片，删除某个图片文件
     */
    @PreAuthorize("@ss.hasPermi('function:articles:remove')")
    @Log(title = "删除文件夹里的图片文件", businessType = BusinessType.DELETE)
    @GetMapping("/deleteFile")
    public AjaxResult deleteFile(String filePath)
    {
        String profile=Constants.RESOURCE_PREFIX;//profile
        String allFilePath=MaikeConfig.getFilePath()+filePath.replace(profile,"");
        boolean flag=FileUtils.deleteFile(allFilePath);
        if(flag==true){
            return AjaxResult.success("删除文件成功！");
        }else{
            return AjaxResult.success("删除文件失败！");
        }
    }

    /**
      * @Author geekplus
      * @Description //读取文件夹下的所有文件和文件夹
      * @Param
      * @Throws
      * @Return {@link }
      */
    @PreAuthorize("@ss.hasPermi('function:articles:list')")
    @GetMapping("/readFileList")
    public AjaxResult readFileList(String folder) throws IOException {
        if(folder==null) {
            folder = "article";
        }
        List<Map> mapList=FileUtils.readFileList(MaikeConfig.getFilePath()+File.separator +folder);
        return AjaxResult.success(mapList);
    }

    /**
     * 查询文件里的所有图片，读取某个文件夹下的所有文件
     */
    @PreAuthorize("@ss.hasPermi('function:articles:list')")
    @GetMapping("/getImageList")
    public AjaxResult listFileImage(String fileFolder)
    {
        try{
            List<String> listImage= FileUtils.readFileImage(MaikeConfig.getFilePath(), File.separator + fileFolder);
            return AjaxResult.success(listImage);
        }catch(IOException e){
            return AjaxResult.success(e.getMessage());
        }
    }
}
