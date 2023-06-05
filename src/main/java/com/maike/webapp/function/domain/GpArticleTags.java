package com.maike.webapp.function.domain;

import com.maike.common.annotation.Excel;
import com.maike.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 文章标签对象 gp_article_tags
 *
 * @author 佚名
 * @date 2023-03-12
 */
public class GpArticleTags extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 文章标签ID */
    private Long id;

    /** 文章标签名称 */
    @Excel(name = "文章标签名称")
    private String tagName;

    /** 文章标签信息 */
    @Excel(name = "文章标签信息")
    private String tagInfo;

    private Long articleCount;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setTagName(String tagName)
    {
        this.tagName = tagName;
    }

    public String getTagName()
    {
        return tagName;
    }
    public void setTagInfo(String tagInfo)
    {
        this.tagInfo = tagInfo;
    }

    public String getTagInfo()
    {
        return tagInfo;
    }

    public Long getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Long articleCount) {
        this.articleCount = articleCount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("tagName", getTagName())
            .append("tagInfo", getTagInfo())
            .toString();
    }
}
