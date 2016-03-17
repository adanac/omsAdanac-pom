package com.adanac.b2b.oms.order.service.saleorder;

import com.adanac.b2b.oms.order.dto.DeliveryReqDto;

/**
 * 发货要求服务接口
 * @author adanac
 * @version 1.0
 */
public interface DeliveryReqService {

	/**
	 * 创建发货要求信息
	 * @param deliveryReq 发货要求信息
	 * @return 主键
	 */
	public String createDeliveryReq(DeliveryReqDto deliveryReq);

	/**
	 * 更新发货要求信息
	 * @param deliveryReq 发货要求信息
	 * @return 成功true;失败false
	 */
	public Boolean updateDeliveryReq(DeliveryReqDto deliveryReq);

	/**
	 * 根据订单ID查询发货要求信息
	 * @param orderId 订单ID
	 * @return 发货要求信息
	 */
	public DeliveryReqDto findByOrderId(String orderId);
}
