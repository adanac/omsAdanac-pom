package com.adanac.b2b.oms.order.baseservice.saleorder;

import com.adanac.b2b.oms.order.bo.InvoiceReqBo;

/*
 * 发票要求基础服务接口
 */
public interface InvoiceReqBaseService {
	/**
	 * 创建发票要求信息
	 * @param invoiceReq 发票要求信息
	 * @return 主键
	 */
	public String createInvoiceReq(InvoiceReqBo invoiceReq);

}
