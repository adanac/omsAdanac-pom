package com.adanac.b2b.oms.order.baseservice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adanac.b2b.oms.dao.BaseDao;
import com.adanac.b2b.oms.order.baseservice.saleorder.DeliveryReqBaseService;
import com.adanac.b2b.oms.order.bo.DeliveryReqBo;
import com.adanac.b2b.oms.order.dto.DeliveryReqDto;
import com.adanac.b2b.oms.utils.uuid.DefaultSequenceGenerator;
import com.adanac.framework.log.MyLogger;
import com.adanac.framework.log.MyLoggerFactory;
import com.adanac.framework.utils.DateUtils;

@Service("deliveryReqBaseServiceImpl")
public class DeliveryReqBaseServiceImpl implements DeliveryReqBaseService {

	@Autowired
	private BaseDao baseDao;

	private MyLogger log = MyLoggerFactory.getLogger(DeliveryReqBaseServiceImpl.class);

	@Override
	public String createDeliveryReq(DeliveryReqBo deliveryReq) {
		String id = DefaultSequenceGenerator.getInstance().uuid();

		deliveryReq.setId(id);
		deliveryReq.setCreateTime(DateUtils.format(new Date(), DateUtils.DEFAULT_YEAR_MONTH_DAY_HMS));
		deliveryReq.setUpdateTime(deliveryReq.getCreateTime());

		baseDao.execute("order_delivery_require.createDeliveryReq", deliveryReq);

		return id;
	}

	@Override
	public DeliveryReqDto findByOrderId(String orderId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderIid", orderId);
		return baseDao.queryForObject("order_delivery_require.findByOrderId", map, DeliveryReqDto.class);
	}

	@Override
	public Boolean updateDeliveryReq(DeliveryReqBo deliveryReq) {
		deliveryReq.setUpdateTime(DateUtils.format(new Date(), DateUtils.DEFAULT_YEAR_MONTH_DAY_HMS));
		int rslt = baseDao.execute("order_delivery_require.updateDeliveryReq", deliveryReq);
		if (rslt > 0) {
			return true;
		}
		return false;
	}

}
