package com.adanac.b2b.oms.order.service.saleorder;

import java.util.ArrayList;
import java.util.List;

import com.adanac.b2b.oms.order.dto.WaybillDto;

/**
 * 运单服务接口
 * @author adanac
 * @version 1.0
 */
public interface WaybillService {

	/**
	 * 创建运单
	 * @param deliveryInfo 运单信息
	 * @return 主键
	 */
	public String createWaybill(WaybillDto deliveryInfo);

	/**
	 * 查询运单信息
	 * @param orderId 订单ID
	 * @return
	 */
	public List<WaybillDto> findWaybillList(String orderId);

	/**
	 * 修改运单信息
	 * @param deliveryInfo 运单信息
	 * @return
	 */
	public Boolean updateWaybill(WaybillDto deliveryInfo);

	/**
	 * 删除运单信息
	 * @param ids 主键列表
	 * @return
	 */
	public Boolean deleteWaybills(ArrayList<String> ids);
}
