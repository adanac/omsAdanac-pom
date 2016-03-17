package com.adanac.b2b.oms.order.bo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单项类
 * @author adanac
 * @version 1.0
 */
public class OrderItemBo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5599602572958232082L;

	/**
	 * 订单行主键
	 */
	private String itemId;

	/**
	 * 订单ID
	 */
	private String orderId;

	/**
	 * 商品名称
	 */
	private String productName;

	/**
	 * 商品了码(商品ID)
	 */
	private String fskuId;

	/**
	 * 销售数量
	 */
	private Integer number;

	/**
	 * 商品原价
	 */
	private BigDecimal referPrice;

	/**
	 * 销售价
	 */
	private BigDecimal realPrice;

	/**
	 * 销售金额
	 */
	private BigDecimal saleAmount;

	/**
	 * 自动折扣折让
	 */
	private BigDecimal autoDiscount;

	/**
	 * 人工折扣折让
	 */
	private BigDecimal manualDiscount;

	/**
	 * 销售税金
	 */
	private BigDecimal saleTax;

	/**
	 * 税率
	 */
	private BigDecimal taxRate;

	/**
	 * 商品快照版本号
	 */
	private String fskuSnapVersion;

	/**
	 * 评价标识: 0未评价; 1已评价
	 */
	private Integer evaluated;

	/**
	 * 留言
	 */
	private String leaveMessage;

	/**
	 * 商品类型(1实际商品2虚拟商品)
	 */
	private String productType;

	/**
	 * 已退数量
	 */
	private int refundCount;

	/**
	 * 已退金额
	 */
	private BigDecimal refundAmount;

	/**
	 * 创建时间
	 */
	private String createTime;

	/**
	 * 最后更新时间
	 */
	private String updateTime;

	/**
	 * 最后更新人
	 */
	private String lastOperator;

	/**
	 * 订单项编码
	 */
	private String itemCode;

	/**
	 * 是否有售后0表示有未处理的售后,9表示没有售后,
	 * 只读
	 */
	private Integer asStatus;

	public Integer getAsStatus() {
		return asStatus;
	}

	public void setAsStatus(Integer asStatus) {
		this.asStatus = asStatus;
	}

	/**
	 * 读取订单项编码
	 * @return  订单项编码
	 */
	public String getItemCode() {
		return itemCode;
	}

	/**
	 * 设置订单项编码
	 * @param itemCode 订单项编码
	 * @return 无返回值
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	/**
	 * 获取创建时间
	 * @return 创建时间
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
	 * 获取最后更新时间
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
	 * 获取最后操作人员ID
	 * @return 最后操作人员ID
	 */
	public String getLastOperator() {
		return lastOperator;
	}

	/**
	 * 设置最后操作人员ID
	 * @param lastOperator 最后操作人员ID
	 * @return 无返回值
	 */
	public void setLastOperator(String lastOperator) {
		this.lastOperator = lastOperator;
	}

	/**
	 * 获取订单行ID
	 * @return 订单行ID
	 */
	public String getItemId() {
		return itemId;
	}

	/**
	 * 设置订单行ID
	 * @param detailId
	 * @return 无返回值
	 */
	public void setItemId(String itemId) {
		this.itemId = itemId;
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
	 * 获取商品ID
	 * @return 商品ID(商品子码)
	 */
	public String getFskuId() {
		return fskuId;
	}

	/**
	 * 设置商品ID
	 * @param fskuId 商品ID(商品子码)
	 * @return 无返回值
	 */
	public void setFskuId(String fskuId) {
		this.fskuId = fskuId;
	}

	/**
	 * 获取销售数量
	 * @return 销售数量
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * 设置销售数量
	 * @param number 销售数量
	 * @return 无返回值
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}

	/**
	 * 获取商品原价
	 * @return 商品原价
	 */
	public BigDecimal getReferPrice() {
		return referPrice;
	}

	/**
	 * 设置商品原价
	 * @param referPrice 商品原价
	 * @return 无返回值
	 */
	public void setReferPrice(BigDecimal referPrice) {
		this.referPrice = referPrice;
	}

	/**
	 * 获取商品售价
	 * @return 商品售价
	 */
	public BigDecimal getRealPrice() {
		return realPrice;
	}

	/**
	 * 设置商品售价
	 * @param realPrice 商品售价
	 * @return 无返回值
	 */
	public void setRealPrice(BigDecimal realPrice) {
		this.realPrice = realPrice;
	}

	/**
	 * 获取销售金额
	 * @return 销售金额
	 */
	public BigDecimal getSaleAmount() {
		return saleAmount;
	}

	/**
	 * 设置销售金额
	 * @param saleaAmount 销售金额
	 * @return 销售金额
	 */
	public void setSaleAmount(BigDecimal saleAmount) {
		this.saleAmount = saleAmount;
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
	 * 获取人工折扣折让
	 * @return 人工折扣折让
	 */
	public BigDecimal getManualDiscount() {
		return manualDiscount;
	}

	/**
	 * 设置人工折扣折让
	 * @param manualDiscount 人工折扣折让
	 * @return 无返回值
	 */
	public void setManualDiscount(BigDecimal manualDiscount) {
		this.manualDiscount = manualDiscount;
	}

	/**
	 * 获取销售税金
	 * @return 销售税金
	 */
	public BigDecimal getSaleTax() {
		return saleTax;
	}

	/**
	 * 设置销售税金
	 * @param saleTax 销售税金
	 * @return 无返回值
	 */
	public void setSaleTax(BigDecimal saleTax) {
		this.saleTax = saleTax;
	}

	/**
	 * 获取税率
	 * @return 税率
	 */
	public BigDecimal getTaxRate() {
		return taxRate;
	}

	/**
	 * 设置税率
	 * @param taxRate 税率
	 * @return 无返回值
	 */
	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}

	/**
	 * 获取商品快照版本号
	 * @return 商品快照版本号
	 */
	public String getFskuSnapVersion() {
		return fskuSnapVersion;
	}

	/**
	 * 设置商品快照版本号
	 * @param fskuSnapVersion 商品快照版本号
	 * @return 无返回值
	 */
	public void setFskuSnapVersion(String fskuSnapVersion) {
		this.fskuSnapVersion = fskuSnapVersion;
	}

	/**
	 * 获取评价标识
	 * @return 评价标识:0未评价;1已评价
	 */
	public Integer getEvaluated() {
		return evaluated;
	}

	/**
	 * 设置评价标识
	 * @param evaluated 评价标识:0未评价;1已评价
	 * @return 无返回值
	 */
	public void setEvaluated(Integer evaluated) {
		this.evaluated = evaluated;
	}

	/**
	 * 获取留言信息
	 * @return 留言信息
	 */
	public String getLeaveMessage() {
		return leaveMessage;
	}

	/**
	 * 设置留言信息
	 * @param leaveMessage 留言信息
	 */
	public void setLeaveMessage(String leaveMessage) {
		this.leaveMessage = leaveMessage;
	}

	/**
	 * 获取已退数量
	 * @return 已退数量
	 */
	public int getRefundCount() {
		return refundCount;
	}

	/**
	 * 设置已退数量
	 * @param refundCount 已退数量
	 * @return 无返回值
	 */
	public void setRefundCount(int refundCount) {
		this.refundCount = refundCount;
	}

	/**
	 * 获取已退金额
	 * @return 已退金额
	 */
	public BigDecimal getRefundAmount() {
		return refundAmount;
	}

	/**
	 * 设置已退金额
	 * @param refundAmount 已退金额
	 * @return 无返回值
	 */
	public void setRefundAmount(BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

}
