package com.maike.webapp.function.service;

import com.maike.webapp.function.domain.PersonalResume;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 *
 * @author 佚名
 * @date 2021-01-08
 */
public interface IPersonalResumeService
{
    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public PersonalResume selectPersonalResumeById(Long id);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param personalResume 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<PersonalResume> selectPersonalResumeList(PersonalResume personalResume);

    /**
     * 新增【请填写功能名称】
     *
     * @param personalResume 【请填写功能名称】
     * @return 结果
     */
    public int insertPersonalResume(PersonalResume personalResume);

    /**
     * 修改【请填写功能名称】
     *
     * @param personalResume 【请填写功能名称】
     * @return 结果
     */
    public int updatePersonalResume(PersonalResume personalResume);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deletePersonalResumeByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deletePersonalResumeById(Long id);

//    String importPersonalResume(List<PersonalResume> personalResume, boolean updateSupport, LoginUser loginUser);
    PersonalResume getPersonalResumeInfo(Long resumeId);
}
