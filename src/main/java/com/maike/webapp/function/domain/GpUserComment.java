package com.maike.webapp.function.domain;

import com.maike.common.annotation.Excel;
import com.maike.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 用户评论回复留言对象 gp_user_comment
 *
 * @author 佚名
 * @date 2023-03-12
 */
public class GpUserComment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 评论表ID */
    private Long id;

    /** 回复的评论ID */
    @Excel(name = "回复的评论ID")
    private Long replyId;

    /** 用户名 */
    @Excel(name = "用户名")
    private String name;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 网址 */
    @Excel(name = "网址")
    private String website;

    /** 评论内容 */
    @Excel(name = "评论内容")
    private String content;

    /** 评论所属的文章或主题ID */
    @Excel(name = "评论所属的文章或主题ID")
    private String topicId;

    /** 评论的主题类型 */
    @Excel(name = "评论的主题类型")
    private String topicType;

    /** 评论的用户ID */
    @Excel(name = "评论的用户ID")
    private String userId;

    /** 判断消息的层级ID */
    @Excel(name = "消息的层级ID")
    private Long parentId;

    /** 回复用户名 */
    @Excel(name = "回复用户名")
    private String replyName;

    /** 评论的回复数 */
    private Long replyCount;

    private List<GpUserComment> children;

    private Long likeCount;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setReplyId(Long replyId)
    {
        this.replyId = replyId;
    }

    public Long getReplyId()
    {
        return replyId;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }
    public void setWebsite(String website)
    {
        this.website = website;
    }

    public String getWebsite()
    {
        return website;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }
    public void setTopicId(String topicId)
    {
        this.topicId = topicId;
    }

    public String getTopicId()
    {
        return topicId;
    }
    public void setTopicType(String topicType)
    {
        this.topicType = topicType;
    }

    public String getTopicType()
    {
        return topicType;
    }
    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getUserId()
    {
        return userId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<GpUserComment> getChildren() {
        return children;
    }

    public void setChildren(List<GpUserComment> children) {
        this.children = children;
    }

    public String getReplyName() {
        return replyName;
    }

    public void setReplyName(String replyName) {
        this.replyName = replyName;
    }

    public Long getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Long replyCount) {
        this.replyCount = replyCount;
    }

    public Long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("replyId", getReplyId())
            .append("name", getName())
            .append("email", getEmail())
            .append("website", getWebsite())
            .append("content", getContent())
            .append("topicId", getTopicId())
            .append("topicType", getTopicType())
            .append("createTime", getCreateTime())
            .append("userId", getUserId())
            .toString();
    }
}
