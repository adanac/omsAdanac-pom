package com.adanac.b2b.oms.order.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class AfterSaleOrderItemDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8919834311457876401L;

	/**
	 * 售后订单项ID
	 */
	private String asOrderItemId;
	
	/**
	 * 售后订单项编码
	 */
	private String asOrderItemCode;
	
	/**
	 * 售后订单ID
	 */
	private String asOrderId;
	
	/**
	 * 商品ID
	 */
	private String fskuid;
	
	/**
	 * 商品名称
	 */
	private String productType;
	
	/**
	 * 商品类型
	 */
	private String productName; 
	
	/**
	 * 商品数量
	 */
	private Integer number; 
	
	/**
	 * 商品售价
	 */
	private BigDecimal referPrice; 
	
	/**
	 * 销售单价
	 */
	private BigDecimal realPrice;
	
	/**
	 * 销售金额
	 */
	private BigDecimal saleAmount;
	
	/**
	 * 自动折扣折让
	 */
	private BigDecimal autoDiscount;
	
	/**
	 * 手工折扣折让
	 */
	private BigDecimal manualDiscount;
	/**
	 * 销项税金
	 */
	private BigDecimal saleTax;
	
	/**
	 * 商品税率
	 */
	private BigDecimal taxRate;
	
	/**
	 * 商品快照
	 */
	private Integer fskusnapversion;
	
	/**
	 * 留言
	 */
	private String comment;
	
	/**
	 * 销售订单项ID
	 */
	private String saleOrderItemId;
	
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

	public String getAsOrderItemId() {
		return asOrderItemId;
	}

	public void setAsOrderItemId(String asOrderItemId) {
		this.asOrderItemId = asOrderItemId;
	}

	public String getAsOrderItemCode() {
		return asOrderItemCode;
	}

	public void setAsOrderItemCode(String asOrderItemCode) {
		this.asOrderItemCode = asOrderItemCode;
	}

	public String getAsOrderId() {
		return asOrderId;
	}

	public void setAsOrderId(String asOrderId) {
		this.asOrderId = asOrderId;
	}

	public String getFskuid() {
		return fskuid;
	}

	public void setFskuid(String fskuid) {
		this.fskuid = fskuid;
	}


	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public BigDecimal getReferPrice() {
		return referPrice;
	}

	public void setReferPrice(BigDecimal referPrice) {
		this.referPrice = referPrice;
	}

	public BigDecimal getRealPrice() {
		return realPrice;
	}

	public void setRealPrice(BigDecimal realPrice) {
		this.realPrice = realPrice;
	}

	public BigDecimal getSaleAmount() {
		return saleAmount;
	}

	public void setSaleAmount(BigDecimal saleAmount) {
		this.saleAmount = saleAmount;
	}

	public BigDecimal getAutoDiscount() {
		return autoDiscount;
	}

	public void setAutoDiscount(BigDecimal autoDiscount) {
		this.autoDiscount = autoDiscount;
	}

	public BigDecimal getManualDiscount() {
		return manualDiscount;
	}

	public void setManualDiscount(BigDecimal manualDiscount) {
		this.manualDiscount = manualDiscount;
	}

	public BigDecimal getSaleTax() {
		return saleTax;
	}

	public void setSaleTax(BigDecimal saleTax) {
		this.saleTax = saleTax;
	}

	public BigDecimal getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}

	public Integer getFskusnapversion() {
		return fskusnapversion;
	}

	public void setFskusnapversion(Integer fskusnapversion) {
		this.fskusnapversion = fskusnapversion;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getSaleOrderItemId() {
		return saleOrderItemId;
	}

	public void setSaleOrderItemId(String saleOrderItemId) {
		this.saleOrderItemId = saleOrderItemId;
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
