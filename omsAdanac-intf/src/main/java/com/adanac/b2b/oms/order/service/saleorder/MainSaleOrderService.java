package com.adanac.b2b.oms.order.service.saleorder;

import java.math.BigDecimal;
import java.util.Date;

import com.adanac.b2b.oms.order.dto.MainOrderDetailDto;
import com.adanac.b2b.oms.order.dto.MainOrderDto;
import com.adanac.b2b.oms.order.dto.MainOrderQueryDto;
import com.adanac.framework.page.Pager;

/**
 * 主订单服务接口
 * @author adanac
 * @version 1.0
 */
public interface MainSaleOrderService {
	/**
	 * 创建主订单
	 * @param morder 主订单
	 * @return 订单主键
	 */
	public String createOrder(MainOrderDetailDto mainOrderDetail);

	/**
	 * 对主订单进行付款
	 * @param mOrderId 主订单ID
	 * @return 成功返回true,失败返回false
	 */
	public Boolean payById(String mOrderId, String operatorId);

	/**
	 * 主订单支付,由支付服务调用
	 * @param mOrderId
	 * @param money
	 * @param payTime
	 * @param userId
	 * @return
	 */
	public Boolean morderPayment(String mOrderId, BigDecimal money, String payTime, String userId);

	/**
	 * 对主订单进行付款
	 * @param mOrderId
	 * @param money
	 * @param payTime
	 * @param userId
	 * @return 成功返回true,失败返回false
	 */
	public Boolean orderPayment(String mOrderId, BigDecimal money, Date payTime, String userId);

	/**
	 * 取消主订单,对未支付的订单进行取消
	 * @param mOrderId 主订单ID
	 * @return 成功返回true,失败返回false
	 */
	public Boolean cancleById(String mOrderId, String operatorId);

	// ==========================查询业务=======================================//
	/**
	 * 根据主订单ID查找主订单内容
	 * @param mOrderId 主订单ID
	 * @return 主订单内容
	 */
	public MainOrderDto findById(String mOrderId);

	/**
	 * 分页查询符合条件的主订单
	 * @param searchCondition 查询条件
	 * @param pageSize 每页面的最多记录条数
	 * @param pageNumber 页面的序号, 从1开始
	 * @return 主订单信息分页列表
	 */
	public Pager<MainOrderDto> pageByCondition(MainOrderQueryDto searchCondition, Integer pageSize, Integer pageNumber);
}
