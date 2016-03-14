package com.adanac.b2b.oms.cart.dto;

import java.util.List;

import com.adanac.b2b.oms.common.BaseDto;

/**
 * 购物车查询条件
 * @author adanac
 * @version 1.0
 */
public class CartQueryDto extends BaseDto {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8400852983323369558L;

	/**
	 * 用户ID
	 */
	private Long userId;

	/**
	 * 商户ID
	 */
	private Long merchantId;

	/**
	 * 供应商ID
	 */
	private Long supplierId;

	/**
	 * 商品ID
	 */
	private String fskuId;

	/**
	 * 商品ID列表
	 */
	private List<String> fskuIds;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public String getFskuId() {
		return fskuId;
	}

	public void setFskuId(String fskuId) {
		this.fskuId = fskuId;
	}

	public List<String> getFskuIds() {
		return fskuIds;
	}

	public void setFskuIds(List<String> fskuIds) {
		this.fskuIds = fskuIds;
	}

}
