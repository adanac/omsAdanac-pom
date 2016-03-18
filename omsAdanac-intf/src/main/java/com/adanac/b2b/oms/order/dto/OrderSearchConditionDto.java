package com.adanac.b2b.oms.order.dto;

import java.io.Serializable;

public class OrderSearchConditionDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 942234497232036508L;

	/**
	 * 订单ID
	 */
	private String orderId;

	/**
	 * 售后申请ID
	 */
	private String aftersaleApplyID;

	/**
	 * 原始订单ID
	 */
	private String orgOrderId;

	/**
	 * 客户ID(商家的用户ID)
	 */
	private String userId;

	/**
	 * 商家ID
	 */
	private String merchantId;

	/**
	 * 供应商ID
	 */
	private String supplierId;

	/**
	 * 订单种类: 暂时无用（如：团购订单等）
	 */
	private String category;

	/**
	 * 订单类型: 0：正向订单、1：售后订单
	 * 以逗号分隔：1,2,3
	 */
	private String type;

	/**
	 * 订单状态:0：待支付1：待发货2：待收货3：已完成4：已评价5：已取消 6：售后待收货7：售后已收货8：售后已退款9：售后完成
	 * 以逗号分隔：1,2,3,4
	 */
	private String status;

	/**
	 * 售后订单状态:
	 */
	private Integer aftersaleStatus;

	/**
	 * 订单来源渠道: 0手机;1PAD
	 */
	private Integer channel;

	/**
	 * 订单生成开始时间
	 */
	private String startTime;

	/**
	 * 订单生成结束时间
	 */
	private String endTime;

	/**
	 * 订单关闭原因: 1自己关闭; 0系统关闭
	 */
	private Integer closeType;

	/**
	 * 订单关闭开始时间
	 */
	private String startCloseTime;

	/**
	 * 订单关闭结束时间
	 */
	private String endCloseTime;

	/**
	 * 是否有发标识: 0无发票;1有发票
	 */
	private Integer isReceipt;

	/**
	 * 订单编码:年+月+日+供应商编码+三位流水
	 */
	private String orderCode;

	/**
	 * 申请单类型
	 */
	private Integer asType;

	/**
	 * 申请状态
	 */
	private Integer asStatus;

	/**
	 * 申请状态取非值 
	 */
	private Integer asStatusNot;

	/**
	 * 申请状态为是否为NULL:　1:　NULL;0:　NOT NULL
	 */
	private Integer asStatusNull;

	/**
	 * 商品名称
	 */
	private String productName;

	/**
	 * 支付开始时间
	 */
	private String payStartTime;

	/**
	 * 支付结束时间
	 */
	private String payEndTime;
	/**
	 * 发货开始时间
	 */
	private String deliveryStartTime;

	/**
	 * 发货结束时间
	 */
	private String deliveryEndTime;
	/**
	 * 主订单ID
	 */
	private String morderId;

	/**
	 * 主订单编码
	 */
	private String morderCode;

	/**
	 * 支付方式: 1支付宝,2微信.....
	 */
	private Integer payBank;

	/**
	 * 订单评价状态标识:0未评价;1已评价(订单中所有订单项都评价才算已评价)
	 */
	private Integer evaluated;

	public Integer getPayBank() {
		return payBank;
	}

	public void setPayBank(Integer payBank) {
		this.payBank = payBank;
	}

	public String getMorderCode() {
		return morderCode;
	}

	public void setMorderCode(String morderCode) {
		this.morderCode = morderCode;
	}

	public Integer getEvaluated() {
		return evaluated;
	}

	public void setEvaluated(Integer evaluated) {
		this.evaluated = evaluated;
	}

	public String getMorderId() {
		return morderId;
	}

	public void setMorderId(String morderId) {
		this.morderId = morderId;
	}

	public String getPayStartTime() {
		return payStartTime;
	}

	public void setPayStartTime(String payStartTime) {
		this.payStartTime = payStartTime;
	}

	public String getPayEndTime() {
		return payEndTime;
	}

	public void setPayEndTime(String payEndTime) {
		this.payEndTime = payEndTime;
	}

	public Integer getAsType() {
		return asType;
	}

	public void setAsType(Integer asType) {
		this.asType = asType;
	}

	public Integer getAsStatus() {
		return asStatus;
	}

	public void setAsStatus(Integer asStatus) {
		this.asStatus = asStatus;
	}

	public Integer getAsStatusNot() {
		return asStatusNot;
	}

	public void setAsStatusNot(Integer asStatusNot) {
		this.asStatusNot = asStatusNot;
	}

	public Integer getAsStatusNull() {
		return asStatusNull;
	}

	public void setAsStatusNull(Integer asStatusNull) {
		this.asStatusNull = asStatusNull;
	}

	/**
	 * 获取订单编码
	 * @return 订单编码
	 */
	public String getOrderCode() {
		return orderCode;
	}

	/**
	 * 设置订单编码
	 * @param orderCode 订单编码
	 * @return 无返回值
	 */
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	/**
	 * 获取订单ID
	 * @return 订单ID
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * 设置订单ID
	 * @param orderId 订单ID
	 * @return 无返回值
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * 获取售后申请ID
	 * @return 返回售后申请ID
	 */
	public String getAftersaleApplyID() {
		return aftersaleApplyID;
	}

	/**
	 * 设置售后申请ID
	 * @param aftersaleApplyID 售后申请ID
	 * @return 无返回值
	 */
	public void setAftersaleApplyID(String aftersaleApplyID) {
		this.aftersaleApplyID = aftersaleApplyID;
	}

	/**
	 * 获取原始订单ID
	 * @return 返回原始订单ID
	 */
	public String getOrgOrderId() {
		return orgOrderId;
	}

	/**
	 * 设置原始订单ID
	 * @param orgOrderId 原始订单ID
	 * @return 无返回值
	 */
	public void setOrgOrderId(String orgOrderId) {
		this.orgOrderId = orgOrderId;
	}

	/**
	 * 获取客户ID
	 * @return 返回客户ID
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 设置客户ID
	 * @param userId 客户ID
	 * @return 无返回值
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 获取商家ID
	 * @return 商家ID
	 */
	public String getMerchantId() {
		return merchantId;
	}

	/**
	 * 设置商家ID
	 * @param merchantId 商家ID
	 * @return 无返回值
	 */
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	/**
	 * 获取供应商ID
	 * @return 供应商ID
	 */
	public String getSupplierId() {
		return supplierId;
	}

	/**
	 * 设置供应商ID
	 * @param supplierId 供应商ID
	 * @return 无返回值
	 */
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	/**
	 * 获取订单种类
	 * @return 订单种类: 暂时无用（如：团购订单等）
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * 设置订单种类
	 * @param category 订单种类: 暂时无用（如：团购订单等）
	 * @return 无返回值
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * 获取订单类型
	 * @return 订单类型: ZOR：正向订单、ZRE：售后订单
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置订单类型
	 * @param type 订单类型: ZOR：正向订单、ZRE：售后订单
	 * @return 无返回值
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 获取订单状态
	 * @return 订单状态: 0：待支付1：待发货2：待收货3：已完成4：已评价5：已取消 6：售后待收货7：售后已收货8：售后已退款9：售后完成
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 设置订单状态
	 * @param status 订单状态: 0：待支付1：待发货2：待收货3：已完成4：已评价5：已取消 6：售后待收货7：售后已收货8：售后已退款9：售后完成
	 * @return 无返回值
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 获取售后订单状态
	 * @return 售后订单状态
	 */
	public Integer getAftersaleStatus() {
		return aftersaleStatus;
	}

	/**
	 * 设置售后订单状态
	 * @param aftersaleStatus 售后订单状态
	 * @return 无返回值
	 */
	public void setAftersaleStatus(Integer aftersaleStatus) {
		this.aftersaleStatus = aftersaleStatus;
	}

	/**
	 * 获取订单渠道
	 * @return 订单渠道  0：手机、1：pad
	 */
	public Integer getChannel() {
		return channel;
	}

	/**
	 * 设置订单渠道
	 * @param channel 订单渠道 0：手机、1：pad
	 * @return 无返回值
	 */
	public void setChannel(Integer channel) {
		this.channel = channel;
	}

	/**
	 * 获取订单关闭类型
	 * @return 订单关闭类型: 1自己关闭;0系统关闭
	 */
	public Integer getCloseType() {
		return closeType;
	}

	/**
	 * 设置订单关闭类型
	 * @param closeType 订单关闭类型: 1自己关闭;0系统关闭
	 * @return 无返回值
	 */
	public void setCloseType(Integer closeType) {
		this.closeType = closeType;
	}

	/**
	 * 有发票标识
	 * @return 是否有发票标识:0无发票;1有发票
	 */
	public Integer getIsReceipt() {
		return isReceipt;
	}

	/**
	 * 设置是否有发票标识
	 * @param isReceipt 是否有发票标识:1有发票;0无发票
	 * @return 无返回值
	 */
	public void setIsReceipt(Integer isReceipt) {
		this.isReceipt = isReceipt;
	}

	/**
	 * 获取订单创建开始时间
	 * @return 订单创建开始时间
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * 设置订单创建开始时间
	 * @param startTime 订单创建开始时间
	 * @return 无返回值
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * 获取订单创建结束时间
	 * @return 订单创建结束时间
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * 设置订单创建结束时间
	 * @param endTime 订单创建结束时间
	 * @return 无返回值
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 * 获取订单关闭开始时间
	 * @return 订单关闭开始时间
	 */
	public String getStartCloseTime() {
		return startCloseTime;
	}

	/**
	 * 设置订单关闭开始时间
	 * @param startCloseTime 订单关闭开始时间
	 * @return 无返回值
	 */
	public void setStartCloseTime(String startCloseTime) {
		this.startCloseTime = startCloseTime;
	}

	/**
	 * 获取订单关闭结束时间
	 * @return 订单关闭结束时间
	 */
	public String getEndCloseTime() {
		return endCloseTime;
	}

	/**
	 * 设置订单关闭结束时间
	 * @param endCloseTime 订单关闭结束时间
	 * @return 无返回值
	 */
	public void setEndCloseTime(String endCloseTime) {
		this.endCloseTime = endCloseTime;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDeliveryStartTime() {
		return deliveryStartTime;
	}

	public void setDeliveryStartTime(String deliveryStartTime) {
		this.deliveryStartTime = deliveryStartTime;
	}

	public String getDeliveryEndTime() {
		return deliveryEndTime;
	}

	public void setDeliveryEndTime(String deliveryEndTime) {
		this.deliveryEndTime = deliveryEndTime;
	}

}
