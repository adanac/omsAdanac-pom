package com.adanac.b2b.oms.payment.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adanac.b2b.oms.common.BaseDto;
import com.adanac.b2b.oms.common.MD5;
import com.adanac.b2b.oms.order.baseservice.saleorder.MainOrderBaseService;
import com.adanac.b2b.oms.order.baseservice.saleorder.SaleOrderBaseService;
import com.adanac.b2b.oms.order.constant.CodeConst;
import com.adanac.b2b.oms.order.constant.ErrorCodeConst;
import com.adanac.b2b.oms.order.dto.MainOrderDto;
import com.adanac.b2b.oms.order.service.saleorder.MainSaleOrderService;
import com.adanac.b2b.oms.payment.baseservice.PayErrorBaseService;
import com.adanac.b2b.oms.payment.baseservice.PayNotifyBaseService;
import com.adanac.b2b.oms.payment.baseservice.PaymentBaseService;
import com.adanac.b2b.oms.payment.bo.PayErrorInfoBo;
import com.adanac.b2b.oms.payment.bo.PayNotifyInfoBo;
import com.adanac.b2b.oms.payment.bo.PaymentInfoBo;
import com.adanac.b2b.oms.payment.constant.AliPayConst;
import com.adanac.b2b.oms.payment.constant.PayDealStatus;
import com.adanac.b2b.oms.payment.constant.PayErrorDealStatus;
import com.adanac.b2b.oms.payment.constant.PayPlatformType;
import com.adanac.b2b.oms.payment.dto.PayErrorInfoDto;
import com.adanac.b2b.oms.payment.dto.PayErrorInfoScDto;
import com.adanac.b2b.oms.payment.dto.PayNotifyInfoDto;
import com.adanac.b2b.oms.payment.dto.PaymentInfoDto;
import com.adanac.b2b.oms.payment.dto.PaymentScDto;
import com.adanac.framework.exception.BizzException;
import com.adanac.framework.exception.SysException;
import com.adanac.framework.log.MyLogger;
import com.adanac.framework.log.MyLoggerFactory;

import net.sf.json.JSONObject;

@Service("paymentService")
@com.alibaba.dubbo.config.annotation.Service(protocol = { "dubbo" })
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentBaseService pbs;

	@Autowired
	PayNotifyBaseService pnbs;

	@Autowired
	PayErrorBaseService pebs;

	@Autowired
	SaleOrderBaseService sobs;

	@Autowired
	MainOrderBaseService mobs;

	// @Autowired
	// AfterSaleOrderBaseService asobs;

	@Autowired
	MainSaleOrderService msos;

	// @Autowired
	// AfterSaleApplyBaseService asbs;

	MyLogger logger = MyLoggerFactory.getLogger(PaymentServiceImpl.class);

	@Transactional
	@Override
	public BaseDto alipayNotify(Map<String, Object> notifyParam) {
		BaseDto rslt = new BaseDto();
		rslt.setErrorCode(BaseDto.ERROR);
		try {
			// 对数据进行校验
			if (!getSignVeryfy(notifyParam) || !checkUrl((String) notifyParam.get("notify_id"))) {
				rslt.setErrorMsg("支付通知数据校验失败!");
				logger.info("ecode:" + rslt.getErrorCode() + " msg: " + rslt.getErrorMsg());
				return rslt;
			}

			// 对交易状态进行校验
			String trade_status = (String) notifyParam.get("trade_status");

			PayNotifyInfoBo payNotifyInfo = new PayNotifyInfoBo();

			payNotifyInfo.setDealStatus(PayDealStatus.UNDEALED);
			payNotifyInfo.setPayBank(PayPlatformType.ALI_PAY);
			payNotifyInfo.setPayNotifyData(JSONObject.fromObject(notifyParam).toString());
			payNotifyInfo.setErrorCode(trade_status);

			if (trade_status.equals(AliPayConst.TRADE_SUCCESS) || trade_status.equals(AliPayConst.TRADE_FINISHED)) {// 需要处理

				payNotifyInfo.setDealStatus(PayDealStatus.UNDEALED);

				rslt.setErrorCode(BaseDto.SUCCESS);

			} else {// 需要再次检验

				payNotifyInfo.setDealStatus(PayDealStatus.NEED_CHECK);

				rslt.setErrorMsg("支付失败!");
			}

			String id = pnbs.addPayNotifyInfo(payNotifyInfo);

			/**
			 * 如果支付验证合法,则启动通知处理
			 */
			if (rslt.getErrorCode().equals(BaseDto.SUCCESS)) {
				dealPaymentNotify(id);
			}

			return rslt;

		} catch (Exception e) {
			throw new SysException(ErrorCodeConst.CODE_ERROR, e);
		}
	}

	@Override
	public BaseDto alipayByOrderId(String mOrderId, String userId, Integer userType) {
		try {

			logger.info("订单支付入参: mOrderId=" + mOrderId + " userId=" + userId + " userType=" + userType);

			BaseDto rslt = new BaseDto();

			rslt.setErrorCode(BaseDto.ERROR);

			Map<String, Object> params = new HashMap<String, Object>();

			MainOrderDto mOrder = mobs.findById(mOrderId);
			if (mOrder == null) {
				rslt.setErrorMsg(mOrderId + "订单不存在!");
				return rslt;
			}

			if (mOrder.getStatus() != CodeConst.MainOrderStatus.PAY_NO) {
				rslt.setErrorMsg(mOrderId + "订单不可以支付!");
				return rslt;
			}

			params.put("service", "alipay.wap.create.direct.pay.by.user");
			params.put("partner", AliPayConst.PARTNER);
			params.put("seller_email", AliPayConst.SELLER_EMAIL);
			params.put("_input_charset", AliPayConst.INPUT_CHARSET);
			params.put("payment_type", AliPayConst.PAYMENT_TYPE);
			params.put("notify_url", AliPayConst.ALIPAY_NOTIFY_URL);
			params.put("return_url", AliPayConst.ALIPAY_RETURN_RUL);
			params.put("out_trade_no", mOrder.getMorderCode());
			params.put("subject", "订单号:" + mOrder.getMorderCode());
			params.put("total_fee",
					mOrder.getTotalMoney().divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP));
			params.put("body", "订单号:" + mOrder.getMorderCode());
			params.put("extern_token", userId + "," + userType);
			params.put("it_b_pay", AliPayConst.DELAY_TIME);

			rslt.setErrorCode(BaseDto.SUCCESS);

			Map<String, String> request = buildRequestPara(params);

			rslt.setReturnId(AliPayConst.ALIPAY_GATEWAY_NEW + createLinkString(request));

			return rslt;

		} catch (Exception e) {

			logger.info("订单支付异常,入参: mOrderId=" + mOrderId + " userId=" + userId + " userType=" + userType);

			logger.error("订单支付异常", e);

			throw new SysException(ErrorCodeConst.CODE_ERROR, e);
		}
	}

	@Override
	public PaymentInfoDto findPaymentByMainOrderId(String mOrderId) {
		try {
			PaymentScDto searchCondition = new PaymentScDto();
			searchCondition.setOrderId(mOrderId);
			// searchCondition.setOrderType(PayOrderType.SALE_ORDER);
			List<PaymentInfoDto> rslt = pbs.listByCondition(searchCondition);
			if (rslt != null && rslt.size() > 0) {
				return rslt.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new SysException(ErrorCodeConst.CODE_ERROR, e);
		}
	}

	@Transactional
	@Override
	public BaseDto dealPaymentNotify(String notifyId) {

		try {

			BaseDto rslt = new BaseDto();
			Boolean ret = false;

			PayNotifyInfoDto payNotify = pnbs.findById(notifyId);

			if (payNotify == null) { // 支付通知不存在
				rslt.setErrorCode(BaseDto.ERROR);
				rslt.setErrorMsg("支付通知不存在");
				return rslt;
			}

			// 支付通知未处理,则处理
			if (payNotify.getStatus().equals(PayDealStatus.UNDEALED)) {
				switch (payNotify.getPayBank()) {
				case PayPlatformType.ALI_PAY: { // alipay
					ret = dealAliPayNotify(payNotify.getPayNotifyData());
				}
				case PayPlatformType.WIXIN_PAY: {
					break;
				}
				case PayPlatformType.BANK_PAY: {
					break;
				}
				case PayPlatformType.CREDIT_PAY: {
					break;
				}
				default:
					break;
				}
			}

			if (ret) {
				rslt.setErrorCode(BaseDto.SUCCESS);
			} else {
				rslt.setErrorCode(BaseDto.ERROR);
				rslt.setErrorMsg("处理支付通知失败");
			}
			return rslt;

		} catch (Exception e) {

			logger.error("处理支付通知出现系统异常", e);

			throw new SysException(ErrorCodeConst.CODE_ERROR, e);
		}
	}

	@Transactional
	@Override
	public BaseDto payOrder(PaymentInfoDto payment) {
		try {
			BaseDto rslt = new BaseDto();

			PaymentInfoBo paymentInfo = new PaymentInfoBo();
			// paymentInfo.setId(id);
			paymentInfo.setInAccount(payment.getInAccount());
			paymentInfo.setLastOperator(payment.getLastOperator());
			paymentInfo.setOrderCode(payment.getOrderCode());
			paymentInfo.setOrderId(payment.getOrderId());
			paymentInfo.setOrderType(payment.getOrderType());
			paymentInfo.setOutAccount(payment.getOutAccount());
			paymentInfo.setPayAmount(payment.getPayAmount());
			paymentInfo.setPayBank(payment.getPayBank());
			// paymentInfo.setPayCode(payCode);
			paymentInfo.setPayerId(payment.getPayerId());
			paymentInfo.setPayRemark(payment.getPayRemark());
			paymentInfo.setPayTime(payment.getPayTime());
			paymentInfo.setPayWaterno(payment.getPayWaterno());
			paymentInfo.setPayWay(payment.getPayWay());
			paymentInfo.setOrderType(payment.getOrderType());
			paymentInfo.setTradeId(payment.getTradeId());

			pbs.addPaymentInfo(paymentInfo);

			// AfterSaleOrderDto asOrder =
			// asobs.findafterSaleOrderById(payment.getOrderId());
			// if (asOrder == null) {
			// Log.error("售后申请不存在");
			// throw new BizzException(ErrorCodeConst.AFTERSALE_APPLY_NOT_EXIST,
			// "售后申请不存在");
			// }
			// asbs.chgStatusById(asOrder.getAsApplyId(),
			// String.valueOf(paymentInfo.getLastOperator()),
			// CodeConst.SaleApplyStatus.CLOSED);

			// 如果是售后订单,则将售后订单状态修改成已退款
			// if (!payment.getOrderType().equals(CodeConst.SaleOrderType.SALE))
			// {
			// AfterSaleOrderBo afterSaleOrderBo = new AfterSaleOrderBo();
			// afterSaleOrderBo.setAsOrderId(payment.getOrderId());
			// afterSaleOrderBo.setStatus(CodeConst.AsOrderStatus.PAYED);
			// asobs.modifyAfterSaleOrder(afterSaleOrderBo);
			// }

			// 如果是整单退款,则将售后订单的原始订单状态修改为已退款
			// if
			// (payment.getOrderType().equals(CodeConst.SaleOrderType.ORDER_REFUND))
			// {
			// AfterSaleOrderBo afterSaleOrderBo = new AfterSaleOrderBo();
			// afterSaleOrderBo.setAsOrderId(payment.getOrderId());
			// afterSaleOrderBo.setStatus(CodeConst.OrderStatus.REFUNDED);
			// // AfterSaleOrderDto asod =
			// // asobs.findafterSaleOrderById(payment.getOrderId());
			// if (asod != null) {
			// sobs.modifyStatusById(asod.getSaleOrderId(),
			// CodeConst.OrderStatus.REFUNDED,
			// String.valueOf(payment.getLastOperator()));
			// } else {
			// throw new BizzException(ErrorCodeConst.ORDER_NOT_EXIST,
			// "销售订单不存在");
			// }
			// }

			rslt.setErrorCode(BaseDto.SUCCESS);

			return rslt;

		} catch (BizzException exp) {
			throw exp;
		} catch (Exception e) {
			logger.error("退款订单退款失败!");
			throw new SysException(ErrorCodeConst.CODE_ERROR, e);
		}
	}

	@Override
	public PayErrorInfoDto findPayErrorStatusByOrderCode(String orderCode) {
		try {
			PayErrorInfoScDto searchCondition = new PayErrorInfoScDto();
			searchCondition.setOrderCode(orderCode);
			List<PayErrorInfoDto> rslt = pebs.listByCondition(searchCondition);
			if (rslt != null && rslt.size() > 0) {
				return rslt.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new SysException(ErrorCodeConst.CODE_ERROR, e);
		}
	}

	@Transactional
	@Override
	public BaseDto confirmPayError(Long userId, String remark, String orderCode) {
		try {
			BaseDto rslt = new BaseDto();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateTime = sdf.format(new Date());
			PayErrorInfoBo payErrorInfo = new PayErrorInfoBo();
			payErrorInfo.setDealRemark(remark);
			payErrorInfo.setDealPerson(userId);
			payErrorInfo.setDealTime(dateTime);
			payErrorInfo.setOrderCode(orderCode);
			payErrorInfo.setDealStatus(PayErrorDealStatus.DEALED);

			Boolean rt = pebs.moidfyOrderCode(payErrorInfo);

			if (rt) {
				rslt.setErrorCode(BaseDto.SUCCESS);
			} else {
				rslt.setErrorCode(BaseDto.ERROR);
			}

			return rslt;

		} catch (Exception e) {
			throw new SysException(ErrorCodeConst.CODE_ERROR, e);
		}
	}

	private Map<String, String> buildRequestPara(Map<String, Object> sParaTemp) {
		// 除去数组中的空值和签名参数
		Map<String, String> sPara = paraFilter(sParaTemp);
		// 生成签名结果
		String mysign = buildRequestMysign(sPara);

		// 签名结果与签名方式加入请求提交参数组中
		sPara.put("sign", mysign);
		sPara.put("sign_type", AliPayConst.SIGN_TYPE);

		return sPara;
	}

	/**
	 * 根据反馈回来的信息，生成签名结果
	 * 
	 * @param Params
	 *            通知返回来的参数数组
	 * @param sign
	 *            比对的签名结果
	 * @return 生成的签名结果
	 */
	private boolean getSignVeryfy(Map<String, Object> Params) {
		// 过滤空值、sign与sign_type参数
		Map<String, String> sParaNew = paraFilter(Params);

		String sign = (String) Params.get("sign");
		// 获取待签名字符串
		String preSignStr = createLinkString(sParaNew);
		// 获得签名验证结果
		boolean isSign = false;
		if (AliPayConst.SIGN_TYPE.equals("MD5")) {
			isSign = MD5.verify(preSignStr, sign, AliPayConst.KEY, AliPayConst.INPUT_CHARSET);
		}
		return isSign;
	}

	/**
	 * 获取远程服务器ATN结果
	 * 
	 * @param notify_id
	 *            指定URL路径地址
	 * @return 服务器ATN结果 验证结果集： invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空 true
	 *         返回正确信息 false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
	 */
	private Boolean checkUrl(String notify_id) {

		String veryfy_url = AliPayConst.HTTPS_VERIFY_URL + "partner=" + AliPayConst.PARTNER + "&notify_id=" + notify_id;

		String inputLine = "";

		try {
			URL url = new URL(veryfy_url);
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			inputLine = in.readLine().toString();
		} catch (Exception e) {
			logger.error(e.getMessage());
			inputLine = "";
		}

		return inputLine.equals("true");
	}

	/**
	 * 生成签名结果
	 * 
	 * @param sPara
	 *            要签名的数组
	 * @return 签名结果字符串
	 */
	private String buildRequestMysign(Map<String, String> sPara) {
		String prestr = createLinkString(sPara); // 把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
		String mysign = "";
		if (AliPayConst.SIGN_TYPE.equals("MD5")) {
			mysign = MD5.sign(prestr, AliPayConst.KEY, AliPayConst.INPUT_CHARSET);
		}
		return mysign;
	}

	/**
	 * 除去数组中的空值和签名参数
	 * 
	 * @param sArray
	 *            签名参数组
	 * @return 去掉空值与签名参数后的新签名参数组
	 */
	private Map<String, String> paraFilter(Map<String, Object> sArray) {

		Map<String, String> result = new HashMap<String, String>();

		if (sArray == null || sArray.size() <= 0) {
			return result;
		}

		for (String key : sArray.keySet()) {
			String value = sArray.get(key).toString();
			if (value == null || value.equals("") || key.equalsIgnoreCase("sign")
					|| key.equalsIgnoreCase("sign_type")) {
				continue;
			}
			result.put(key, value);
		}

		return result;
	}

	/**
	 * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
	 * 
	 * @param params
	 *            需要排序并参与字符拼接的参数组
	 * @return 拼接后字符串
	 */
	public String createLinkString(Map<String, String> params) {

		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);

		String prestr = "";

		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = params.get(key);

			if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符
				prestr = prestr + key + "=" + value;
			} else {
				prestr = prestr + key + "=" + value + "&";
			}
		}

		return prestr;
	}

	/**
	 * 处理alipay支付通知数据
	 * @param payNotifyData
	 * @return
	 */
	private Boolean dealAliPayNotify(String payNotifyData) {
		try {
			JSONObject paymentData = JSONObject.fromObject(payNotifyData);

			// 公用回传参数 userId + "," + userType
			String extra = String.valueOf(paymentData.get("extra_common_param"));
			// 商户网站唯一订单号
			String orderId = String.valueOf(paymentData.get("out_trade_no"));
			// 支付宝交易号
			String tradeNo = String.valueOf(paymentData.get("trade_no"));
			// 交易付款时间
			String payTime = String.valueOf(paymentData.get("gmt_payment"));
			// 交易金额
			BigDecimal totalMoney = new BigDecimal(String.valueOf(paymentData.get("total_fee")));
			// 卖家支付宝账户号
			String inAccount = String.valueOf(paymentData.get("seller_id"));
			// 买家支付宝账户号
			String outAccount = String.valueOf(paymentData.get("buyer_id"));

			String[] tmp = extra.split(",");
			String userId = tmp[0];
			Integer userType = Integer.valueOf(tmp[1]);

			if (userType.equals(CodeConst.PayerType.CLIENT)) { // 销售订单支付处理

				MainOrderDto mOrder = mobs.findById(orderId);

				// 支付无订单
				if (mOrder == null) {
					return false;
				}

				// 支付金额不对
				if (mOrder.getTotalMoney().compareTo(totalMoney) != CodeConst.RESULT_0) {
					return false;
				}

				PaymentInfoBo payment = new PaymentInfoBo();

				payment.setOrderId(orderId);
				payment.setOrderType(CodeConst.SaleOrderType.SALE);
				payment.setOrderCode(mOrder.getMorderCode());

				payment.setInAccount(inAccount);
				payment.setOutAccount(outAccount);

				payment.setPayerId(userId);
				payment.setPayerType(userType);

				payment.setPayBank(PayPlatformType.ALI_PAY);
				payment.setPayTime(payTime);
				payment.setPayWay(CodeConst.RESULT_0); // 线上支付
				payment.setPayWaterno(tradeNo);
				payment.setTradeId(tradeNo);
				payment.setPayAmount(totalMoney);
				payment.setPayRemark("");

				payment.setLastOperator(userId);

				// 销售订单增加支付信息
				pbs.addPaymentInfo(payment);

				// 更新销售订单的状态
				msos.morderPayment(orderId, totalMoney, payTime, userId);

				return true;

			} else if (userType.equals(CodeConst.PayerType.PLATFORM)) { // 售后订单退款支付处理
				return false;
			}

			return false;

		} catch (Exception e) {
			return false;
		}
	}

}
