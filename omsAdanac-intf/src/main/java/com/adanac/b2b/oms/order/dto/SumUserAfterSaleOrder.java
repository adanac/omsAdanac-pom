package com.adanac.b2b.oms.order.dto;

import java.io.Serializable;

public class SumUserAfterSaleOrder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6225666768077661031L;
	/**
	 * 用户ID
	 */
	private String userId;
	/**
	 * 订单状态
	 */
	private String orderStatus;
	/**
	 * 订单类型
	 */
	private String orderType;
	/**
	 * 订单数量
	 */
	private String orders;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getOrders() {
		return orders;
	}
	public void setOrders(String orders) {
		this.orders = orders;
	}
}
