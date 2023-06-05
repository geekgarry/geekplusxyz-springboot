package com.maike.webapp.function.domain;

import com.maike.common.annotation.Excel;
import com.maike.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 首页跑马灯轮播图对象 gp_carousel
 *
 * @author 佚名
 * @date 2023-03-12
 */
public class GpCarousel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 轮播图ID */
    private Integer id;

    /** 跑马轮播图地址 */
    @Excel(name = "跑马轮播图地址")
    private String carouselImg;

    /** 跑马灯轮播图标题 */
    @Excel(name = "跑马灯轮播图标题")
    private String carouselTitle;

    /** 跑马灯轮播信息 */
    @Excel(name = "跑马灯轮播信息")
    private String carouselInfo;

    /** 跑马灯轮播图链接地址 */
    @Excel(name = "跑马灯轮播图链接地址")
    private String carouselLink;

    /** 跑马灯轮播图是否显示 */
    @Excel(name = "跑马灯轮播图是否显示")
    private String isDisplay;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setCarouselImg(String carouselImg)
    {
        this.carouselImg = carouselImg;
    }

    public String getCarouselImg()
    {
        return carouselImg;
    }
    public void setCarouselTitle(String carouselTitle)
    {
        this.carouselTitle = carouselTitle;
    }

    public String getCarouselTitle()
    {
        return carouselTitle;
    }
    public void setCarouselInfo(String carouselInfo)
    {
        this.carouselInfo = carouselInfo;
    }

    public String getCarouselInfo()
    {
        return carouselInfo;
    }
    public void setCarouselLink(String carouselLink)
    {
        this.carouselLink = carouselLink;
    }

    public String getCarouselLink()
    {
        return carouselLink;
    }

    public String getIsDisplay() {
        return isDisplay;
    }

    public void setIsDisplay(String isDisplay) {
        this.isDisplay = isDisplay;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("carouselImg", getCarouselImg())
            .append("carouselTitle", getCarouselTitle())
            .append("carouselInfo", getCarouselInfo())
            .append("carouselLink", getCarouselLink())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
