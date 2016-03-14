package com.adanac.b2b.oms.payment.service;

import java.util.Map;

import com.adanac.b2b.oms.common.BaseDto;
import com.adanac.b2b.oms.payment.dto.PayErrorInfoDto;
import com.adanac.b2b.oms.payment.dto.PaymentInfoDto;

/**
 * 订单支付服务接口
 * @author adanac
 * @version 1.0
 */
public interface PaymentService {

	/**
	 * 支付宝支付通知处理
	 * @param notifyParam 支付通知参数
	 * @return 成功返回true,失败返回false
	 */
	public BaseDto alipayNotify(Map<String, Object> notifyParam);

	/**
	 * 通过支付宝支付指定的主订单
	 * @param mOrderId
	 * @param userId
	 * @param userType
	 * @return 支付宝支付请求URL
	 */
	public BaseDto alipayByOrderId(String mOrderId, String userId, Integer userType);

	/**
	 * 根据主订单ID查询支付信息
	 * @param mOrderId
	 * @return
	 */
	public PaymentInfoDto findPaymentByMainOrderId(String mOrderId);

	/**
	 * 支付退款订单
	 * @return
	 */
	public BaseDto payOrder(PaymentInfoDto payment);

	/**
	 * 根据支付通知ID处理支付通知
	 * @param notifyId
	 * @return
	 */
	public BaseDto dealPaymentNotify(String notifyId);

	/**
	 * 支付异常处理
	 * @param userId
	 * @param remark
	 * @return
	 */
	public BaseDto confirmPayError(Long userId, String remark, String orderCode);

	/**
	 * 根据大订单CODE查询异常支付信息
	 * @param orderCode
	 * @return 
	 */
	public PayErrorInfoDto findPayErrorStatusByOrderCode(String orderCode);
}
