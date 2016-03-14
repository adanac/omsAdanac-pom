package com.adanac.b2b.oms.cart.baseservice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adanac.b2b.oms.cart.bo.CartBo;
import com.adanac.b2b.oms.dao.BaseDao;
import com.adanac.b2b.oms.utils.CommonUtil;
import com.adanac.framework.dac.util.DacUtils;

/**
 * 购物车业务
 * 
 * @author xuneng
 * @date 2016年2月17日
 *
 */
@Service("CartBaseServiceImpl")
public class CartBaseServiceImpl implements CartBaseService {

	@Autowired
	private BaseDao baseDao;

	@Override
	public CartBo addCart(CartBo cartBo) {
		Map<String, Object> paramMap = DacUtils.convertToMap(cartBo);
		// 返回主键
		Number key = baseDao.execute4PrimaryKey("cart.addCart", paramMap);
		long longValue = key.longValue();
		if (longValue > 0) {
			cartBo.setShoppingId(longValue);
			return cartBo;
		}
		return null;
	}

	@Override
	public Boolean delCarts(Long userId, Long merchantId, List<String> fskuIds) {
		Map<String, Object> map = new HashMap<String, Object>();

		// 如果fskuIds为空，则清空购物车
		if (fskuIds != null && !fskuIds.isEmpty()) {
			String fskuIdsStr = CommonUtil.ListToString(fskuIds);
			map.put("fskuIds", fskuIdsStr);
		}
		map.put("userId", userId);
		map.put("merchantId", merchantId);
		int result = baseDao.execute("cart.delCarts", map);
		if (result <= 0) {
			return false;
		}
		return true;
	}

	@Override
	public Boolean modifyCartNumber(CartBo cartBo) {
		int result = baseDao.execute("cart.modifyCartNumber", cartBo);
		if (result <= 0) {
			return false;
		}
		return true;
	}

}
