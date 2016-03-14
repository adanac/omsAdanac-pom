package com.adanac.b2b.oms.payment.baseservice;

import java.util.List;

import com.adanac.b2b.oms.payment.bo.PaymentInfoBo;
import com.adanac.b2b.oms.payment.dto.PaymentInfoDto;
import com.adanac.b2b.oms.payment.dto.PaymentScDto;

/**
 * 订单支付基础服务接口
 * @author adanac
 * @version 1.0
 */
public interface PaymentBaseService {
	/**
	 * 增加支付信息
	 * @param paymetInfo
	 * @return 主键
	 */
	public String addPaymentInfo(PaymentInfoBo paymetInfo);

	/**
	 * 根据ID修改支付信息
	 * @param paymentInfo
	 * @return 成功返回TRUE;失败返回FASLE
	 */
	public Boolean modifyPaymentInfo(PaymentInfoBo paymentInfo);

	/**
	 * 根据ID查找支付信息
	 * @param id
	 * @return 支付信息
	 */
	public PaymentInfoDto findById(String id);

	/**
	 * 查询符合条件支付列表
	 * @param searchCondition
	 * @return 支付列表
	 */
	public List<PaymentInfoDto> listByCondition(PaymentScDto searchCondition);
}
