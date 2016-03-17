package com.adanac.b2b.oms.order.service.saleorder;

import com.adanac.b2b.oms.order.dto.InvoiceReqDto;

/**
 * 发票要求服务接口
 * @author adanac
 * @version 1.0
 */
public interface InvoiceReqService {
	// ===============查询业务==========================================//

	/**
	 * 根据订单ID查询该订单的发票要求信息
	 * @param orderId 订单ID
	 * @return 发票要求信息
	 */
	public InvoiceReqDto findByOrderId(String orderId);

	/**
	 * 根据发票要求信息ID查询发票要求信息
	 * @param InvoiceReqId 发票要求信息ID
	 * @return 发票要求信息
	 */
	public InvoiceReqDto findById(String InvoiceReqId);
}
