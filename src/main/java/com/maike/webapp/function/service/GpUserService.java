package com.maike.webapp.function.service;
import com.maike.webapp.function.domain.GpUser;
import com.maike.webapp.function.domain.SysUser;
//import com.maike.core.Service;
import java.util.List;


/**
 * 用户信息表 用户信息表
 * Created by CodeGenerator on 2023/06/14.
 */
public interface GpUserService {

    /**
    * 增加
    * @param gpUser
    * @return 用户信息表
    */
    public Integer insertGpUser(GpUser gpUser);

    /**
    * 批量增加
    * @param gpUserList
    * @return 用户信息表
    */
    public Integer batchInsertGpUserList(List<GpUser> gpUserList);

    /**
    * 删除
    * @param userId
    */
    public Integer deleteGpUserById(Long userId);

    /**
    * 批量删除某几个字段
    */
    public Integer deleteGpUserByIds(Long[] userIds);

    /**
    * 修改
    * @param gpUser
    */
    public Integer updateGpUser(GpUser gpUser);

    /**
    * 批量修改
    * @param userIds
    */
    public Integer batchUpdateGpUserList(Long[] userIds);

    /**
    * 查询全部
    */
    public List<GpUser> selectGpUserList(GpUser gpUser);

    /**
    * 查询全部，用作联合查询使用(在基础上修改即可)
    */
    public List<GpUser> selectUnionGpUserList(GpUser gpUser);

    /**
    * 根据Id查询单条数据
    */
    public GpUser selectGpUserById(Long userId);

    /**
     * 根据Id查询单条数据
     */
    public SysUser selectGpUserByGpUser(GpUser user);
}
