package com.maike.webapp.function.domain;

import com.maike.common.annotation.Excel;
import com.maike.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 【请填写功能名称】对象 personal_technology
 *
 * @author 佚名
 * @date 2021-01-08
 */
public class PersonalTechnology extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String technologyName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer technologyScore;

    /** 关联的简历表id */
    @Excel(name = "关联的简历表id")
    private Long resumeId;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setTechnologyName(String technologyName)
    {
        this.technologyName = technologyName;
    }

    public String getTechnologyName()
    {
        return technologyName;
    }
    public void setTechnologyScore(Integer technologyScore)
    {
        this.technologyScore = technologyScore;
    }

    public Integer getTechnologyScore()
    {
        return technologyScore;
    }
    public void setResumeId(Long resumeId)
    {
        this.resumeId = resumeId;
    }

    public Long getResumeId()
    {
        return resumeId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("technologyName", getTechnologyName())
            .append("technologyScore", getTechnologyScore())
            .append("resumeId", getResumeId())
            .toString();
    }
}
