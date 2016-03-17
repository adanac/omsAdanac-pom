package com.adanac.b2b.oms.order.baseservice;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adanac.b2b.oms.dao.BaseDao;
import com.adanac.b2b.oms.order.baseservice.saleorder.InvoiceBaseService;
import com.adanac.b2b.oms.order.bo.InvoiceBo;
import com.adanac.b2b.oms.utils.uuid.DefaultSequenceGenerator;
import com.adanac.framework.log.MyLogger;
import com.adanac.framework.log.MyLoggerFactory;
import com.adanac.framework.utils.DateUtils;

@Service("invoiceBaseServiceImpl")
public class InvoiceBaseServiceImpl implements InvoiceBaseService {

	@Autowired
	private BaseDao baseDao;

	private MyLogger log = MyLoggerFactory.getLogger(InvoiceBaseServiceImpl.class);

	@Override
	public String addInvoice(InvoiceBo invoice) {
		String id = DefaultSequenceGenerator.getInstance().uuid();

		invoice.setId(id);
		invoice.setCreateTime(DateUtils.format(new Date(), DateUtils.DEFAULT_YEAR_MONTH_DAY_HMS));
		invoice.setUpdateTime(invoice.getCreateTime());

		baseDao.execute("order_invoice.createInvoice", invoice);

		return id;
	}

}
