package com.adanac.b2b.oms.order.baseservice;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adanac.b2b.oms.dao.BaseDao;
import com.adanac.b2b.oms.order.baseservice.saleorder.DeliveryTraceBaseService;
import com.adanac.b2b.oms.order.bo.DeliveryTraceBo;
import com.adanac.b2b.oms.order.dto.DeliveryTraceDto;
import com.adanac.b2b.oms.utils.uuid.DefaultSequenceGenerator;
import com.adanac.framework.log.MyLogger;
import com.adanac.framework.log.MyLoggerFactory;
import com.adanac.framework.utils.DateUtils;

@Service("DeliveryTraceBaseServiceImpl")
public class DeliveryTraceBaseServiceImpl implements DeliveryTraceBaseService {

	@Autowired
	private BaseDao baseDao;

	private MyLogger log = MyLoggerFactory.getLogger(DeliveryTraceBaseServiceImpl.class);

	@Override
	public String createDeliveryTrace(DeliveryTraceBo deliveryTrace) {
		String id = DefaultSequenceGenerator.getInstance().uuid();

		deliveryTrace.setId(id);
		deliveryTrace.setCreateTime(DateUtils.format(new Date(), DateUtils.DEFAULT_YEAR_MONTH_DAY_HMS));
		deliveryTrace.setUpdateTime(deliveryTrace.getCreateTime());

		baseDao.execute("delivery_trace.createDeliveryTrace", deliveryTrace);
		return id;
	}

	@Override
	public List<DeliveryTraceDto> listByOrderyId(String orderId) {
		Map<String, Object> temp = new HashMap<String, Object>();
		temp.put("orderId", orderId);
		return baseDao.queryForList("delivery_trace.listByOrderyId", temp, DeliveryTraceDto.class);
	}

}
