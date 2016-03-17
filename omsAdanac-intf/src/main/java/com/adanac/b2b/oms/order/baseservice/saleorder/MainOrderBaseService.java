package com.adanac.b2b.oms.order.baseservice.saleorder;

import com.adanac.b2b.oms.order.bo.MainOrderBo;
import com.adanac.b2b.oms.order.dto.MainOrderDto;
import com.adanac.b2b.oms.order.dto.MainOrderQueryDto;
import com.adanac.framework.page.Pager;

/**
 * 
 * @author adanac
 * @version 1.0
 */
public interface MainOrderBaseService {
	/**
	 * 创建主订单
	 * @param mOrder 主订单ID为自动生成,不需要填写
	 * @return 主订单的主键
	 */
	public String createMainOrder(MainOrderBo mOrder);

	/**
	 * 修改主订单状态
	 * @param status 状态
	 * @return 是否成功
	 */
	public Boolean modifyStatus(String morderId, Integer status);

	/**
	 * 根据主订单ID修改订主订单其它内容
	 * @param mOrder 主订单ID必填,其它内容必须有一个要修改的内容
	 * @return 成功返回true,失败返回false
	 */
	public Boolean modifyById(MainOrderBo mOrder);

	/**
	 * 根据主订单ID查找主订单内容
	 * @param mOrderId 主订单ID
	 * @return 主订单内容
	 */
	public MainOrderDto findById(String mOrderId);

	/**
	 * 分页查询符合条件的主订单
	 * @param mainOrderQueryDto 查询条件
	 * @param pageSize 每页最多记录条数
	 * @param pageNumber 页数,从1开始
	 * @return 主订单的分页列表
	 */
	public Pager<MainOrderDto> pageByCondition(MainOrderQueryDto mainOrderQueryDto, Integer pageSize,
			Integer pageNumber);
}
