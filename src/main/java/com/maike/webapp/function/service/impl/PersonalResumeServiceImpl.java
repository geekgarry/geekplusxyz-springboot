package com.maike.webapp.function.service.impl;

import com.maike.common.exception.CustomException;
import com.maike.common.utils.StringUtils;
import com.maike.webapp.function.domain.PersonalResume;
import com.maike.webapp.function.mapper.PersonalResumeMapper;
import com.maike.webapp.function.service.IPersonalResumeService;
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
public class PersonalResumeServiceImpl implements IPersonalResumeService
{
    @Autowired
    private PersonalResumeMapper personalResumeMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public PersonalResume selectPersonalResumeById(Long id)
    {
        return personalResumeMapper.selectPersonalResumeById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param personalResume 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<PersonalResume> selectPersonalResumeList(PersonalResume personalResume)
    {
        return personalResumeMapper.selectPersonalResumeList(personalResume);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param personalResume 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertPersonalResume(PersonalResume personalResume)
    {
        return personalResumeMapper.insertPersonalResume(personalResume);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param personalResume 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updatePersonalResume(PersonalResume personalResume)
    {
        return personalResumeMapper.updatePersonalResume(personalResume);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deletePersonalResumeByIds(Long[] ids)
    {
        return personalResumeMapper.deletePersonalResumeByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deletePersonalResumeById(Long id)
    {
        return personalResumeMapper.deletePersonalResumeById(id);
    }

//    @Override
//    public String importPersonalResume(List<PersonalResume> personalResumes, boolean updateSupport, LoginUser loginUser) {
//        if (StringUtils.isNull(personalResumes) || personalResumes.size() == 0)
//        {
//            throw new CustomException("导入数据不能为空！");
//        }
//        int successNum = 0;
//        int failureNum = 0;
//        StringBuilder successMsg = new StringBuilder();
//        StringBuilder failureMsg = new StringBuilder();
//        Date createTime = DateTimeUtils.getCurrentTime(DateTimeUtils.getCurrentLocalDateTime());
//        for (PersonalResume resume : personalResumes)
//        {
//            try
//            {
//                fireCompany.setCreateBy(StringUtils.trimString(loginUser.getUser().getUserId()));
//                fireCompany.setCreateTime(createTime);
//                fireCompany.setFcStationId(loginUser.getUser().getDeptId());
//                fireCompany.setFcPoliceId(loginUser.getUser().getUserId());
//                this.insertFireCompany(fireCompany);
//                successNum++;
//                successMsg.append("<br/>" + successNum + "、"+fireCompany.getFireCompany()+"的信息数据导入成功");
//            }
//            catch (Exception e)
//            {
//                failureNum++;
//                String msg = "<br/>" + failureNum + "、" +fireCompany.getFireCompany() + " 的信息数据导入失败：";
//                failureMsg.append(msg + e.getMessage());
//                log.error(msg, e);
//            }
//        }
//        if (failureNum > 0)
//        {
//            failureMsg.insert(0, "抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
//            throw new CustomException(failureMsg.toString());
//        }
//        else
//        {
//            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
//        }
//        return successMsg.toString();
//    }

    @Override
    public PersonalResume getPersonalResumeInfo(Long resumeId) {
        return personalResumeMapper.selectResumeInfo(resumeId);
    }
}
