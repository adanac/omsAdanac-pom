package com.adanac.b2b.oms.order.service.saleorder;

import java.util.ArrayList;
import java.util.List;

import com.adanac.b2b.oms.order.dto.InvoiceDto;

/**
 * 发票服务接口 
 * @author adanac
 * @version 1.0
 */
public interface InvoiceService {

	/**
	 * 增加订单的发票,支持增加单张或多张
	 * @param invInfo 需要增加的发票信息
	 * @return 成功返回true,失败返回false
	 */
	public String addInvoice(InvoiceDto invInfo);

	// =============================查询业务========================================//

	/**
	 * 根据发票ID查询发票信息
	 * @param invId 发票的ID
	 * @return 发票信息
	 */
	public InvoiceDto findById(String invId);

	/**
	 * 根据订单ID查询该订单下的所有发票信息
	 * @param orderId 订单ID
	 * @return 发票信息列表
	 */
	public List<InvoiceDto> listByOrderId(String orderId);

	/**
	 * 修改订单发票信息
	 * @param invoice 发票信息
	 * @return 主键
	 */
	public Boolean updateInvoice(InvoiceDto invoice);

	/**
	 * （批量）删除订单发票信息
	 * @param ids 主键列表
	 * @return 主键
	 */
	public Boolean deleteInvoice(ArrayList<String> ids);
}
