package com.adanac.b2b.oms.order.dto;

import java.io.Serializable;

/**
 * 订单对应的发票要求
 * @author adanac
 * @version 1.0
 */
public class InvoiceReqDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4163527883924251470L;

	/**
	 * 主键
	 */
	private String id;

	/**
	 * 订单ID
	 */
	private String orderId;
	/**
	 * 发票台头
	 */
	private String companyName;
	/**
	 * 税号
	 */
	private String taxNum;
	/**
	 * 开户银行
	 */
	private String companyBank;
	/**
	 * 银行账号
	 */
	private String bankAccount;
	/**
	 * 公司地址
	 */
	private String companyAddress;
	/**
	 * 公司电话
	 */
	private String companyTelephone;
	/**
	 * 发票类型
	 */
	private Integer invoiceType;
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
	 * 获取公司名称
	 * @return  公司名称
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * 设置公司名称
	 * @param companyName 公司名称
	 * @return 无返回值
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * 获取税号
	 * @return 税号
	 */
	public String getTaxNum() {
		return taxNum;
	}

	/**
	 * 设置税号
	 * @param taxNum 税号
	 * @return 无返回值
	 */
	public void setTaxNum(String taxNum) {
		this.taxNum = taxNum;
	}

	/**
	 * 获取开户银行
	 * @return 开户银行 
	 */
	public String getCompanyBank() {
		return companyBank;
	}

	/**
	 * 设置开户银行
	 * @param companyBank 开户银行
	 * @return 无返回值
	 */
	public void setCompanyBank(String companyBank) {
		this.companyBank = companyBank;
	}

	/**
	 * 获取银行账号
	 * @return 银行账号
	 */
	public String getBankAccount() {
		return bankAccount;
	}

	/**
	 * 设置银行账号
	 * @param bankAccount 银行账号
	 * @return 无返回值
	 */
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	/**
	 * 获取公司地址
	 * @return 公司地址
	 */
	public String getCompanyAddress() {
		return companyAddress;
	}

	/**
	 * 设置公司地址
	 * @param companyAddress 公司地址
	 * @return 无返回值
	 */
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	/**
	 * 获取公司电话
	 * @return 公司电话
	 */
	public String getCompanyTelephone() {
		return companyTelephone;
	}

	/**
	 * 设置公司电话
	 * @param companyTelephone 公司电话
	 * @return 无返回值
	 */
	public void setCompanyTelephone(String companyTelephone) {
		this.companyTelephone = companyTelephone;
	}

	/**
	 * 获取发票类型
	 * @return 发票类型 0：普通、1：专用
	 */
	public Integer getInvoiceType() {
		return invoiceType;
	}

	/**
	 * 设置发票类型
	 * @param invoiceType 发票类型 0：普通、1：专用
	 * @return 无返回值
	 */
	public void setInvoiceType(Integer invoiceType) {
		this.invoiceType = invoiceType;
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
	 * @return  最后更新时间
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

}
