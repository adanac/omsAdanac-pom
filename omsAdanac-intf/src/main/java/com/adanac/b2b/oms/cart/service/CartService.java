package com.adanac.b2b.oms.cart.service;

import java.util.List;

import com.adanac.b2b.oms.cart.dto.CartDto;
import com.adanac.b2b.oms.cart.dto.CartQueryDto;

/**
 * 购物车业务接口
 * @author adanac
 * @version 1.0
 */
public interface CartService {
	/**
	 * 将商品放入购物车
	 * @param cartDto 购物车数据对象
	 * @return 数据对象
	 */
	CartDto addCart(CartDto cartDto);

	/**
	 * 将商品移出购物车，如果fskuIds为空，则清空指定商户下员工的购物车
	 * @param userId 用户ID
	 * @param merchantId 商户ID
	 * @param fskuIds 商品ID列表
	 * @return 是否成功删除。true:成功，false：不成功
	 */
	Boolean delCarts(CartQueryDto cartQueryDto);

	/**
	 * 修改购物车中商品数量
	 * @param cartDto 购物车数据对象<br/>
	 * （参数：用户ID、商户ID、商品ID、购买数量）
	 * @return 是否成功修改。true:成功，false：不成功
	 */
	Boolean modifyCartNumber(CartDto cartDto);

	/**
	 * 查询购物车列表
	 * @param userId 用户ID
	 * @param merchantId 商户ID
	 * @param supplierId 供应商ID
	 * @param fskuIds 商品ID列表
	 * @return 购物车列表
	 */
	List<CartDto> findCarts(CartQueryDto cartQueryDto);

	/**
	 * 查询购物车商品数量
	 * @param userId 用户ID
	 * @param merchantId 商户ID
	 * @return 购物车商品数量 
	 */
	Integer findCartsCount(Long userId, Long merchantId);
}
