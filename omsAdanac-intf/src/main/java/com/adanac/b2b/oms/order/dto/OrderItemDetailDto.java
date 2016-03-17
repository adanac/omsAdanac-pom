package com.adanac.b2b.oms.order.dto;

import java.io.Serializable;
import java.util.List;

import com.adanac.b2b.oms.order.bo.OrderItemBo;
import com.adanac.b2b.oms.order.bo.OrderItemDiscountBo;

/**
 * 订单详细信息类（订单项+订单项优惠）
 * @author adanac
 * @version 1.0
 */
public class OrderItemDetailDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3068323964179295802L;
	/**
	 * 订单项
	 */
	private OrderItemBo orderItem;
	/**
	 * 订单项优惠信息
	 */
	private List<OrderItemDiscountBo> orderItemDiscounts;

	public OrderItemBo getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(OrderItemBo orderItem) {
		this.orderItem = orderItem;
	}

	public List<OrderItemDiscountBo> getOrderItemDiscounts() {
		return orderItemDiscounts;
	}

	public void setOrderItemDiscounts(List<OrderItemDiscountBo> orderItemDiscounts) {
		this.orderItemDiscounts = orderItemDiscounts;
	}

}
