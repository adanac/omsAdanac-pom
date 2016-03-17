package com.adanac.b2b.oms.order.bo;

import java.io.Serializable;

import com.adanac.b2b.oms.order.dto.AfterSaleApplyPicDto;

public class AfterSaleApplyPicBo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7455785489990435826L;

	/**
	 * 图片ID
	 */
	private String picId;

	/**
	 * 售后申请ID
	 */
	private String aftersaleApplyId;

	/**
	 * 图片URL
	 */
	private String url;

	/**
	 * 图片备注
	 */
	private String remark;

	/**
	 * 创建时间
	 */
	private String createTime;

	/**
	 * 最后更新人员ID
	 */
	private String lastOperator;

	public AfterSaleApplyPicBo() {
		super();
	}

	public AfterSaleApplyPicBo(AfterSaleApplyPicDto afterSaleApplyPicDto) {
		this.setPicId(afterSaleApplyPicDto.getPicId());
		this.setAftersaleApplyId(afterSaleApplyPicDto.getAftersaleApplyId());
		this.setUrl(afterSaleApplyPicDto.getUrl());
		this.setRemark(afterSaleApplyPicDto.getRemark());
		this.setCreateTime(afterSaleApplyPicDto.getCreateTime());
		this.setLastOperator(afterSaleApplyPicDto.getLastOperator());
	}

	public String getPicId() {
		return picId;
	}

	public void setPicId(String picId) {
		this.picId = picId;
	}

	public String getAftersaleApplyId() {
		return aftersaleApplyId;
	}

	public void setAftersaleApplyId(String aftersaleApplyId) {
		this.aftersaleApplyId = aftersaleApplyId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getLastOperator() {
		return lastOperator;
	}

	public void setLastOperator(String lastOperator) {
		this.lastOperator = lastOperator;
	}

}
