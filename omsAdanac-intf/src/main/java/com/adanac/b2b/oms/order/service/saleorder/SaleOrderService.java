package com.adanac.b2b.oms.order.service.saleorder;

import java.util.List;

import com.adanac.b2b.oms.order.dto.OrderSearchConditionDto;
import com.adanac.b2b.oms.order.dto.SaleOrderDto;
import com.adanac.b2b.oms.order.dto.SumUserOrdersDto;
import com.adanac.framework.page.Pager;

/**
 * 订单服务接口
 * @author adanac
 * @version 1.0
 */
public interface SaleOrderService {

	/**
	 * 根据订单主键拒收订单
	 * @param orderId 订单物理主键
	 * @return 成功返回当头状态
	 */
	public Boolean rejectByOrderId(String orderId, String operatorId);

	/**
	 * 根据订单ID确认收货
	 * @param orderId 订单物理主键
	 * @param userId 操作人员ID
	 * @return 成功返回true,失败返回false
	 */
	public Boolean receiveByOrderId(String orderId, String userId);

	/**
	 * 订单发货
	 * @param orderId 订单物理主键
	 * @param userId 操作人员ID
	 * @param deliveryTime 发货时间
	 * @return 成功返回true,失败返回false
	 */
	public Boolean deliveryByOrderId(String orderId, String userId, String deliveryTime);

	/**
	 * 根据订单主键取消订单
	 * @param orderId 订单物理主键
	 * @return true:成功取消;false取消失败
	 */
	public Boolean cancleByOrderId(String orderId, String operatorId);

	/**
	 * 根据订单编号取消订单
	 * @param orderCode 订单编码
	 * @return true:成功取消;false取消失败
	 */
	public Boolean cancleByOrderCode(String orderCode, String operatorId);

	// =========================================查询接口==============================================//

	/**
	 * 根据订单ID查找订单
	 * @param orderId 订单ID
	 * @return 订单信息
	 */
	public SaleOrderDto findById(String orderId);

	/**
	 * 根据订单编号查找订单
	 * @param orderCode 订单编号
	 * @return 订单信息
	 */
	public SaleOrderDto findByCode(String orderCode);

	/**
	 * 分页查询符合条件的订单信息
	 * @param searchCondition 查询条件
	 * @param pageSize 每页面的最多记录条数
	 * @param pageNumber 页面的序号, 从1开始
	 * @return 订单信息的分页列表
	 */
	public Pager<SaleOrderDto> pageByCondition(OrderSearchConditionDto searchCondition, Integer pageSize,
			Integer pageNumber);

	/**
	 * 查询符合条件的订单列表
	 * @param searchCondition
	 * @return 订单列表信息
	 */
	public List<SaleOrderDto> listByCondition(OrderSearchConditionDto searchCondition);

	/**
	 * 根据宝宝店用户ID统计订单数量
	 * @param userId 宝宝店用户ID
	 * @return 宝宝店用户订单统计列表
	 */
	public List<SumUserOrdersDto> sumUserOrders(String userId);

	/**
	 * 根据宝宝店用户ID统计待评价订单数量
	 * @param userId 宝宝店用户ID
	 * @return 宝宝店用户订单统计列表
	 */
	public Integer sumEvaluatedUserOrders(String userId);

	/**
	 * 根据主订单ID查找该主订单下的订单
	 * @param morderId 主订单ID
	 * @return 该主订单下的所有订单
	 */
	public List<SaleOrderDto> listByMainOrderId(String morderId);

}
