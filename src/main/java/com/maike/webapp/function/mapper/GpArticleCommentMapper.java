package com.maike.webapp.function.mapper;

import com.maike.webapp.function.domain.GpUserComment;

import java.util.List;

/**
 * 用户评论回复留言Mapper接口
 *
 * @author 佚名
 * @date 2023-03-12
 */
public interface GpArticleCommentMapper
{
    /**
     * 查询用户评论回复留言
     *
     * @param id 用户评论回复留言ID
     * @return 用户评论回复留言
     */
    public GpUserComment selectGpArticleCommentById(Long id);

    /**
     * 查询用户评论回复留言列表
     *
     * @param gpUserComment 用户评论回复留言
     * @return 用户评论回复留言集合
     */
    public List<GpUserComment> selectGpArticleCommentList(GpUserComment gpUserComment);

    /**
      * @Author geekplus
      * @Description //网站查询获取用户评论信息
      * @Param
      * @Throws
      * @Return {@link }
      */
    public List<GpUserComment> getArticleComment(GpUserComment gpUserComment);

    /**
      * @Author geekplus
      * @Description //网站获取用户评论的条数
      * @Param
      * @Throws
      * @Return {@link }
      */
    public int getArticleCommentCount();

    /**
      * @Author geekplus
      * @Description //获取最新的十条用户文章评论
      * @Param
      * @Throws
      * @Return {@link }
      */
    public List<GpUserComment> getLatestArticleComment();

    /**
     * @Author geekplus
     * @Description //获取最热门的六条用户评论
     * @Param
     * @Throws
     * @Return {@link }
     */
    public List<GpUserComment> getHotWebArticleComment();

    /**
     * @Author geekplus
     * @Description //网站用户评论留言
     * @Param
     * @Throws
     * @Return {@link }
     */
    public int insertArticleComment(GpUserComment gpUserComment);

    /**
     * 新增用户评论回复留言
     *
     * @param gpUserComment 用户评论回复留言
     * @return 结果
     */
    public int insertGpArticleComment(GpUserComment gpUserComment);

    /**
     * 修改用户评论回复留言
     *
     * @param gpUserComment 用户评论回复留言
     * @return 结果
     */
    public int updateGpArticleComment(GpUserComment gpUserComment);

    /**
     * 删除用户评论回复留言
     *
     * @param id 用户评论回复留言ID
     * @return 结果
     */
    public int deleteGpArticleCommentById(Long id);

    /**
     * 批量删除用户评论回复留言
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGpArticleCommentByIds(Long[] ids);
}
