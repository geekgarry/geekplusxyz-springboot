package com.maike.webapp.function.domain;

import com.maike.common.annotation.Excel;
import com.maike.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 【请填写功能名称】对象 project_experience
 *
 * @author 佚名
 * @date 2021-01-08
 */
public class ProjectExperience extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 项目时间 */
    @Excel(name = "项目时间")
    private String projectTime;

    /** 项目主要内容 */
    @Excel(name = "项目主要内容")
    private String projectContent;

    /** 使用的技术 */
    @Excel(name = "使用的技术")
    private String usingTechnology;

    /** 关联的简历表id */
    @Excel(name = "关联的简历表id")
    private Long resumeId;

    /** 优先级id */
    @Excel(name = "优先级id")
    private Long priorityId;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }

    public String getProjectName()
    {
        return projectName;
    }
    public void setProjectTime(String projectTime)
    {
        this.projectTime = projectTime;
    }

    public String getProjectTime()
    {
        return projectTime;
    }
    public void setProjectContent(String projectContent)
    {
        this.projectContent = projectContent;
    }

    public String getProjectContent()
    {
        return projectContent;
    }
    public void setUsingTechnology(String usingTechnology)
    {
        this.usingTechnology = usingTechnology;
    }

    public String getUsingTechnology()
    {
        return usingTechnology;
    }
    public void setResumeId(Long resumeId)
    {
        this.resumeId = resumeId;
    }

    public Long getResumeId()
    {
        return resumeId;
    }

    public Long getPriorityId() { return priorityId; }

    public void setPriorityId(Long priorityId) { this.priorityId = priorityId; }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("projectName", getProjectName())
            .append("projectTime", getProjectTime())
            .append("projectContent", getProjectContent())
            .append("usingTechnology", getUsingTechnology())
            .append("resumeId", getResumeId())
            .toString();
    }
}
