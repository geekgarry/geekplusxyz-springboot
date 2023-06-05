package com.maike.webapp.function.mapper;

import com.maike.webapp.function.domain.ResumeWorkExperience;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author 佚名
 * @date 2021-01-08
 */
public interface ResumeWorkExperienceMapper
{
    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ResumeWorkExperience selectResumeWorkExperienceById(Long id);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param resumeWorkExperience 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ResumeWorkExperience> selectResumeWorkExperienceList(ResumeWorkExperience resumeWorkExperience);

    /**
     * 新增【请填写功能名称】
     *
     * @param resumeWorkExperience 【请填写功能名称】
     * @return 结果
     */
    public int insertResumeWorkExperience(ResumeWorkExperience resumeWorkExperience);

    /**
     * 修改【请填写功能名称】
     *
     * @param resumeWorkExperience 【请填写功能名称】
     * @return 结果
     */
    public int updateResumeWorkExperience(ResumeWorkExperience resumeWorkExperience);

    /**
     * 删除【请填写功能名称】
     *
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteResumeWorkExperienceById(Long id);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteResumeWorkExperienceByIds(Long[] ids);
}
