package com.maike.webapp.function.domain;

import com.maike.common.annotation.Excel;
import com.maike.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息对象 gp_about_web
 *
 * @author 佚名
 * @date 2023-03-15
 */
public class GpAboutWeb extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 网站信息表ID */
    private Integer id;

    /** 我的姓名或是昵称 */
    @Excel(name = "我的姓名或是昵称")
    private String gpName;

    /** 网站简介标题 */
    @Excel(name = "网站简介标题")
    private String gpTitle;

    /** 网站与我的个人介绍 */
    @Excel(name = "网站与我的个人介绍")
    private String gpContent;

    /** 网站名称 */
    @Excel(name = "网站名称")
    private String gpWebName;

    /** 网站标题 */
    @Excel(name = "网站标题")
    private String gpWebTitle;

    /** 网站信息 */
    @Excel(name = "网站信息")
    private String gpWebInfo;

    /** icp备案 */
    @Excel(name = "icp备案")
    private String gpWebIcp;

    /** 公安备案 */
    @Excel(name = "公安备案")
    private String gpWebBeian;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setGpName(String gpName)
    {
        this.gpName = gpName;
    }

    public String getGpName()
    {
        return gpName;
    }
    public void setGpTitle(String gpTitle)
    {
        this.gpTitle = gpTitle;
    }

    public String getGpTitle()
    {
        return gpTitle;
    }
    public void setGpContent(String gpContent)
    {
        this.gpContent = gpContent;
    }

    public String getGpContent()
    {
        return gpContent;
    }
    public void setGpWebName(String gpWebName)
    {
        this.gpWebName = gpWebName;
    }

    public String getGpWebName()
    {
        return gpWebName;
    }
    public void setGpWebTitle(String gpWebTitle)
    {
        this.gpWebTitle = gpWebTitle;
    }

    public String getGpWebTitle()
    {
        return gpWebTitle;
    }
    public void setGpWebInfo(String gpWebInfo)
    {
        this.gpWebInfo = gpWebInfo;
    }

    public String getGpWebInfo()
    {
        return gpWebInfo;
    }
    public void setGpWebIcp(String gpWebIcp)
    {
        this.gpWebIcp = gpWebIcp;
    }

    public String getGpWebIcp()
    {
        return gpWebIcp;
    }
    public void setGpWebBeian(String gpWebBeian)
    {
        this.gpWebBeian = gpWebBeian;
    }

    public String getGpWebBeian()
    {
        return gpWebBeian;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("gpName", getGpName())
            .append("gpTitle", getGpTitle())
            .append("gpContent", getGpContent())
            .append("gpWebName", getGpWebName())
            .append("gpWebTitle", getGpWebTitle())
            .append("gpWebInfo", getGpWebInfo())
            .append("gpWebIcp", getGpWebIcp())
            .append("gpWebBeian", getGpWebBeian())
            .append("createTime", getCreateTime())
            .toString();
    }
}
