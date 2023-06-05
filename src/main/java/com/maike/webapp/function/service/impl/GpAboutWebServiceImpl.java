package com.maike.webapp.function.service.impl;

import com.maike.common.utils.time.DateUtils;
import com.maike.webapp.function.domain.GpAboutWeb;
import com.maike.webapp.function.mapper.GpAboutWebMapper;
import com.maike.webapp.function.service.IGpAboutWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息Service业务层处理
 *
 * @author 佚名
 * @date 2023-03-15
 */
@Service
public class GpAboutWebServiceImpl implements IGpAboutWebService
{
    @Autowired
    private GpAboutWebMapper gpAboutWebMapper;

    /**
     * 查询关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息
     *
     * @param id 关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息ID
     * @return 关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息
     */
    @Override
    public GpAboutWeb selectGpAboutWebById(Integer id)
    {
        return gpAboutWebMapper.selectGpAboutWebById(id);
    }

    /**
     * 查询关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息列表
     *
     * @param gpAboutWeb 关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息
     * @return 关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息
     */
    @Override
    public List<GpAboutWeb> selectGpAboutWebList(GpAboutWeb gpAboutWeb)
    {
        return gpAboutWebMapper.selectGpAboutWebList(gpAboutWeb);
    }

    /**
      * @Author geekplus
      * @Description //查询网站信息，比如标题，网站介绍，网站底部备案信息等
      * @Param
      * @Throws
      * @Return {@link }
      */
    @Override
    public GpAboutWeb selectGpWebInfo(Integer id) {
        return gpAboutWebMapper.selectGpWebInfo(id);
    }

    /**
      * @Author geekplus
      * @Description //查询关于我的信息，我的个人介绍等
      * @Param
      * @Throws
      * @Return {@link }
      */
    @Override
    public GpAboutWeb selectAboutGpWeb(Integer id) {
        return gpAboutWebMapper.selectAboutGpWeb(id);
    }

    /**
     * 新增关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息
     *
     * @param gpAboutWeb 关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息
     * @return 结果
     */
    @Override
    public int insertGpAboutWeb(GpAboutWeb gpAboutWeb)
    {
        gpAboutWeb.setCreateTime(DateUtils.getNowDate());
        return gpAboutWebMapper.insertGpAboutWeb(gpAboutWeb);
    }

    /**
     * 修改关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息
     *
     * @param gpAboutWeb 关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息
     * @return 结果
     */
    @Override
    public int updateGpAboutWeb(GpAboutWeb gpAboutWeb)
    {
        return gpAboutWebMapper.updateGpAboutWeb(gpAboutWeb);
    }

    /**
     * 批量删除关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息
     *
     * @param ids 需要删除的关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息ID
     * @return 结果
     */
    @Override
    public int deleteGpAboutWebByIds(Integer[] ids)
    {
        return gpAboutWebMapper.deleteGpAboutWebByIds(ids);
    }

    /**
     * 删除关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息信息
     *
     * @param id 关于网站信息，关于我的的介绍，和网站标头与尾部信息，如果有备案包括备案信息ID
     * @return 结果
     */
    @Override
    public int deleteGpAboutWebById(Integer id)
    {
        return gpAboutWebMapper.deleteGpAboutWebById(id);
    }
}
