package com.adanac.b2b.oms.payment.dto;

import java.io.Serializable;

public class PayNotifyInfoScDto implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8245077155068001111L;
	/**
	 * 物理主键
	 */
	private String id;
	/**
	 * 订单编码
	 */
	private String orderCode;
	/**
	 * 支付时间
	 */
	private String payTime;
	/**
	 * 支付平台
	 */
	private Integer payBank;
	/**
	 * 支付通知原始数据
	 */
	private String payNotifyData;
	/**
	 * 处理状态
	 */
	private Integer dealStatus;
	/**
	 * 处理时间
	 */
	private String dealTime;
	/**
	 * 创建时间
	 */
	private String createTime;
	/**
	 * 错误码
	 */
	private String errorCode;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getPayTime() {
		return payTime;
	}
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	public Integer getPayBank() {
		return payBank;
	}
	public void setPayBank(Integer payBank) {
		this.payBank = payBank;
	}
	public String getPayNotifyData() {
		return payNotifyData;
	}
	public void setPayNotifyData(String payNotifyData) {
		this.payNotifyData = payNotifyData;
	}
	public Integer getDealStatus() {
		return dealStatus;
	}
	public void setDealStatus(Integer dealStatus) {
		this.dealStatus = dealStatus;
	}
	public String getDealTime() {
		return dealTime;
	}
	public void setDealTime(String dealTime) {
		this.dealTime = dealTime;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
