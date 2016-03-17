package com.adanac.b2b.oms.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adanac.b2b.oms.dao.BaseDao;
import com.adanac.b2b.oms.order.baseservice.saleorder.DeliveryTraceBaseService;
import com.adanac.b2b.oms.order.bo.DeliveryTraceBo;
import com.adanac.b2b.oms.order.dto.DeliveryTraceDto;
import com.adanac.b2b.oms.order.service.saleorder.DeliveryTraceService;
import com.adanac.framework.exception.SysException;
import com.adanac.framework.log.MyLogger;
import com.adanac.framework.log.MyLoggerFactory;

@Service("deliveryTraceServiceImpl")
@com.alibaba.dubbo.config.annotation.Service(protocol = { "dubbo" })
public class DeliveryTraceServiceImpl implements DeliveryTraceService {

	@Autowired
	private BaseDao baseDao;

	@Autowired
	DeliveryTraceBaseService deliveryTraceBaseService;

	private MyLogger log = MyLoggerFactory.getLogger(DeliveryTraceServiceImpl.class);

	@Transactional
	@Override
	public String createDeliveryTrace(DeliveryTraceDto deliveryTrace) {
		try {
			DeliveryTraceBo bo = new DeliveryTraceBo(deliveryTrace);
			return deliveryTraceBaseService.createDeliveryTrace(bo);

		} catch (Exception e) {
			log.error("DeliveryTraceServiceImpl-->createDeliveryTrace-->deliveryTrace: " + deliveryTrace + e);
			throw new SysException("创建物流跟踪信息失败", e);
		}
	}

	@Override
	public List<DeliveryTraceDto> listByOrderyId(String orderId) {
		try {
			return deliveryTraceBaseService.listByOrderyId(orderId);
		} catch (Exception e) {
			log.error("DeliveryTraceServiceImpl-->listByOrderyId-->orderId: " + orderId + e);
			throw new SysException("根据订单ID查询物流跟踪信息列表", e);
		}
	}

}
