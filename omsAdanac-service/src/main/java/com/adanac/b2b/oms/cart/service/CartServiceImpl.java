package com.adanac.b2b.oms.cart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adanac.b2b.oms.cart.baseservice.CartBaseService;
import com.adanac.b2b.oms.cart.bo.CartBo;
import com.adanac.b2b.oms.cart.dto.CartDto;
import com.adanac.b2b.oms.cart.dto.CartQueryDto;
import com.adanac.b2b.oms.dao.BaseDao;
import com.adanac.b2b.oms.utils.CommonUtil;
import com.adanac.framework.exception.SysException;
import com.adanac.framework.log.MyLogger;
import com.adanac.framework.log.MyLoggerFactory;

/**
 * 购物车业务接口
 * @author adanac
 * @version 1.0
 */
@Service("cartServiceImpl")
@com.alibaba.dubbo.config.annotation.Service(protocol = { "dubbo" })
public class CartServiceImpl implements CartService {
	@Autowired
	private BaseDao baseDao;
	@Autowired
	private CartBaseService cartBaseService;

	private MyLogger logger = MyLoggerFactory.getLogger(CartServiceImpl.class);

	@Override
	public CartDto addCart(CartDto cartDto) {
		try {
			CartBo cartBo = new CartBo(cartDto);
			cartBo = cartBaseService.addCart(cartBo);
			return new CartDto(cartBo);
		} catch (Exception e) {
			logger.error("系统异常，异常信息:[{}]", e);
			throw new SysException("查询购物车商品数量失败", e);
		}

	}

	@Override
	public Boolean delCarts(CartQueryDto cartQueryDto) {
		try {
			return cartBaseService.delCarts(cartQueryDto.getUserId(), cartQueryDto.getMerchantId(),
					cartQueryDto.getFskuIds());
		} catch (Exception e) {
			logger.error("系统异常，异常信息:[{}]", e);
			throw new SysException("查询购物车商品数量失败", e);
		}
	}

	@Override
	public Boolean modifyCartNumber(CartDto cartDto) {
		try {
			CartBo cartBo = new CartBo(cartDto);
			return cartBaseService.modifyCartNumber(cartBo);
		} catch (Exception e) {
			logger.error("系统异常，异常信息:[{}]", e);
			throw new SysException("查询购物车商品数量失败", e);
		}
	}

	@Override
	public List<CartDto> findCarts(CartQueryDto cartQueryDto) {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String fskuIdsStr = CommonUtil.ListToString(cartQueryDto.getFskuIds());
			paramMap.put("fskuIdsStr", fskuIdsStr);
			paramMap.put("userId", cartQueryDto.getUserId());
			paramMap.put("merchantId", cartQueryDto.getMerchantId());
			paramMap.put("supplierId", cartQueryDto.getSupplierId());
			List<CartDto> cartList = baseDao.queryForList("cart.findCarts", paramMap, CartDto.class);
			return cartList;
		} catch (Exception e) {
			logger.error("系统异常，异常信息:[{}]", e);
			throw new SysException("查询购物车商品数量失败", e);
		}
	}

	@Override
	public Integer findCartsCount(Long userId, Long merchantId) {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("userId", userId);
			paramMap.put("merchantId", merchantId);
			return baseDao.queryForObject("cart.findCartsCount", paramMap, Integer.class);
		} catch (Exception e) {
			logger.error("系统异常，异常信息:[{}]", e);
			throw new SysException("查询购物车商品数量失败", e);
		}
	}
}
