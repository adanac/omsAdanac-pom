package com.adanac.b2b.oms.payment.bo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 支付异常信息业务对象类, PayErrorInfoBo
 * @author adanac
 * @version 1.0
 */
public class PayErrorInfoBo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4149734193907167080L;
	/**
	 * 物理主键
	 */
	private String id;
	/**
	 * 订单编码
	 */
	private String orderCode;
	/**
	 * 支付人员ID
	 */
	private Long payerId;
	/**
	 * 支付方类型,宝宝店,供应商,平台
	 */
	private Integer payerType;
	/**
	 * 支付流水
	 */
	private String payWaterno;
	/**
	 * 支付时间
	 */
	private String payTime;
	/**
	 * 支付平台(支付宝,微信支付,银联支付)
	 */
	private Integer payBank;
	/**
	 * 支付金额
	 */
	private BigDecimal payAmount;
	/**
	 * 交易ID
	 */
	private String tradeId;
	/**
	 * 支付说明
	 */
	private String payRemark;
	/**
	 * 支付账号
	 */
	private String outAccount;
	/**
	 * 收款账号
	 */
	private String inAccount;
	/**
	 * 处理状态
	 */
	private Integer dealStatus;
	/**
	 * 异常标识
	 */
	private Integer errorFlag;
	/**
	 * 处理时间
	 */
	private String dealTime;
	/**
	 * 处理说明
	 */
	private String dealRemark;

	/**
	 * 处理时间
	 */
	private Long dealPerson;

	public Long getDealPerson() {
		return dealPerson;
	}

	public void setDealPerson(Long dealPerson) {
		this.dealPerson = dealPerson;
	}

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

	public Long getPayerId() {
		return payerId;
	}

	public void setPayerId(Long payerId) {
		this.payerId = payerId;
	}

	public Integer getPayerType() {
		return payerType;
	}

	public void setPayerType(Integer payerType) {
		this.payerType = payerType;
	}

	public String getPayWaterno() {
		return payWaterno;
	}

	public void setPayWaterno(String payWaterno) {
		this.payWaterno = payWaterno;
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

	public BigDecimal getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	public String getTradeId() {
		return tradeId;
	}

	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	public String getPayRemark() {
		return payRemark;
	}

	public void setPayRemark(String payRemark) {
		this.payRemark = payRemark;
	}

	public String getOutAccount() {
		return outAccount;
	}

	public void setOutAccount(String outAccount) {
		this.outAccount = outAccount;
	}

	public String getInAccount() {
		return inAccount;
	}

	public void setInAccount(String inAccount) {
		this.inAccount = inAccount;
	}

	public Integer getDealStatus() {
		return dealStatus;
	}

	public void setDealStatus(Integer dealStatus) {
		this.dealStatus = dealStatus;
	}

	public Integer getErrorFlag() {
		return errorFlag;
	}

	public void setErrorFlag(Integer errorFlag) {
		this.errorFlag = errorFlag;
	}

	public String getDealTime() {
		return dealTime;
	}

	public void setDealTime(String dealTime) {
		this.dealTime = dealTime;
	}

	public String getDealRemark() {
		return dealRemark;
	}

	public void setDealRemark(String dealRemark) {
		this.dealRemark = dealRemark;
	}

}
