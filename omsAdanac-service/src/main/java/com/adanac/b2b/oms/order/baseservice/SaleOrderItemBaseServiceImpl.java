package com.adanac.b2b.oms.order.baseservice;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adanac.b2b.oms.dao.BaseDao;
import com.adanac.b2b.oms.order.baseservice.saleorder.SaleOrderItemBaseService;
import com.adanac.b2b.oms.order.bo.OrderItemBo;
import com.adanac.b2b.oms.order.constant.CodeConst;
import com.adanac.b2b.oms.order.dto.OrderItemDto;
import com.adanac.b2b.oms.utils.uuid.DefaultSequenceGenerator;
import com.adanac.framework.exception.SysException;
import com.adanac.framework.log.MyLogger;
import com.adanac.framework.log.MyLoggerFactory;
import com.adanac.framework.utils.DateUtils;

@Service("saleOrderItemBaseServiceImpl")
public class SaleOrderItemBaseServiceImpl implements SaleOrderItemBaseService {

	@Autowired
	private BaseDao baseDao;

	private MyLogger log = MyLoggerFactory.getLogger(SaleOrderItemBaseServiceImpl.class);

	@Override
	public String createOrderItem(OrderItemBo orderItem) {
		try {
			String id = DefaultSequenceGenerator.getInstance().uuid();
			orderItem.setEvaluated(CodeConst.OrderItemEvaluated.UNEVALUATE);// 默认未评价
			orderItem.setItemId(id);
			orderItem.setCreateTime(DateUtils.format(new Date(), DateUtils.DEFAULT_YEAR_MONTH_DAY_HMS));
			orderItem.setUpdateTime(orderItem.getCreateTime());

			int rst = baseDao.execute("order_item.createOrderItem", orderItem);
			if (rst < 1) {
				return null;
			}
			return id;
		} catch (Exception e) {
			log.error("OrderItemServiceImpl-->createOrderItem-->orderItem: " + orderItem + e);
			throw new SysException("创建订单项失败", e);
		}
	}

	@Override
	public Boolean evaluateById(String itemId, String userId) {
		try {
			Map<String, Object> temp = new HashMap<String, Object>();
			temp.put("itemId", itemId);
			temp.put("lastOperator", userId);
			temp.put("evaluated", CodeConst.OrderItemEvaluated.EVALUATED);
			temp.put("updateTime", DateUtils.format(new Date(), DateUtils.DEFAULT_YEAR_MONTH_DAY_HMS));
			int rlt = baseDao.execute("order_item.evaluateById", temp);
			return rlt != 0;
		} catch (Exception e) {
			log.error("OrderItemServiceImpl-->evaluateById-->itemId: " + itemId + e);
			throw new SysException("根据订单项设定订单项已评论失败", e);
		}
	}

	@Override
	public void modifyAfterSaleData(String itemId, int number, BigDecimal amount, String userId) {
		try {
			Map<String, Object> temp = new HashMap<String, Object>();
			temp.put("itemId", itemId);
			temp.put("amount", amount);
			temp.put("number", number);
			temp.put("updateTime", DateUtils.format(new Date(), DateUtils.DEFAULT_YEAR_MONTH_DAY_HMS));
			temp.put("lastOperator", userId);

			baseDao.execute("order_item.modifyAfterSaleData", temp);

		} catch (Exception e) {
			log.error("OrderItemServiceImpl-->modifyAfterSaleData-->itemId: " + itemId + " number:" + number
					+ " amount:" + amount + e);
			throw new SysException("更新原始订单项中的退货数量及金额失败", e);
		}
	}

	@Override
	public List<OrderItemDto> listByOrderId(String orderId) {
		try {
			Map<String, Object> temp = new HashMap<String, Object>();
			temp.put("orderId", orderId);
			return baseDao.queryForList("order_item.listByOrderId", temp, OrderItemDto.class);
		} catch (Exception e) {
			log.error("OrderItemServiceImpl-->listByOrderId-->orderId: " + orderId + e);
			throw new SysException("查询指定的订单下的订单项失败", e);
		}

	}

	@Override
	public OrderItemDto findById(String itemId) {
		try {
			Map<String, Object> temp = new HashMap<String, Object>();
			temp.put("itemId", itemId);
			return baseDao.queryForObject("order_item.findByItemId", temp, OrderItemDto.class);
		} catch (Exception e) {
			log.error("OrderItemServiceImpl-->findById-->itemId: " + itemId + e);
			throw new SysException("根据订单项ID查询订单项失败", e);
		}
	}

}
