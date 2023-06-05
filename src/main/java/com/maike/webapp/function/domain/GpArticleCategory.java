package com.maike.webapp.function.domain;

import com.maike.common.annotation.Excel;
import com.maike.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;
import java.util.List;

/**
 * 文章类型目录对象 gp_article_category
 *
 * @author 佚名
 * @date 2023-03-12
 */
public class GpArticleCategory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 文章类型ID */
    private Integer id;

    /** 文章类型目录名称 */
    @Excel(name = "文章类型目录名称")
    private String categoryName;

    /** 文章类型目录信息 */
    @Excel(name = "文章类型目录信息")
    private String categoryInfo;

    /** 所属父类目录 */
    @Excel(name = "所属父类目录")
    private Integer parentId;

    /** 目录优先级 */
    @Excel(name="目录优先级")
    private Integer priorityId;

    /** 网站目录路由地址 */
    @Excel(name = "网站目录路由地址")
    private String path;

    /** 文章目录组件地址 */
    @Excel(name = "文章目录组件地址")
    private String component;

    /** 目录权限 */
    @Excel(name = "目录权限")
    private String permission;

    private String menuType;

    /** 菜单图标 */
    private String icon;

    private List<GpArticleCategory> children=new ArrayList<>();

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }

    public String getCategoryName()
    {
        return categoryName;
    }
    public void setCategoryInfo(String categoryInfo)
    {
        this.categoryInfo = categoryInfo;
    }

    public String getCategoryInfo()
    {
        return categoryInfo;
    }
    public void setParentId(Integer parentId)
    {
        this.parentId = parentId;
    }

    public Integer getParentId()
    {
        return parentId;
    }

    public Integer getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(Integer priorityId) {
        this.priorityId = priorityId;
    }

    public List<GpArticleCategory> getChildren() {
        return children;
    }

    public void setChildren(List<GpArticleCategory> children) {
        this.children = children;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("categoryName", getCategoryName())
            .append("categoryInfo", getCategoryInfo())
            .append("parentId", getParentId())
            .toString();
    }
}
