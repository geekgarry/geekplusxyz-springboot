package com.maike.webapp.function.service;

import com.maike.webapp.function.domain.GpFriendlyLink;

import java.util.List;

/**
 * 网站友情链接Service接口
 *
 * @author 佚名
 * @date 2023-03-12
 */
public interface IGpFriendlyLinkService
{
    /**
     * 查询网站友情链接
     *
     * @param id 网站友情链接ID
     * @return 网站友情链接
     */
    public GpFriendlyLink selectGpFriendlyLinkById(Long id);

    /**
     * 查询首页网站友情链接列表,is_display=1
     *
     * @param
     * @return 网站友情链接集合
     */
    public List<GpFriendlyLink> displayGpFriendlyLink();

    /**
     * 查询网站友情链接列表
     *
     * @param gpFriendlyLink 网站友情链接
     * @return 网站友情链接集合
     */
    public List<GpFriendlyLink> selectGpFriendlyLinkList(GpFriendlyLink gpFriendlyLink);

    /**
     * 新增网站友情链接
     *
     * @param gpFriendlyLink 网站友情链接
     * @return 结果
     */
    public int insertGpFriendlyLink(GpFriendlyLink gpFriendlyLink);

    /**
     * 修改网站友情链接
     *
     * @param gpFriendlyLink 网站友情链接
     * @return 结果
     */
    public int updateGpFriendlyLink(GpFriendlyLink gpFriendlyLink);

    /**
     * 批量删除网站友情链接
     *
     * @param ids 需要删除的网站友情链接ID
     * @return 结果
     */
    public int deleteGpFriendlyLinkByIds(Long[] ids);

    /**
     * 删除网站友情链接信息
     *
     * @param id 网站友情链接ID
     * @return 结果
     */
    public int deleteGpFriendlyLinkById(Long id);
}
