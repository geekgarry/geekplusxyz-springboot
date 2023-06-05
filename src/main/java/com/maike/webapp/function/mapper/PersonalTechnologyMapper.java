package com.maike.webapp.function.mapper;

import com.maike.webapp.function.domain.PersonalTechnology;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author 佚名
 * @date 2021-01-08
 */
public interface PersonalTechnologyMapper
{
    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public PersonalTechnology selectPersonalTechnologyById(Long id);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param personalTechnology 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<PersonalTechnology> selectPersonalTechnologyList(PersonalTechnology personalTechnology);

    /**
     * 新增【请填写功能名称】
     *
     * @param personalTechnology 【请填写功能名称】
     * @return 结果
     */
    public int insertPersonalTechnology(PersonalTechnology personalTechnology);

    /**
     * 修改【请填写功能名称】
     *
     * @param personalTechnology 【请填写功能名称】
     * @return 结果
     */
    public int updatePersonalTechnology(PersonalTechnology personalTechnology);

    /**
     * 删除【请填写功能名称】
     *
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deletePersonalTechnologyById(Long id);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePersonalTechnologyByIds(Long[] ids);
}
