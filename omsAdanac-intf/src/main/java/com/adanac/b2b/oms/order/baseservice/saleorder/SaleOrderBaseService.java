package com.adanac.b2b.oms.order.baseservice.saleorder;

import java.util.List;

import com.adanac.b2b.oms.order.bo.SaleOrderBo;
import com.adanac.b2b.oms.order.dto.SaleOrderDto;

/**
 * 订单基础服务接口
 * @author adanac
 * @version 1.0
 */
public interface SaleOrderBaseService {
	/**
	 * 创建订单
	 * @param order 订单信息
	 * @return 主键
	 */
	public String createOrder(SaleOrderBo order);

	/**
	 * 根据订单主键取消订单
	 * @param orderId 订单物理主键
	 * @return 成功返回当头状态
	 */
	public Boolean cancleByOrderId(String orderId, String operatorId);

	/**
	 * 根据订单主键拒收订单
	 * @param orderId 订单物理主键
	 * @return 成功返回当头状态
	 */
	public Boolean rejectByOrderId(String orderId, String operatorId);

	/**
	 * 修改订单售后未审批状态
	 * @param orderId
	 * @param operatorId
	 * @param status
	 * @return 修改后的状态
	 */
	public Boolean chgAfterSaleStatusByOrderId(String orderId, String operatorId, int status);

	/**
	 * 根据订单ID支付订单
	 * @param orderId 订单物理主键
	 * @param operatorId 操作人员id
	 * @return 成功返回当头状态
	 */
	public Boolean payByOrderId(String orderId, String operatorId);

	/**
	 * 根据订单ID确认收货
	 * @param orderId
	 * @param operatorId
	 * @return
	 */
	public Boolean receiveByOrderId(String orderId, String operatorId);

	/**
	 * 根据售后订单ID退款
	 * @param orderId 售后订单物理主键
	 * @param operatorId 操作人员id
	 * @return 成功返回当头状态
	 */
	public Boolean payAfterSaleByOrderId(String orderId, String operatorId);

	/**
	 * 将销售订单设置成已退款状态
	 * @param orderId 订单物理主键
	 * @param operatorId 操作人员id
	 * @return 成功返回当头状态
	 */
	public Boolean chg2RefundByOrderId(String orderId, String operatorId);

	/**
	 * 根据订单ID支付多个订单
	 * @param orderIds 订单物理主键
	 * @param operatorId 操作人员id
	 * @return true:成功取消;false取消失败
	 */
	public Boolean payByOrderIds(List<String> orderIds, String operatorId);

	/**
	 * 根据订单ID查找订单
	 * @param orderId 订单ID
	 * @return 订单信息
	 */
	public SaleOrderBo findByOrderId(String orderId);

	/**
	 * 根据订单编号查找订单
	 * @param orderCode 订单编号
	 * @return 订单信息
	 */
	public SaleOrderBo findByOrderCode(String orderCode);

	/**
	 * 订单发货
	 * @param orderId
	 * @param userId
	 * @param deliveryTime 发货时间
	 * @return 退款退货成功 返回true,失败 返回false
	 */
	public Boolean deliveryByOrderId(String orderId, String userId, String deliveryTime);

	/**
	 * 根据订单编号取消订单
	 * @param orderCode 订单编码
	 * @param operatorId 操作人员id
	 * @return true:成功取消;false取消失败
	 */
	public Boolean cancleByOrderCode(String orderCode, String operatorId);

	/**
	 * 根据主订单ID查找该主订单下的订单
	 * @param morderId 主订单ID
	 * @return 该主订单下的所有订单
	 */
	public List<SaleOrderDto> listByMainOrderId(String morderId);

	/**
	 * 根据订单ID修改订单状态
	 * @param id
	 * @param status
	 * @param userId
	 * @return true:成功; false失败
	 */
	public Boolean modifyStatusById(String id, int status, String userId);

	/**
	 * 更新订单的评价状态
	 * @param orderId
	 * @return true:成功; false失败
	 */
	public Boolean updateEvaluateStatus(String orderId);
}
