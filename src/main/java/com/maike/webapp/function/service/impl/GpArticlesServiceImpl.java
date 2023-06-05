package com.maike.webapp.function.service.impl;

import com.maike.common.utils.time.DateUtils;
import com.maike.webapp.function.domain.GpArticles;
import com.maike.webapp.function.mapper.GpArticlesMapper;
import com.maike.webapp.function.service.IGpArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文章Service业务层处理
 *
 * @author 佚名
 * @date 2023-03-12
 */
@Service
public class GpArticlesServiceImpl implements IGpArticlesService
{
    @Autowired
    private GpArticlesMapper gpArticlesMapper;

    /**
     * 查询文章
     *
     * @param id 文章ID
     * @return 文章
     */
    @Override
    public GpArticles selectGpArticlesById(Long id)
    {
        return gpArticlesMapper.selectGpArticlesById(id);
    }

    /**
      * @Author geekplus
      * @Description //前端网站查询文章详情
      * @Param
      * @Throws
      * @Return {@link }
      */
    @Override
    public GpArticles selectGpArticlesByIdForUser(String isDisplay, Long id) {
        return gpArticlesMapper.selectGpArticlesByIdForUser(isDisplay,id);
    }

    /**
      * @Author geekplus
      * @Description //前端网站查询文章详情
      * @Param
      * @Throws
      * @Return {@link }
      */
    @Override
    public GpArticles selectGpArticlesByIdForWeb(Long id) {
        return gpArticlesMapper.selectGpArticlesByIdForWeb(id);
    }

    //固定查询每个目录的前六条
    @Override
    public List<GpArticles> selectGpArticlesListByCategoryLimitTen(GpArticles gpArticles) {
        return gpArticlesMapper.selectGpArticlesListByCategoryLimitTen(gpArticles);
    }
    //动态条件查询某目录前几条
    @Override
    public List<GpArticles> selectGpArticlesListByCategoryLimit(String pathName, Integer limitCount) {
        return gpArticlesMapper.selectGpArticlesListByCategoryLimit(pathName,limitCount);
    }

    //根据目录ID动态查询分页的文章
    @Override
    public List<GpArticles> selectGpArticlesListByCategory(String pathName) {
        return gpArticlesMapper.selectGpArticlesListByCategory(pathName);
    }

    @Override
    public List<GpArticles> selectGpArticlesListByKeyWords(String articleTitle) {
        return gpArticlesMapper.selectGpArticlesListByKeyWords(articleTitle);
    }

    //根据目录ID查询首页大屏的一篇文章
    @Override
    public GpArticles selectOneArticleByCategory(String pathName) {
        return gpArticlesMapper.selectOneArticleByCategory(pathName);
    }

    //根据目录ID查询首页大屏的四篇文章
    @Override
    public List<GpArticles> selectFourArticleByCategory(String pathName) {
        return gpArticlesMapper.selectFourArticleByCategory(pathName);
    }

    /**
     * 查询文章列表
     *
     * @param gpArticles 文章
     * @return 文章
     */
    @Override
    public List<GpArticles> selectGpArticlesList(GpArticles gpArticles)
    {
        return gpArticlesMapper.selectGpArticlesList(gpArticles);
    }

    /**
      * @Author geekplus
      * @Description //提供前端博客用户查询文章列表
      * @Param
      * @Throws
      * @Return {@link }
      */
    @Override
    public List<GpArticles> selectGpArticlesListForUser(GpArticles gpArticles) {
        return gpArticlesMapper.selectGpArticlesListForUser(gpArticles);
    }

    /**
     * 新增文章
     *
     * @param gpArticles 文章
     * @return 结果
     */
    @Override
    public int insertGpArticles(GpArticles gpArticles)
    {
        gpArticles.setCreateTime(DateUtils.getNowDate());
        int size=gpArticlesMapper.insertGpArticles(gpArticles);
        //System.out.println("返回主键ID："+gpArticles.getId());
        return size;
    }

    /**
      * @Author geekplus
      * @Description //用户投稿文章
      * @Param
      * @Throws
      * @Return {@link }
      */
    @Override
    public int userWriteGpArticles(GpArticles gpArticles) {
        gpArticles.setCreateTime(DateUtils.getNowDate());
        return gpArticlesMapper.userWriteGpArticles(gpArticles);
    }

    /**
     * 修改文章
     *
     * @param gpArticles 文章
     * @return 结果
     */
    @Override
    public int updateGpArticles(GpArticles gpArticles)
    {
        gpArticles.setUpdateTime(DateUtils.getNowDate());
        return gpArticlesMapper.updateGpArticles(gpArticles);
    }

    /**
      * @Author geekplus
      * @Description //用于用户端更新浏览量和点赞数
      * @Param
      * @Throws
      * @Return {@link }
      */
    @Override
    public int updateGpArticlesForUser(GpArticles gpArticles) {
        return gpArticlesMapper.updateGpArticlesForUser(gpArticles);
    }

    /**
     * 批量删除文章
     *
     * @param ids 需要删除的文章ID
     * @return 结果
     */
    @Override
    public int deleteGpArticlesByIds(Long[] ids)
    {
        return gpArticlesMapper.deleteGpArticlesByIds(ids);
    }

    /**
     * 删除文章信息
     *
     * @param id 文章ID
     * @return 结果
     */
    @Override
    public int deleteGpArticlesById(Long id)
    {
        return gpArticlesMapper.deleteGpArticlesById(id);
    }

    /**
      * @Author geekplus
      * @Description //根据tagId查询tag的文章列表
      * @Param
      * @Throws
      * @Return {@link }
      */
    @Override
    public List<GpArticles> selectTagDeArticle(String tagName,Long tagId) {
        return gpArticlesMapper.selectTagDeArticle(tagName,tagId);
    }

    /**
      * @Author geekplus
      * @Description //查找当前文章的上一篇
      * @Param
      * @Throws
      * @Return {@link }
      */
    @Override
    public GpArticles selectPrevGpArticle(String pathName, Long articleId) {
        return gpArticlesMapper.selectPrevGpArticle(pathName,articleId);
    }

    /**
      * @Author geekplus
      * @Description //查找当前文章的下一篇
      * @Param
      * @Throws
      * @Return {@link }
      */
    @Override
    public GpArticles selectNextGpArticle(String pathName, Long articleId) {
        return gpArticlesMapper.selectNextGpArticle(pathName,articleId);
    }
}
