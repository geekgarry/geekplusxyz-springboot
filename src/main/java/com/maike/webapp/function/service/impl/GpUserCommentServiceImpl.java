package com.maike.webapp.function.service.impl;

import com.maike.common.utils.time.DateUtils;
import com.maike.webapp.function.domain.GpUserComment;
import com.maike.webapp.function.mapper.GpUserCommentMapper;
import com.maike.webapp.function.service.IGpUserCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户评论回复留言Service业务层处理
 *
 * @author 佚名
 * @date 2023-03-12
 */
@Service
@Slf4j
public class GpUserCommentServiceImpl implements IGpUserCommentService
{
    @Autowired
    private GpUserCommentMapper gpUserCommentMapper;

    /**
     * 查询用户评论回复留言
     *
     * @param id 用户评论回复留言ID
     * @return 用户评论回复留言
     */
    @Override
    public GpUserComment selectGpUserCommentById(Long id)
    {
        return gpUserCommentMapper.selectGpUserCommentById(id);
    }

    /**
     * 查询用户评论回复留言列表
     *
     * @param gpUserComment 用户评论回复留言,查询列表list
     * @return 用户评论回复留言
     */
    @Override
    public List<GpUserComment> selectGpUserCommentList(GpUserComment gpUserComment)
    {
        List<GpUserComment> list=gpUserCommentMapper.selectGpUserCommentList(gpUserComment);
        return list;
    }

    /**
      * @Author geekplus
      * @Description //网站用户评论留言，parentId为0，子查询
      * @Param
      * @Throws
      * @Return {@link }
      */
    @Override
    public List<GpUserComment> getUserComment(GpUserComment gpUserComment) {
        List<GpUserComment> list=gpUserCommentMapper.getUserComment(gpUserComment);
        //log.info(list.toString());
        return list;
    }

    /**
      * @Author geekplus
      * @Description //获取网站用户留言的数量
      * @Param
      * @Throws
      * @Return {@link }
      */
    @Override
    public int getUserCommentCount() {
        return gpUserCommentMapper.getUserCommentCount();
    }

    /**
      * @Author geekplus
      * @Description //获取网站用户评论的最新十条数据
      * @Param
      * @Throws
      * @Return {@link }
      */
    @Override
    public List<GpUserComment> getLatestUserComment() {
        return gpUserCommentMapper.getLatestUserComment();
    }

    /**
      * @Author geekplus
      * @Description //获取最热门的六条评论
      * @Param
      * @Throws
      * @Return {@link }
      */
    @Override
    public List<GpUserComment> getHotWebUserComment() {
        return gpUserCommentMapper.getHotWebUserComment();
    }

    /**
      * @Author geekplus
      * @Description // 网站用户留言评论回复
      * @Param
      * @Throws
      * @Return {@link }
      */
    @Override
    public int insertUserComment(GpUserComment gpUserComment) {
        gpUserComment.setCreateTime(DateUtils.getNowDate());
        return gpUserCommentMapper.insertUserComment(gpUserComment);
    }
    /**
     * 新增用户评论回复留言
     *
     * @param gpUserComment 用户评论回复留言
     * @return 结果
     */
    @Override
    public int insertGpUserComment(GpUserComment gpUserComment)
    {
        gpUserComment.setCreateTime(DateUtils.getNowDate());
        return gpUserCommentMapper.insertGpUserComment(gpUserComment);
    }

    /**
     * 修改用户评论回复留言
     *
     * @param gpUserComment 用户评论回复留言
     * @return 结果
     */
    @Override
    public int updateGpUserComment(GpUserComment gpUserComment)
    {
        return gpUserCommentMapper.updateGpUserComment(gpUserComment);
    }

    /**
     * 批量删除用户评论回复留言
     *
     * @param ids 需要删除的用户评论回复留言ID
     * @return 结果
     */
    @Override
    public int deleteGpUserCommentByIds(Long[] ids)
    {
        return gpUserCommentMapper.deleteGpUserCommentByIds(ids);
    }

    /**
     * 删除用户评论回复留言信息
     *
     * @param id 用户评论回复留言ID
     * @return 结果
     */
    @Override
    public int deleteGpUserCommentById(Long id)
    {
        return gpUserCommentMapper.deleteGpUserCommentById(id);
    }

    //获取属性结构菜单目录
    public List<GpUserComment> buildTreeGpUserComment(List<GpUserComment> gpUserCommentList){
        List<GpUserComment> gpArticleCategoryList=new ArrayList<>();
        for (GpUserComment item:gpUserCommentList) {
            if(item.getParentId()==0){
                item.setChildren(getChildrenList(gpUserCommentList,item.getId()));
                gpArticleCategoryList.add(item);
            }
        }
        return gpArticleCategoryList;
    }

    //获取当前目录的子菜单
    private List<GpUserComment> getChildrenList(List<GpUserComment> gpUserCommentList, Long id) {
        List<GpUserComment> childrenList=new ArrayList<>();
//        for (Iterator<SysMenu> iterator = list.iterator(); iterator.hasNext();){
//            SysMenu menu = iterator.next();
//            if (menu.getParentId().equals(menuId)){
//                log.info("==========>数据"+menu);
//                getChild(list, menu.getMenuId());
//                childList.add(menu);
//                log.info("==========>数据"+childList);
//            }
//        }
        for(GpUserComment item:gpUserCommentList){
            if(item.getParentId().equals(id)){
                item.setChildren(getChildrenList(gpUserCommentList,item.getId()));
                childrenList.add(item);
            }
        }
        return childrenList;
    }
}
