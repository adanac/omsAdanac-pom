package com.adanac.b2b.oms.order.bo;

import java.io.Serializable;

import com.adanac.b2b.oms.order.dto.SkuEvaluateDto;

/**
 * 商品评价实体
 * @author lfz
 * @version 2.0
 */
public class SkuEvaluateBo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6052970884248424308L;
	/**
	 * id
	 */
	private String id;
	/**
	 * 订单项id
	 */
	private String orderItemId;
	/**
	 * 供应商id
	 */
	private String supplierId;
	/**
	 * 商品id
	 */
	private String productId;
	/**
	 * 描述相符
	 */
	private Integer facticity;
	/**
	 * 卖家服务
	 */
	private Integer service;
	/**
	 * 物流服务
	 */
	private Integer delivery;
	/**
	 * 评价内容
	 */
	private String remark;
	/**
	 * 创建时间
	 */
	private String createTime;
	/**
	 * 更新时间
	 */
	private String updateTime;
	/**
	 * 最后更新人
	 */
	private String lastOperator;
	/**
	 * 帖子状态:1-待审核,2-屏蔽,3-删除
	 */
	private Integer status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Integer getFacticity() {
		return facticity;
	}

	public void setFacticity(Integer facticity) {
		this.facticity = facticity;
	}

	public Integer getService() {
		return service;
	}

	public void setService(Integer service) {
		this.service = service;
	}

	public Integer getDelivery() {
		return delivery;
	}

	public void setDelivery(Integer delivery) {
		this.delivery = delivery;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getLastOperator() {
		return lastOperator;
	}

	public void setLastOperator(String lastOperator) {
		this.lastOperator = lastOperator;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 默认无参构造函数
	 */
	public SkuEvaluateBo() {

	}

	/**
	 * 将dto转为bo
	 */
	public SkuEvaluateBo(SkuEvaluateDto dto) {
		this.id = dto.getId();
		this.orderItemId = dto.getOrderItemId();
		this.createTime = dto.getCreateTime();
		this.delivery = dto.getDelivery();
		this.facticity = dto.getFacticity();
		this.lastOperator = dto.getLastOperator();
		this.productId = dto.getProductId();
		this.remark = dto.getRemark();
		this.service = dto.getService();
		this.status = dto.getStatus();
		this.supplierId = dto.getSupplierId();
		this.updateTime = dto.getUpdateTime();
	}

}
