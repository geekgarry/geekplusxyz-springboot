package com.maike.webapp.function.service.impl;

import com.maike.webapp.function.domain.PersonalTechnology;
import com.maike.webapp.function.mapper.PersonalTechnologyMapper;
import com.maike.webapp.function.service.IPersonalTechnologyService;
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
public class PersonalTechnologyServiceImpl implements IPersonalTechnologyService
{
    @Autowired
    private PersonalTechnologyMapper personalTechnologyMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public PersonalTechnology selectPersonalTechnologyById(Long id)
    {
        return personalTechnologyMapper.selectPersonalTechnologyById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param personalTechnology 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<PersonalTechnology> selectPersonalTechnologyList(PersonalTechnology personalTechnology)
    {
        return personalTechnologyMapper.selectPersonalTechnologyList(personalTechnology);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param personalTechnology 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertPersonalTechnology(PersonalTechnology personalTechnology)
    {
        return personalTechnologyMapper.insertPersonalTechnology(personalTechnology);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param personalTechnology 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updatePersonalTechnology(PersonalTechnology personalTechnology)
    {
        return personalTechnologyMapper.updatePersonalTechnology(personalTechnology);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deletePersonalTechnologyByIds(Long[] ids)
    {
        return personalTechnologyMapper.deletePersonalTechnologyByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deletePersonalTechnologyById(Long id)
    {
        return personalTechnologyMapper.deletePersonalTechnologyById(id);
    }
}
