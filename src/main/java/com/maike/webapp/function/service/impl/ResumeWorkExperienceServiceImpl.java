package com.maike.webapp.function.service.impl;

import com.maike.webapp.function.domain.ResumeWorkExperience;
import com.maike.webapp.function.mapper.ResumeWorkExperienceMapper;
import com.maike.webapp.function.service.IResumeWorkExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author 佚名
 * @date 2021-01-08
 */
@Service
public class ResumeWorkExperienceServiceImpl implements IResumeWorkExperienceService
{
    @Autowired
    private ResumeWorkExperienceMapper resumeWorkExperienceMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ResumeWorkExperience selectResumeWorkExperienceById(Long id)
    {
        return resumeWorkExperienceMapper.selectResumeWorkExperienceById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param resumeWorkExperience 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ResumeWorkExperience> selectResumeWorkExperienceList(ResumeWorkExperience resumeWorkExperience)
    {
        return resumeWorkExperienceMapper.selectResumeWorkExperienceList(resumeWorkExperience);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param resumeWorkExperience 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertResumeWorkExperience(ResumeWorkExperience resumeWorkExperience)
    {
        return resumeWorkExperienceMapper.insertResumeWorkExperience(resumeWorkExperience);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param resumeWorkExperience 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateResumeWorkExperience(ResumeWorkExperience resumeWorkExperience)
    {
        return resumeWorkExperienceMapper.updateResumeWorkExperience(resumeWorkExperience);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteResumeWorkExperienceByIds(Long[] ids)
    {
        return resumeWorkExperienceMapper.deleteResumeWorkExperienceByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteResumeWorkExperienceById(Long id)
    {
        return resumeWorkExperienceMapper.deleteResumeWorkExperienceById(id);
    }
}
