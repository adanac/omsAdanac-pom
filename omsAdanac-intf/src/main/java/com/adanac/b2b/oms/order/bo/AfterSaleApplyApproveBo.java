package com.adanac.b2b.oms.order.bo;

import java.io.Serializable;

import com.adanac.b2b.oms.order.dto.AfterSaleApplyApproveDto;

/**
 * 售后申请记录类
 * @author adanac
 * @version 1.0
 */
public class AfterSaleApplyApproveBo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1486555883803288892L;
	/**
	 * 申请处理记录ID
	 */
	private String approveId;
	/**
	 * 售后申请ID
	 */
	private String aftersaleApplyId;
	/**
	 * 用户ID
	 */
	private String userId;
	/**
	 * 处理类型
	 */
	private Integer approveType;
	/**
	 * 处理状态
	 */
	private Integer approveStatus;
	/**
	 * 处理备注
	 */
	private String message;
	/**
	 * 处理时间
	 */
	private String approveTime;
	/**
	 * 创建时间
	 */
	private String createTime;
	/**
	 * 最后更新时间
	 */
	private String updateTime;
	/**
	 * 最后更新人ID
	 */
	private String lastOperator;

	public AfterSaleApplyApproveBo() {
		super();
	}

	public AfterSaleApplyApproveBo(AfterSaleApplyApproveDto afterSaleApplyApproveDto) {
		this.setApproveId(afterSaleApplyApproveDto.getApproveId());
		this.setAftersaleApplyId(afterSaleApplyApproveDto.getAftersaleApplyId());
		this.setUserId(afterSaleApplyApproveDto.getUserId());
		this.setApproveType(afterSaleApplyApproveDto.getApproveType());
		this.setApproveStatus(afterSaleApplyApproveDto.getApproveStatus());
		this.setMessage(afterSaleApplyApproveDto.getMessage());
		this.setApproveTime(afterSaleApplyApproveDto.getApproveTime());
		this.setCreateTime(afterSaleApplyApproveDto.getCreateTime());
		this.setUpdateTime(afterSaleApplyApproveDto.getUpdateTime());
		this.setLastOperator(afterSaleApplyApproveDto.getLastOperator());
	}

	public String getApproveId() {
		return approveId;
	}

	public void setApproveId(String approveId) {
		this.approveId = approveId;
	}

	public String getAftersaleApplyId() {
		return aftersaleApplyId;
	}

	public void setAftersaleApplyId(String aftersaleApplyId) {
		this.aftersaleApplyId = aftersaleApplyId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getApproveType() {
		return approveType;
	}

	public void setApproveType(Integer approveType) {
		this.approveType = approveType;
	}

	public Integer getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(Integer approveStatus) {
		this.approveStatus = approveStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getApproveTime() {
		return approveTime;
	}

	public void setApproveTime(String approveTime) {
		this.approveTime = approveTime;
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
}
