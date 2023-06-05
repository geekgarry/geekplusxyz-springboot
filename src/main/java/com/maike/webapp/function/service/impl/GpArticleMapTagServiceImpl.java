package com.maike.webapp.function.service.impl;

import com.maike.webapp.function.domain.GpArticleMapTag;
import com.maike.webapp.function.mapper.GpArticleMapTagMapper;
import com.maike.webapp.function.service.IGpArticleMapTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文章标签映射Service业务层处理
 *
 * @author 佚名
 * @date 2023-03-12
 */
@Service
public class GpArticleMapTagServiceImpl implements IGpArticleMapTagService
{
    @Autowired
    private GpArticleMapTagMapper gpArticleMapTagMapper;

    /**
     * 查询文章标签映射
     *
     * @param aticleId 文章标签映射ID
     * @return 文章标签映射
     */
    @Override
    public GpArticleMapTag selectGpArticleMapTagById(Long aticleId)
    {
        return gpArticleMapTagMapper.selectGpArticleMapTagById(aticleId);
    }

    /**
     * 查询文章标签映射列表
     *
     * @param gpArticleMapTag 文章标签映射
     * @return 文章标签映射
     */
    @Override
    public List<GpArticleMapTag> selectGpArticleMapTagList(GpArticleMapTag gpArticleMapTag)
    {
        return gpArticleMapTagMapper.selectGpArticleMapTagList(gpArticleMapTag);
    }

    /**
     * 新增文章标签映射
     *
     * @param gpArticleMapTag 文章标签映射
     * @return 结果
     */
    @Override
    public int insertGpArticleMapTag(GpArticleMapTag gpArticleMapTag)
    {
        return gpArticleMapTagMapper.insertGpArticleMapTag(gpArticleMapTag);
    }

    /**
     * 修改文章标签映射
     *
     * @param gpArticleMapTag 文章标签映射
     * @return 结果
     */
    @Override
    public int updateGpArticleMapTag(GpArticleMapTag gpArticleMapTag)
    {
        return gpArticleMapTagMapper.updateGpArticleMapTag(gpArticleMapTag);
    }

    /**
     * 批量删除文章标签映射
     *
     * @param aticleIds 需要删除的文章标签映射ID
     * @return 结果
     */
    @Override
    public int deleteGpArticleMapTagByIds(Long[] aticleIds)
    {
        return gpArticleMapTagMapper.deleteGpArticleMapTagByIds(aticleIds);
    }

    /**
     * 删除文章标签映射信息
     *
     * @param aticleId 文章标签映射ID
     * @return 结果
     */
    @Override
    public int deleteGpArticleMapTagById(Long aticleId)
    {
        return gpArticleMapTagMapper.deleteGpArticleMapTagById(aticleId);
    }
}
