package com.adanac.b2b.oms.order.dto;

import java.io.Serializable;

public class AfterSaleApplyScDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -142511046850731280L;
	/**
	 * 售后申请ID
	 */
	private String aftersaleApplyId;
	/**
	 * 售后申请编号
	 */
	private String aftersaleApplyCode;
	/**
	 * 用户ID
	 */
	private String userId; 
	/**
	 * 供应商ID
	 */
	private String supplierId; 
	/**
	 * 售后类型：0退款，1退货
	 */
	private String type;
	/**
	 * 原因类型
	 */
	private Integer reasonType; 
	/**
	 * 申请状态: 0：待审批2：同意3：驳回4：客服介入5：关闭
	 */
	private String status;
	/**
	 * 关闭时间
	 */
	private String closeTimeStart;
	/**
	 * 关闭时间
	 */
	private String closeTimeEnd;
	/**
	 * 创建时间
	 */
	private String createTimeStart;
	/**
	 * 创建时间
	 */
	private String createTimeEnd;
	
	/**
	 * 订单ID
	 */
	private String orderId;
	
	/**
	 * 申请状态以逗号分开的多值
	 */
	private String statuses;
	/**
	 * 申请类型以逗号分开的多值
	 */
	private String types;
	
	/**
	 * 支付类型
	 */
	private String payBank;
	
	/**
	 * 支付时间
	 */
	private String payStartTime;
	
	/**
	 * 支付时间
	 */
	private String payEndTime;
	
	/**
	 * 支付时间
	 */
	private String hasPay;
	
	public String getAftersaleApplyCode() {
		return aftersaleApplyCode;
	}
	public void setAftersaleApplyCode(String aftersaleApplyCode) {
		this.aftersaleApplyCode = aftersaleApplyCode;
	}
	public String getStatuses() {
		return statuses;
	}
	public void setStatuses(String statuses) {
		this.statuses = statuses;
	}
	public String getTypes() {
		return types;
	}
	public void setTypes(String types) {
		this.types = types;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getAftersaleApplyId() {
		return aftersaleApplyId;
	}
	public void setAftersaleApplyId(String aftersaleApplyId) {
		this.aftersaleApplyId = aftersaleApplyId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getReasonType() {
		return reasonType;
	}
	public void setReasonType(Integer reasonType) {
		this.reasonType = reasonType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCloseTimeStart() {
		return closeTimeStart;
	}
	public void setCloseTimeStart(String closeTimeStart) {
		this.closeTimeStart = closeTimeStart;
	}
	public String getCloseTimeEnd() {
		return closeTimeEnd;
	}
	public void setCloseTimeEnd(String closeTimeEnd) {
		this.closeTimeEnd = closeTimeEnd;
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
	public String getPayBank() {
		return payBank;
	}
	public void setPayBank(String payBank) {
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
	public String getHasPay() {
		return hasPay;
	}
	public void setHasPay(String hasPay) {
		this.hasPay = hasPay;
	}
	
}
