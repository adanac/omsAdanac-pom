package com.adanac.b2b.oms.order.bo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 主订单Bo
 * 仅供支付用（支付后拆分为多个子订单）
 * @author adanac
 * @version 1.0
 */
public class MainOrderBo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8700550810349150347L;

	/**
	 * 订单ID
	 */
	private String morderId;

	/**
	 * 订单编号
	 */
	private String morderCode;

	/**
	 * 客户ID(商家的用户ID)
	 */
	private String userId;

	/**
	 * 商家ID
	 */
	private String merchantId;

	/**
	 * 订单总金额=运费+销售金额
	 */
	private BigDecimal totalMoney;

	/**
	 * 支付金额
	 */
	private BigDecimal payMoney;

	/**
	 * 订单状态:1未支付2已支付3已取消
	 */
	private Integer status;

	/**
	 * 订单来源渠道: 1手机2PAD
	 */
	private Integer channel;

	/**
	 * 订单创建人员ID
	 */
	private Integer createUser;

	/**
	 * 取消人
	 */
	private String cancelUser;

	/**
	 * 取消时间
	 */
	private String cancelTime;

	/**
	 * 支付人
	 */
	private String payUser;

	/**
	 * 支付时间
	 */
	private String payTime;

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
	 * 订单最后更新人员ID
	 */
	private String lastOperator;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getMorderId() {
		return morderId;
	}

	public void setMorderId(String morderId) {
		this.morderId = morderId;
	}

	public String getMorderCode() {
		return morderCode;
	}

	public void setMorderCode(String morderCode) {
		this.morderCode = morderCode;
	}

	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}

	public BigDecimal getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(BigDecimal payMoney) {
		this.payMoney = payMoney;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getChannel() {
		return channel;
	}

	public void setChannel(Integer channel) {
		this.channel = channel;
	}

	public Integer getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
	}

	public String getCancelUser() {
		return cancelUser;
	}

	public void setCancelUser(String cancelUser) {
		this.cancelUser = cancelUser;
	}

	public String getCancelTime() {
		return cancelTime;
	}

	public void setCancelTime(String cancelTime) {
		this.cancelTime = cancelTime;
	}

	public String getPayUser() {
		return payUser;
	}

	public void setPayUser(String payUser) {
		this.payUser = payUser;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public Integer getCloseType() {
		return closeType;
	}

	public void setCloseType(Integer closeType) {
		this.closeType = closeType;
	}

	public String getCloseReason() {
		return closeReason;
	}

	public void setCloseReason(String closeReason) {
		this.closeReason = closeReason;
	}

	public String getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}

	public String getLastOperator() {
		return lastOperator;
	}

	public void setLastOperator(String lastOperator) {
		this.lastOperator = lastOperator;
	}
}
