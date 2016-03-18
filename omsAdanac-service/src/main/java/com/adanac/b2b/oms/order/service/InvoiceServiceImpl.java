package com.adanac.b2b.oms.order.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adanac.b2b.oms.dao.BaseDao;
import com.adanac.b2b.oms.order.baseservice.saleorder.InvoiceBaseService;
import com.adanac.b2b.oms.order.bo.InvoiceBo;
import com.adanac.b2b.oms.order.dto.InvoiceDto;
import com.adanac.b2b.oms.order.service.saleorder.InvoiceService;
import com.adanac.b2b.oms.utils.CommonUtil;
import com.adanac.framework.exception.SysException;
import com.adanac.framework.log.MyLogger;
import com.adanac.framework.log.MyLoggerFactory;

@Component("invoiceServiceImpl")
@com.alibaba.dubbo.config.annotation.Service(protocol = { "dubbo" })
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private BaseDao baseDao;

	@Autowired
	private InvoiceBaseService invoiceBaseService;

	private MyLogger log = MyLoggerFactory.getLogger(InvoiceServiceImpl.class);

	@Override
	public String addInvoice(InvoiceDto invInfo) {
		try {
			return invoiceBaseService.addInvoice(new InvoiceBo(invInfo));
		} catch (Exception e) {
			log.error("InvoiceServiceImpl-->addInvoice: " + invInfo + e);
			throw new SysException("创建运单失败", e);
		}
	}

	@Override
	public InvoiceDto findById(String invId) {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("invoiceId", invId);
			return baseDao.queryForObject("order_invoice.findInvoiceById", paramMap, InvoiceDto.class);
		} catch (Exception e) {
			log.error("InvoiceServiceImpl-->findById-->invoiceId: " + invId + e);
			throw new SysException("根据ID查询发票信息失败", e);
		}
	}

	@Override
	public List<InvoiceDto> listByOrderId(String orderId) {
		try {
			Map<String, Object> temp = new HashMap<String, Object>();
			temp.put("orderId", orderId);
			return baseDao.queryForList("order_invoice.listByOrderId", temp, InvoiceDto.class);
		} catch (Exception e) {
			log.error("InvoiceServiceImpl-->listByOrderId-->orderId: " + orderId + e);
			throw new SysException("根据订单ID查询该订单下的所有发票信息失败", e);
		}
	}

	@Override
	public Boolean updateInvoice(InvoiceDto invoice) {
		try {
			int rst = baseDao.execute("order_invoice.updateInvoice", invoice);
			return rst > 0;
		} catch (Exception e) {
			log.error("InvoiceServiceImpl-->updateInvoice-->invoice: " + invoice + e);
			throw new SysException("修改订单发票信息失败", e);
		}
	}

	@Override
	public Boolean deleteInvoice(ArrayList<String> ids) {
		Map<String, Object> temp = new HashMap<String, Object>();
		try {
			String invoiceIds = CommonUtil.ListToString(ids);
			temp.put("invoiceIds", invoiceIds);
			int rst = baseDao.execute("order_invoice.deleteInvoice", temp);
			return rst > 0;
		} catch (Exception e) {
			log.error("InvoiceServiceImpl-->deleteInvoice-->入参: " + ids + e);
			throw new SysException("（批量）删除订单发票信息失败", e);
		}
	}

}
