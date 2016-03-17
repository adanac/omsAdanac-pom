package com.adanac.b2b.oms.order.service.saleorder;

import java.util.List;

import com.adanac.b2b.oms.order.dto.DeliveryTraceDto;

/**
 * 物流跟踪服务接口
 */
public interface DeliveryTraceService {

	/**
	 * 创建物流跟踪信息
	 * @param deliveryTrace 物流跟踪信息
	 * @return 主键
	 */
	public String createDeliveryTrace(DeliveryTraceDto deliveryTrace);

	/**
	 * 根据订单ID查询物流跟踪信息列表
	 * @param orderId 订单ID
	 * @return 物流跟踪信息列表
	 */
	public List<DeliveryTraceDto> listByOrderyId(String orderId);

}
