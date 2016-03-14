package com.adanac.b2b.oms.cart.baseservice;

import java.util.List;

import com.adanac.b2b.oms.cart.bo.CartBo;

/**
 * 购物车接口
 * @author adanac
 * @version 1.0
 */
public interface CartBaseService {

	/**
	 * 将商品放入购物车
	 * @param cartBo 购物车数据对象
	 * @return 数据对象
	 */
	CartBo addCart(CartBo cartBo);

	/**
	 * 将商品移出购物车，如果fskuIds为空，则清空指定商户下员工的购物车
	 * @param userId 用户ID
	 * @param merchantId 商户ID
	 * @param fskuIds 商品ID列表
	 * @return 是否成功删除。true:成功，false：不成功
	 */
	Boolean delCarts(Long userId, Long merchantId, List<String> fskuIds);

	/**
	 * 修改购物车中商品数量
	 * @param cartBo 购物车数据对象<br/>
	 * （参数：用户ID、商户ID、商品ID、购买数量）
	 * @return 是否成功修改。true:成功，false：不成功
	 */
	Boolean modifyCartNumber(CartBo cartBo);

}
