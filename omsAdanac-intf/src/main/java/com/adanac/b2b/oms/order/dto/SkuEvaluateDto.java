package com.adanac.b2b.oms.order.dto;

import java.io.Serializable;
import java.util.List;

import com.adanac.b2b.oms.order.bo.SkuEvaluateBo;

/**
 * 商品评价dto
 * @author lfz
 * @version 2.0
 */
public class SkuEvaluateDto implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5969537914754280046L;
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

	private List<SkuEvaluatePicDto> pics;

	public List<SkuEvaluatePicDto> getPics() {
		return pics;
	}

	public void setPics(List<SkuEvaluatePicDto> pics) {
		this.pics = pics;
	}

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
	 * 默认无参构造
	 */
	public SkuEvaluateDto() {

	}

	/**
	 * 将bo转为dto
	 */
	public SkuEvaluateDto(SkuEvaluateBo bo) {
		this.id = bo.getId();
		this.orderItemId = bo.getOrderItemId();
		this.createTime = bo.getCreateTime();
		this.delivery = bo.getDelivery();
		this.facticity = bo.getFacticity();
		this.lastOperator = bo.getLastOperator();
		this.productId = bo.getProductId();
		this.remark = bo.getRemark();
		this.service = bo.getService();
		this.status = bo.getStatus();
		this.supplierId = bo.getSupplierId();
		this.updateTime = bo.getUpdateTime();
	}

	@Override
	public String toString() {
		return "SkuEvaluateDto [id=" + id + ", orderItemId=" + orderItemId + ", supplierId=" + supplierId
				+ ", productId=" + productId + ", facticity=" + facticity + ", service=" + service + ", delivery="
				+ delivery + ", remark=" + remark + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", lastOperator=" + lastOperator + ", status=" + status + "]";
	}

}
