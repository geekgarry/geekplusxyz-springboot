package com.maike.webapp.function.service.impl;

import com.maike.common.utils.time.DateUtils;
import com.maike.webapp.function.domain.GpNotice;
import com.maike.webapp.function.mapper.GpNoticeMapper;
import com.maike.webapp.function.service.IGpNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 网站通知Service业务层处理
 *
 * @author 佚名
 * @date 2023-03-18
 */
@Service
public class GpNoticeServiceImpl implements IGpNoticeService
{
    @Autowired
    private GpNoticeMapper gpNoticeMapper;

    /**
     * 查询网站通知
     *
     * @param id 网站通知ID
     * @return 网站通知
     */
    @Override
    public GpNotice selectGpNoticeById(Long id)
    {
        return gpNoticeMapper.selectGpNoticeById(id);
    }

    /**
      * @Author geekplus
      * @Description //查询最新的一条通知
      * @Param
      * @Throws
      * @Return {@link }
      */
    @Override
    public GpNotice selectGpNoticeNewOne() {
        return gpNoticeMapper.selectGpNoticeNewOne();
    }

    /**
      * @Author geekplus
      * @Description //查询最新的五条通知
      * @Param
      * @Throws
      * @Return {@link }
      */
    @Override
    public List<GpNotice> selectGpNoticeNewFive() {
        return gpNoticeMapper.selectGpNoticeNewFive();
    }

    /**
     * 查询网站通知列表
     *
     * @param gpNotice 网站通知
     * @return 网站通知
     */
    @Override
    public List<GpNotice> selectGpNoticeList(GpNotice gpNotice)
    {
        return gpNoticeMapper.selectGpNoticeList(gpNotice);
    }

    /**
     * 新增网站通知
     *
     * @param gpNotice 网站通知
     * @return 结果
     */
    @Override
    public int insertGpNotice(GpNotice gpNotice)
    {
        gpNotice.setCreateTime(DateUtils.getNowDate());
        return gpNoticeMapper.insertGpNotice(gpNotice);
    }

    /**
     * 修改网站通知
     *
     * @param gpNotice 网站通知
     * @return 结果
     */
    @Override
    public int updateGpNotice(GpNotice gpNotice)
    {
        gpNotice.setUpdateTime(DateUtils.getNowDate());
        return gpNoticeMapper.updateGpNotice(gpNotice);
    }

    /**
     * 批量删除网站通知
     *
     * @param ids 需要删除的网站通知ID
     * @return 结果
     */
    @Override
    public int deleteGpNoticeByIds(Long[] ids)
    {
        return gpNoticeMapper.deleteGpNoticeByIds(ids);
    }

    /**
     * 删除网站通知信息
     *
     * @param id 网站通知ID
     * @return 结果
     */
    @Override
    public int deleteGpNoticeById(Long id)
    {
        return gpNoticeMapper.deleteGpNoticeById(id);
    }
}
