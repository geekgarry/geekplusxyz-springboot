package com.maike.webapp.function.domain;

import com.maike.common.annotation.Excel;
import com.maike.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 【请填写功能名称】对象 resume_work_experience
 *
 * @author 佚名
 * @date 2021-01-08
 */
public class ResumeWorkExperience extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 工作时间 */
    @Excel(name = "工作时间")
    private String workTime;

    /** 公司 */
    @Excel(name = "公司")
    private String workCompany;

    /** 工作职位 */
    @Excel(name = "工作职位")
    private String workPosition;

    /** 工作内容简介 */
    @Excel(name = "工作内容简介")
    private String workIntroduce;

    /** 工作类型，0为实习，1为工作 */
    @Excel(name = "工作类型，0为实习，1为工作")
    private String workType;

    /** 关联的简历表id */
    @Excel(name = "关联的简历表id")
    private Long resumeId;

    /** 优先级id */
    @Excel(name = "优先级id")
    private Long priorityId;

    /**是否显示工作经历*/
    @Excel(name="是否显示工作经历")
    private String workVisible;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setWorkTime(String workTime)
    {
        this.workTime = workTime;
    }

    public String getWorkTime()
    {
        return workTime;
    }
    public void setWorkCompany(String workCompany)
    {
        this.workCompany = workCompany;
    }

    public String getWorkCompany()
    {
        return workCompany;
    }
    public void setWorkPosition(String workPosition)
    {
        this.workPosition = workPosition;
    }

    public String getWorkPosition()
    {
        return workPosition;
    }
    public void setWorkIntroduce(String workIntroduce)
    {
        this.workIntroduce = workIntroduce;
    }

    public String getWorkIntroduce()
    {
        return workIntroduce;
    }
    public void setWorkType(String workType)
    {
        this.workType = workType;
    }

    public String getWorkType()
    {
        return workType;
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

    public String getWorkVisible() {
        return workVisible;
    }

    public void setWorkVisible(String workVisible) {
        this.workVisible = workVisible;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("workTime", getWorkTime())
            .append("workCompany", getWorkCompany())
            .append("workPosition", getWorkPosition())
            .append("workIntroduce", getWorkIntroduce())
            .append("workType", getWorkType())
            .append("resumeId", getResumeId())
            .toString();
    }
}
