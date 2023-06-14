package com.maike.webapp.function.mapper;
import com.maike.webapp.function.domain.GpUser;
import com.maike.webapp.function.domain.SysUser;

import java.util.List;

/**
 * 用户信息表 用户信息表
 * Created by CodeGenerator on 2023/06/14.
 */

public interface GpUserMapper {

    /**
    * 增加
    * @param gpUser
    * @return 用户信息表
    */
    Integer insertGpUser(GpUser gpUser);

    /**
    * 批量增加
    * @param gpUserList
    * @return
    */
    public int batchInsertGpUserList(List<GpUser> gpUserList);

    /**
    * 删除
    * @param userId
    */
    Integer deleteGpUserById(Long userId);

    /**
    * 批量删除
    */
    Integer deleteGpUserByIds(Long[] userIds);

    /**
    * 修改
    * @param gpUser
    */
    Integer updateGpUser(GpUser gpUser);

    /**
    * 批量修改魔偶几个字段
    * @param userIds
    */
    Integer batchUpdateGpUserList(Long[] userIds);

    /**
    * 查询全部
    */
    List<GpUser> selectGpUserList(GpUser gpUser);

    /**
    * 查询全部,联合查询使用
    */
    List<GpUser> selectUnionGpUserList(GpUser gpUser);

    /**
    * 根据Id查询单条数据
    */
    GpUser selectGpUserById(Long userId);

    /**
     * 根据Id查询单条数据
     */
    SysUser selectGpUserByGpUser(GpUser users);
}
