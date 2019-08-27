package com.imooc.o2o.entity;

import java.util.Date;
/**
 * 微信账号实体类
 * @author zhongchunyang
 *
 */
public class WechatAuth {
	//ID
	private Long wechatAuthId;
	//
	private String openId;
	//创建时间
	private Date createTime;
	//用户Id
	private PersionInfo persionInfo;
	public Long getWechatAuthId() {
		return wechatAuthId;
	}
	public void setWechatAuthId(Long wechatAuthId) {
		this.wechatAuthId = wechatAuthId;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public PersionInfo getPersionInfo() {
		return persionInfo;
	}
	public void setPersionInfo(PersionInfo persionInfo) {
		this.persionInfo = persionInfo;
	}
	
}
