package com.maike.webapp.function.service.impl;

import com.maike.webapp.function.domain.ProjectExperience;
import com.maike.webapp.function.mapper.ProjectExperienceMapper;
import com.maike.webapp.function.service.IProjectExperienceService;
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
public class ProjectExperienceServiceImpl implements IProjectExperienceService
{
    @Autowired
    private ProjectExperienceMapper projectExperienceMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ProjectExperience selectProjectExperienceById(Long id)
    {
        return projectExperienceMapper.selectProjectExperienceById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param projectExperience 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ProjectExperience> selectProjectExperienceList(ProjectExperience projectExperience)
    {
        return projectExperienceMapper.selectProjectExperienceList(projectExperience);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param projectExperience 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertProjectExperience(ProjectExperience projectExperience)
    {
        return projectExperienceMapper.insertProjectExperience(projectExperience);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param projectExperience 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateProjectExperience(ProjectExperience projectExperience)
    {
        return projectExperienceMapper.updateProjectExperience(projectExperience);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteProjectExperienceByIds(Long[] ids)
    {
        return projectExperienceMapper.deleteProjectExperienceByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteProjectExperienceById(Long id)
    {
        return projectExperienceMapper.deleteProjectExperienceById(id);
    }
}
