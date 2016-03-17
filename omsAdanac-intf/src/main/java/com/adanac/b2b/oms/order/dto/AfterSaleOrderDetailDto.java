package com.adanac.b2b.oms.order.dto;

import java.io.Serializable;
import java.util.List;

public class AfterSaleOrderDetailDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8919834311457876401L;
	
	private AfterSaleOrderDto asoDto;
	
	private List<AfterSaleOrderItemDto> asoiDto;

	public AfterSaleOrderDto getAsoDto() {
		return asoDto;
	}

	public void setAsoDto(AfterSaleOrderDto asoDto) {
		this.asoDto = asoDto;
	}

	public List<AfterSaleOrderItemDto> getAsoiDto() {
		return asoiDto;
	}

	public void setAsoiDto(List<AfterSaleOrderItemDto> asoiDto) {
		this.asoiDto = asoiDto;
	}
	
}
