package com.maike.webapp.function.mapper;

import com.maike.webapp.function.domain.GpCarousel;

import java.util.List;

/**
 * 首页跑马灯轮播图Mapper接口
 *
 * @author 佚名
 * @date 2023-03-12
 */
public interface GpCarouselMapper
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
     * 查询首页跑马灯轮播图列表
     *
     * @param
     * @return 首页跑马灯轮播图集合
     */
    public List<GpCarousel> selectGpCarouselImage();

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
     * 删除首页跑马灯轮播图
     *
     * @param id 首页跑马灯轮播图ID
     * @return 结果
     */
    public int deleteGpCarouselById(Integer id);

    /**
     * 批量删除首页跑马灯轮播图
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGpCarouselByIds(Integer[] ids);
}
