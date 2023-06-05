package com.maike.webapp.function.controller;

import com.maike.common.annotation.Log;
import com.maike.common.config.MaikeConfig;
import com.maike.common.constant.Constants;
import com.maike.common.core.controller.BaseController;
import com.maike.common.result.AjaxResult;
import com.maike.common.core.page.PageDataInfo;
import com.maike.common.enums.BusinessType;
import com.maike.common.utils.time.DateUtils;
import com.maike.common.utils.file.FileUploadUtils;
import com.maike.common.utils.file.FileUtils;
import com.maike.common.utils.uuid.IdUtils;
import com.maike.framework.config.ServerConfig;
import com.maike.webapp.function.domain.GpCarousel;
import com.maike.webapp.function.service.IGpCarouselService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 首页跑马灯轮播图Controller
 *
 * @author 佚名
 * @date 2023-03-12
 */
@Slf4j
@RestController
@RequestMapping("/geekplus/carousel")
public class GpCarouselController extends BaseController
{
    @Autowired
    private IGpCarouselService gpCarouselService;
    @Resource
    private ServerConfig serverConfig;

    /**
     * 查询首页跑马灯轮播图列表
     */
    @PreAuthorize("@ss.hasPermi('function:carousel:list')")
    @GetMapping("/list")
    public PageDataInfo list(GpCarousel gpCarousel)
    {
        startPage();
        List<GpCarousel> list = gpCarouselService.selectGpCarouselList(gpCarousel);
        return getDataTable(list);
    }

    /**
     * 导出首页跑马灯轮播图列表
     */
//    @PreAuthorize("@ss.hasPermi('function:carousel:export')")
//    @Log(title = "首页跑马灯轮播图", businessType = BusinessType.EXPORT)
//    @GetMapping("/export")
//    public AjaxResult export(GpCarousel gpCarousel)
//    {
//        List<GpCarousel> list = gpCarouselService.selectGpCarouselList(gpCarousel);
//        ExcelUtil<GpCarousel> util = new ExcelUtil<GpCarousel>(GpCarousel.class);
//        return util.exportExcel(list, "carousel");
//    }

    /**
     * 获取首页跑马灯轮播图详细信息
     */
    @PreAuthorize("@ss.hasPermi('function:carousel:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(gpCarouselService.selectGpCarouselById(id));
    }

    /**
     * 新增首页跑马灯轮播图
     */
    @PreAuthorize("@ss.hasPermi('function:carousel:add')")
    @Log(title = "首页跑马灯轮播图", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GpCarousel gpCarousel)
    {
        return toAjax(gpCarouselService.insertGpCarousel(gpCarousel));
    }

    /**
     * 修改首页跑马灯轮播图
     */
    @PreAuthorize("@ss.hasPermi('function:carousel:edit')")
    @Log(title = "首页跑马灯轮播图", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GpCarousel gpCarousel)
    {
        return toAjax(gpCarouselService.updateGpCarousel(gpCarousel));
    }

    /**
     * 删除首页跑马灯轮播图
     */
    @PreAuthorize("@ss.hasPermi('function:carousel:remove')")
    @Log(title = "首页跑马灯轮播图", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(gpCarouselService.deleteGpCarouselByIds(ids));
    }

    /**
     * 通用上传请求
     */
    @PostMapping("/uploadCarousel")
    public AjaxResult uploadFile( MultipartFile file) throws Exception
    {
        try
        {
            // 上传文件路径
            //String filePath = MaikeConfig.getUploadPath();
            String uploadDir=MaikeConfig.getFilePath()+"/carousel";
            // 上传并获取文件名称
            String fileName = file.getOriginalFilename();
            String extension = FileUploadUtils.getExtension(file);
            fileName = DateUtils.dateTime() + IdUtils.fastUUID() + "." + extension;

            // 上传并返回新文件名称
            //String fileName = FileUploadUtils.upload(filePath, file);
            File desc = new File(uploadDir + File.separator + fileName);
            file.transferTo(desc);
            //String pathFileName = getPathFileName(baseDir, fileName);
            String resultFileName= Constants.RESOURCE_PREFIX+"/carousel/"+fileName;
            String url = serverConfig.getUrl() + resultFileName;
            log.info("用户请求URL信息："+serverConfig.getUrl());
            AjaxResult ajax = AjaxResult.success();
            ajax.put("fileName", fileName);
            ajax.put("url", url);
            return ajax;
        }
        catch (Exception e)
        {
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 查询文件里的所有图片，读取某个文件夹下的所有文件
     */
    @PreAuthorize("@ss.hasPermi('function:carousel:list')")
    @Log(title = "首页跑马灯轮播图", businessType = BusinessType.DELETE)
    @GetMapping("/getImageList")
    public AjaxResult listFileImage()
    {
        try{
            List<String> listImage= FileUtils.readFileImage(MaikeConfig.getFilePath(),File.separator +"carousel");
            return AjaxResult.success(listImage);
        }catch(IOException e){
            return AjaxResult.success(e.getMessage());
        }
    }

    /**
     * 查询文件里的所有图片，删除某个图片文件
     */
    @PreAuthorize("@ss.hasPermi('function:carousel:remove')")
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
     * 去掉指定字符串的开头的指定字符
     * @param stream 原始字符串
     * @param trim 要删除的字符串
     * @return
     */
    public static String StringStartTrim(String stream, String trim) {
        // null或者空字符串的时候不处理
        if (stream == null || stream.length() == 0 || trim == null || trim.length() == 0) {
            return stream;
        }
        // 要删除的字符串结束位置
        int end;
        // 正规表达式
        String regPattern = "[" + trim + "]*+";
        Pattern pattern = Pattern.compile(regPattern, Pattern.CASE_INSENSITIVE);
        // 去掉原始字符串开头位置的指定字符
        Matcher matcher = pattern.matcher(stream);
        if (matcher.lookingAt()) {
            end = matcher.end();
            stream = stream.substring(end);
        }
        // 返回处理后的字符串
        return stream;
    }

}
