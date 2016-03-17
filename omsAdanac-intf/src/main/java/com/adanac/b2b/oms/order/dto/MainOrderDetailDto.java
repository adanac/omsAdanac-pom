package com.adanac.b2b.oms.order.dto;

import java.io.Serializable;
import java.util.List;

import com.adanac.b2b.oms.order.bo.MainOrderBo;

/**
 * 主订单详细信息类（主订单+子订单详情列表）
 * @author adanac
 * @version 1.0
 */
public class MainOrderDetailDto implements Serializable {

	private static final long serialVersionUID = 2384600818527126273L;

	private MainOrderBo mainOrder;

	private List<SaleOrderDetailDto> orderDetailList;

	public List<SaleOrderDetailDto> getOrderDetailList() {
		return orderDetailList;
	}

	public void setOrderDetailList(List<SaleOrderDetailDto> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}

	public MainOrderBo getMainOrder() {
		return mainOrder;
	}

	public void setMainOrder(MainOrderBo mainOrder) {
		this.mainOrder = mainOrder;
	}

}
