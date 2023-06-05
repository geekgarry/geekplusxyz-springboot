package com.maike.webapp.function.service;

import com.maike.webapp.function.domain.GpArticleMapTag;

import java.util.List;

/**
 * 文章标签映射Service接口
 *
 * @author 佚名
 * @date 2023-03-12
 */
public interface IGpArticleMapTagService
{
    /**
     * 查询文章标签映射
     *
     * @param aticleId 文章标签映射ID
     * @return 文章标签映射
     */
    public GpArticleMapTag selectGpArticleMapTagById(Long aticleId);

    /**
     * 查询文章标签映射列表
     *
     * @param gpArticleMapTag 文章标签映射
     * @return 文章标签映射集合
     */
    public List<GpArticleMapTag> selectGpArticleMapTagList(GpArticleMapTag gpArticleMapTag);

    /**
     * 新增文章标签映射
     *
     * @param gpArticleMapTag 文章标签映射
     * @return 结果
     */
    public int insertGpArticleMapTag(GpArticleMapTag gpArticleMapTag);

    /**
     * 修改文章标签映射
     *
     * @param gpArticleMapTag 文章标签映射
     * @return 结果
     */
    public int updateGpArticleMapTag(GpArticleMapTag gpArticleMapTag);

    /**
     * 批量删除文章标签映射
     *
     * @param aticleIds 需要删除的文章标签映射ID
     * @return 结果
     */
    public int deleteGpArticleMapTagByIds(Long[] aticleIds);

    /**
     * 删除文章标签映射信息
     *
     * @param aticleId 文章标签映射ID
     * @return 结果
     */
    public int deleteGpArticleMapTagById(Long aticleId);
}
