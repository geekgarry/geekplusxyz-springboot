package com.maike.webapp.function.service;

import com.maike.webapp.function.domain.GpCarousel;

import java.util.List;

/**
 * 首页跑马灯轮播图Service接口
 *
 * @author 佚名
 * @date 2023-03-12
 */
public interface IGpCarouselService
{
    /**
     * 查询首页跑马灯轮播图
     *
     * @param id 首页跑马灯轮播图ID
     * @return 首页跑马灯轮播图
     */
    public GpCarousel selectGpCarouselById(Integer id);

    /**
     * 查询首页跑马灯轮播图列表
     *
     * @param gpCarousel 首页跑马灯轮播图
     * @return 首页跑马灯轮播图集合
     */
    public List<GpCarousel> selectGpCarouselList(GpCarousel gpCarousel);

    /**
     * 查询首页跑马灯轮播图
     *
     * @param
     * @return 首页跑马灯轮播图集合
     */
    public List<GpCarousel> selectGpCarouselListImage();
    /**
     * 新增首页跑马灯轮播图
     *
     * @param gpCarousel 首页跑马灯轮播图
     * @return 结果
     */
    public int insertGpCarousel(GpCarousel gpCarousel);

    /**
     * 修改首页跑马灯轮播图
     *
     * @param gpCarousel 首页跑马灯轮播图
     * @return 结果
     */
    public int updateGpCarousel(GpCarousel gpCarousel);

    /**
     * 批量删除首页跑马灯轮播图
     *
     * @param ids 需要删除的首页跑马灯轮播图ID
     * @return 结果
     */
    public int deleteGpCarouselByIds(Integer[] ids);

    /**
     * 删除首页跑马灯轮播图信息
     *
     * @param id 首页跑马灯轮播图ID
     * @return 结果
     */
    public int deleteGpCarouselById(Integer id);
}
