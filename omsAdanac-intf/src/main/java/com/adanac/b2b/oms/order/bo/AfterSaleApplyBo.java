package com.adanac.b2b.oms.order.bo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.adanac.b2b.oms.order.dto.AfterSaleApplyDto;

/**
 * 售后申请Bo
 * @author adanac
 * @version 1.0
 */
public class AfterSaleApplyBo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3331688220743998252L;

	/**
	 * 售后申请ID
	 */
	private String aftersaleApplyId;

	/**
	 * 售后申请编号
	 */
	private String aftersaleApplyCode;

	/**
	 * 销售子订单ID
	 */
	private String saleorderId;

	/**
	 * 申请用户ID
	 */
	private String applyUser;

	/**
	 * 用户ID(客户)
	 */
	private String userId;

	/**
	 * 供应商ID
	 */
	private String supplierId;

	/**
	 * 售后类型：0：退款1：退货.2整单退3拒收
	 */
	private Integer type;

	/**
	 * 原因类型分类:系统预定的几种
	 */
	private Integer reasonType;

	/**
	 * 原因售后
	 */
	private String reason;

	/**
	 * 退款金额
	 */
	private BigDecimal price;

	/**
	 * 申请状态:1：申请中2：同意3：驳回4：客服介入5：关闭
	 */
	private Integer status;

	/**
	 * 关闭时间
	 */
	private String closeTime;

	/**
	 * 创建时间
	 */
	private String createTime;

	/**
	 * 更新时间
	 */
	private String updateTime;

	/**
	 * 更新人员ID
	 */
	private String lastOperator;

	/**
	 * 物流公司名称
	 */
	private String lgsCompanyName;

	/**
	 * 物流类型
	 */
	private String lgsType;

	/**
	 * 物流单号
	 */
	private String waybillCode;

	/**
	 * 申请售后说明
	 */
	private String remark;

	public AfterSaleApplyBo() {
		super();
	}

	public AfterSaleApplyBo(AfterSaleApplyDto afterSaleApplyDto) {
		this.setAftersaleApplyCode(afterSaleApplyDto.getAftersaleApplyCode());
		this.setAftersaleApplyId(afterSaleApplyDto.getAftersaleApplyId());
		this.setSaleorderId(afterSaleApplyDto.getSaleorderId());
		this.setUserId(afterSaleApplyDto.getUserId());
		this.setSupplierId(afterSaleApplyDto.getSupplierId());
		this.setType(afterSaleApplyDto.getType());
		this.setReasonType(afterSaleApplyDto.getReasonType());
		this.setReason(afterSaleApplyDto.getReason());
		this.setPrice(afterSaleApplyDto.getPrice());
		this.setStatus(afterSaleApplyDto.getStatus());
		this.setCloseTime(afterSaleApplyDto.getCloseTime());
		this.setCreateTime(afterSaleApplyDto.getCreateTime());
		this.setUpdateTime(afterSaleApplyDto.getUpdateTime());
		this.setLastOperator(afterSaleApplyDto.getLastOperator());
		this.setLgsCompanyName(afterSaleApplyDto.getLgsCompanyName());
		this.setLgsType(afterSaleApplyDto.getLgsType());
		this.setWaybillCode(afterSaleApplyDto.getWaybillCode());
		this.setRemark(afterSaleApplyDto.getRemark());
	}

	public String getAftersaleApplyCode() {
		return aftersaleApplyCode;
	}

	public void setAftersaleApplyCode(String aftersaleApplyCode) {
		this.aftersaleApplyCode = aftersaleApplyCode;
	}

	public String getAftersaleApplyId() {
		return aftersaleApplyId;
	}

	public void setAftersaleApplyId(String aftersaleApplyId) {
		this.aftersaleApplyId = aftersaleApplyId;
	}

	public String getSaleorderId() {
		return saleorderId;
	}

	public void setSaleorderId(String saleorderId) {
		this.saleorderId = saleorderId;
	}

	public String getApplyUser() {
		return applyUser;
	}

	public void setApplyUser(String applyUser) {
		this.applyUser = applyUser;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getReasonType() {
		return reasonType;
	}

	public void setReasonType(Integer reasonType) {
		this.reasonType = reasonType;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
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

	public String getLgsCompanyName() {
		return lgsCompanyName;
	}

	public void setLgsCompanyName(String lgsCompanyName) {
		this.lgsCompanyName = lgsCompanyName;
	}

	public String getLgsType() {
		return lgsType;
	}

	public void setLgsType(String lgsType) {
		this.lgsType = lgsType;
	}

	public String getWaybillCode() {
		return waybillCode;
	}

	public void setWaybillCode(String waybillCode) {
		this.waybillCode = waybillCode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
