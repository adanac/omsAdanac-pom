package com.adanac.b2b.oms.order.baseservice.saleorder;

import com.adanac.b2b.oms.order.bo.InvoiceBo;

/*
 * 发票基础服务接口
 */
public interface InvoiceBaseService {
	/**
	 * 创建订单发票信息
	 * @param invoice 发票信息
	 * @return 主键
	 */
	public String addInvoice(InvoiceBo invoice);

}
