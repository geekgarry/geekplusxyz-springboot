package com.maike.webapp.function.domain;

import com.maike.common.annotation.Excel;
import com.maike.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 网站通知对象 gp_notice
 *
 * @author 佚名
 * @date 2023-03-18
 */
public class GpNotice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 通知ID */
    private Long id;

    /** 通知标题 */
    @Excel(name = "通知标题")
    private String noticeTitle;

    /** 通知内容 */
    @Excel(name = "通知内容")
    private String noticeContent;

    /** 通知图片 */
    @Excel(name = "通知图片")
    private String noticeImg;

    /** 通知链接 */
    @Excel(name = "通知链接")
    private String noticeLink;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setNoticeTitle(String noticeTitle)
    {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeTitle()
    {
        return noticeTitle;
    }
    public void setNoticeContent(String noticeContent)
    {
        this.noticeContent = noticeContent;
    }

    public String getNoticeContent()
    {
        return noticeContent;
    }
    public void setNoticeImg(String noticeImg)
    {
        this.noticeImg = noticeImg;
    }

    public String getNoticeImg()
    {
        return noticeImg;
    }
    public void setNoticeLink(String noticeLink)
    {
        this.noticeLink = noticeLink;
    }

    public String getNoticeLink()
    {
        return noticeLink;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("noticeTitle", getNoticeTitle())
            .append("noticeContent", getNoticeContent())
            .append("noticeImg", getNoticeImg())
            .append("noticeLink", getNoticeLink())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
