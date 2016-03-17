package com.adanac.b2b.oms.order.baseservice.saleorder;

import java.util.List;

import com.adanac.b2b.oms.order.bo.OrderItemDiscountBo;

/**
 * 订单项优惠基础服务接口
 * @author adanac
 * @version 1.0
 */
public interface SaleOrderItemDiscountBaseService {
	/**
	 * 创建订单项优惠信息
	 * @param discount 订单项优惠信息
	 * @return 主键
	 */
	public String createOrderItemDiscount(OrderItemDiscountBo discount);

	/**
	 * 批量创建指定订单项的优惠信息
	 * @param itemId 订单项ID
	 * @param discounts 订单项优惠列表
	 * @return 成功创建个数
	 */
	public Integer createOrderItemDiscounts(String itemId, List<OrderItemDiscountBo> discounts);

	/**
	 * 根据订单项ID查询订单项优惠信息列表
	 * @param itemId 订单项ID
	 * @return 订单项列表
	 */
	public List<OrderItemDiscountBo> listByOrderItemId(String itemId);

}
