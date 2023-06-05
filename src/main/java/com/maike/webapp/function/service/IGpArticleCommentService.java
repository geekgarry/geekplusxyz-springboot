package com.maike.webapp.function.service;

import com.maike.webapp.function.domain.GpUserComment;

import java.util.List;

/**
 * 用户文章评论回复留言Service接口
 *
 * @author 佚名
 * @date 2023-03-12
 */
public interface IGpArticleCommentService
{
    /**
     * 查询用户文章评论回复留言
     *
     * @param id 用户评论回复留言ID
     * @return 用户评论回复留言
     */
    public GpUserComment selectGpArticleCommentById(Long id);

    /**
     * 查询用户文章评论回复留言列表
     *
     * @param gpUserComment 用户评论回复留言
     * @return 用户评论回复留言集合
     */
    public List<GpUserComment> selectGpArticleCommentList(GpUserComment gpUserComment);

    /**
      * @Author geekplus
      * @Description //获取网站用户文章评论留言信息
      * @Param
      * @Throws
      * @Return {@link }
      */
    public List<GpUserComment> getArticleComment(GpUserComment gpUserComment);

    /**
      * @Author geekplus
      * @Description //我的网站文章评论留言数量
      * @Param
      * @Throws
      * @Return {@link }
      */
    public int getArticleCommentCount();

    /**
      * @Author geekplus
      * @Description //获取最新十条用户文章评论留言
      * @Param
      * @Throws
      * @Return {@link }
      */
    public List<GpUserComment> getLatestArticleComment();

    /**
     * @Author geekplus
     * @Description //获取最热门六条用户文章评论留言
     * @Param
     * @Throws
     * @Return {@link }
     */
    public List<GpUserComment> getHotWebArticleComment();

    /**
     * @Author geekplus
     * @Description //我的网站用户文章评论留言
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
     * 修改用户文章评论回复留言
     *
     * @param gpUserComment 用户评论回复留言
     * @return 结果
     */
    public int updateGpArticleComment(GpUserComment gpUserComment);

    /**
     * 批量删除用户文章评论回复留言
     *
     * @param ids 需要删除的用户评论回复留言ID
     * @return 结果
     */
    public int deleteGpArticleCommentByIds(Long[] ids);

    /**
     * 删除用户文章评论回复留言信息
     *
     * @param id 用户评论回复留言ID
     * @return 结果
     */
    public int deleteGpArticleCommentById(Long id);
}
