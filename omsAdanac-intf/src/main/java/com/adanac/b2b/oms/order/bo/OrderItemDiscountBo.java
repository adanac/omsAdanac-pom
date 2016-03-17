package com.adanac.b2b.oms.order.bo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单项优惠类
 * @author adanac
 * @version 1.0
 */
public class OrderItemDiscountBo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3102210232533972553L;

	private String id;
	private String promotionId;
	private Integer prmtType;
	private String activity;
	private String distcountType;
	private String discountDesc;
	private BigDecimal prmtAmount;
	private String orderItemId;
	private String createTime;
	private String updateTime;
	private String lastOperator;
	private String fskuid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(String promotionId) {
		this.promotionId = promotionId;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getDistcountType() {
		return distcountType;
	}

	public void setDistcountType(String distcountType) {
		this.distcountType = distcountType;
	}

	public String getDiscountDesc() {
		return discountDesc;
	}

	public void setDiscountDesc(String discountDesc) {
		this.discountDesc = discountDesc;
	}

	public String getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
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

	public String getFskuid() {
		return fskuid;
	}

	public void setFskuid(String fskuid) {
		this.fskuid = fskuid;
	}

	public Integer getPrmtType() {
		return prmtType;
	}

	public void setPrmtType(Integer prmtType) {
		this.prmtType = prmtType;
	}

	public BigDecimal getPrmtAmount() {
		return prmtAmount;
	}

	public void setPrmtAmount(BigDecimal prmtAmount) {
		this.prmtAmount = prmtAmount;
	}
}
