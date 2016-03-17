package com.adanac.b2b.oms.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adanac.b2b.oms.order.baseservice.saleorder.SaleOrderItemBaseService;
import com.adanac.b2b.oms.order.dto.OrderItemDto;
import com.adanac.b2b.oms.order.service.saleorder.SaleOrderItemService;
import com.adanac.framework.exception.SysException;
import com.adanac.framework.log.MyLogger;
import com.adanac.framework.log.MyLoggerFactory;

@Service("saleOrderItemServiceImpl")
@com.alibaba.dubbo.config.annotation.Service(protocol = { "dubbo" })
public class SaleOrderItemServiceImpl implements SaleOrderItemService {

	@Autowired
	SaleOrderItemBaseService orderItemBaseService;

	private MyLogger log = MyLoggerFactory.getLogger(SaleOrderItemServiceImpl.class);

	@Override
	public List<OrderItemDto> listByOrderId(String orderId) {
		try {
			return orderItemBaseService.listByOrderId(orderId);
		} catch (Exception e) {
			log.error("OrderItemServiceImpl-->listByOrderId-->orderId: " + orderId + e);
			throw new SysException("查询指定的订单下的订单项失败", e);
		}
	}

	@Override
	public OrderItemDto findById(String itemId) {
		try {
			return orderItemBaseService.findById(itemId);
		} catch (Exception e) {
			log.error("OrderItemServiceImpl-->findById-->itemId: " + itemId + e);
			throw new SysException("根据订单项ID查询订单项失败", e);
		}
	}

}
