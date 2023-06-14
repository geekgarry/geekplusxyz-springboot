package com.maike.webapp.function.domain;

import com.maike.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.Date;
import java.util.Date;
import java.util.Date;

/**
 * 功能：用户信息表 对象:gp_user
 *
 * @author CodeGenerator
 * @date 2023/06/14
 */
public class GpUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;


    /**
     * 用户信息表 用户信息表
     */
    private Long userId;

    /**
     * 用户信息表 用户信息表
     */
    private Long deptId;

    /**
     * 用户信息表 用户信息表
     */
    private String userName;

    /**
     * 用户信息表 用户信息表
     */
    private String nickName;

    /**
     * 用户信息表 用户信息表
     */
    private String userType;

    /**
     * 用户信息表 用户信息表
     */
    private String email;

    /**
     * 用户信息表 用户信息表
     */
    private String phonenumber;

    /**
     * 用户信息表 用户信息表
     */
    private String sex;

    /**
     * 用户信息表 用户信息表
     */
    private String avatar;

    /**
     * 用户信息表 用户信息表
     */
    private String password;

    /**
     * 用户信息表 用户信息表
     */
    private String status;

    /**
     * 用户信息表 用户信息表
     */
    private String delFlag;

    /**
     * 用户信息表 用户信息表
     */
    private String loginIp;

    /**
     * 用户信息表 用户信息表
     */
    private Date loginDate;

    /**
     * 用户信息表 用户信息表
     */
    private String createBy;

    /**
     * 用户信息表 用户信息表
     */
    private Date createTime;

    /**
     * 用户信息表 用户信息表
     */
    private String updateBy;

    /**
     * 用户信息表 用户信息表
     */
    private Date updateTime;

    /**
     * 用户信息表 用户信息表
     */
    private String remark;

	/**
	 *获取用户ID
	 */
	public Long getUserId(){
		return userId;
	}

	/**
	 *设置用户ID
	 */
	public void setUserId(Long userId){
		this.userId = userId;
	}
	/**
	 *获取部门ID
	 */
	public Long getDeptId(){
		return deptId;
	}

	/**
	 *设置部门ID
	 */
	public void setDeptId(Long deptId){
		this.deptId = deptId;
	}
	/**
	 *获取用户账号
	 */
	public String getUserName(){
		return userName;
	}

	/**
	 *设置用户账号
	 */
	public void setUserName(String userName){
		this.userName = userName;
	}
	/**
	 *获取用户昵称
	 */
	public String getNickName(){
		return nickName;
	}

	/**
	 *设置用户昵称
	 */
	public void setNickName(String nickName){
		this.nickName = nickName;
	}
	/**
	 *获取用户类型（00系统用户）
	 */
	public String getUserType(){
		return userType;
	}

	/**
	 *设置用户类型（00系统用户）
	 */
	public void setUserType(String userType){
		this.userType = userType;
	}
	/**
	 *获取用户邮箱
	 */
	public String getEmail(){
		return email;
	}

	/**
	 *设置用户邮箱
	 */
	public void setEmail(String email){
		this.email = email;
	}
	/**
	 *获取手机号码
	 */
	public String getPhonenumber(){
		return phonenumber;
	}

	/**
	 *设置手机号码
	 */
	public void setPhonenumber(String phonenumber){
		this.phonenumber = phonenumber;
	}
	/**
	 *获取用户性别（0男 1女 2未知）
	 */
	public String getSex(){
		return sex;
	}

	/**
	 *设置用户性别（0男 1女 2未知）
	 */
	public void setSex(String sex){
		this.sex = sex;
	}
	/**
	 *获取头像地址
	 */
	public String getAvatar(){
		return avatar;
	}

	/**
	 *设置头像地址
	 */
	public void setAvatar(String avatar){
		this.avatar = avatar;
	}
	/**
	 *获取密码
	 */
	public String getPassword(){
		return password;
	}

	/**
	 *设置密码
	 */
	public void setPassword(String password){
		this.password = password;
	}
	/**
	 *获取帐号状态（0正常 1停用）
	 */
	public String getStatus(){
		return status;
	}

	/**
	 *设置帐号状态（0正常 1停用）
	 */
	public void setStatus(String status){
		this.status = status;
	}
	/**
	 *获取删除标志（0代表存在 2代表删除）
	 */
	public String getDelFlag(){
		return delFlag;
	}

	/**
	 *设置删除标志（0代表存在 2代表删除）
	 */
	public void setDelFlag(String delFlag){
		this.delFlag = delFlag;
	}
	/**
	 *获取最后登录IP
	 */
	public String getLoginIp(){
		return loginIp;
	}

	/**
	 *设置最后登录IP
	 */
	public void setLoginIp(String loginIp){
		this.loginIp = loginIp;
	}
	/**
	 *获取最后登录时间
	 */
	public Date getLoginDate(){
		return loginDate;
	}

	/**
	 *设置最后登录时间
	 */
	public void setLoginDate(Date loginDate){
		this.loginDate = loginDate;
	}
	/**
	 *获取创建者
	 */
	public String getCreateBy(){
		return createBy;
	}

	/**
	 *设置创建者
	 */
	public void setCreateBy(String createBy){
		this.createBy = createBy;
	}
	/**
	 *获取创建时间
	 */
	public Date getCreateTime(){
		return createTime;
	}

	/**
	 *设置创建时间
	 */
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
	/**
	 *获取更新者
	 */
	public String getUpdateBy(){
		return updateBy;
	}

	/**
	 *设置更新者
	 */
	public void setUpdateBy(String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *获取更新时间
	 */
	public Date getUpdateTime(){
		return updateTime;
	}

	/**
	 *设置更新时间
	 */
	public void setUpdateTime(Date updateTime){
		this.updateTime = updateTime;
	}
	/**
	 *获取备注
	 */
	public String getRemark(){
		return remark;
	}

	/**
	 *设置备注
	 */
	public void setRemark(String remark){
		this.remark = remark;
	}

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("deptId", getDeptId())
            .append("userName", getUserName())
            .append("nickName", getNickName())
            .append("userType", getUserType())
            .append("email", getEmail())
            .append("phonenumber", getPhonenumber())
            .append("sex", getSex())
            .append("avatar", getAvatar())
            .append("password", getPassword())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("loginIp", getLoginIp())
            .append("loginDate", getLoginDate())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
