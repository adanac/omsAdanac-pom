package com.adanac.b2b.oms.order.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adanac.b2b.oms.order.baseservice.saleorder.DeliveryReqBaseService;
import com.adanac.b2b.oms.order.baseservice.saleorder.InvoiceReqBaseService;
import com.adanac.b2b.oms.order.baseservice.saleorder.MainOrderBaseService;
import com.adanac.b2b.oms.order.baseservice.saleorder.SaleOrderBaseService;
import com.adanac.b2b.oms.order.baseservice.saleorder.SaleOrderItemBaseService;
import com.adanac.b2b.oms.order.baseservice.saleorder.SaleOrderItemDiscountBaseService;
import com.adanac.b2b.oms.order.bo.DeliveryReqBo;
import com.adanac.b2b.oms.order.bo.InvoiceReqBo;
import com.adanac.b2b.oms.order.bo.MainOrderBo;
import com.adanac.b2b.oms.order.bo.OrderItemBo;
import com.adanac.b2b.oms.order.bo.OrderItemDiscountBo;
import com.adanac.b2b.oms.order.bo.SaleOrderBo;
import com.adanac.b2b.oms.order.constant.CodeConst;
import com.adanac.b2b.oms.order.dto.MainOrderDetailDto;
import com.adanac.b2b.oms.order.dto.MainOrderDto;
import com.adanac.b2b.oms.order.dto.MainOrderQueryDto;
import com.adanac.b2b.oms.order.dto.OrderItemDetailDto;
import com.adanac.b2b.oms.order.dto.SaleOrderDetailDto;
import com.adanac.b2b.oms.order.dto.SaleOrderDto;
import com.adanac.b2b.oms.order.service.saleorder.MainSaleOrderService;
import com.adanac.b2b.oms.payment.baseservice.PaymentBaseService;
import com.adanac.b2b.oms.payment.bo.PaymentInfoBo;
import com.adanac.framework.exception.SysException;
import com.adanac.framework.log.MyLogger;
import com.adanac.framework.log.MyLoggerFactory;
import com.adanac.framework.page.Pager;
import com.adanac.framework.utils.DateUtils;
import com.alibaba.fastjson.JSON;

@Service("mainSaleOrderServiceImpl")
@com.alibaba.dubbo.config.annotation.Service(protocol = { "dubbo" })
public class MainSaleOrderServiceImpl implements MainSaleOrderService {

	@Autowired
	MainOrderBaseService mobs;

	@Autowired
	SaleOrderBaseService sobs;

	@Autowired
	SaleOrderItemBaseService soibs;

	@Autowired
	SaleOrderItemDiscountBaseService soidbs;

	@Autowired
	DeliveryReqBaseService drbs;

	@Autowired
	InvoiceReqBaseService irbs;

	@Autowired
	PaymentBaseService pbs;

	MyLogger logger = MyLoggerFactory.getLogger(MainSaleOrderServiceImpl.class);

	@Transactional
	@Override
	public String createOrder(MainOrderDetailDto mainOrderDetail) {
		String morderId = mobs.createMainOrder(mainOrderDetail.getMainOrder());
		for (SaleOrderDetailDto odetail : mainOrderDetail.getOrderDetailList()) {
			SaleOrderBo order = odetail.getOrder();
			order.setMorderId(morderId);
			String orderId = sobs.createOrder(order);
			DeliveryReqBo deliveryReq = odetail.getDeliveryReq();
			deliveryReq.setOrderId(orderId);
			drbs.createDeliveryReq(deliveryReq);

			// 有发票才添加发票
			if (odetail.getOrder().getIsReceipt().equals(CodeConst.RESULT_1)) {
				InvoiceReqBo invoiceReq = odetail.getInvoiceReq();
				invoiceReq.setOrderId(orderId);
				irbs.createInvoiceReq(invoiceReq);
			}

			// 保存订单项数据
			int i = 1;
			for (OrderItemDetailDto itemDetail : odetail.getItemDetails()) {
				OrderItemBo item = itemDetail.getOrderItem();
				item.setOrderId(orderId);
				item.setItemCode(String.format("%02d", (i++)));
				String itemId = soibs.createOrderItem(item);

				// 如果有优惠信息，则保存订单项优惠信息
				List<OrderItemDiscountBo> orderItemDiscounts = itemDetail.getOrderItemDiscounts();
				if (orderItemDiscounts != null && orderItemDiscounts.size() > 0) {
					soidbs.createOrderItemDiscounts(itemId, orderItemDiscounts);
				}
			}
		}
		return morderId;
	}

	@Transactional
	@Override
	public Boolean morderPayment(String mOrderId, BigDecimal money, String payTime, String userId) {
		try {
			MainOrderDto morder = mobs.findById(mOrderId);
			if (morder.getStatus().equals(CodeConst.MainOrderStatus.PAY_NO)) {
				MainOrderBo mainOrder = new MainOrderBo();
				mainOrder.setMorderId(mOrderId);
				mainOrder.setPayMoney(money);
				mainOrder.setLastOperator(userId);
				mainOrder.setPayTime(payTime);
				mainOrder.setPayUser(String.valueOf(userId));
				if (morder.getTotalMoney().compareTo(money) == CodeConst.RESULT_0) { // 金额正常
					mainOrder.setStatus(CodeConst.MainOrderStatus.PAY_YES);
					Boolean rst = false;
					// 2.改变主订单下的销售订单状态
					List<SaleOrderDto> orderList = sobs.listByMainOrderId(mOrderId);
					for (SaleOrderDto order : orderList) {
						rst = sobs.payByOrderId(order.getOrderId(), String.valueOf(userId));
						if (!rst) {
							throw new SysException("主订单下的销售订单改变状态失败：" + JSON.toJSONString(order));
						}
					}
				} else { // 金额异常
					mainOrder.setStatus(CodeConst.MainOrderStatus.EXCEPTION);
				}

				return mobs.modifyById(mainOrder);
			}
			return false;
		} catch (Exception e) {
			logger.error("大订单支付失败", e);
			throw new SysException("大订单支付失败", e);
		}
	}

	@Transactional
	@Override
	public Boolean payById(String mOrderId, String operatorId) {
		// 1.改变主订单的状态
		Boolean rst = mobs.modifyStatus(mOrderId, CodeConst.MainOrderStatus.PAY_YES);
		if (!rst) {
			throw new SysException("主订单改变状态失败，主订单ID：" + JSON.toJSONString(mOrderId));
		}
		// 2.改变主订单下的销售订单状态
		List<SaleOrderDto> orderList = sobs.listByMainOrderId(mOrderId);
		for (SaleOrderDto order : orderList) {
			rst = sobs.payByOrderId(order.getOrderId(), operatorId);
			if (!rst) {
				throw new SysException("主订单下的销售订单改变状态失败：" + JSON.toJSONString(order));
			}
		}
		return rst;
	}

	@Transactional
	@Override
	public Boolean cancleById(String mOrderId, String operatorId) {
		// 1.改变主订单的状态
		Boolean rst = mobs.modifyStatus(mOrderId, CodeConst.MainOrderStatus.CANCEL);
		if (!rst) {
			throw new SysException("主订单改变状态失败，主订单ID：" + JSON.toJSONString(mOrderId));
		}
		// 2.改变主订单下的销售订单状态
		List<SaleOrderDto> orderList = sobs.listByMainOrderId(mOrderId);
		for (SaleOrderDto order : orderList) {
			rst = sobs.cancleByOrderId(order.getOrderId(), operatorId);
			if (!rst) {
				throw new SysException("主订单下的销售订单改变状态失败：" + JSON.toJSONString(order));
			}
		}
		return rst;
	}

	@Override
	public Pager<MainOrderDto> pageByCondition(MainOrderQueryDto searchCondition, Integer pageSize,
			Integer pageNumber) {
		return mobs.pageByCondition(searchCondition, pageSize, pageNumber);
	}

	@Override
	public MainOrderDto findById(String mOrderId) {
		return mobs.findById(mOrderId);
	}

	@Transactional
	@Override
	public Boolean orderPayment(String mOrderId, BigDecimal money, Date payTime, String userId) {
		try {
			MainOrderDto morder = mobs.findById(mOrderId);
			if (morder.getStatus().equals(CodeConst.MainOrderStatus.PAY_NO)) {
				MainOrderBo mainOrder = new MainOrderBo();
				mainOrder.setMorderId(mOrderId);
				mainOrder.setPayMoney(money);
				mainOrder.setLastOperator(userId);
				mainOrder.setPayTime(DateUtils.format(payTime, DateUtils.DEFAULT_YEAR_MONTH_DAY_HMS));
				mainOrder.setPayUser(String.valueOf(userId));
				if (morder.getTotalMoney().compareTo(money) == CodeConst.RESULT_0) { // 金额正常
					mainOrder.setStatus(CodeConst.MainOrderStatus.PAY_YES);
					Boolean rst = false;
					// 2.改变主订单下的销售订单状态
					List<SaleOrderDto> orderList = sobs.listByMainOrderId(mOrderId);
					for (SaleOrderDto order : orderList) {
						rst = sobs.payByOrderId(order.getOrderId(), String.valueOf(userId));
						if (!rst) {
							throw new SysException("主订单下的销售订单改变状态失败：" + JSON.toJSONString(order));
						}
					}
					// 增加支付记录
					PaymentInfoBo paymetInfo = new PaymentInfoBo();
					paymetInfo.setInAccount("4008888222209");
					paymetInfo.setLastOperator(userId);
					paymetInfo.setOrderCode(morder.getMorderCode());
					paymetInfo.setOrderId(morder.getMorderId());
					paymetInfo.setOrderType(CodeConst.SaleOrderType.SALE);
					paymetInfo.setOutAccount("6228833778889");
					paymetInfo.setPayBank(CodeConst.PayPlatform.ALI_PAY);
					paymetInfo.setPayerId(userId);
					paymetInfo.setPayerType(CodeConst.PayerType.CLIENT);
					paymetInfo.setPayTime(mainOrder.getPayTime());
					paymetInfo.setPayWaterno("201699999999999999999");
					paymetInfo.setTradeId("201699999999999999999");
					paymetInfo.setPayWay(CodeConst.RESULT_0);
					paymetInfo.setPayAmount(morder.getTotalMoney());
					pbs.addPaymentInfo(paymetInfo);
				} else { // 金额异常
					mainOrder.setStatus(CodeConst.MainOrderStatus.EXCEPTION);
				}

				return mobs.modifyById(mainOrder);
			}
			return false;
		} catch (Exception e) {
			logger.error("大订单支付失败", e);
			throw new SysException("大订单支付失败", e);
		}
	}

}
