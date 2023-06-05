package com.maike.webapp.function.mapper;

import com.maike.webapp.function.domain.GpAboutWeb;

import java.util.List;

/**
 * 关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息Mapper接口
 *
 * @author 佚名
 * @date 2023-03-15
 */
public interface GpAboutWebMapper
{
    /**
     * 查询关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息
     *
     * @param id 关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息ID
     * @return 关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息
     */
    public GpAboutWeb selectGpAboutWebById(Integer id);

    /**
     * 查询关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息列表
     *
     * @param gpAboutWeb 关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息
     * @return 关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息集合
     */
    public List<GpAboutWeb> selectGpAboutWebList(GpAboutWeb gpAboutWeb);

    /**
      * @Author geekplus
      * @Description //查询网站信息，比如标题，网站介绍，网站底部备案信息等
      * @Param
      * @Throws
      * @Return {@link }
      */
    public GpAboutWeb selectGpWebInfo(Integer id);

    /**
      * @Author geekplus
      * @Description //查询关于我的信息，我的个人介绍等
      * @Param
      * @Throws
      * @Return {@link }
      */
    public GpAboutWeb selectAboutGpWeb(Integer id);

    /**
     * 新增关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息
     *
     * @param gpAboutWeb 关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息
     * @return 结果
     */
    public int insertGpAboutWeb(GpAboutWeb gpAboutWeb);

    /**
     * 修改关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息
     *
     * @param gpAboutWeb 关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息
     * @return 结果
     */
    public int updateGpAboutWeb(GpAboutWeb gpAboutWeb);

    /**
     * 删除关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息
     *
     * @param id 关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息ID
     * @return 结果
     */
    public int deleteGpAboutWebById(Integer id);

    /**
     * 批量删除关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGpAboutWebByIds(Integer[] ids);
}
