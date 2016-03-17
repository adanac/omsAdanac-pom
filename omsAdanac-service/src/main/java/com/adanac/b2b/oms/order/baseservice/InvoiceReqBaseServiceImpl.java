package com.adanac.b2b.oms.order.baseservice;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adanac.b2b.oms.dao.BaseDao;
import com.adanac.b2b.oms.order.baseservice.saleorder.InvoiceReqBaseService;
import com.adanac.b2b.oms.order.bo.InvoiceReqBo;
import com.adanac.b2b.oms.utils.uuid.DefaultSequenceGenerator;
import com.adanac.framework.exception.SysException;
import com.adanac.framework.log.MyLogger;
import com.adanac.framework.log.MyLoggerFactory;
import com.adanac.framework.utils.DateUtils;

@Service("invoiceReqBaseServiceImpl")
public class InvoiceReqBaseServiceImpl implements InvoiceReqBaseService {

	@Autowired
	private BaseDao baseDao;

	private MyLogger log = MyLoggerFactory.getLogger(InvoiceReqBaseServiceImpl.class);

	@Override
	public String createInvoiceReq(InvoiceReqBo invoiceReq) {
		try {
			String id = DefaultSequenceGenerator.getInstance().uuid();

			invoiceReq.setId(id);
			invoiceReq.setCreateTime(DateUtils.format(new Date(), DateUtils.DEFAULT_YEAR_MONTH_DAY_HMS));
			invoiceReq.setUpdateTime(invoiceReq.getCreateTime());

			baseDao.execute("invoice_requirement.createInvoiceReq", invoiceReq);

			return id;

		} catch (Exception e) {
			log.error("InvoiceReqServiceImpl-->createInvoiceReq-->invoiceReq: " + invoiceReq + e);
			throw new SysException("创建发票要求信息失败", e);
		}
	}

}
