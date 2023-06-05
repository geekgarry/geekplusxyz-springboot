package com.maike.webapp.function.service;

import com.maike.webapp.function.domain.GpNotice;

import java.util.List;

/**
 * 网站通知Service接口
 *
 * @author 佚名
 * @date 2023-03-18
 */
public interface IGpNoticeService
{
    /**
     * 查询网站通知
     *
     * @param id 网站通知ID
     * @return 网站通知
     */
    public GpNotice selectGpNoticeById(Long id);

    /**
      * @Author geekplus
      * @Description //查询最新的一条通知
      * @Param
      * @Throws
      * @Return {@link }
      */
    public GpNotice selectGpNoticeNewOne();

    /**
     * @Author geekplus
     * @Description //查询最新的五条通知
     * @Param
     * @Throws
     * @Return {@link }
     */
    public List<GpNotice> selectGpNoticeNewFive();

    /**
     * 查询网站通知列表
     *
     * @param gpNotice 网站通知
     * @return 网站通知集合
     */
    public List<GpNotice> selectGpNoticeList(GpNotice gpNotice);

    /**
     * 新增网站通知
     *
     * @param gpNotice 网站通知
     * @return 结果
     */
    public int insertGpNotice(GpNotice gpNotice);

    /**
     * 修改网站通知
     *
     * @param gpNotice 网站通知
     * @return 结果
     */
    public int updateGpNotice(GpNotice gpNotice);

    /**
     * 批量删除网站通知
     *
     * @param ids 需要删除的网站通知ID
     * @return 结果
     */
    public int deleteGpNoticeByIds(Long[] ids);

    /**
     * 删除网站通知信息
     *
     * @param id 网站通知ID
     * @return 结果
     */
    public int deleteGpNoticeById(Long id);
}
