package com.adanac.b2b.oms.order.baseservice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adanac.b2b.oms.dao.BaseDao;
import com.adanac.b2b.oms.order.baseservice.saleorder.SaleOrderBaseService;
import com.adanac.b2b.oms.order.bo.SaleOrderBo;
import com.adanac.b2b.oms.order.constant.CodeConst;
import com.adanac.b2b.oms.order.constant.ErrorCodeConst;
import com.adanac.b2b.oms.order.dto.SaleOrderDto;
import com.adanac.b2b.oms.utils.uuid.DefaultSequenceGenerator;
import com.adanac.framework.exception.BizzException;
import com.adanac.framework.exception.SysException;
import com.adanac.framework.log.MyLogger;
import com.adanac.framework.log.MyLoggerFactory;
import com.adanac.framework.utils.DateUtils;

@Service("saleOrderBaseServiceImpl")
public class SaleOrderBaseServiceImpl implements SaleOrderBaseService {

	@Autowired
	private BaseDao baseDao;

	private MyLogger log = MyLoggerFactory.getLogger(SaleOrderBaseServiceImpl.class);

	/**
	 * 创建订单
	 * @param order 订单信息
	 * @return 主键
	 */
	@Override
	public String createOrder(SaleOrderBo order) {

		try {
			String id = DefaultSequenceGenerator.getInstance().uuid();

			order.setCreateTime(DateUtils.format(new Date(), DateUtils.DEFAULT_YEAR_MONTH_DAY_HMS));
			order.setUpdateTime(order.getCreateTime());
			order.setOrderId(id);
			order.setStatus(CodeConst.OrderStatus.UNPAY);//
			order.setOrderCode(createId(order.getSupplierId())); // 创造部分订单编码,用于SQL中拼接

			int rst = baseDao.execute("orders.createOrder", order);
			if (rst != CodeConst.RESULT_1) {
				return null;
			}
			return id;
		} catch (Exception e) {
			log.error("OrderBaseServiceImpl-->CreateOrder-->order: " + order + e);

			throw new SysException(ErrorCodeConst.CODE_ERROR, ErrorCodeConst.ERROR_MESSAGE_UNKNOWN_EXCEPTION, e);
		}
	}

	/**
	 * 根据订单ID查找订单
	 * @param orderId 订单ID
	 * @return 订单
	 */
	@Override
	public SaleOrderBo findByOrderId(String orderId) {

		try {
			Map<String, Object> temp = new HashMap<String, Object>();
			temp.put("orderId", orderId);
			return baseDao.queryForObject("orders.listOrders", temp, SaleOrderBo.class);
		} catch (Exception e) {

			log.error("OrderBaseServiceImpl-->findByOrderId-->orderId: " + orderId + e);

			throw new SysException(ErrorCodeConst.CODE_ERROR, ErrorCodeConst.ERROR_MESSAGE_UNKNOWN_EXCEPTION, e);
		}
	}

	protected String createId(String supplierId) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		String fmt = "%0" + CodeConst.SPULIER_CODE_LENTH + "d";
		return sdf.format(new Date()) + String.format(fmt, Integer.parseInt(supplierId));
	}

	@Override
	public Boolean cancleByOrderId(String orderId, String operatorId) {

		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("orderId", orderId);
			paramMap.put("updateTime", DateUtils.format(new Date(), DateUtils.DEFAULT_YEAR_MONTH_DAY_HMS));
			paramMap.put("lastOperator", operatorId);
			paramMap.put("status", CodeConst.OrderStatus.CANCLED);
			int rslt = baseDao.execute("orders.cancleByOrderId", paramMap);
			return rslt == CodeConst.RESULT_1;

		} catch (Exception e) {

			log.error("OrderBaseServiceImpl-->cancleByOrderId-->orderId: " + orderId + e);

			throw new SysException(ErrorCodeConst.CODE_ERROR, ErrorCodeConst.ERROR_MESSAGE_UNKNOWN_EXCEPTION, e);
		}
	}

	@Override
	public Boolean cancleByOrderCode(String orderCode, String operatorId) {

		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("orderCode", orderCode);
			paramMap.put("updateTime", DateUtils.format(new Date(), DateUtils.DEFAULT_YEAR_MONTH_DAY_HMS));
			paramMap.put("lastOperator", operatorId);
			paramMap.put("status", CodeConst.OrderStatus.CANCLED);
			int rslt = baseDao.execute("orders.cancleByOrderCode", paramMap);
			return rslt == CodeConst.RESULT_1;
		} catch (Exception e) {

			log.error("OrderBaseServiceImpl-->cancleByOrderCode-->orderCode: " + orderCode + e);

			throw new SysException(ErrorCodeConst.CODE_ERROR, ErrorCodeConst.ERROR_MESSAGE_UNKNOWN_EXCEPTION, e);
		}
	}

	/**
	 * 根据订单编号查找订单
	 * @param orderCode 订单编号
	 * @return 订单信息
	 */
	@Override
	public SaleOrderBo findByOrderCode(String orderCode) {

		try {
			Map<String, Object> temp = new HashMap<String, Object>();
			temp.put("orderCode", orderCode);
			return baseDao.queryForObject("orders.listOrders", temp, SaleOrderBo.class);
		} catch (Exception e) {

			log.error("OrderBaseServiceImpl-->findByOrderCode-->orderCode: " + orderCode + e);

			throw new SysException(ErrorCodeConst.CODE_ERROR, ErrorCodeConst.ERROR_MESSAGE_UNKNOWN_EXCEPTION, e);
		}
	}

	@Override
	public Boolean payByOrderId(String orderId, String operatorId) {

		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("orderId", orderId);
			paramMap.put("updateTime", DateUtils.format(new Date(), DateUtils.DEFAULT_YEAR_MONTH_DAY_HMS));
			paramMap.put("lastOperator", operatorId);
			paramMap.put("status", CodeConst.OrderStatus.PAYED);
			int rslt = baseDao.execute("orders.payByOrderId", paramMap);
			return rslt == CodeConst.RESULT_1;
		} catch (Exception e) {

			log.error("OrderBaseServiceImpl-->payByOrderId-->orderId: " + orderId + e);

			throw new SysException(ErrorCodeConst.CODE_ERROR, ErrorCodeConst.ERROR_MESSAGE_UNKNOWN_EXCEPTION, e);
		}
	}

	@Override
	public Boolean payByOrderIds(List<String> orderIds, String operatorId) {

		try {
			for (String orderId : orderIds) {
				payByOrderId(orderId, operatorId);
			}
			return true;
		} catch (Exception e) {

			log.error("OrderBaseServiceImpl-->payByOrderIds-->orderIds: " + orderIds + e);

			throw new SysException(ErrorCodeConst.CODE_ERROR, ErrorCodeConst.ERROR_MESSAGE_UNKNOWN_EXCEPTION, e);
		}
	}

	@Override
	public Boolean payAfterSaleByOrderId(String orderId, String operatorId) {

		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("orderId", orderId);
			paramMap.put("updateTime", DateUtils.format(new Date(), DateUtils.DEFAULT_YEAR_MONTH_DAY_HMS));
			paramMap.put("lastOperator", operatorId);
			paramMap.put("status", CodeConst.OrderStatus.REFUNDED);
			int rslt = baseDao.execute("orders.payByOrderId", paramMap);
			return rslt == CodeConst.RESULT_1;

		} catch (Exception e) {

			log.error("OrderBaseServiceImpl-->payAfterSaleByOrderId-->orderId: " + orderId + e);

			throw new SysException(ErrorCodeConst.CODE_ERROR, ErrorCodeConst.ERROR_MESSAGE_UNKNOWN_EXCEPTION, e);
		}
	}

	@Override
	public Boolean chg2RefundByOrderId(String orderId, String operatorId) {

		try {
			return chgOrderStatusById(orderId, operatorId, CodeConst.OrderStatus.REFUNDED);

		} catch (Exception e) {

			log.error("OrderBaseServiceImpl-->chg2RefundByOrderId-->orderId: " + orderId + e);

			throw new SysException(ErrorCodeConst.CODE_ERROR, ErrorCodeConst.ERROR_MESSAGE_UNKNOWN_EXCEPTION, e);
		}
	}

	private Boolean chgOrderStatusById(String orderId, String operatorId, int status) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("orderId", orderId);
		paramMap.put("updateTime", DateUtils.format(new Date(), DateUtils.DEFAULT_YEAR_MONTH_DAY_HMS));
		paramMap.put("lastOperator", operatorId);
		paramMap.put("status", status);
		int rslt = baseDao.execute("orders.chgOrderStatusById", paramMap);
		return rslt == CodeConst.RESULT_1;
	}

	@Override
	public Boolean chgAfterSaleStatusByOrderId(String orderId, String operatorId, int status) {

		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("orderId", orderId);
			paramMap.put("updateTime", DateUtils.format(new Date(), DateUtils.DEFAULT_YEAR_MONTH_DAY_HMS));
			paramMap.put("lastOperator", operatorId);
			paramMap.put("status", status);///
			int rslt = baseDao.execute("orders.chgAfterSaleStatusByOrderId", paramMap);
			return rslt == CodeConst.RESULT_1;
		} catch (Exception e) {

			log.error("OrderBaseServiceImpl-->refundByOrderId-->orderId: " + orderId + e);

			throw new SysException(ErrorCodeConst.CODE_ERROR, ErrorCodeConst.ERROR_MESSAGE_UNKNOWN_EXCEPTION, e);
		}
	}

	@Override
	public Boolean receiveByOrderId(String orderId, String operatorId) {

		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("orderId", orderId);
			paramMap.put("updateTime", DateUtils.format(new Date(), DateUtils.DEFAULT_YEAR_MONTH_DAY_HMS));
			paramMap.put("lastOperator", operatorId);
			paramMap.put("status", CodeConst.OrderStatus.RECEIVED);
			int rslt = baseDao.execute("orders.receiveByOrderId", paramMap);
			return rslt == CodeConst.RESULT_1;
		} catch (Exception e) {

			log.error("OrderBaseServiceImpl-->receiveByOrderId-->orderId: " + orderId + e);

			throw new SysException(ErrorCodeConst.CODE_ERROR, ErrorCodeConst.ERROR_MESSAGE_UNKNOWN_EXCEPTION, e);
		}
	}

	@Override
	public Boolean deliveryByOrderId(String orderId, String userId, String deliveryTime) {

		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("orderId", orderId);
			paramMap.put("updateTime", DateUtils.format(new Date(), DateUtils.DEFAULT_YEAR_MONTH_DAY_HMS));
			paramMap.put("lastOperator", userId);
			paramMap.put("status", CodeConst.OrderStatus.OUTSTORE);
			paramMap.put("deliveryTime", deliveryTime);
			int rslt = baseDao.execute("orders.deliveryByOrderId", paramMap);
			if (rslt != CodeConst.RESULT_1) {
				throw new BizzException(ErrorCodeConst.CODE_ERROR,
						ErrorCodeConst.ERROR_MESSAGE_MODIFY_ORDER_STATUS_ERROR);
			}

			return true;
		} catch (Exception e) {
			log.error("OrderBaseServiceImpl-->deliveryByOrderId-->orderId: " + orderId + e);
			throw new SysException(ErrorCodeConst.CODE_ERROR, ErrorCodeConst.ERROR_MESSAGE_UNKNOWN_EXCEPTION, e);
		}
	}

	@Override
	public List<SaleOrderDto> listByMainOrderId(String morderId) {
		try {
			Map<String, Object> temp = new HashMap<String, Object>();
			temp.put("morderId", morderId);
			return baseDao.queryForList("orders.listOrders", temp, SaleOrderDto.class);
		} catch (Exception e) {
			log.error("OrderServiceImpl-->listByMainOrderId-->morderId: " + morderId + e);
			throw new SysException(ErrorCodeConst.CODE_ERROR, ErrorCodeConst.ERROR_MESSAGE_UNKNOWN_EXCEPTION, e);
		}
	}

	@Override
	public Boolean rejectByOrderId(String orderId, String operatorId) {
		try {
			return chgOrderStatusById(orderId, operatorId, CodeConst.OrderStatus.REJECTED);
		} catch (Exception e) {
			log.error("OrderBaseServiceImpl-->rejectByOrderId-->orderId: " + orderId + e);

			throw new SysException(ErrorCodeConst.CODE_ERROR, ErrorCodeConst.ERROR_MESSAGE_UNKNOWN_EXCEPTION, e);
		}
	}

	@Override
	public Boolean modifyStatusById(String id, int status, String userId) {
		try {
			Map<String, Object> tmp = new HashMap<String, Object>();
			tmp.put("status", status);
			tmp.put("orderId", id);
			tmp.put("lastOperator", userId);
			int rslt = baseDao.execute("orders.chgOrderStatusById", tmp);

			return rslt > CodeConst.RESULT_0;

		} catch (Exception e) {
			log.error("OrderBaseServiceImpl-->modifyStatusById-->id: " + id + e);

			throw new SysException(ErrorCodeConst.CODE_ERROR, ErrorCodeConst.ERROR_MESSAGE_UNKNOWN_EXCEPTION, e);
		}
	}

	@Override
	public Boolean updateEvaluateStatus(String orderId) {
		try {
			Map<String, Object> tmp = new HashMap<String, Object>();

			tmp.put("orderId", orderId);

			baseDao.execute("orders.updateEvaluateStatus", tmp);

			return true;

		} catch (Exception e) {
			log.error("OrderBaseServiceImpl-->updateEvaluateStatus-->orderId: " + orderId + e);

			throw new SysException(ErrorCodeConst.CODE_ERROR, ErrorCodeConst.ERROR_MESSAGE_UNKNOWN_EXCEPTION, e);
		}
	}
}
