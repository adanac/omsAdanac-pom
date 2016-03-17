package com.adanac.b2b.oms.order.dto;

import java.io.Serializable;

import com.adanac.b2b.oms.order.bo.DeliveryReqBo;

/**
 * 订单对应的客户收货要求类
 * @author adanac
 * @version 1.0
 */
public class DeliveryReqDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4899306927534987379L;

	/**
	 * 主键
	 */
	private String id;

	/**
	 * 订单ID
	 */
	private String orderId;

	/**
	 * 客户要求送货时间
	 */
	private String sendTime;

	/**
	 * 客户要求收货日期
	 */
	private String receiveTime;

	/**
	 * 运送方式: 0:快递1:货运
	 */
	private Integer transportMode;

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
	 * 是否延长收货: 0：否1：是
	 */
	private Integer extentTime;

	/**
	 * 特殊要求
	 */
	private String sepcial;

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

	public DeliveryReqDto() {
		super();
	}

	public DeliveryReqDto(DeliveryReqBo deliveryReqBo) {
		this.setCreateTime(deliveryReqBo.getCreateTime());
		this.setExtentTime(deliveryReqBo.getExtentTime());
		this.setId(deliveryReqBo.getId());
		this.setLastOperator(deliveryReqBo.getLastOperator());
		this.setLgsAddr(deliveryReqBo.getLgsAddr());
		this.setNickName(deliveryReqBo.getNickName());
		this.setOrderId(deliveryReqBo.getOrderId());
		this.setPhone(deliveryReqBo.getPhone());
		this.setReceiveTime(deliveryReqBo.getReceiveTime());
		this.setSendTime(deliveryReqBo.getSendTime());
		this.setSepcial(deliveryReqBo.getSepcial());
		this.setTransportMode(deliveryReqBo.getTransportMode());
		this.setUpdateTime(deliveryReqBo.getUpdateTime());
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
	 * 获取客户要求送货时间
	 * @return 客户要求送货时间
	 */
	public String getSendTime() {
		return sendTime;
	}

	/**
	 * 设置客户要求送货时间
	 * @param sendTime 客户要求送货时间
	 * @return 无返回值
	 */
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(String receiveTime) {
		this.receiveTime = receiveTime;
	}

	/**
	 * 获取运送方式
	 * @return 运送方式: 0:快递1:货运
	 */
	public Integer getTransportMode() {
		return transportMode;
	}

	/**
	 * 设置运送方式
	 * @param transportMode 运送方式: 0:快递1:货运
	 * @return 无返回值
	 */
	public void setTransportMode(Integer transportMode) {
		this.transportMode = transportMode;
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
	 * 获取是否延迟收货标识
	 * @return 延迟收货标识 0：否1：是
	 */
	public Integer getExtentTime() {
		return extentTime;
	}

	/**
	 * 设置是否延迟收货标识
	 * @param extentTime 延迟收货标识 0：否1：是
	 * @return 无返回值
	 */
	public void setExtentTime(Integer extentTime) {
		this.extentTime = extentTime;
	}

	/**
	 * 获取特殊要求
	 * @return 特殊要求
	 */
	public String getSepcial() {
		return sepcial;
	}

	/**
	 * 设置特殊要求
	 * @param sepcial 特殊要求
	 * @return 无返回值
	 */
	public void setSepcial(String sepcial) {
		this.sepcial = sepcial;
	}

	/**
	 * 设置联系电话
	 * @param phone 联系电话
	 * @return 无返回值
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
