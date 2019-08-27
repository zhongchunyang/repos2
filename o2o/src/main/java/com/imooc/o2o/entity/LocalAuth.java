package com.imooc.o2o.entity;

import java.util.Date;
/**
 * 本地账户实体类
 * @author zhongchunyang
 *
 */
public class LocalAuth {
	//ID
	private Long LocalAuthId;
	//用户名
	private String username;
	//密码
	private String password;
	//创建时间
	private Date createTime;
	//修改时间
	private Date lastEditTime;
	//用户id
	private PersionInfo persionInfo;
	public Long getLocalAuthId() {
		return LocalAuthId;
	}
	public void setLocalAuthId(Long localAuthId) {
		LocalAuthId = localAuthId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastEditTime() {
		return lastEditTime;
	}
	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}
	public PersionInfo getPersionInfo() {
		return persionInfo;
	}
	public void setPersionInfo(PersionInfo persionInfo) {
		this.persionInfo = persionInfo;
	}
	
}
