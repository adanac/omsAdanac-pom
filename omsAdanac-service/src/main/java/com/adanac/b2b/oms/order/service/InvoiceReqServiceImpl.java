package com.adanac.b2b.oms.order.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adanac.b2b.oms.dao.BaseDao;
import com.adanac.b2b.oms.order.dto.InvoiceReqDto;
import com.adanac.b2b.oms.order.service.saleorder.InvoiceReqService;
import com.adanac.framework.exception.SysException;
import com.adanac.framework.log.MyLogger;
import com.adanac.framework.log.MyLoggerFactory;

@Service("InvoiceReqServiceImpl")
@com.alibaba.dubbo.config.annotation.Service(protocol = { "dubbo" })
public class InvoiceReqServiceImpl implements InvoiceReqService {

	@Autowired
	private BaseDao baseDao;

	private MyLogger log = MyLoggerFactory.getLogger(InvoiceReqServiceImpl.class);

	@Override
	public InvoiceReqDto findByOrderId(String orderId) {
		try {
			Map<String, Object> temp = new HashMap<String, Object>();
			temp.put("orderId", orderId);
			return baseDao.queryForObject("invoice_requirement.findByOrderId", temp, InvoiceReqDto.class);
		} catch (Exception e) {
			log.error("InvoiceReqServiceImpl-->findByOrderId-->orderId: " + orderId + e);
			throw new SysException("", e);
		}
	}

	@Override
	public InvoiceReqDto findById(String InvRqrmntId) {
		return null;
	}

}
