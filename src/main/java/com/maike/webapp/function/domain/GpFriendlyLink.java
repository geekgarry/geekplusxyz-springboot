package com.maike.webapp.function.domain;

import com.maike.common.annotation.Excel;
import com.maike.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 网站友情链接对象 gp_friendly_link
 *
 * @author 佚名
 * @date 2023-03-12
 */
public class GpFriendlyLink extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 网站友情链接ID */
    private Long id;

    /** 链接地址 */
    @Excel(name = "链接地址")
    private String linkUrl;

    /** 链接网站名称 */
    @Excel(name = "链接网站名称")
    private String linkName;

    /** 链接简介 */
    @Excel(name = "链接简介")
    private String linkIntro;

    /** 链接申请理由 */
    @Excel(name = "链接申请理由")
    private String appReason;

    /** 是否展示 */
    @Excel(name = "是否展示")
    private String isDisplay;

//    /** 创建时间 */
//    @Excel(name = "创建时间")
//    private Date createTime;
//
//    /** 更新时间 */
//    @Excel(name = "更新时间")
//    private String updateTime;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setLinkUrl(String linkUrl)
    {
        this.linkUrl = linkUrl;
    }

    public String getLinkUrl()
    {
        return linkUrl;
    }
    public void setLinkName(String linkName)
    {
        this.linkName = linkName;
    }

    public String getLinkName()
    {
        return linkName;
    }
    public void setLinkIntro(String linkIntro)
    {
        this.linkIntro = linkIntro;
    }

    public String getLinkIntro()
    {
        return linkIntro;
    }
    public void setAppReason(String appReason)
    {
        this.appReason = appReason;
    }

    public String getAppReason()
    {
        return appReason;
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
            .append("linkUrl", getLinkUrl())
            .append("linkName", getLinkName())
            .append("linkIntro", getLinkIntro())
            .append("appReason", getAppReason())
            .toString();
    }
}
