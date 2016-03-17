package com.adanac.b2b.oms.order.service.saleorder;

import java.util.List;

import com.adanac.b2b.oms.order.dto.OrderItemDto;

/**
 * 订单项服务接口
 * @author adanac
 * @version 1.0
 */
public interface SaleOrderItemService {

	// ===================================查询业务=================================//

	/**
	 * 查询指定的订单下的订单项
	 * @param orderId 订单的ID
	 * @return 订单项列表
	 */
	public List<OrderItemDto> listByOrderId(String orderId);

	/**
	 * 根据订单项ID查询订单项
	 * @param itemId 订单项ID
	 * @return 订单项
	 */
	public OrderItemDto findById(String itemId);
}
