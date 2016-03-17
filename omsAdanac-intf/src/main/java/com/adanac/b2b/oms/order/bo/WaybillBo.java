package com.adanac.b2b.oms.order.bo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单对应的运单信息Bo
 * @author adanac
 * @version 1.0
 */
public class WaybillBo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8692460685680426645L;

	/**
	 * 主键
	 */
	private String id;

	/**
	 * 订单ID
	 */
	private String orderId;

	/**
	 * 物流公司编码
	 */
	private String companyCode;

	/**
	 * 物流公司名称
	 */
	private String companyName;
	/**
	 * 运费金额
	 */
	private BigDecimal freightMoney;

	/**
	 * 收货人
	 */
	private String nickName;

	/**
	 * 收货人电话
	 */
	private String phone;

	/**
	 * 收货地址
	 */
	private String lgsAddr;

	/**
	 * 运单号
	 */
	private String waybillCode;

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
	 * 获取主键
	 * @return 主键
	 */
	public String getId() {
		return id;
	}

	/**
	 * 设置主键
	 * @param id 主键
	 * @return 无返回值
	 */
	public void setId(String id) {
		this.id = id;
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
	 * 获取物流公司编码
	 * @return 物流公司编码
	 */
	public String getCompanyCode() {
		return companyCode;
	}

	/**
	 * 设置物流公司编码
	 * @param companyCode 物流公司编码
	 * @return 无返回值
	 */
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	/**
	 * 获取物流公司名称
	 * @return 物流公司名称
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * 设置物流公司名称
	 * @param companyName 物流公司名称
	 * @return 无返回值
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * 获取收货人姓名
	 * @return 收货人姓名
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * 设置收货人姓名
	 * @param nickName 收货人姓名
	 * @return 无返回值
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * 获取联系电话
	 * @return 联系电话
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 获取收货地址
	 * @return 收货地址
	 */
	public String getLgsAddr() {
		return lgsAddr;
	}

	/**
	 * 设置收货地址
	 * @param lgsAddr 收货地址
	 * @return 无返回值
	 */
	public void setLgsAddr(String lgsAddr) {
		this.lgsAddr = lgsAddr;
	}

	/**
	 * 获取运单号
	 * @return 运单号
	 */
	public String getWaybillCode() {
		return waybillCode;
	}

	/**
	 * 设置运单号
	 * @param waybillCode 运单号
	 * @return 无返回值
	 */
	public void setWaybillCode(String waybillCode) {
		this.waybillCode = waybillCode;
	}

	/**
	 * 设置联系电话
	 * @param phone 联系电话
	 * @return 无返回值
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public BigDecimal getFreightMoney() {
		return freightMoney;
	}

	public void setFreightMoney(BigDecimal freightMoney) {
		this.freightMoney = freightMoney;
	}
}
