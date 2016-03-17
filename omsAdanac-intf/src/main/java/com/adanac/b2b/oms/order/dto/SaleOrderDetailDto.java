package com.adanac.b2b.oms.order.dto;

import java.io.Serializable;
import java.util.List;

import com.adanac.b2b.oms.order.bo.DeliveryReqBo;
import com.adanac.b2b.oms.order.bo.InvoiceReqBo;
import com.adanac.b2b.oms.order.bo.SaleOrderBo;

/**
 * 子订单详细信息类（订单+订单项列表+发票要求+发货要求）
 * @author adanac
 * @version 1.0
 */
public class SaleOrderDetailDto implements Serializable {

	private static final long serialVersionUID = -3242213899606083942L;
	/**
	 * 订单
	 */
	private SaleOrderBo order;
	/**
	 * 订单项列表
	 */
	private List<OrderItemDetailDto> itemDetails;

	/**
	 * 客户发票要求
	 */
	private InvoiceReqBo invoiceReq;

	/**
	 * 客户发货要求
	 */
	private DeliveryReqBo deliveryReq;

	public SaleOrderBo getOrder() {
		return order;
	}

	public void setOrder(SaleOrderBo order) {
		this.order = order;
	}

	public List<OrderItemDetailDto> getItemDetails() {
		return itemDetails;
	}

	public void setItemDetails(List<OrderItemDetailDto> itemDetails) {
		this.itemDetails = itemDetails;
	}

	public InvoiceReqBo getInvoiceReq() {
		return invoiceReq;
	}

	public void setInvoiceReq(InvoiceReqBo invoiceReq) {
		this.invoiceReq = invoiceReq;
	}

	public DeliveryReqBo getDeliveryReq() {
		return deliveryReq;
	}

	public void setDeliveryReq(DeliveryReqBo deliveryReq) {
		this.deliveryReq = deliveryReq;
	}

}
