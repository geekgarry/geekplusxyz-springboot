package com.maike.webapp.function.service.impl;

import com.maike.common.utils.time.DateUtils;
import com.maike.webapp.function.domain.GpFriendlyLink;
import com.maike.webapp.function.mapper.GpFriendlyLinkMapper;
import com.maike.webapp.function.service.IGpFriendlyLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 网站友情链接Service业务层处理
 *
 * @author 佚名
 * @date 2023-03-12
 */
@Service
public class GpFriendlyLinkServiceImpl implements IGpFriendlyLinkService
{
    @Autowired
    private GpFriendlyLinkMapper gpFriendlyLinkMapper;


    /**
     * 查询网站友情链接
     *
     * @param id 网站友情链接ID
     * @return 网站友情链接
     */
    @Override
    public GpFriendlyLink selectGpFriendlyLinkById(Long id)
    {
        return gpFriendlyLinkMapper.selectGpFriendlyLinkById(id);
    }

    /**
     * 查询首页网站友情链接，is_display=1
     *
     * @param
     * @return 网站友情链接
     */
    @Override
    public List<GpFriendlyLink> displayGpFriendlyLink() {
        return gpFriendlyLinkMapper.displayGpFriendlyLink();
    }

    /**
     * 查询网站友情链接列表
     *
     * @param gpFriendlyLink 网站友情链接
     * @return 网站友情链接
     */
    @Override
    public List<GpFriendlyLink> selectGpFriendlyLinkList(GpFriendlyLink gpFriendlyLink)
    {
        return gpFriendlyLinkMapper.selectGpFriendlyLinkList(gpFriendlyLink);
    }

    /**
     * 新增网站友情链接
     *
     * @param gpFriendlyLink 网站友情链接
     * @return 结果
     */
    @Override
    public int insertGpFriendlyLink(GpFriendlyLink gpFriendlyLink)
    {
        gpFriendlyLink.setCreateTime(DateUtils.getNowDate());
        return gpFriendlyLinkMapper.insertGpFriendlyLink(gpFriendlyLink);
    }

    /**
     * 修改网站友情链接
     *
     * @param gpFriendlyLink 网站友情链接
     * @return 结果
     */
    @Override
    public int updateGpFriendlyLink(GpFriendlyLink gpFriendlyLink)
    {
        gpFriendlyLink.setUpdateTime(DateUtils.getNowDate());
        return gpFriendlyLinkMapper.updateGpFriendlyLink(gpFriendlyLink);
    }

    /**
     * 批量删除网站友情链接
     *
     * @param ids 需要删除的网站友情链接ID
     * @return 结果
     */
    @Override
    public int deleteGpFriendlyLinkByIds(Long[] ids)
    {
        return gpFriendlyLinkMapper.deleteGpFriendlyLinkByIds(ids);
    }

    /**
     * 删除网站友情链接信息
     *
     * @param id 网站友情链接ID
     * @return 结果
     */
    @Override
    public int deleteGpFriendlyLinkById(Long id)
    {
        return gpFriendlyLinkMapper.deleteGpFriendlyLinkById(id);
    }
}
