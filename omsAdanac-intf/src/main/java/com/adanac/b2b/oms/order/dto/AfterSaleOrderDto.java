package com.adanac.b2b.oms.order.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class AfterSaleOrderDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3331688220743998252L;
	
	/**
	 * 售后订单ID
	 */
	private String asOrderId;
	
	/**
	 * 售后订单编号:年+月+日+供应商编码+三位流水
	 */
	private String asOrderCode;
	
	/**
	 * 售后类型:1整单退款2售后退款3售后退货4拒收
	 */
	private Integer type;
	
	/**
	 * 售后订单状态 
	 */
	private Integer status;

	/**
	 * 售后申请状态 
	 */
	private Integer applyStatus;
	
	/**
	 * 售后申请ID
	 */
	private String asApplyId; 
	
	/**
	 * 销售子订单ID
	 */
	private String saleOrderId; 
	
	/**
	 * 客户ID
	 */
	private String userId; 
	
	/**
	 * 商户ID
	 */
	private String merchantId;
	
	/**
	 * 供应商ID
	 */
	private String supplierId;
	
	/**
	 * 供应商名称
	 */
	private String supplierName;
	
	/**
	 * 订单总额:实际支付金额，运费金额+销售金额
	 */
	private BigDecimal totalMoney;
	
	/**
	 * 运费金额
	 */
	private BigDecimal freightMoney;
	
	/**
	 * 销售金额（含税）:销售金额，订单行的销售金额之和
	 */
	private BigDecimal productMoney;
	
	/**
	 * 手工折扣折让:优惠金额，订单行的优惠金额之和
	 */
	private BigDecimal manualDiscount;
	
	/**
	 * 自动折扣折让
	 */
	private BigDecimal autoDiscount;
	
	/**
	 * 渠道:0：手机、1：pad
	 */
	private Integer channel;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 创建人 
	 */
	private String createUser;
	
	/**
	 * 创建时间
	 */
	private String createTime;
	
	/**
	 * 更新时间
	 */
	private String updateTime;
	
	/**
	 * 最后更新人
	 */
	private String lastOperator;
	
	/**
	 * 关闭类型:0：系统关闭1:自己关闭
	 */
	private Integer closeType;
	
	/**
	 * 关闭原因
	 */
	private String closeReson;
	
	/**
	 * 关闭时间
	 */
	private String closeTime;

	/**
	 * 退款人ID
	 */
	private String refundUser;
	
	/**
	 * 退款时间
	 */
	private String refundTime;
	
	/**
	 * 取消人ID
	 */
	private String cancleUser;
	
	/**
	 * 取消时间
	 */
	private String cancleTime;
	
	/**
	 * 退款时间
	 */
	private String payTime;
	
	/**
	 * 退款方式
	 */
	private Integer payBank;
	
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getAsApplyId() {
		return asApplyId;
	}

	public void setAsApplyId(String asApplyId) {
		this.asApplyId = asApplyId;
	}

	public String getSaleOrderId() {
		return saleOrderId;
	}

	public void setSaleOrderId(String saleOrderId) {
		this.saleOrderId = saleOrderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}

	public BigDecimal getFreightMoney() {
		return freightMoney;
	}

	public void setFreightMoney(BigDecimal freightMoney) {
		this.freightMoney = freightMoney;
	}

	public BigDecimal getProductMoney() {
		return productMoney;
	}

	public void setProductMoney(BigDecimal productMoney) {
		this.productMoney = productMoney;
	}

	public BigDecimal getManualDiscount() {
		return manualDiscount;
	}

	public void setManualDiscount(BigDecimal manualDiscount) {
		this.manualDiscount = manualDiscount;
	}

	public BigDecimal getAutoDiscount() {
		return autoDiscount;
	}

	public void setAutoDiscount(BigDecimal autoDiscount) {
		this.autoDiscount = autoDiscount;
	}

	public Integer getChannel() {
		return channel;
	}

	public void setChannel(Integer channel) {
		this.channel = channel;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
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

	public Integer getCloseType() {
		return closeType;
	}

	public void setCloseType(Integer closeType) {
		this.closeType = closeType;
	}

	public String getCloseReson() {
		return closeReson;
	}

	public void setCloseReson(String closeReson) {
		this.closeReson = closeReson;
	}

	public String getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}

	public String getRefundUser() {
		return refundUser;
	}

	public void setRefundUser(String refundUser) {
		this.refundUser = refundUser;
	}

	public String getRefundTime() {
		return refundTime;
	}

	public void setRefundTime(String refundTime) {
		this.refundTime = refundTime;
	}

	public String getCancleUser() {
		return cancleUser;
	}

	public void setCancleUser(String cancleUser) {
		this.cancleUser = cancleUser;
	}

	public String getCancleTime() {
		return cancleTime;
	}

	public void setCancleTime(String cancleTime) {
		this.cancleTime = cancleTime;
	}

	public Integer getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(Integer applyStatus) {
		this.applyStatus = applyStatus;
	}
	
}
