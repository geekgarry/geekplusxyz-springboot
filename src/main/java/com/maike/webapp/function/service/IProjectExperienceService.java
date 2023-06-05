package com.maike.webapp.function.service;

import com.maike.webapp.function.domain.ProjectExperience;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 *
 * @author 佚名
 * @date 2021-01-08
 */
public interface IProjectExperienceService
{
    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ProjectExperience selectProjectExperienceById(Long id);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param projectExperience 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ProjectExperience> selectProjectExperienceList(ProjectExperience projectExperience);

    /**
     * 新增【请填写功能名称】
     *
     * @param projectExperience 【请填写功能名称】
     * @return 结果
     */
    public int insertProjectExperience(ProjectExperience projectExperience);

    /**
     * 修改【请填写功能名称】
     *
     * @param projectExperience 【请填写功能名称】
     * @return 结果
     */
    public int updateProjectExperience(ProjectExperience projectExperience);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteProjectExperienceByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteProjectExperienceById(Long id);
}
