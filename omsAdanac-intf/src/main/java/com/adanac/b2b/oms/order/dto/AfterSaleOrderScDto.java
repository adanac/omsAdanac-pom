package com.adanac.b2b.oms.order.dto;

import java.io.Serializable;

public class AfterSaleOrderScDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -142511046850731280L;
	
	/**
	 * 售后订单id
	 */
	private String asOrderId;
	
	/**
	 * 售后订单code
	 */
	private String asOrderCode;
	
	/**
	 * 售后类型:1整单退款2售后退款3售后退货4拒收
	 */
	private Integer type;
	
	/**
	 * 客户昵称
	 */
	private String nickName;
	
	/**
	 * 创建时间
	 */
	private String createTimeStart;
	
	/**
	 * 创建时间
	 */
	private String createTimeEnd;
	
	/**
	 * 售后订单状态 
	 */
	private Integer status;
	
	/**
	 * 售后申请状态 
	 */
	private Integer applyStatus;
	
	private String userId;
	
	/**
	 * 支付方式1:支付宝;2微信支付
	 */
	private Integer payBank;
	
	/**
	 * 退款开始时间
	 */
	private String payStartTime;
	
	/**
	 * 退款结束时间
	 */
	private String payEndTime;
	
	
	public Integer getPayBank() {
		return payBank;
	}

	public void setPayBank(Integer payBank) {
		this.payBank = payBank;
	}

	public String getPayStartTime() {
		return payStartTime;
	}

	public void setPayStartTime(String payStartTime) {
		this.payStartTime = payStartTime;
	}

	public String getPayEndTime() {
		return payEndTime;
	}

	public void setPayEndTime(String payEndTime) {
		this.payEndTime = payEndTime;
	}

	public String getAsOrderId() {
		return asOrderId;
	}

	public void setAsOrderId(String asOrderId) {
		this.asOrderId = asOrderId;
	}

	public String getAsOrderCode() {
		return asOrderCode;
	}

	public void setAsOrderCode(String asOrderCode) {
		this.asOrderCode = asOrderCode;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getCreateTimeStart() {
		return createTimeStart;
	}

	public void setCreateTimeStart(String createTimeStart) {
		this.createTimeStart = createTimeStart;
	}

	public String getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(String createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(Integer applyStatus) {
		this.applyStatus = applyStatus;
	}

}
