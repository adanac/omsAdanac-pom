package com.adanac.b2b.oms.order.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class AfterSaleApplyItemDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8919834311457876401L;
	/**
	 * 申请项ID
	 */
	private String id;
	/**
	 * 订单项ID
	 */
	private String itemId;
	/**
	 * 售后申请ID
	 */
	private String applyId; 
	/**
	 * 商品子码
	 */
	private String fskuid; 
	
	/**
	 * 商品名称
	 */
	private String productName; 
	
	/**
	 * 退货数量
	 */
	private Integer number;  
	/**
	 * 退款金额
	 */
	private BigDecimal amount; 
	/**
	 * 创建时间
	 */
	private String createTime;
	/**
	 * 最后更新时间
	 */
	private String updateTime; 
	/**
	 * 最后更新人ID
	 */
	private String lastOperator;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}


	public String getApplyId() {
		return applyId;
	}


	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}


	public String getFskuid() {
		return fskuid;
	}


	public void setFskuid(String fskuid) {
		this.fskuid = fskuid;
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

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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

	@Override
	public String toString() {
		return "AfterSaleApplyItem{" +
				"id='" + id + '\'' +
				", itemId='" + itemId + '\'' +
				", applyId='" + applyId + '\'' +
				", fskuid='" + fskuid + '\'' +
				", number=" + number +
				", amount=" + amount +
				", createTime='" + createTime + '\'' +
				", updateTime='" + updateTime + '\'' +
				", lastOperator='" + lastOperator + '\'' +
				'}';
	}
}
