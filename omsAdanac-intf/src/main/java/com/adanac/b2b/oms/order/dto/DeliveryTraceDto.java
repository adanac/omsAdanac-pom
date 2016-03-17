package com.adanac.b2b.oms.order.dto;

import java.io.Serializable;

/**
 * 订单对应的物流跟踪信息类
 * @author adanac
 * @version 1.0
 */
public class DeliveryTraceDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5116414265830775731L;

	/**
	 * 主键
	 */
	private String id;

	/**
	 * 订单ID
	 */
	private String orderId;

	/**
	 * 运单信息ID
	 */
	private String deliveryInfoId;

	/**
	 * 处理时间
	 */
	private String deliveryTime;

	/**
	 * 处理描述
	 */
	private String deliveryRemark;

	/**
	 * 物流状态
	 */
	private Integer logStatus;

	/**
	 * 所在位置
	 */
	private String location;

	/**
	 * 接递人
	 */
	private String reciever;

	/**
	 * 联系电话
	 */
	private String linkPhone;

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
	 * 获取物流处理时间
	 * @return 物流处理时间
	 */
	public String getDeliveryTime() {
		return deliveryTime;
	}

	/**
	 * 设置物流处理时间
	 * @param deliveryTime 物流处理时间
	 * @return 无返回值
	 */
	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	/**
	 * 获取物流处理描述
	 * @return 物流处理描述
	 */
	public String getDeliveryRemark() {
		return deliveryRemark;
	}

	/**
	 * 设置物流处理描述
	 * @param deliveryRemark 物流处理描述
	 * @return 无返回值
	 */
	public void setDeliveryRemark(String deliveryRemark) {
		this.deliveryRemark = deliveryRemark;
	}

	/**
	 * 获取物流状态
	 * @return 物流状态
	 */
	public Integer getLogStatus() {
		return logStatus;
	}

	/**
	 * 设置物流状态
	 * @param transportMode 物流状态
	 * @return 无返回值
	 */
	public void setLogStatus(Integer logStatus) {
		this.logStatus = logStatus;
	}

	/**
	 * 获取所在位置
	 * @return 所在位置
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * 设置所在位置
	 * @param location 所在位置
	 * @return 无返回值
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * 获取接递人
	 * @return 接递人
	 */
	public String getReciever() {
		return reciever;
	}

	/**
	 * 设置接递人
	 * @param reciever 接递人
	 * @return 无返回值
	 */
	public void setReciever(String reciever) {
		this.reciever = reciever;
	}

	/**
	 * 获取联系电话
	 * @return 联系电话
	 */
	public String getLinkPhone() {
		return linkPhone;
	}

	/**
	 * 设置联系电话
	 * @param linkPhone 联系电话
	 * @return 无返回值
	 */
	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}

	public String getDeliveryInfoId() {
		return deliveryInfoId;
	}

	public void setDeliveryInfoId(String deliveryInfoId) {
		this.deliveryInfoId = deliveryInfoId;
	}

}
