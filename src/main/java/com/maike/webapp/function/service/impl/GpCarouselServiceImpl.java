package com.maike.webapp.function.service.impl;

import com.maike.common.utils.time.DateUtils;
import com.maike.webapp.function.domain.GpCarousel;
import com.maike.webapp.function.mapper.GpCarouselMapper;
import com.maike.webapp.function.service.IGpCarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 首页跑马灯轮播图Service业务层处理
 *
 * @author 佚名
 * @date 2023-03-12
 */
@Service
public class GpCarouselServiceImpl implements IGpCarouselService
{
    @Autowired
    private GpCarouselMapper gpCarouselMapper;

    /**
     * 查询首页跑马灯轮播图
     *
     * @param id 首页跑马灯轮播图ID
     * @return 首页跑马灯轮播图
     */
    @Override
    public GpCarousel selectGpCarouselById(Integer id)
    {
        return gpCarouselMapper.selectGpCarouselById(id);
    }

    /**
     * 查询首页跑马灯轮播图列表
     *
     * @param gpCarousel 首页跑马灯轮播图
     * @return 首页跑马灯轮播图
     */
    @Override
    public List<GpCarousel> selectGpCarouselList(GpCarousel gpCarousel)
    {
        return gpCarouselMapper.selectGpCarouselList(gpCarousel);
    }

    /**
     * 查询首页跑马灯轮播图列表
     *
     * @param
     * @return 首页跑马灯轮播图
     */
    @Override
    public List<GpCarousel> selectGpCarouselListImage()
    {
        return gpCarouselMapper.selectGpCarouselImage();
    }

    /**
     * 新增首页跑马灯轮播图
     *
     * @param gpCarousel 首页跑马灯轮播图
     * @return 结果
     */
    @Override
    public int insertGpCarousel(GpCarousel gpCarousel)
    {
        gpCarousel.setCreateTime(DateUtils.getNowDate());
        return gpCarouselMapper.insertGpCarousel(gpCarousel);
    }

    /**
     * 修改首页跑马灯轮播图
     *
     * @param gpCarousel 首页跑马灯轮播图
     * @return 结果
     */
    @Override
    public int updateGpCarousel(GpCarousel gpCarousel)
    {
        gpCarousel.setUpdateTime(DateUtils.getNowDate());
        return gpCarouselMapper.updateGpCarousel(gpCarousel);
    }

    /**
     * 批量删除首页跑马灯轮播图
     *
     * @param ids 需要删除的首页跑马灯轮播图ID
     * @return 结果
     */
    @Override
    public int deleteGpCarouselByIds(Integer[] ids)
    {
        return gpCarouselMapper.deleteGpCarouselByIds(ids);
    }

    /**
     * 删除首页跑马灯轮播图信息
     *
     * @param id 首页跑马灯轮播图ID
     * @return 结果
     */
    @Override
    public int deleteGpCarouselById(Integer id)
    {
        return gpCarouselMapper.deleteGpCarouselById(id);
    }
}
