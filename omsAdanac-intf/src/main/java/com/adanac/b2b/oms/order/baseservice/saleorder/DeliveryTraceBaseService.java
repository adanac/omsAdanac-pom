package com.adanac.b2b.oms.order.baseservice.saleorder;

import java.util.List;

import com.adanac.b2b.oms.order.bo.DeliveryTraceBo;
import com.adanac.b2b.oms.order.dto.DeliveryTraceDto;

/**
 * 物流跟踪基础服务接口
 * @author adanac
 * @version 1.0
 */
public interface DeliveryTraceBaseService {
	/**
	 * 创建物流跟踪信息
	 * @param deliveryTrace 物流跟踪信息
	 * @return 主键
	 */
	public String createDeliveryTrace(DeliveryTraceBo deliveryTrace);

	/**
	 * 根据订单ID查询物流跟踪信息列表
	 * @param orderId 订单ID
	 * @return 物流跟踪信息列表
	 */
	public List<DeliveryTraceDto> listByOrderyId(String orderId);
}
