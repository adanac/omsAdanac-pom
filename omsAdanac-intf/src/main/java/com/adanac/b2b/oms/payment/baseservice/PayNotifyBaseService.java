package com.adanac.b2b.oms.payment.baseservice;

import java.util.List;

import com.adanac.b2b.oms.payment.bo.PayNotifyInfoBo;
import com.adanac.b2b.oms.payment.dto.PayNotifyInfoDto;
import com.adanac.b2b.oms.payment.dto.PayNotifyInfoScDto;

/**
 * 订单支付通知基础服务接口
 * @author adanac
 * @version 1.0
 */
public interface PayNotifyBaseService {
	/**
	 * 增加支付通知信息
	 * @param payNotifyInfo
	 * @return 主键
	 */
	public String addPayNotifyInfo(PayNotifyInfoBo payNotifyInfo);

	/**
	 * 根据ID修改支付通知信息
	 * @param payNotifyInfo
	 * @return 成功返回TRUE,失败返回FASLE
	 */
	public Boolean modifyPayNotifyInfo(PayNotifyInfoBo payNotifyInfo);

	/**
	 * 根据ID修改支付通知信息
	 * @param id
	 * @return 支付通知信息
	 */
	public PayNotifyInfoDto findById(String id);

	/**
	 * 对支付信息处理
	 * @param id
	 * @return
	 */
	public Boolean dealWithPayment(String id);

	/**
	 * 查询符合条件的支付通知列表
	 * @param searchCondition
	 * @return 支付通知信息列表
	 */
	public List<PayNotifyInfoDto> listByCondition(PayNotifyInfoScDto searchCondition);
}
