/**
 * author     : geekplus
 * email      : geekcjj@gmail.com
 * date       : 3/12/23 01:54
 * description: 做什么的？
 */
package com.maike.webapp.function.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maike.common.annotation.Log;
import com.maike.common.config.MaikeConfig;
import com.maike.common.constant.Constants;
import com.maike.common.core.controller.BaseController;
import com.maike.common.result.Result;
import com.maike.common.core.page.PageDataInfo;
import com.maike.common.enums.BusinessType;
import com.maike.common.utils.time.DateUtils;
import com.maike.common.utils.file.FileUploadUtils;
import com.maike.common.utils.file.FileUtils;
import com.maike.common.utils.uuid.IdUtils;
import com.maike.framework.config.ServerConfig;
import com.maike.webapp.function.domain.*;
import com.maike.webapp.function.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@RestController
@RequestMapping("/geekplusapp")
public class GeekPlusAppController extends BaseController {
    //设置上传文件限制格式，列表中为可以上传的类型
    List<String> supportFileFormats =new ArrayList<>(Arrays.asList("doc,docx,xls,xlsx,ppt,pptx,pdf,jpg,jpeg,png,gif,JPG,JPEG,PNG,GIF,bmp,BMP,txt,wmv,mp4".split(",")));

    @Resource
    private ChatGPTService chatGPTService;
    @Resource
    private IGpCarouselService gpCarouselService;
    @Resource
    private IGpFriendlyLinkService gpFriendlyLinkService;
    @Resource
    private IGpUserCommentService gpUserCommentService;
    @Resource
    private IGpArticleCommentService gpArticleCommentService;
    @Resource
    private IGpArticlesService gpArticlesService;
    @Resource
    private IGpArticleTagsService gpArticleTagsService;
    @Resource
    private IGpArticleMapTagService gpArticleMapTagService;
    @Resource
    private IGpArticleCategoryService gpArticleCategoryService;
    @Resource
    private IGpAboutWebService gpAboutWebService;
    @Resource
    private IGpNoticeService gpNoticeService;
    @Resource
    private ServerConfig serverConfig;

    /**
     * 查询首页跑马灯轮播图列表
     */
    //@PreAuthorize("@ss.hasPermi('function:carousel:list')")
    @GetMapping("/getCarousel")
    public Result getCarouselList()
    {
        List<GpCarousel> list = gpCarouselService.selectGpCarouselListImage();
        return Result.success(list);
    }

    /**
     * @Author geekplus
     * @Description //TODO
     * @Param
     * @Throws
     * @Return {@link }
     */
    @GetMapping("/displayFriendlyLink")
    public Result displayFriendlyLink(){
        List<GpFriendlyLink> list=gpFriendlyLinkService.displayGpFriendlyLink();
        return Result.success(list);
    }

    /**
     * @Author geekplus
     * @Description //用户申请友情链接
     * @Param
     * @Throws
     * @Return {@link }
     */
    @PostMapping("/userAppFriendlyLink")
    public Result userAppFriendlyLink(@RequestBody GpFriendlyLink gpFriendlyLink){
        int size=gpFriendlyLinkService.insertGpFriendlyLink(gpFriendlyLink);
        if(size>0){
            return Result.success();
        }else{
            return Result.error();
        }
    }

    /**
      * @Author geekplus
      * @Description //我的网站用户评论留言
      * @Param
      * @Throws
      * @Return {@link }
      */
    @PostMapping("/userCommentMessage")
    public Result insertUserComment(@RequestBody GpUserComment gpUserComment){
        int size=gpUserCommentService.insertUserComment(gpUserComment);
        if(size>0){
            return Result.success();
        }else {
            return Result.error();
        }
    }

    /**
     * @Author geekplus
     * @Description //我的网站用户文章评论留言
     * @Param
     * @Throws
     * @Return {@link }
     */
    @PostMapping("/articleCommentMessage")
    public Result insertArticleComment(@RequestBody GpUserComment gpUserComment){
        int size=gpArticleCommentService.insertArticleComment(gpUserComment);
        if(size>0){
            return Result.success();
        }else {
            return Result.error();
        }
    }

    /**
     * @Author geekplus
     * @Description //获取用户的留言信息
     * @Param
     * @Throws
     * @Return {@link }
     */
    @GetMapping("/getAllUserComment")
    public PageDataInfo getAllUserComment(GpUserComment gpUserComment){
        startPage();
        List<GpUserComment> list=gpUserCommentService.getUserComment(gpUserComment);
        return getDataTable(list);
    }

    /**
     * @Author geekplus
     * @Description //获取用户的留言信息
     * @Param
     * @Throws
     * @Return {@link }
     */
    @GetMapping("/getAllArticleComment")
    public PageDataInfo getAllArticleComment(GpUserComment gpUserComment){
        startPage();
        List<GpUserComment> list=gpArticleCommentService.getArticleComment(gpUserComment);
        return getDataTable(list);
    }

//    public List<GpUserComment> getUserCommentListToList(GpUserComment gpUserComment){
//        List<GpUserComment> allList=new ArrayList<>();
//        List<GpUserComment> list=gpUserCommentService.getUserComment(gpUserComment);
//        for(GpUserComment userComment : list){
//            if(userComment.getReplyUserComment()!=null||userComment.getReplyUserComment().size()!=0){
//                GpUserComment gpUserComment1=new GpUserComment();
//                gpUserComment1.setParentId(userComment.getId());
//                getUserCommentListToList(gpUserComment1);
//                //allList.add(gpUserComment);
//            }
//            allList.add(userComment);
//        }
//        return allList;
//    }

    /**
     * @Author geekplus
     * @Description //获取用户的留言评论数量
     * @Param
     * @Throws
     * @Return {@link }
     */
    @GetMapping("/getUserCommentCount")
    public Result getUserCommentCount(){
        int count=gpUserCommentService.getUserCommentCount();
        return Result.success(count);
    }

    /**
     * @Author geekplus
     * @Description //获取最新的十条用户的文章留言评论
     * @Param
     * @Throws
     * @Return {@link }
     */
    @GetMapping("/getLatestArticleUserComment")
    public Result getLatestArticleCommentCount(){
        List<GpUserComment> list=gpArticleCommentService.getLatestArticleComment();
        return Result.success(list);
    }

    /**
     * @Author geekplus
     * @Description //获取热门的六条用户的留言评论
     * @Param
     * @Throws
     * @Return {@link }
     */
    @GetMapping("/getHotWebUserComment")
    public Result getHotUserCommentCount(){
        List<GpUserComment> list=gpUserCommentService.getHotWebUserComment();
        return Result.success(list);
    }

    /**
     * @Author geekplus
     * @Description //查询网站信息，比如标题，网站介绍，网站底部备案信息等
     * @Param
     * @Throws
     * @Return {@link }
     */
    @GetMapping(value="/getGpWebTitleInfo")
    public Result getGpWebTitleInfo(Integer id){
        GpAboutWeb webInfo=gpAboutWebService.selectGpWebInfo(id);
        return Result.success(webInfo);
    }

    /**
     * @Author geekplus
     * @Description //查询关于我的信息，我的个人介绍等
     * @Param
     * @Throws
     * @Return {@link }
     */
    @GetMapping("/getAboutMyGpWeb/{id}")
    public Result getAboutMyGpWeb(@PathVariable("id") Integer id){
        GpAboutWeb aboutWeb=gpAboutWebService.selectAboutGpWeb(id);
        return Result.success(aboutWeb);
    }

    /**
     * @Author geekplus
     * @Description //固定查询最新六条的不同目录文章
     * @Param
     * @Throws
     * @Return {@link }
     */
    @GetMapping("/getTenNewestArticle")
    public Result getSixNewestArticle(GpArticles gpArticles){
//        if(gpArticles.getIsDisplay()==null||"".equals(gpArticles.getIsDisplay())){
//            gpArticles.setIsDisplay("1");
//        }
        List<GpArticles> list=gpArticlesService.selectGpArticlesListByCategoryLimitTen(gpArticles);
        return Result.success(list);
    }

    /**
     * @Author geekplus
     * @Description //动态条件查询某目录前几条
     * @Param
     * @Throws
     * @Return {@link }
     */
    @GetMapping("/getArticlesListByCategoryLimit")
    public Result selectGpArticlesListByCategoryLimit(String pathName, Integer limitCount){
        List<GpArticles> list=gpArticlesService.selectGpArticlesListByCategoryLimit(pathName,limitCount);
        return Result.success(list);
    }

    /**
     * @Author geekplus
     * @Description //根据目录ID查询分页的文章,目录文章页面动态分页查询
     * @Param
     * @Throws
     * @Return {@link }
     */
    @GetMapping("/getGpArticlesListByCategory")
    public Result selectGpArticlesListByCategory(String pathName, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        //startPage();
        List<GpArticles> list=gpArticlesService.selectGpArticlesListByCategory(pathName);
        PageInfo pageInfo=new PageInfo(list);
        Result result = Result.success();
        result.put("rows",list);
        result.put("total",pageInfo.getTotal());
        return result;
    }

    /**
     * @Author geekplus
     * @Description //根据搜索关键字查询分页的文章,目录文章页面动态查询分页
     * @Param
     * @Throws
     * @Return {@link }
     */
    @GetMapping("/selectGpArticlesListByKeyWords")
    public Result selectGpArticlesListByKeyWords(String articleTitle, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        //startPage();
        List<GpArticles> list=gpArticlesService.selectGpArticlesListByKeyWords(articleTitle);
        PageInfo pageInfo=new PageInfo(list);
        Result result = Result.success();
        result.put("rows",list);
        result.put("total",pageInfo.getTotal());
        return result;
    }

    /**
     * @Author geekplus
     * @Description //查询四加一个大屏显示特别推荐的文章
     * @Param
     * @Throws
     * @Return {@link }
     */
    @GetMapping("/getFourPlusOneArticles")
    public Result getOneRecommendArticle(String firstPathName, String secondPathName){
        GpArticles list=gpArticlesService.selectOneArticleByCategory(firstPathName);
        List<GpArticles> fourList=gpArticlesService.selectFourArticleByCategory(secondPathName);
        Result ajax = Result.success();
        ajax.put("one", list);
        ajax.put("four", fourList);
        return ajax;
    }

/*************************下面还未定义*********************/
    /**
     * @Author geekplus
     * @Description //查询十条特别推荐的文章
     * @Param
     * @Throws
     * @Return {@link }
     */
    @GetMapping("/getTenRecommendArticle")
    public Result getTenRecommendArticle(GpArticles gpArticles){
        List<GpArticles> list=gpArticlesService.selectGpArticlesList(gpArticles);
        return Result.success(list);
    }

    /**
     * @Author geekplus
     * @Description //查询四个大屏显示特别推荐的文章
     * @Param
     * @Throws
     * @Return {@link }
     */
    @GetMapping("/getFourRecommendArticle")
    public Result getFourRecommendArticle(GpArticles gpArticles){
        List<GpArticles> list=gpArticlesService.selectGpArticlesList(gpArticles);
        return Result.success(list);
    }
/***********************************************/

    /**
     * 获取父目录子菜单循环递归目录菜单，sql子查询方式
     */
    //@Log(title = "文章类型目录", businessType = BusinessType.DELETE)
    @GetMapping("/listSubParentCategory")
    public Result listSubParentCategory()
    {
        return Result.success(gpArticleCategoryService.selectSubParentCategory());
    }

    /**
     * 获取所有子菜单
     */
    //@Log(title = "文章类型目录", businessType = BusinessType.DELETE)
    @GetMapping("/listSubCategory")
    public Result listSubCategory()
    {
        GpArticleCategory gpArticleCategory=new GpArticleCategory();
        gpArticleCategory.setMenuType("1");
        return Result.success(gpArticleCategoryService.selectArticleCategoryList(gpArticleCategory));
    }

    /**
     * @Author geekplus
     * @Description //查询各个标签的文章数量
     * @Param
     * @Throws
     * @Return {@link }
     */
    @GetMapping("/getTagArticleCount")
    public Result selectTagArticleCount(){
        return Result.success(gpArticleTagsService.selectTagArticleCount());
    }

    /**
     * @Author geekplus
     * @Description //根据标签的tagId查询每个标签的所有文章列表,带分页
     * @Param
     * @Throws
     * @Return {@link }
     */
    @GetMapping("/selectArticleListForTag")
    public Result selectTagDeArticle(String tagName, Long tagId, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<GpArticles> list=gpArticlesService.selectTagDeArticle(tagName,tagId);
        PageInfo pageInfo=new PageInfo(list);
        Result result = Result.success();
        result.put("rows",list);
        result.put("total",pageInfo.getTotal());
        return result;
    }

    /**
      * @Author geekplus
      * @Description //查询最新的一条通知
      * @Param
      * @Throws
      * @Return {@link }
      */
    @RequestMapping(value = "/getGpNoticeNewOne",method = {RequestMethod.POST, RequestMethod.GET})
    public Result selectGpNoticeNewOne(){
        return Result.success(gpNoticeService.selectGpNoticeNewOne());
    }

    /**
     * @Author geekplus
     * @Description //查询最新的五条通知
     * @Param
     * @Throws
     * @Return {@link }
     */
    @RequestMapping(value = "/getGpNoticeNewFive",method = {RequestMethod.POST, RequestMethod.GET})
    public Result selectGpNoticeNewFive(){
        return Result.success(gpNoticeService.selectGpNoticeNewFive());
    }

    /**
      * @Author geekplus
      * @Description //用户投稿文章
      * @Param
      * @Throws
      * @Return {@link }
      */
    @PostMapping("/userWriteGpArticles")
    public Result userWriteGpArticles(@RequestBody GpArticles gpArticles){
        int size=gpArticlesService.userWriteGpArticles(gpArticles);
        return size > 0 ? Result.success() : Result.error();
    }

    /**
      * @Author geekplus
      * @Description //用户端根据文章ID查看文章详情页面,设置文章是否显示is_display
      * @Param
      * @Throws
      * @Return {@link }
      */
    @PostMapping(value = "/getArticle")
    public Result getArticleDetail(@RequestBody HashMap<String,String> map)
    {
        String isDisplay=map.get("isDisplay");
        if("".equals(map.get("isDisplay"))||map.get("isDisplay")==null) {
            isDisplay="1";
        }
        Long id=Long.parseLong(map.get("id"));
        GpArticles gpArticles=gpArticlesService.selectGpArticlesByIdForUser(isDisplay,id);
        Result result = Result.success(gpArticles);
        result.put("prevRow",gpArticlesService.selectPrevGpArticle(null,id));
        result.put("nextRow",gpArticlesService.selectNextGpArticle(null,id));
        return result;
    }

    /**
     * @Author geekplus
     * @Description //用户端根据文章ID查看文章详情页面,设置文章是否显示is_display
     * @Param
     * @Throws
     * @Return {@link }
     */
    @GetMapping(value = "/getArticleIsDisplay/{id}")
    public Result getArticleDetailIsDisplay(@PathVariable("id") Long id)
    {
        //String isDisplay="1";
        return Result.success(gpArticlesService.selectGpArticlesByIdForWeb(id));
    }

    /**
      * @Author geekplus
      * @Description //提供前端博客用户查询文章列表,首页混合所有类型,分页查询功能
      * @Param
      * @Throws
      * @Return {@link }
      */
    @GetMapping(value = "/getArticleList")
    public PageDataInfo getArticleList(GpArticles gpArticles)
    {
//        GpArticles gpArticles=new GpArticles();
//        gpArticles.setArticleCategory(String.valueOf(categoryId));
        startPage();
        List<GpArticles> list=gpArticlesService.selectGpArticlesListForUser(gpArticles);
//        PageInfo pageInfo=new PageInfo(list);
//        Map map=new HashMap();
//        map.put("data",list);
//        map.put("total",pageInfo.getTotal());
//        map.put("code",200);
//        map.put("msg","成功查询数据！");
        return getDataTable(list);
    }

    /**
     * @Author geekplus
     * @Description //提供在写文章时查询所有标签
     * @Param
     * @Throws
     * @Return {@link }
     */
    @GetMapping(value = "/getArticleTagList")
    public Result getArticleTagList(GpArticleTags gpArticleTags)
    {
        return Result.success(gpArticleTagsService.selectGpArticleTagsList(gpArticleTags));
    }

    /**
     * @Author geekplus
     * @Description //在写文章时，需要插入文章的所属标签
     * @Param
     * @Throws
     * @Return {@link }
     */
    @PostMapping(value = "/insertArticleMapTag")
    public Result insertGpArticleMapTag(@RequestBody Map<String,Object> map)
    {
        return toAjax(gpArticleTagsService.insertGpArticleMapTag(map));
        //return AjaxResult.success(gpArticleTagsService.insertGpArticleMapTag(map));
    }

    /**
     * 通用上传文件请求
     */
    @PostMapping("/uploadFile")
    public Result uploadFile(@RequestPart("file") MultipartFile file) throws Exception
    {
//        if(!checkFormats(file.getOriginalFilename())){
//            return AjaxResult.error("上传图片格式不是png,jpg或jpeg！");
//        }
        try
        {
            // 上传文件路径,加上以日期为路径的一个目录
            //String filePath = MaikeConfig.getUploadPath();
            String realFilePath="/article/"+DateUtils.dateTime();
            String uploadDir= MaikeConfig.getFilePath()+realFilePath;
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
            String resultFileName= Constants.RESOURCE_PREFIX+realFilePath+"/"+fileName;
            String url = serverConfig.getUrl() + resultFileName;
            log.info("用户请求URL信息："+serverConfig.getUrl());
            Result ajax = Result.success();
            ajax.put("fileName", fileName);
            ajax.put("url", resultFileName);
            return ajax;
        }
        catch (Exception e)
        {
            return Result.error(e.getMessage());
        }
    }

    /**
     * 查询文件里的所有图片，读取某个文件夹下的所有文件
     */
    @Log(title = "文章内容相关图片", businessType = BusinessType.DELETE)
    @GetMapping("/getImageList")
    public Result listFileImage(String filePath)
    {
        try{
            List<String> listImage= FileUtils.readFileImage(MaikeConfig.getFilePath(),File.separator+filePath);
            return Result.success(listImage);
        }catch(IOException e){
            return Result.success(e.getMessage());
        }
    }

    /**
     * 查询文件里的所有图片，删除某个图片文件
     */
    @Log(title = "删除文件夹里的图片文件", businessType = BusinessType.DELETE)
    @PostMapping("/deleteFile")
    public Result deleteFile(@RequestBody List<Map> filePaths)
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
            return Result.success("删除文件成功！");
        }else{
            return Result.success("删除文件失败！");
        }
    }

    /**
      * @Author geekplus
      * @Description //用于用户端更新浏览量和点赞数
      * @Param
      * @Throws
      * @Return {@link }
      */
    @GetMapping("/updateArticleViewCount")
    public Result updateGpArticlesForUser(GpArticles gpArticles){
        return toAjax(gpArticlesService.updateGpArticlesForUser(gpArticles));
    }

    /**
      * @Author geekplus
      * @Description //查找当前文章的上一篇
      * @Param
      * @Throws
      * @Return {@link }
      */
    @GetMapping("/getCurrentPrevArticle")
    public Result getPrevArticleInfo(String pathName, Long articleId){
        return Result.success(gpArticlesService.selectPrevGpArticle(pathName,articleId));
    }

    /**
      * @Author geekplus
      * @Description //查找当前文章的下一篇
      * @Param
      * @Throws
      * @Return {@link }
      */
    @GetMapping("/getCurrentNextArticle")
    public Result getNextArticleInfo(String pathName, Long articleId){
        return Result.success(gpArticlesService.selectNextGpArticle(pathName,articleId));
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

    //文件类型校验方法
    private boolean checkFormats(String fileFullName){
        String suffix = fileFullName.substring(fileFullName.lastIndexOf(".") + 1).toLowerCase();
        return supportFileFormats.stream().anyMatch(suffix::contains);
    }

}
