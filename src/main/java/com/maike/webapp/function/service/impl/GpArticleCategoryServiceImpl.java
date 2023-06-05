package com.maike.webapp.function.service.impl;

import com.maike.common.utils.time.DateUtils;
import com.maike.webapp.function.domain.GpArticleCategory;
import com.maike.webapp.function.mapper.GpArticleCategoryMapper;
import com.maike.webapp.function.service.IGpArticleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 文章类型目录Service业务层处理
 *
 * @author 佚名
 * @date 2023-03-12
 */
@Service
public class GpArticleCategoryServiceImpl implements IGpArticleCategoryService
{
    @Autowired
    private GpArticleCategoryMapper gpArticleCategoryMapper;

    /**
     * 查询文章类型目录
     *
     * @param id 文章类型目录ID
     * @return 文章类型目录
     */
    @Override
    public GpArticleCategory selectGpArticleCategoryById(Integer id)
    {
        return gpArticleCategoryMapper.selectGpArticleCategoryById(id);
    }

    /**
     * 查询文章类型目录列表,树形结构表
     *
     * @param gpArticleCategory 文章类型目录
     * @return 文章类型目录
     */
    @Override
    public List<GpArticleCategory> selectGpArticleCategoryList(GpArticleCategory gpArticleCategory)
    {
        List<GpArticleCategory> list=gpArticleCategoryMapper.selectGpArticleCategoryList(gpArticleCategory);
        return buildTreeCategory(list);
    }

    /**
     * 查询文章类型目录列表
     *
     * @param gpArticleCategory 文章类型目录
     * @return 文章类型目录
     */
    @Override
    public List<GpArticleCategory> selectArticleCategoryList(GpArticleCategory gpArticleCategory)
    {
        List<GpArticleCategory> list=gpArticleCategoryMapper.selectGpArticleCategoryList(gpArticleCategory);
        return list;
    }

    /**
     * 新增文章类型目录
     *
     * @param gpArticleCategory 文章类型目录
     * @return 结果
     */
    @Override
    public int insertGpArticleCategory(GpArticleCategory gpArticleCategory)
    {
        gpArticleCategory.setCreateTime(DateUtils.getNowDate());
        return gpArticleCategoryMapper.insertGpArticleCategory(gpArticleCategory);
    }

    /**
     * 修改文章类型目录
     *
     * @param gpArticleCategory 文章类型目录
     * @return 结果
     */
    @Override
    public int updateGpArticleCategory(GpArticleCategory gpArticleCategory)
    {
        gpArticleCategory.setUpdateTime(DateUtils.getNowDate());
        return gpArticleCategoryMapper.updateGpArticleCategory(gpArticleCategory);
    }

    /**
     * 批量删除文章类型目录
     *
     * @param ids 需要删除的文章类型目录ID
     * @return 结果
     */
    @Override
    public int deleteGpArticleCategoryByIds(Integer[] ids)
    {
        return gpArticleCategoryMapper.deleteGpArticleCategoryByIds(ids);
    }

    /**
     * 删除文章类型目录信息
     *
     * @param id 文章类型目录ID
     * @return 结果
     */
    @Override
    public int deleteGpArticleCategoryById(Integer id)
    {
        return gpArticleCategoryMapper.deleteGpArticleCategoryById(id);
    }

    /**
      * @Author geekplus
      * @Description //查询子目录的父目录
      * @Param
      * @Throws
      * @Return {@link }
      */
    @Override
    public List<GpArticleCategory> selectParentCategory() {
        return gpArticleCategoryMapper.selectParentCategory();
    }

    /**
      * @Author geekplus
      * @Description //查询目录和子菜单
      * @Param
      * @Throws
      * @Return {@link }
      */
    @Override
    public List<GpArticleCategory> selectSubParentCategory() {
        return gpArticleCategoryMapper.selectSubParentCategory();
    }

    //获取属性结构菜单目录
    public List<GpArticleCategory> buildTreeCategory(List<GpArticleCategory> gpArticleCategories){
        List<GpArticleCategory> gpArticleCategoryList=new ArrayList<>();
        for (GpArticleCategory item:gpArticleCategories) {
            if(item.getParentId()==0){
                item.setChildren(getChildrenList(gpArticleCategories,item.getId()));
                gpArticleCategoryList.add(item);
            }
        }
        return gpArticleCategoryList;
    }

    //获取当前目录的子菜单
    private List<GpArticleCategory> getChildrenList(List<GpArticleCategory> gpArticleCategories, Integer id) {
        List<GpArticleCategory> childrenList=new ArrayList<>();
//        for (Iterator<SysMenu> iterator = list.iterator(); iterator.hasNext();){
//            SysMenu menu = iterator.next();
//            if (menu.getParentId().equals(menuId)){
//                log.info("==========>数据"+menu);
//                getChild(list, menu.getMenuId());
//                childList.add(menu);
//                log.info("==========>数据"+childList);
//            }
//        }
        for(GpArticleCategory item:gpArticleCategories){
            if(item.getParentId().equals(id)){
                item.setChildren(getChildrenList(gpArticleCategories,item.getId()));
                childrenList.add(item);
            }
        }
        return childrenList;
    }

//    private void returnChildrenList(List<GpArticleCategory> gpArticleCategories, GpArticleCategory item) {
//        // 得到子节点列表
//        List<SysMenu> childList = getChildList(list, t);
//        t.setChildren(childList);
//        for (SysMenu tChild : childList)
//        {
//            if (hasChild(list, tChild))
//            {
//                recursionFn(list, tChild);
//            }
//        }
//    }

    /**
     * 得到子节点列表
     */
    private List<GpArticleCategory> getChildList(List<GpArticleCategory> list, GpArticleCategory t)
    {
        List<GpArticleCategory> tlist = new ArrayList<GpArticleCategory>();
        Iterator<GpArticleCategory> it = list.iterator();
        while (it.hasNext())
        {
            GpArticleCategory n = (GpArticleCategory) it.next();
            if (n.getParentId().longValue() == t.getId().longValue())
            {
                tlist.add(n);
            }
        }
        return tlist;
    }

}
