package com.maike.webapp.function.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maike.common.annotation.Excel;
import com.maike.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.List;

/**
 * 【请填写功能名称】对象 personal_resume
 *
 * @author 佚名
 * @date 2021-01-08
 */
public class PersonalResume extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 昵称 */
    @Excel(name = "昵称")
    private String nickName;

    /** 真实姓名 */
    @Excel(name = "真实姓名")
    private String realName;

    /** 性别 */
    @Excel(name = "性别")
    private String gender;

    /** 个人简介 */
    @Excel(name = "个人简介")
    private String personalIntroduce;

    /** 居住地址 */
    @Excel(name = "居住地址")
    private String liveAddressNow;

    /** 生日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthDay;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String contactPhone;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String contactEmail;

    /** 求职意向 */
    @Excel(name = "求职意向")
    private String jobIntention;

    /** 头像 */
    @Excel(name = "头像")
    private String headPic;

    /** 大学名称 */
    @Excel(name = "大学名称")
    private String universityName;

    /** 大学期间 */
    @Excel(name = "大学期间")
    private String universityStudyTime;

    /** 大学所学专业 */
    @Excel(name = "大学所学专业")
    private String unSpecializedSubject;

    /** 大学主要学习课程 */
    @Excel(name = "大学主要学习课程")
    private String unMainCoursesStudy;

    /** 自我评价 */
    @Excel(name = "自我评价")
    private String selfEvaluation;

    /** 掌握语言 */
    @Excel(name = "掌握语言")
    private String masterLanguage;

    /** 专业技能 */
    @Excel(name = "专业技能")
    private String professionSkill;

    /** 办公技能 */
    @Excel(name = "办公技能")
    private String officeSkill;

    /** 学历 */
    @Excel(name = "学历")
    private String education;

    /** 民族 */
    @Excel(name = "民族")
    private String nation;

    /** $column.columnComment */
    @Excel(name = "民族")
    private String height;

    private List<PersonalTechnology> listTech;

    private List<ProjectExperience> listProject;

    private List<ResumeWorkExperience> listWork;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    public String getNickName()
    {
        return nickName;
    }
    public void setRealName(String realName)
    {
        this.realName = realName;
    }

    public String getRealName()
    {
        return realName;
    }
    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getGender()
    {
        return gender;
    }
    public void setPersonalIntroduce(String personalIntroduce)
    {
        this.personalIntroduce = personalIntroduce;
    }

    public String getPersonalIntroduce()
    {
        return personalIntroduce;
    }
    public void setLiveAddressNow(String liveAddressNow)
    {
        this.liveAddressNow = liveAddressNow;
    }

    public String getLiveAddressNow()
    {
        return liveAddressNow;
    }
    public void setBirthDay(Date birthDay)
    {
        this.birthDay = birthDay;
    }

    public Date getBirthDay()
    {
        return birthDay;
    }
    public void setContactPhone(String contactPhone)
    {
        this.contactPhone = contactPhone;
    }

    public String getContactPhone()
    {
        return contactPhone;
    }
    public void setContactEmail(String contactEmail)
    {
        this.contactEmail = contactEmail;
    }

    public String getContactEmail()
    {
        return contactEmail;
    }
    public void setJobIntention(String jobIntention)
    {
        this.jobIntention = jobIntention;
    }

    public String getJobIntention()
    {
        return jobIntention;
    }
    public void setHeadPic(String headPic)
    {
        this.headPic = headPic;
    }

    public String getHeadPic()
    {
        return headPic;
    }
    public void setUniversityName(String universityName)
    {
        this.universityName = universityName;
    }

    public String getUniversityName()
    {
        return universityName;
    }
    public void setUniversityStudyTime(String universityStudyTime)
    {
        this.universityStudyTime = universityStudyTime;
    }

    public String getUniversityStudyTime()
    {
        return universityStudyTime;
    }
    public void setUnSpecializedSubject(String unSpecializedSubject)
    {
        this.unSpecializedSubject = unSpecializedSubject;
    }

    public String getUnSpecializedSubject()
    {
        return unSpecializedSubject;
    }
    public void setUnMainCoursesStudy(String unMainCoursesStudy)
    {
        this.unMainCoursesStudy = unMainCoursesStudy;
    }

    public String getUnMainCoursesStudy()
    {
        return unMainCoursesStudy;
    }
    public void setSelfEvaluation(String selfEvaluation)
    {
        this.selfEvaluation = selfEvaluation;
    }

    public String getSelfEvaluation()
    {
        return selfEvaluation;
    }
    public void setMasterLanguage(String masterLanguage)
    {
        this.masterLanguage = masterLanguage;
    }

    public String getMasterLanguage()
    {
        return masterLanguage;
    }
    public void setProfessionSkill(String professionSkill)
    {
        this.professionSkill = professionSkill;
    }

    public String getProfessionSkill()
    {
        return professionSkill;
    }
    public void setOfficeSkill(String officeSkill)
    {
        this.officeSkill = officeSkill;
    }

    public String getOfficeSkill()
    {
        return officeSkill;
    }
    public void setEducation(String education)
    {
        this.education = education;
    }

    public String getEducation()
    {
        return education;
    }
    public void setNation(String nation)
    {
        this.nation = nation;
    }

    public String getNation()
    {
        return nation;
    }
    public void setHeight(String height)
    {
        this.height = height;
    }

    public String getHeight()
    {
        return height;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("nickName", getNickName())
            .append("realName", getRealName())
            .append("gender", getGender())
            .append("personalIntroduce", getPersonalIntroduce())
            .append("liveAddressNow", getLiveAddressNow())
            .append("birthDay", getBirthDay())
            .append("contactPhone", getContactPhone())
            .append("contactEmail", getContactEmail())
            .append("jobIntention", getJobIntention())
            .append("headPic", getHeadPic())
            .append("universityName", getUniversityName())
            .append("universityStudyTime", getUniversityStudyTime())
            .append("unSpecializedSubject", getUnSpecializedSubject())
            .append("unMainCoursesStudy", getUnMainCoursesStudy())
            .append("selfEvaluation", getSelfEvaluation())
            .append("masterLanguage", getMasterLanguage())
            .append("professionSkill", getProfessionSkill())
            .append("officeSkill", getOfficeSkill())
            .append("education", getEducation())
            .append("nation", getNation())
            .append("height", getHeight())
            .toString();
    }

    public List<ResumeWorkExperience> getListWork() {
        return listWork;
    }

    public void setListWork(List<ResumeWorkExperience> listWork) {
        this.listWork = listWork;
    }

    public List<ProjectExperience> getListProject() {
        return listProject;
    }

    public void setListProject(List<ProjectExperience> listProject) {
        this.listProject = listProject;
    }

    public List<PersonalTechnology> getListTech() {
        return listTech;
    }

    public void setListTech(List<PersonalTechnology> listTech) {
        this.listTech = listTech;
    }
}
