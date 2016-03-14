package com.adanac.b2b.oms.payment.baseservice;

import java.util.List;

import com.adanac.b2b.oms.payment.bo.PayErrorInfoBo;
import com.adanac.b2b.oms.payment.dto.PayErrorInfoDto;
import com.adanac.b2b.oms.payment.dto.PayErrorInfoScDto;

/**
 * 订单支付异常基础服务接口, PayErrorBaseService
 * @author adanac
 * @version 1.0
 */
public interface PayErrorBaseService {
	/**
	 * 增加支付异常信息
	 * @param payErrorInfo
	 * @return 返回主键
	 */
	public String addPayErrorInfo(PayErrorInfoBo payErrorInfo);

	/**
	 * 修改支付异常信息
	 * @param payErrorInfo
	 * @return 成功返回TRUE,失败返回FALSE
	 */
	public Boolean moidfyPayErrorInfo(PayErrorInfoBo payErrorInfo);

	/**
	 * 根据支付编码修改支付异常信息
	 * @param payErrorInfo
	 * @return 成功返回TRUE,失败返回FALSE
	 */
	public Boolean moidfyOrderCode(PayErrorInfoBo payErrorInfo);

	/**
	 * 根据支付异常ID查找异常信息
	 * @param id
	 * @return 异常信息
	 */
	public PayErrorInfoDto findById(String id);

	/**
	 * 查找符合条件的支付异常信息
	 * @param searchCondition
	 * @return 异常信息列表
	 */
	public List<PayErrorInfoDto> listByCondition(PayErrorInfoScDto searchCondition);
}
