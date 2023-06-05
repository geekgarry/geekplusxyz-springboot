package com.maike.webapp.function.service;

import com.maike.webapp.function.domain.GpUserComment;

import java.util.List;

/**
 * 用户评论回复留言Service接口
 *
 * @author 佚名
 * @date 2023-03-12
 */
public interface IGpUserCommentService
{
    /**
     * 查询用户评论回复留言
     *
     * @param id 用户评论回复留言ID
     * @return 用户评论回复留言
     */
    public GpUserComment selectGpUserCommentById(Long id);

    /**
     * 查询用户评论回复留言列表
     *
     * @param gpUserComment 用户评论回复留言
     * @return 用户评论回复留言集合
     */
    public List<GpUserComment> selectGpUserCommentList(GpUserComment gpUserComment);

    /**
      * @Author geekplus
      * @Description //获取网站用户评论留言信息
      * @Param
      * @Throws
      * @Return {@link }
      */
    public List<GpUserComment> getUserComment(GpUserComment gpUserComment);

    /**
      * @Author geekplus
      * @Description //我的网站评论留言数量
      * @Param
      * @Throws
      * @Return {@link }
      */
    public int getUserCommentCount();

    /**
      * @Author geekplus
      * @Description //获取最新十条用户评论留言
      * @Param
      * @Throws
      * @Return {@link }
      */
    public List<GpUserComment> getLatestUserComment();

    /**
     * @Author geekplus
     * @Description //获取最热门六条用户评论留言
     * @Param
     * @Throws
     * @Return {@link }
     */
    public List<GpUserComment> getHotWebUserComment();

    /**
     * @Author geekplus
     * @Description //我的网站用户评论留言
     * @Param
     * @Throws
     * @Return {@link }
     */
    public int insertUserComment(GpUserComment gpUserComment);

    /**
     * 新增用户评论回复留言
     *
     * @param gpUserComment 用户评论回复留言
     * @return 结果
     */
    public int insertGpUserComment(GpUserComment gpUserComment);

    /**
     * 修改用户评论回复留言
     *
     * @param gpUserComment 用户评论回复留言
     * @return 结果
     */
    public int updateGpUserComment(GpUserComment gpUserComment);

    /**
     * 批量删除用户评论回复留言
     *
     * @param ids 需要删除的用户评论回复留言ID
     * @return 结果
     */
    public int deleteGpUserCommentByIds(Long[] ids);

    /**
     * 删除用户评论回复留言信息
     *
     * @param id 用户评论回复留言ID
     * @return 结果
     */
    public int deleteGpUserCommentById(Long id);
}
