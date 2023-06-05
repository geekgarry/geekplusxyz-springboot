package com.maike.webapp.function.service;

import com.maike.webapp.function.domain.GpArticles;

import java.util.List;

/**
 * 文章Service接口
 *
 * @author 佚名
 * @date 2023-03-12
 */
public interface IGpArticlesService
{
    /**
     * 查询文章
     *
     * @param id 文章ID
     * @return 文章
     */
    public GpArticles selectGpArticlesById(Long id);

    /**
      * @Author geekplus
      * @Description //前端网站查询文章详情
      * @Param
      * @Throws
      * @Return {@link }
      */
    public GpArticles selectGpArticlesByIdForUser(String isDisplay, Long id);

    /**
      * @Author geekplus
      * @Description //前端网站查询文章详情
      * @Param
      * @Throws
      * @Return {@link }
      */
    public GpArticles selectGpArticlesByIdForWeb(Long id);

    //固定查询前十条
    public List<GpArticles> selectGpArticlesListByCategoryLimitTen(GpArticles gpArticles);

    //动态条件查询某目录前几条
    public List<GpArticles> selectGpArticlesListByCategoryLimit(String pathName, Integer limitCount);

    //根据目录ID查询分页的文章
    public List<GpArticles> selectGpArticlesListByCategory(String pathName);

    //根据目录ID查询分页的文章
    public List<GpArticles> selectGpArticlesListByKeyWords(String articleTitle);

    //根据目录ID查询首页大屏的一篇文章
    public GpArticles selectOneArticleByCategory(String pathName);

    //根据目录ID查询首页大屏的四篇文章
    public List<GpArticles> selectFourArticleByCategory(String pathName);

    /**
     * 查询文章列表
     *
     * @param gpArticles 文章
     * @return 文章集合
     */
    public List<GpArticles> selectGpArticlesList(GpArticles gpArticles);

    /**
     * 提供前端博客用户查询文章列表
     *
     * @param gpArticles 文章
     * @return 文章集合
     */
    public List<GpArticles> selectGpArticlesListForUser(GpArticles gpArticles);

    /**
     * 新增文章
     *
     * @param gpArticles 文章
     * @return 结果
     */
    public int insertGpArticles(GpArticles gpArticles);

    /**
      * @Author geekplus
      * @Description //用户投稿文章
      * @Param
      * @Throws
      * @Return {@link }
      */
    public int userWriteGpArticles(GpArticles gpArticles);

    /**
     * 修改文章
     *
     * @param gpArticles 文章
     * @return 结果
     */
    public int updateGpArticles(GpArticles gpArticles);

    /**
      * @Author geekplus
      * @Description //用于用户端更新浏览量和点赞数
      * @Param
      * @Throws
      * @Return {@link }
      */
    public int updateGpArticlesForUser(GpArticles gpArticles);

    /**
     * 批量删除文章
     *
     * @param ids 需要删除的文章ID
     * @return 结果
     */
    public int deleteGpArticlesByIds(Long[] ids);

    /**
     * 删除文章信息
     *
     * @param id 文章ID
     * @return 结果
     */
    public int deleteGpArticlesById(Long id);

    /**
      * @Author geekplus
      * @Description //根据标签的tagId查询每个标签的文章数量
      * @Param
      * @Throws
      * @Return {@link }
      */
    public List<GpArticles> selectTagDeArticle(String tagName, Long tagId);

    /**
      * @Author geekplus
      * @Description //查找当前文章的上一篇
      * @Param
      * @Throws
      * @Return {@link }
      */
    public GpArticles selectPrevGpArticle(String pathName, Long articleId);

    /**
     * @Author geekplus
     * @Description //查找当前文章的下一篇
     * @Param
     * @Throws
     * @Return {@link }
     */
    public GpArticles selectNextGpArticle(String pathName, Long articleId);
}
