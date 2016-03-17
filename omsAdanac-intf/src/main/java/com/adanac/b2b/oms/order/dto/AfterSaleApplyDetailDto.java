package com.adanac.b2b.oms.order.dto;

import java.io.Serializable;
import java.util.List;

public class AfterSaleApplyDetailDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8919834311457876401L;
	
	private AfterSaleApplyDto apply;
	
	private List<AfterSaleApplyApproveDto> approves;
	
	private List<AfterSaleApplyItemDto> applyItem;
	
	private List<AfterSaleApplyPicDto> pics;

	public AfterSaleApplyDto getApply() {
		return apply;
	}

	public void setApply(AfterSaleApplyDto apply) {
		this.apply = apply;
	}

	public List<AfterSaleApplyApproveDto> getApproves() {
		return approves;
	}

	public void setApproves(List<AfterSaleApplyApproveDto> approves) {
		this.approves = approves;
	}

	public List<AfterSaleApplyItemDto> getApplyItem() {
		return applyItem;
	}

	public void setApplyItem(List<AfterSaleApplyItemDto> applyItem) {
		this.applyItem = applyItem;
	}

	public List<AfterSaleApplyPicDto> getPics() {
		return pics;
	}

	public void setPics(List<AfterSaleApplyPicDto> pics) {
		this.pics = pics;
	}
	
	
}
