package com.maike.webapp.function.service;

import com.maike.webapp.function.domain.GpArticleCategory;

import java.util.List;

/**
 * 文章类型目录Service接口
 *
 * @author 佚名
 * @date 2023-03-12
 */
public interface IGpArticleCategoryService
{
    /**
     * 查询文章类型目录
     *
     * @param id 文章类型目录ID
     * @return 文章类型目录
     */
    public GpArticleCategory selectGpArticleCategoryById(Integer id);

    /**
     * 查询文章类型目录列表，树形结构表
     *
     * @param gpArticleCategory 文章类型目录
     * @return 文章类型目录集合
     */
    public List<GpArticleCategory> selectGpArticleCategoryList(GpArticleCategory gpArticleCategory);

    /**
     * 查询文章类型目录列表
     *
     * @param gpArticleCategory 文章类型目录
     * @return 文章类型目录集合
     */
    public List<GpArticleCategory> selectArticleCategoryList(GpArticleCategory gpArticleCategory);

    /**
     * 新增文章类型目录
     *
     * @param gpArticleCategory 文章类型目录
     * @return 结果
     */
    public int insertGpArticleCategory(GpArticleCategory gpArticleCategory);

    /**
     * 修改文章类型目录
     *
     * @param gpArticleCategory 文章类型目录
     * @return 结果
     */
    public int updateGpArticleCategory(GpArticleCategory gpArticleCategory);

    /**
     * 批量删除文章类型目录
     *
     * @param ids 需要删除的文章类型目录ID
     * @return 结果
     */
    public int deleteGpArticleCategoryByIds(Integer[] ids);

    /**
     * 删除文章类型目录信息
     *
     * @param id 文章类型目录ID
     * @return 结果
     */
    public int deleteGpArticleCategoryById(Integer id);

    /**
      * @Author geekplus
      * @Description //查询父目录选项列表
      * @Param
      * @Throws
      * @Return {@link }
      */
    public List<GpArticleCategory> selectParentCategory();

    /**
      * @Author geekplus
      * @Description //查询父子目录菜单的循环递归菜单
      * @Param
      * @Throws
      * @Return {@link }
      */
    public List<GpArticleCategory> selectSubParentCategory();
}
