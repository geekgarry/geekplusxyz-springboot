package com.maike.webapp.function.domain;

import com.maike.common.annotation.Excel;
import com.maike.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 文章标签映射对象 gp_article_map_tag
 *
 * @author 佚名
 * @date 2023-03-12
 */
public class GpArticleMapTag extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 文章ID */
    @Excel(name = "文章ID")
    private Long aticleId;

    /** 文章标签ID */
    @Excel(name = "文章标签ID")
    private Long articleTag;

    public void setAticleId(Long aticleId)
    {
        this.aticleId = aticleId;
    }

    public Long getAticleId()
    {
        return aticleId;
    }
    public void setArticleTag(Long articleTag)
    {
        this.articleTag = articleTag;
    }

    public Long getArticleTag()
    {
        return articleTag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("aticleId", getAticleId())
            .append("articleTag", getArticleTag())
            .toString();
    }
}
