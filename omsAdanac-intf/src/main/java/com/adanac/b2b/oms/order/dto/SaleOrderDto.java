package com.adanac.b2b.oms.order.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 子订单
 * @author adanac
 * @version 1.0
 */
public class SaleOrderDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3754096465753472719L;

	/**
	 * 子订单ID
	 */
	private String orderId;

	/**
	 * 主订单ID
	 */
	private String morderId;

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
	 * 供应商名称
	 */
	private String supplierName;

	/**
	 * 订单总金额=运费+销售金额
	 */
	private BigDecimal totalMoney;

	/**
	 * 运费
	 */
	private BigDecimal freightMoney;

	/**
	 * 销售金额
	 */
	private BigDecimal productMoney;

	/**
	 * 人工折扣折让
	 */
	private BigDecimal manualDiscount;

	/**
	 * 自动折扣折让
	 */
	private BigDecimal autoDiscount;

	/**
	 * 订单种类: 暂时无用（如：团购订单等）
	 */
	private Integer category;

	/**
	 * 订单类型: 0：正向订单、1：售后订单
	 */
	private Integer type;

	/**
	 * 订单状态:0：待支付1：待发货2：待收货3：已完成4：已评价5：已取消 6：售后待收货7：售后已收货8：售后已退款9：售后完成
	 */
	private Integer status;

	/**
	 * 售后订单状态: 目前用于标识整单退款和拒收,2标识整退款待审核状态,3标识拒待审核状态,0表示其它售后状态或无售后状态
	 * 请参见CodeConst.AfterSaleStatus中的状态
	 */
	private Integer aftersaleStatus;

	/**
	 * 订单来源渠道: 1手机2PAD
	 */
	private Integer channel;

	/**
	 * 订单创建人员ID
	 */
	private Integer createUser;

	/**
	 * 订单创建时间
	 */
	private String createTime;

	/**
	 * 订单最后更新时间
	 */
	private String updateTime;

	/**
	 * 订单最后更新人员ID
	 */
	private Integer lastOperator;

	/**
	 * 订单关闭原因: 1自己关闭; 0系统关闭
	 */
	private Integer closeType;

	/**
	 * 订单关闭原因
	 */
	private String closeReason;

	/**
	 * 订单关闭时间
	 */
	private String closeTime;

	/**
	 * 是否有发标识: 0无发票;1有发票
	 */
	private Integer isReceipt;

	/**
	 * 供应商预计承诺到货时间
	 */
	private String preArriveTime;

	/**
	 * 订单编码:年+月+日+供应商编码+三位流水
	 */
	private String orderCode;

	/**
	 * 订单备注
	 */
	private String remark;

	/**
	 * 订单发货时间
	 */
	private String deliveryTime;

	/**
	 * 商品数量
	 */
	private Integer productNumber;

	/**
	 * 支付时间
	 */
	private String payTime;

	/**
	 * 支付方式: 0未支付,1支付宝,2微信支付
	 */
	private Integer payBank;

	/**
	 * 主订单编码
	 */
	private String morderCode;

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

	/**
	 * 获取订单备注
	 * @return 订单备注
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置订单备注
	 * @param remark 订单备注
	 * @return 无返回值
	 */
	public void setRemark(String remark) {
		this.remark = remark;
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
	 * 获取供应商ID
	 * @return 返回供应商ID
	 */
	public String getSupplierName() {
		return supplierName;
	}

	/**
	 * 设置供应商名称
	 * @param supplierName
	 * @return 无返回值
	 */
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	/**
	 * 获取订单总额
	 * @return 订单总额
	 */
	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	/**
	 * 设置订单总额
	 * @param totalMoney
	 * @return 无返回值
	 */
	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}

	/**
	 * 获取运费
	 * @return 运费
	 */
	public BigDecimal getFreightMoney() {
		return freightMoney;
	}

	/**
	 * 设置运费
	 * @param freightMoney 运费
	 * @return 无返回值
	 */
	public void setFreightMoney(BigDecimal freightMoney) {
		this.freightMoney = freightMoney;
	}

	/**
	 * 获取销售金额
	 * @return 销售金额
	 */
	public BigDecimal getProductMoney() {
		return productMoney;
	}

	/**
	 * 设置销售金额
	 * @param productMoney 销售金额
	 * @return 无返回值
	 */
	public void setProductMoney(BigDecimal productMoney) {
		this.productMoney = productMoney;
	}

	/**
	 * 获取人工折扣折让
	 * @return 人工折扣折让
	 */
	public BigDecimal getManualDiscount() {
		return manualDiscount;
	}

	/**
	 * 设置人工折扣折让
	 * @param manualDiscount 折扣折让
	 * @return 无返回值
	 */
	public void setManualDiscount(BigDecimal manualDiscount) {
		this.manualDiscount = manualDiscount;
	}

	/**
	 * 获取自动折扣折让
	 * @return 自动折扣折让
	 */
	public BigDecimal getAutoDiscount() {
		return autoDiscount;
	}

	/**
	 * 设置自动折扣折让
	 * @param autoDiscount 自动折扣折让
	 * @return 无返回值
	 */
	public void setAutoDiscount(BigDecimal autoDiscount) {
		this.autoDiscount = autoDiscount;
	}

	/**
	 * 获取订单种类
	 * @return 订单种类: 暂时无用（如：团购订单等）
	 */
	public Integer getCategory() {
		return category;
	}

	/**
	 * 设置订单种类
	 * @param category 订单种类: 暂时无用（如：团购订单等）
	 * @return 无返回值
	 */
	public void setCategory(Integer category) {
		this.category = category;
	}

	/**
	 * 获取订单类型
	 * @return 订单类型: ZOR：正向订单、ZRE：售后订单
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * 设置订单类型
	 * @param type 订单类型: ZOR：正向订单、ZRE：售后订单
	 * @return 无返回值
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * 获取订单状态
	 * @return 订单状态: 0：待支付1：待发货2：待收货3：已完成4：已评价5：已取消 6：售后待收货7：售后已收货8：售后已退款9：售后完成
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 设置订单状态
	 * @param status 订单状态: 0：待支付1：待发货2：待收货3：已完成4：已评价5：已取消 6：售后待收货7：售后已收货8：售后已退款9：售后完成
	 * @return 无返回值
	 */
	public void setStatus(Integer status) {
		this.status = status;
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
	 * 获取订单创建人
	 * @return 订单创建人ID
	 */
	public Integer getCreateUser() {
		return createUser;
	}

	/**
	 * 获取订单创建人
	 * @param createUser 订单创建人ID
	 * @return 无返回值
	 */
	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
	}

	/**
	 * 获取订单创建时间
	 * @return 订单创建时间 
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * 设置创建时间
	 * @param createTime 创建时间
	 * @return 无返回值
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取最后最新时间
	 * @return 最后更新时间
	 */
	public String getUpdateTime() {
		return updateTime;
	}

	/**
	 * 设置最后更新时间
	 * @param updateTime 最后更新时间
	 * @return 无返回值
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 获取最后更新人员
	 * @return 最后更新人人员ID
	 */
	public Integer getLastOperator() {
		return lastOperator;
	}

	/**
	 * 设置最后更新人员
	 * @param lastOperator 最后更新人员ID
	 * @return 无返回值 
	 */
	public void setLastOperator(Integer lastOperator) {
		this.lastOperator = lastOperator;
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

	public

	/**
	 * 获取订单关闭原因
	 * @return  订单关闭原因
	 */
	String getCloseReason() {
		return closeReason;
	}

	/**
	 * 设置订单关闭原因
	 * @param closeReason 订单关闭原因
	 * @return 无返回值
	 */
	public void setCloseReason(String closeReason) {
		this.closeReason = closeReason;
	}

	/**
	 * 获取订单关闭时间
	 * @return 订单关闭时间
	 */
	public String getCloseTime() {
		return closeTime;
	}

	/**
	 * 设置订单关闭时间
	 * @param closeTime 订单关闭时间
	 * @return 无返回值
	 */
	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
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
	 * 获取供应商预计承诺到货时间
	 * @return 返回供应商预计承诺到货时间
	 */
	public String getPreArriveTime() {
		return preArriveTime;
	}

	/**
	 * 设置供应商预计承诺到货时间
	 * @param preArriveTime 供应商预计承诺到货时间
	 * @return 无返回值
	 */
	public void setPreArriveTime(String preArriveTime) {
		this.preArriveTime = preArriveTime;
	}

	@Override
	public String toString() {
		return "Order{" + "orderId='" + orderId + '\'' + ", userId='" + userId + '\'' + ", merchantId='" + merchantId
				+ '\'' + ", supplierId='" + supplierId + '\'' + ", supplierName='" + supplierName + '\''
				+ ", totalMoney=" + totalMoney + ", freightMoney=" + freightMoney + ", productMoney=" + productMoney
				+ ", manualDiscount=" + manualDiscount + ", autoDiscount=" + autoDiscount + ", category=" + category
				+ ", type=" + type + ", status=" + status + ", channel=" + channel + ", createUser=" + createUser
				+ ", createTime='" + createTime + '\'' + ", updateTime='" + updateTime + '\'' + ", lastOperator="
				+ lastOperator + ", closeType=" + closeType + ", closeReason='" + closeReason + '\'' + ", closeTime='"
				+ closeTime + '\'' + ", isReceipt=" + isReceipt + ", preArriveTime='" + preArriveTime + '\''
				+ ", orderCode='" + orderCode + '\'' + ", remark='" + remark + '\'' + '}';
	}

	public String getMorderId() {
		return morderId;
	}

	public void setMorderId(String morderId) {
		this.morderId = morderId;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public Integer getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(Integer productNumber) {
		this.productNumber = productNumber;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public Integer getAftersaleStatus() {
		return aftersaleStatus;
	}

	public void setAftersaleStatus(Integer aftersaleStatus) {
		this.aftersaleStatus = aftersaleStatus;
	}
}
