package com.maike.webapp.function.domain;

import com.maike.common.annotation.Excel;
import com.maike.common.core.domain.BaseEntity;
import com.maike.common.utils.html.ArticleUtil;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;
import java.util.Set;

/**
 * 文章对象 gp_articles
 *
 * @author 佚名
 * @date 2023-03-12
 */
public class GpArticles extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 文章表ID */
    private Long id;

    /** 作者名称，用户名 */
    @Excel(name = "作者名称，用户名")
    private String authorName;

    /** 作者ID，用户ID */
    @Excel(name = "作者ID，用户ID")
    private Long authorId;

    /** 文章标题 */
    @Excel(name = "文章标题")
    private String articleTitle;

    /** 文章内容 */
    @Excel(name = "文章内容")
    private String articleContent;

    /** 文章类型 */
    @Excel(name = "文章类型")
    private Long articleCategory;

    /** 文章点赞数量 */
    @Excel(name = "文章点赞数量")
    private Long likeCount;

    /** 文章浏览数量 */
    @Excel(name = "文章浏览数量")
    private Long viewCount;

    private String isDisplay;

    private String indexPicture;

    private String abstractText;

    private String pathName;

    private List<GpArticleTags> tags;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setAuthorName(String authorName)
    {
        this.authorName = authorName;
    }

    public String getAuthorName()
    {
        return authorName;
    }
    public void setAuthorId(Long authorId)
    {
        this.authorId = authorId;
    }

    public Long getAuthorId()
    {
        return authorId;
    }
    public void setArticleTitle(String articleTitle)
    {
        this.articleTitle = articleTitle;
    }

    public String getArticleTitle()
    {
        return articleTitle;
    }
    public void setArticleContent(String articleContent)
    {
        //这里分别动态处理提取文章内容的首张缩略图和摘要内容
        this.abstractText = ArticleUtil.getArticleAbstract(articleContent);
        //this.indexPicture = articleContent;
        setIndexPicture(articleContent);
        this.articleContent = articleContent;
    }

    public String getArticleContent()
    {
        return articleContent;
    }
    public void setArticleCategory(Long articleCategory)
    {
        this.articleCategory = articleCategory;
    }

    public Long getArticleCategory()
    {
        return articleCategory;
    }
    public void setLikeCount(Long likeCount)
    {
        this.likeCount = likeCount;
    }

    public Long getLikeCount()
    {
        return likeCount;
    }
    public void setViewCount(Long viewCount)
    {
        this.viewCount = viewCount;
    }

    public Long getViewCount()
    {
        return viewCount;
    }

    public String getIsDisplay() {
        return isDisplay;
    }

    public void setIsDisplay(String isDisplay) {
        this.isDisplay = isDisplay;
    }

    public String getIndexPicture() {
        return indexPicture;
    }

    public void setIndexPicture(String indexPicture) {
        Set<String> fp = ArticleUtil.getImgStr(indexPicture);
        if (!fp.isEmpty()) {
            //System.out.println(fp.iterator().next());//获取第一张
            indexPicture = fp.iterator().next();
        }else{
            indexPicture="";
        }
        this.indexPicture=indexPicture;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public void setAbstractText(String abstractText) {
        this.abstractText = abstractText;
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    public List<GpArticleTags> getTags() {
        return tags;
    }

    public void setTags(List<GpArticleTags> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("authorName", getAuthorName())
            .append("authorId", getAuthorId())
            .append("articleTitle", getArticleTitle())
            .append("articleContent", getArticleContent())
            .append("articleCategory", getArticleCategory())
            .append("likeCount", getLikeCount())
            .append("viewCount", getViewCount())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
