package com.adanac.b2b.oms.order.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adanac.b2b.oms.dao.BaseDao;
import com.adanac.b2b.oms.order.baseservice.saleorder.SaleOrderBaseService;
import com.adanac.b2b.oms.order.bo.SaleOrderBo;
import com.adanac.b2b.oms.order.constant.ErrorCodeConst;
import com.adanac.b2b.oms.order.dto.OrderSearchConditionDto;
import com.adanac.b2b.oms.order.dto.SaleOrderDto;
import com.adanac.b2b.oms.order.dto.SumUserOrdersDto;
import com.adanac.b2b.oms.order.service.saleorder.SaleOrderService;
import com.adanac.framework.exception.SysException;
import com.adanac.framework.log.MyLogger;
import com.adanac.framework.log.MyLoggerFactory;
import com.adanac.framework.page.Pager;
import com.alibaba.fastjson.JSON;

/**
 * 订单管理服务实现
 * @author adanac
 * @version 1.0
 */
@Service("saleOrderServiceImpl")
@com.alibaba.dubbo.config.annotation.Service(protocol = { "dubbo" })
public class SaleOrderServiceImpl implements SaleOrderService {

	@Autowired
	private BaseDao baseDao;

	@Autowired
	private SaleOrderBaseService orderBaseService;

	private MyLogger log = MyLoggerFactory.getLogger(SaleOrderServiceImpl.class);

	/**
	 * 查询订单列表
	 * 
	 * @return 返回订单列表
	 */
	@Override
	public Pager<SaleOrderDto> pageByCondition(OrderSearchConditionDto searchCondition, Integer pageSize,
			Integer pageNumber) {
		try {
			Map<String, Object> temp = new HashMap<String, Object>();

			temp.put("orderCode", searchCondition.getOrderCode());
			temp.put("orderId", searchCondition.getOrderId());
			temp.put("aftersaleApplyID", searchCondition.getAftersaleApplyID());
			temp.put("orgOrderId", searchCondition.getOrgOrderId());
			temp.put("userId", searchCondition.getUserId());
			temp.put("merchantId", searchCondition.getMerchantId());
			temp.put("supplierId", searchCondition.getSupplierId());
			temp.put("category", searchCondition.getCategory());
			temp.put("morderId", searchCondition.getMorderId());
			temp.put("evaluated", searchCondition.getEvaluated());
			temp.put("morderCode", searchCondition.getMorderCode());
			temp.put("payBank", searchCondition.getPayBank());

			if (searchCondition.getType() != null && !searchCondition.getType().equals("")) {
				String[] tmpType = searchCondition.getType().split(",");
				String type = "";
				int i = 0;
				for (String tmp : tmpType) {
					if (i++ != 0) {
						type += " OR so.TYPE = " + tmp;
					} else {
						type += " ( so.TYPE = " + tmp;
					}
				}
				temp.put("type", type + ") ");
			}
			if (searchCondition.getStatus() != null && !searchCondition.getStatus().equals("")) {
				String[] tmpStatus = searchCondition.getStatus().split(",");
				String status = "";
				int i = 0;
				for (String tmp : tmpStatus) {
					if (i++ != 0) {
						status += " OR so.STATUS = " + tmp;
					} else {
						status += " ( so.STATUS = " + tmp;
					}
				}
				temp.put("status", status + ") ");
			}
			temp.put("aftersaleStatus", searchCondition.getAftersaleStatus());
			temp.put("channel", searchCondition.getChannel());
			temp.put("startTime", searchCondition.getStartTime());
			temp.put("endTime", searchCondition.getEndTime());
			temp.put("closeType", searchCondition.getCloseType());
			temp.put("startCloseTime", searchCondition.getStartCloseTime());
			temp.put("endCloseTime", searchCondition.getEndCloseTime());
			temp.put("isReceipt", searchCondition.getIsReceipt());
			temp.put("asStatusNull", searchCondition.getAsStatusNull());
			temp.put("asStatus", searchCondition.getAsStatus());
			temp.put("asStatusNot", searchCondition.getAsStatusNot());
			temp.put("asType", searchCondition.getAsType());
			String productName = searchCondition.getProductName();
			if (StringUtils.isNotBlank(productName)) {
				productName = "%" + productName + "%";// 模糊查询
			}
			temp.put("productName", productName);
			String payStartTime = searchCondition.getPayStartTime();
			temp.put("payStartTime", payStartTime);
			String payEndTime = searchCondition.getPayEndTime();
			temp.put("payEndTime", payEndTime);

			String deliveryStartTime = searchCondition.getDeliveryStartTime();
			temp.put("deliveryStartTime", deliveryStartTime);
			String deliveryEndTime = searchCondition.getDeliveryEndTime();
			temp.put("deliveryEndTime", deliveryEndTime);
			return baseDao.queryForPage("orders.listOrderComp", temp, SaleOrderDto.class, pageSize, pageNumber);

		} catch (Exception e) {
			log.error(
					"OrderServiceImpl-->pageByCondition-->searchCondition: " + JSON.toJSONString(searchCondition) + e);
			Pager<SaleOrderDto> orders = new Pager<SaleOrderDto>();
			orders.setPageSize(pageSize);
			orders.setPageNumber(pageNumber);
			orders.setTotalDataCount(0);
			orders.setDatas(new ArrayList<SaleOrderDto>());
			return orders;
		}
	}

	@Override
	public List<SaleOrderDto> listByCondition(OrderSearchConditionDto searchCondition) {
		try {
			Map<String, Object> temp = new HashMap<String, Object>();

			temp.put("orderCode", searchCondition.getOrderCode());
			temp.put("orderId", searchCondition.getOrderId());
			temp.put("aftersaleApplyID", searchCondition.getAftersaleApplyID());
			temp.put("orgOrderId", searchCondition.getOrgOrderId());
			temp.put("userId", searchCondition.getUserId());
			temp.put("merchantId", searchCondition.getMerchantId());
			temp.put("supplierId", searchCondition.getSupplierId());
			temp.put("category", searchCondition.getCategory());
			temp.put("morderId", searchCondition.getMorderId());
			temp.put("evaluated", searchCondition.getEvaluated());

			if (searchCondition.getType() != null) {
				String[] tmpType = searchCondition.getType().split(",");
				String type = "";
				int i = 0;
				for (String tmp : tmpType) {
					if (i++ != 0) {
						type += " OR so.TYPE = " + tmp;
					} else {
						type += " ( so.TYPE = " + tmp;
					}
				}
				temp.put("type", type + ") ");
			}
			if (searchCondition.getStatus() != null) {
				String[] tmpStatus = searchCondition.getStatus().split(",");
				String status = "";
				int i = 0;
				for (String tmp : tmpStatus) {
					if (i++ != 0) {
						status += " OR so.STATUS = " + tmp;
					} else {
						status += " ( so.STATUS = " + tmp;
					}
				}
				temp.put("status", status + ") ");
			}
			temp.put("aftersaleStatus", searchCondition.getAftersaleStatus());
			temp.put("channel", searchCondition.getChannel());
			temp.put("startTime", searchCondition.getStartTime());
			temp.put("endTime", searchCondition.getEndTime());
			temp.put("closeType", searchCondition.getCloseType());
			temp.put("startCloseTime", searchCondition.getStartCloseTime());
			temp.put("endCloseTime", searchCondition.getEndCloseTime());
			temp.put("isReceipt", searchCondition.getIsReceipt());
			temp.put("asStatusNull", searchCondition.getAsStatusNull());
			temp.put("asStatus", searchCondition.getAsStatus());
			temp.put("asStatusNot", searchCondition.getAsStatusNot());
			temp.put("asType", searchCondition.getAsType());
			String productName = searchCondition.getProductName();
			if (StringUtils.isNotBlank(productName)) {
				productName = "%" + productName + "%";// 模糊查询
			}
			temp.put("productName", productName);
			String payStartTime = searchCondition.getPayStartTime();
			temp.put("payStartTime", payStartTime);
			String payEndTime = searchCondition.getPayEndTime();
			temp.put("payEndTime", payEndTime);
			return baseDao.queryForList("orders.listOrderComp", temp, SaleOrderDto.class);

		} catch (Exception e) {
			log.error(
					"OrderServiceImpl-->pageByCondition-->searchCondition: " + JSON.toJSONString(searchCondition) + e);
			List<SaleOrderDto> orders = new ArrayList<SaleOrderDto>();
			return orders;
		}
	}

	/**
	 * 根据订单主键取消订单
	 * 
	 * @param orderId
	 *            订单物理主键
	 * @return true:成功取消;false取消失败
	 */
	@Override
	@Transactional
	public Boolean cancleByOrderId(String orderId, String userId) {

		try {
			log.info("OrderServiceImpl-->cancleByOrderId-->orderId: " + orderId);
			return orderBaseService.cancleByOrderId(orderId, userId);

		} catch (Exception e) {
			log.error("OrderServiceImpl-->cancleByOrderId-->orderId: " + orderId + e);
			throw new SysException(ErrorCodeConst.CODE_ERROR, ErrorCodeConst.ERROR_MESSAGE_UNKNOWN_EXCEPTION, e);
		}
	}

	/**
	 * 根据订单编号取消订单
	 * 
	 * @param orderCode
	 *            订单编码
	 * @return true:成功取消;false取消失败
	 */
	@Override
	@Transactional
	public Boolean cancleByOrderCode(String orderCode, String userId) {

		try {
			log.info("OrderServiceImpl-->cancleByOrderCode-->orderCode: " + orderCode);

			return orderBaseService.cancleByOrderCode(orderCode, userId);

		} catch (Exception e) {
			log.error("OrderServiceImpl-->cancleByOrderCode-->orderCode: " + orderCode + e);
			throw new SysException(ErrorCodeConst.CODE_ERROR, ErrorCodeConst.ERROR_MESSAGE_UNKNOWN_EXCEPTION, e);
		}
	}

	@Override
	public SaleOrderDto findById(String orderId) {

		try {
			SaleOrderBo bo = orderBaseService.findByOrderId(orderId);
			SaleOrderDto dto = new SaleOrderDto();
			BeanUtils.copyProperties(dto, bo);
			return dto;
		} catch (Exception e) {
			log.error("OrderServiceImpl-->findByCode-->orderId: " + orderId + e);
			throw new SysException(ErrorCodeConst.CODE_ERROR, ErrorCodeConst.ERROR_MESSAGE_UNKNOWN_EXCEPTION, e);
		}
	}

	@Override
	public SaleOrderDto findByCode(String orderCode) {

		try {
			SaleOrderBo bo = orderBaseService.findByOrderCode(orderCode);
			SaleOrderDto dto = new SaleOrderDto();
			BeanUtils.copyProperties(dto, bo);
			return dto;
		} catch (Exception e) {
			log.error("OrderServiceImpl-->findByCode-->orderCode: " + orderCode + e);
			throw new SysException(ErrorCodeConst.CODE_ERROR, ErrorCodeConst.ERROR_MESSAGE_UNKNOWN_EXCEPTION, e);
		}
	}

	@Override
	@Transactional
	public Boolean receiveByOrderId(String orderId, String userId) {

		try {
			return orderBaseService.receiveByOrderId(orderId, userId);
		} catch (Exception e) {
			log.error("OrderServiceImpl-->receiveByOrderId-->orderId: " + orderId + e);
			throw new SysException("ErrorCodeConst.CODE_ERROR, ErrorCodeConst.ERROR_MESSAGE_UNKNOWN_EXCEPTION", e);
		}
	}

	@Override
	@Transactional
	public Boolean deliveryByOrderId(String orderId, String userId, String deliveryTime) {

		try {
			return orderBaseService.deliveryByOrderId(orderId, userId, deliveryTime);
		} catch (Exception e) {
			log.error("OrderServiceImpl-->deliveryByOrderId-->orderId: " + orderId + e);
			throw new SysException("ErrorCodeConst.CODE_ERROR, ErrorCodeConst.ERROR_MESSAGE_UNKNOWN_EXCEPTION", e);
		}
	}

	@Override
	public List<SumUserOrdersDto> sumUserOrders(String userId) {
		try {
			Map<String, Object> temp = new HashMap<String, Object>();
			temp.put("userId", userId);
			return baseDao.queryForList("orders.sumOrdersByUserId", temp, SumUserOrdersDto.class);
		} catch (Exception e) {
			log.error("OrderServiceImpl-->findByOrderId-->userId: " + userId + e);
			throw new SysException(ErrorCodeConst.CODE_ERROR, ErrorCodeConst.ERROR_MESSAGE_UNKNOWN_EXCEPTION, e);
		}
	}

	@Override
	public Integer sumEvaluatedUserOrders(String userId) {
		try {
			Map<String, Object> temp = new HashMap<String, Object>();
			temp.put("userId", userId);
			return baseDao.queryForObject("orders.sumEvaluatedUserOrders", temp, Integer.class);
		} catch (Exception e) {
			log.error("OrderServiceImpl-->findByOrderId-->userId: " + userId + e);
			throw new SysException(ErrorCodeConst.CODE_ERROR, ErrorCodeConst.ERROR_MESSAGE_UNKNOWN_EXCEPTION, e);
		}
	}

	@Override
	public List<SaleOrderDto> listByMainOrderId(String morderId) {
		try {
			return orderBaseService.listByMainOrderId(morderId);
		} catch (Exception e) {
			log.error("OrderServiceImpl-->listByMainOrderId-->morderId: " + morderId + e);
			throw new SysException(ErrorCodeConst.CODE_ERROR, ErrorCodeConst.ERROR_MESSAGE_UNKNOWN_EXCEPTION, e);
		}
	}

	@Override
	@Transactional
	public Boolean rejectByOrderId(String orderId, String operatorId) {
		return orderBaseService.rejectByOrderId(orderId, operatorId);
	}

}
