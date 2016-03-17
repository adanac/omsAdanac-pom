package com.adanac.b2b.oms.order.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @author Administrator
 *
 */
public class ReturnAmountDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -640628557626499540L;
	/**
	 * 支付确认人员
	 */
	private String userId;
	/**
	 * 支付流水号
	 */
	private String payWaterCode;
	/**
	 * 支付金额
	 */
	private BigDecimal amount;
	/**
	 * 支付日期
	 */
	private String payDate;
	
	/**
	 * 售后退款订单ID
	 */
	private String asorderId;
	
	/**
	 * 退款订单编码
	 */
	private String orderCode;
	
	/**
	 * 申请单号
	 */
	private String applyCode;
	
	/**
	 * 支付方式:1线上支付,2线下支付
	 */
	private int payWay;
	/**
	 * 支付类型:1供应商支付,2运营平台支付,3宝宝店支付
	 */
	private int payType;
	
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getApplyCode() {
		return applyCode;
	}
	public void setApplyCode(String applyCode) {
		this.applyCode = applyCode;
	}
	public int getPayWay() {
		return payWay;
	}
	public void setPayWay(int payWay) {
		this.payWay = payWay;
	}
	public int getPayType() {
		return payType;
	}
	public void setPayType(int payType) {
		this.payType = payType;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPayWaterCode() {
		return payWaterCode;
	}
	public void setPayWaterCode(String payWaterCode) {
		this.payWaterCode = payWaterCode;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public String getAsorderId() {
		return asorderId;
	}
	public void setAsorderId(String asorderId) {
		this.asorderId = asorderId;
	}
	
}
