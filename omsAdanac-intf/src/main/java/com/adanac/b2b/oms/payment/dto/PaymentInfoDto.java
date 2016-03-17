package com.adanac.b2b.oms.payment.dto;

import java.math.BigDecimal;

import com.adanac.b2b.oms.common.BaseDto;

public class PaymentInfoDto extends BaseDto {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4957296208654837683L;
	/**
	 * 物理主键
	 */
	private String id;
	/**
	 * 物理主键
	 */
	private String payCode;
	/**
	 * 订单ID
	 */
	private String orderId;
	/**
	 * 订单编码
	 */
	private String orderCode;
	/**
	 * 订单类型(1销售订单,2售后订单)
	 */
	private Integer orderType;
	/**
	 * 物理主键
	 */
	private String payerId;
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
	 * 支付方式,线上支付,线下支付
	 */
	private Integer payWay;
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
	 * 支付备注
	 */
	private String payRemark;
	/**
	 * 支出账号
	 */
	private String outAccount;
	/**
	 * 进账账号
	 */
	private String inAccount;
	/**
	 * 创建时间
	 */
	private String createTime;
	/**
	 * 最后更新时间
	 */
	private String updateTime;
	/**
	 * 最后更新人
	 */
	private String lastOperator;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPayCode() {
		return payCode;
	}

	public void setPayCode(String payCode) {
		this.payCode = payCode;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public String getPayerId() {
		return payerId;
	}

	public void setPayerId(String payerId) {
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

	public Integer getPayWay() {
		return payWay;
	}

	public void setPayWay(Integer payWay) {
		this.payWay = payWay;
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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getLastOperator() {
		return lastOperator;
	}

	public void setLastOperator(String lastOperator) {
		this.lastOperator = lastOperator;
	}
}
