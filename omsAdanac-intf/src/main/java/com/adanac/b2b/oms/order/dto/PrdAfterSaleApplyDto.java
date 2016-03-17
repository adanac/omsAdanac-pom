package com.adanac.b2b.oms.order.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class PrdAfterSaleApplyDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8728644712577329035L;
	/**
	 * 售后申请编号
	 */
	private String applyId;
	/**
	 * 用户ID
	 */
	private String userId; 
	/**
	 * 供应商ID
	 */
	private String supplierId; 
	/**
	 * 售后类型：退款，退货
	 */
	private Integer type;
	/**
	 * 原因类型
	 */
	private Integer reasonType;
	/**
	 * 原因售后
	 */
	private String reason;  
	/**
	 * 售后说明
	 */
	private String interpret;
	
	/**
	 * 申请状态
	 */
	private Integer status;
	/**
	 * 关闭时间
	 */
	private String closeTime;
	/**
	 * 创建时间
	 */
	private String createTime;
	
	/**
	 * 申请编号
	 */
	private String aftersaleApplyCode;
	
	/**
	 * 订单ID
	 */
	private String orderId;
	
	/**
	 * 物流公司编码
	 */
	private String lgsCompanyName;
	
	/**
	 * 物流单号
	 */
	private String waybillCode;
	
	/**
	 * 申请售后说明
	 */
	private String remark;	
	
	/**
	 * 申请项ID
	 */
	private String applyItemId;
	
	/**
	 * 商品子码
	 */
	private String fskuid; 
	
	/**
	 * 退货数量
	 */
	private Integer number;
	
	/**
	 * 退款金额
	 */
	private BigDecimal amount;
	
	/**
	 * 订单金额
	 */
	private BigDecimal price;
	
	

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getApplyId() {
		return applyId;
	}

	public void setApplyId(String applyId) {
		this.applyId = applyId;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getReasonType() {
		return reasonType;
	}

	public void setReasonType(Integer reasonType) {
		this.reasonType = reasonType;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getInterpret() {
		return interpret;
	}

	public void setInterpret(String interpret) {
		this.interpret = interpret;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getAftersaleApplyCode() {
		return aftersaleApplyCode;
	}

	public void setAftersaleApplyCode(String aftersaleApplyCode) {
		this.aftersaleApplyCode = aftersaleApplyCode;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getLgsCompanyName() {
		return lgsCompanyName;
	}

	public void setLgsCompanyName(String lgsCompanyName) {
		this.lgsCompanyName = lgsCompanyName;
	}

	public String getWaybillCode() {
		return waybillCode;
	}

	public void setWaybillCode(String waybillCode) {
		this.waybillCode = waybillCode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getApplyItemId() {
		return applyItemId;
	}

	public void setApplyItemId(String applyItemId) {
		this.applyItemId = applyItemId;
	}

	public String getFskuid() {
		return fskuid;
	}

	public void setFskuid(String fskuid) {
		this.fskuid = fskuid;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	} 
	
	
}
