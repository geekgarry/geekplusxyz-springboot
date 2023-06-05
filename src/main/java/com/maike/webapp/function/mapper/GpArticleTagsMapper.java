package com.maike.webapp.function.mapper;

import com.maike.webapp.function.domain.GpArticleMapTag;
import com.maike.webapp.function.domain.GpArticleTags;

import java.util.List;
import java.util.Map;

/**
 * 文章标签Mapper接口
 *
 * @author 佚名
 * @date 2023-03-12
 */
public interface GpArticleTagsMapper
{
    /**
     * 查询文章标签
     *
     * @param id 文章标签ID
     * @return 文章标签
     */
    public GpArticleTags selectGpArticleTagsById(Long id);

    /**
     * 查询文章标签列表
     *
     * @param gpArticleTags 文章标签
     * @return 文章标签集合
     */
    public List<GpArticleTags> selectGpArticleTagsList(GpArticleTags gpArticleTags);

    /**
     * 新增文章标签
     *
     * @param gpArticleTags 文章标签
     * @return 结果
     */
    public int insertGpArticleTags(GpArticleTags gpArticleTags);

    /**
     * 修改文章标签
     *
     * @param gpArticleTags 文章标签
     * @return 结果
     */
    public int updateGpArticleTags(GpArticleTags gpArticleTags);

    /**
     * 删除文章标签
     *
     * @param id 文章标签ID
     * @return 结果
     */
    public int deleteGpArticleTagsById(Long id);

    /**
     * 批量删除文章标签
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGpArticleTagsByIds(Long[] ids);

    /**
      * @Author geekplus
      * @Description //查询标签的文章数量
      * @Param
      * @Throws
      * @Return {@link }
      */
    public List<GpArticleTags> selectTagArticleCount();

    /**
      * @Author geekplus
      * @Description //通过文章ID查询所属标签
      * @Param
      * @Throws
      * @Return {@link }
      */
    public List<GpArticleTags> selectTagByArticleId(String articleId);

    /**
     * @Author geekplus
     * @Description //插入文章的标签
     * @Param
     * @Throws
     * @Return {@link }
     */
    public int insertGpArticleMapTag(Map<String, Object> map);

    //查询标签映射是否存在
    public List<GpArticleMapTag> selectGpArticleMapTagList(Map<String, Object> map);

    //删除不需要的标签映射
    public int deleteGpArticleMapTagByIdTag(Map<String, Object> map);
}
