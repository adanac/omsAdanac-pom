package com.adanac.b2b.oms.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adanac.b2b.oms.order.baseservice.saleorder.DeliveryReqBaseService;
import com.adanac.b2b.oms.order.bo.DeliveryReqBo;
import com.adanac.b2b.oms.order.dto.DeliveryReqDto;
import com.adanac.b2b.oms.order.service.saleorder.DeliveryReqService;
import com.adanac.framework.exception.SysException;
import com.adanac.framework.log.MyLogger;
import com.adanac.framework.log.MyLoggerFactory;

@Service("deliveryReqServiceImpl")
@com.alibaba.dubbo.config.annotation.Service(protocol = { "dubbo" })
public class DeliveryReqServiceImpl implements DeliveryReqService {
	@Autowired
	DeliveryReqBaseService deliveryReqBaseService;

	private MyLogger log = MyLoggerFactory.getLogger(DeliveryReqServiceImpl.class);

	@Transactional
	@Override
	public String createDeliveryReq(DeliveryReqDto deliveryReq) {
		try {
			return deliveryReqBaseService.createDeliveryReq(new DeliveryReqBo(deliveryReq));
		} catch (Exception e) {
			log.error("DeliveryReqServiceImpl-->createDeliveryReq-->deliveryReq: " + deliveryReq + e);
			throw new SysException("创建发货要求信息失败", e);
		}
	}

	@Override
	public DeliveryReqDto findByOrderId(String orderId) {
		try {

			return deliveryReqBaseService.findByOrderId(orderId);
		} catch (Exception e) {
			log.error("DeliveryReqServiceImpl-->findByOrderId-->orderId: " + orderId + e);
			throw new SysException("根据订单ID查询发货要求信息失败", e);
		}
	}

	@Override
	public Boolean updateDeliveryReq(DeliveryReqDto deliveryReq) {
		try {
			return deliveryReqBaseService.updateDeliveryReq(new DeliveryReqBo(deliveryReq));
		} catch (Exception e) {
			log.error("DeliveryReqServiceImpl-->updateDeliveryReq-->deliveryReq: " + deliveryReq + e);
			throw new SysException("更新发货要求信息失败", e);
		}
	}

}
