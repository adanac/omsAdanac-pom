package com.adanac.b2b.oms.order.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ReturnOrderItemDto  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 原订单ID
	 */
	private String orgOrderId;
	
	/**
	 * 订单项ID
	 */
	private String orderItemId;
	
	/**
	 * 退货金额
	 */
	private BigDecimal returnMoney;
	
	/**
	 * 退货数量
	 */
	private Integer returnCount;
	
	/**
	 *退货商品skuid 
	 */
	private String returnSkuid;
	
	/**
	 *图片地址,多个用,分割
	 */
	private String picUrl;
	
	/**
	 *图片描述
	 */
	private String picremark;
	
	/**
	 *当前用户ID
	 */
	private String userId;
	
	/**
	 *退款说明
	 */
	private String remark;
	
	/**
	 *售后原因说明
	 */
	private String reason;
	
	/**
	 *售后原因类型
	 */
	private Integer reasonType;
	
	/**
	 *物流公司
	 */
	private String lgsCompanyCode;
	
	/**
	 *物流单号
	 */
	private String waybillCode;
	
	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getPicremark() {
		return picremark;
	}

	public void setPicremark(String picremark) {
		this.picremark = picremark;
	}

	public String getOrgOrderId() {
		return orgOrderId;
	}

	public void setOrgOrderId(String orgOrderId) {
		this.orgOrderId = orgOrderId;
	}

	public String getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}

	public BigDecimal getReturnMoney() {
		return returnMoney;
	}

	public void setReturnMoney(BigDecimal returnMoney) {
		this.returnMoney = returnMoney;
	}

	public Integer getReturnCount() {
		return returnCount;
	}

	public void setReturnCount(Integer returnCount) {
		this.returnCount = returnCount;
	}

	public String getReturnSkuid() {
		return returnSkuid;
	}

	public void setReturnSkuid(String returnSkuid) {
		this.returnSkuid = returnSkuid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getReasonType() {
		return reasonType;
	}

	public void setReasonType(Integer reasonType) {
		this.reasonType = reasonType;
	}

	public String getLgsCompanyCode() {
		return lgsCompanyCode;
	}

	public void setLgsCompanyCode(String lgsCompanyCode) {
		this.lgsCompanyCode = lgsCompanyCode;
	}

	public String getWaybillCode() {
		return waybillCode;
	}

	public void setWaybillCode(String waybillCode) {
		this.waybillCode = waybillCode;
	}
	
}
