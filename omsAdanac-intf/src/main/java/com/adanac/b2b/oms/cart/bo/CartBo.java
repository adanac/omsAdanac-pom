package com.adanac.b2b.oms.cart.bo;

import java.io.Serializable;
import java.util.Date;

import com.adanac.b2b.oms.cart.dto.CartDto;

/**
 * 购物车Bo
 * @author adanac
 * @version 1.0
 */
public class CartBo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2958633692420171895L;

	/**
	 * 购物ID
	 */
	private Long shoppingId;

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
	 * 供应商名称
	 */
	private String supplierName;

	/**
	 * 商品ID
	 */
	private String fskuId;

	/**
	 * 购买数量
	 */
	private Integer number;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 更新时间
	 */
	private Date updateTime;

	/**
	 * 最后更新用户ID
	 */
	private Long lastOperator;

	public Long getShoppingId() {
		return shoppingId;
	}

	public void setShoppingId(Long shoppingId) {
		this.shoppingId = shoppingId;
	}

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

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getFskuId() {
		return fskuId;
	}

	public void setFskuId(String fskuId) {
		this.fskuId = fskuId;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Long getLastOperator() {
		return lastOperator;
	}

	public void setLastOperator(Long lastOperator) {
		this.lastOperator = lastOperator;
	}

	public CartBo() {
	}

	public CartBo(CartDto cartDto) {
		this.setFskuId(cartDto.getFskuId());
		this.setLastOperator(cartDto.getLastOperator());
		this.setMerchantId(cartDto.getMerchantId());
		this.setNumber(cartDto.getNumber());
		this.setShoppingId(cartDto.getShoppingId());
		this.setSupplierId(cartDto.getSupplierId());
		this.setSupplierName(cartDto.getSupplierName());
		this.setCreateTime(cartDto.getCreateTime());
		this.setUpdateTime(cartDto.getUpdateTime());
		this.setUserId(cartDto.getUserId());
	}
}
