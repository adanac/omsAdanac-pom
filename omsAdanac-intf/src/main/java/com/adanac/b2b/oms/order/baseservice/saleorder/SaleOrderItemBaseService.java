package com.adanac.b2b.oms.order.baseservice.saleorder;

import java.math.BigDecimal;
import java.util.List;

import com.adanac.b2b.oms.order.bo.OrderItemBo;
import com.adanac.b2b.oms.order.dto.OrderItemDto;

/**
 * 订单项基础服务接口
 * @author adanac
 * @version 1.0
 */
public interface SaleOrderItemBaseService {
	/**
	 * 创建订单项
	 * @param orderItem 订单项
	 * @return 主键
	 */
	public String createOrderItem(OrderItemBo orderItem);

	/**
	 * 根据订单项设定订单项已评论
	 * @param itemId 订单项ID
	 * @param userId 用户ID
	 * @return
	 */
	public Boolean evaluateById(String itemId, String userId);

	/**
	 * 更新原始订单项中的退货数量及金额
	 * @param itemId 原始订单项ID
	 * @param number 实际退货数量
	 * @param amount 实际退款金额
	 * @return 无返回值
	 */
	public void modifyAfterSaleData(String itemId, int number, BigDecimal amount, String userId);

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
