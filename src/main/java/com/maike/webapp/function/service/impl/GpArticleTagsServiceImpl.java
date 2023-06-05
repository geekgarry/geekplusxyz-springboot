package com.maike.webapp.function.service.impl;

import com.maike.webapp.function.domain.GpArticleMapTag;
import com.maike.webapp.function.domain.GpArticleTags;
import com.maike.webapp.function.mapper.GpArticleTagsMapper;
import com.maike.webapp.function.service.IGpArticleTagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 文章标签Service业务层处理
 *
 * @author 佚名
 * @date 2023-03-12
 */
@Service
public class GpArticleTagsServiceImpl implements IGpArticleTagsService
{
    @Autowired
    private GpArticleTagsMapper gpArticleTagsMapper;

    /**
     * 查询文章标签
     *
     * @param id 文章标签ID
     * @return 文章标签
     */
    @Override
    public GpArticleTags selectGpArticleTagsById(Long id)
    {
        return gpArticleTagsMapper.selectGpArticleTagsById(id);
    }

    /**
     * 查询文章标签列表
     *
     * @param gpArticleTags 文章标签
     * @return 文章标签
     */
    @Override
    public List<GpArticleTags> selectGpArticleTagsList(GpArticleTags gpArticleTags)
    {
        return gpArticleTagsMapper.selectGpArticleTagsList(gpArticleTags);
    }

    /**
     * 新增文章标签
     *
     * @param gpArticleTags 文章标签
     * @return 结果
     */
    @Override
    public int insertGpArticleTags(GpArticleTags gpArticleTags)
    {
        return gpArticleTagsMapper.insertGpArticleTags(gpArticleTags);
    }

    /**
     * 修改文章标签
     *
     * @param gpArticleTags 文章标签
     * @return 结果
     */
    @Override
    public int updateGpArticleTags(GpArticleTags gpArticleTags)
    {
        return gpArticleTagsMapper.updateGpArticleTags(gpArticleTags);
    }

    /**
     * 批量删除文章标签
     *
     * @param ids 需要删除的文章标签ID
     * @return 结果
     */
    @Override
    public int deleteGpArticleTagsByIds(Long[] ids)
    {
        return gpArticleTagsMapper.deleteGpArticleTagsByIds(ids);
    }

    /**
     * 删除文章标签信息
     *
     * @param id 文章标签ID
     * @return 结果
     */
    @Override
    public int deleteGpArticleTagsById(Long id)
    {
        return gpArticleTagsMapper.deleteGpArticleTagsById(id);
    }

    /**
      * @Author geekplus
      * @Description //查询各个标签的文章数量
      * @Param
      * @Throws
      * @Return {@link }
      */
    @Override
    public List<GpArticleTags> selectTagArticleCount() {
        return gpArticleTagsMapper.selectTagArticleCount();
    }

    /**
     * @Author geekplus
     * @Description //通过文章ID查询所属标签
     * @Param
     * @Throws
     * @Return {@link }
     */
    @Override
    public List<GpArticleTags> selectTagByArticleId(String articleId) {
        return gpArticleTagsMapper.selectTagByArticleId(articleId);
    }

    /**
      * @Author geekplus
      * @Description //插入文章的标签,在写文章后提交的时候插入
      * @Param
      * @Throws
      * @Return {@link }
      */
    @Override
    public int insertGpArticleMapTag(Map<String,Object> map) {
        return gpArticleTagsMapper.insertGpArticleMapTag(map);
    }

    @Override
    public List<GpArticleMapTag> selectGpArticleMapTagList(Map<String, Object> map) {
        return gpArticleTagsMapper.selectGpArticleMapTagList(map);
    }

    /**
      * @Author geekplus
      * @Description //删除文章标签映射表，通过文章ID和标签ID一起判断删除
      * @Param
      * @Throws
      * @Return {@link }
      */
    @Override
    public int deleteGpArticleMapTagByIdTag(Map<String, Object> map) {
        return gpArticleTagsMapper.deleteGpArticleMapTagByIdTag(map);
    }
}
