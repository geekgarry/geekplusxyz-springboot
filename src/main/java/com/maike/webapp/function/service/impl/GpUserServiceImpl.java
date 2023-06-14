package com.maike.webapp.function.service.impl;

import com.maike.webapp.function.domain.SysUser;
import com.maike.webapp.function.mapper.GpUserMapper;
import com.maike.webapp.function.domain.GpUser;
import com.maike.webapp.function.service.GpUserService;
//import com.maike.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2023/06/14.
 */
@Service
@Transactional
public class GpUserServiceImpl implements GpUserService {
    @Resource
    private GpUserMapper gpUserMapper;

    /**
    * 增加
    * @param gpUser
    * @return 用户信息表
    */
    public Integer insertGpUser(GpUser gpUser){
        return gpUserMapper.insertGpUser(gpUser);
    }

    /**
    * 批量增加
    * @param gpUserList
    * @return 用户信息表
    */
    public Integer batchInsertGpUserList(List<GpUser> gpUserList){
        return gpUserMapper.batchInsertGpUserList(gpUserList);
    }

    /**
    * 删除
    * @param userId
    */
    public Integer deleteGpUserById(Long userId){
        return gpUserMapper.deleteGpUserById(userId);
    }

    /**
    * 批量删除
    */
    public Integer deleteGpUserByIds(Long[] userIds){
        return gpUserMapper.deleteGpUserByIds(userIds);
    }

    /**
    * 修改
    * @param gpUser
    */
    public Integer updateGpUser(GpUser gpUser){
        return gpUserMapper.updateGpUser(gpUser);
    }

    /**
    * 批量修改某几个字段
    * @param userIds
    */
    public Integer batchUpdateGpUserList(Long[] userIds){
        return gpUserMapper.batchUpdateGpUserList(userIds);
    }

    /**
    * 查询全部
    */
    public List<GpUser> selectGpUserList(GpUser gpUser){
        return gpUserMapper.selectGpUserList(gpUser);
    }

    /**
    * 查询全部,用于联合查询，在此基础做自己的定制改动
    */
    public List<GpUser> selectUnionGpUserList(GpUser gpUser){
        return gpUserMapper.selectUnionGpUserList(gpUser);
    }

    /**
    * 根据Id查询单条数据
    */
    public GpUser selectGpUserById(Long userId){
        return gpUserMapper.selectGpUserById(userId);
    }

    @Override
    public SysUser selectGpUserByGpUser(GpUser user) {
        return gpUserMapper.selectGpUserByGpUser(user);
    }
}
