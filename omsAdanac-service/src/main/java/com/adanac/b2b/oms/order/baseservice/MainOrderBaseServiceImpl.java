package com.adanac.b2b.oms.order.baseservice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adanac.b2b.oms.dao.BaseDao;
import com.adanac.b2b.oms.order.baseservice.saleorder.MainOrderBaseService;
import com.adanac.b2b.oms.order.bo.MainOrderBo;
import com.adanac.b2b.oms.order.constant.CodeConst;
import com.adanac.b2b.oms.order.dto.MainOrderDto;
import com.adanac.b2b.oms.order.dto.MainOrderQueryDto;
import com.adanac.b2b.oms.utils.uuid.DefaultSequenceGenerator;
import com.adanac.framework.dac.util.DacUtils;
import com.adanac.framework.exception.SysException;
import com.adanac.framework.log.MyLogger;
import com.adanac.framework.log.MyLoggerFactory;
import com.adanac.framework.page.Pager;
import com.adanac.framework.utils.DateUtils;

@Service("mainOrderBaseServiceImpl")
public class MainOrderBaseServiceImpl implements MainOrderBaseService {

	@Autowired
	private BaseDao baseDao;

	private MyLogger log = MyLoggerFactory.getLogger(MainOrderBaseServiceImpl.class);

	@Override
	public String createMainOrder(MainOrderBo mOrder) {
		try {
			String id = DefaultSequenceGenerator.getInstance().uuid();
			mOrder.setMorderId(id);
			baseDao.execute("mainOrder.create", mOrder);
			return id;
		} catch (Exception e) {
			log.error("创建主订单失败!", e);
			throw new SysException(e);
		}
	}

	@Override
	public Boolean modifyStatus(String morderId, Integer status) {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("status", status);
			paramMap.put("morderId", morderId);
			paramMap.put("updateTime", DateUtils.format(new Date(), DateUtils.DEFAULT_YEAR_MONTH_DAY_HMS));
			int rslt = baseDao.execute("mainOrder.chgOrderStatus", paramMap);
			return rslt > CodeConst.RESULT_0;
		} catch (Exception e) {
			log.error("修改状态失败!", e);
			throw new SysException(e);
		}
	}

	@Override
	public Boolean modifyById(MainOrderBo mOrder) {
		try {
			int rslt = baseDao.execute("mainOrder.modifyById", mOrder);
			return rslt > CodeConst.RESULT_0;
		} catch (Exception e) {
			log.error("修改主订单失败!", e);
			throw new SysException(e);
		}
	}

	@Override
	public MainOrderDto findById(String mOrderId) {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("morderId", mOrderId);
			return baseDao.queryForObject("mainOrder.query", paramMap, MainOrderDto.class);
		} catch (Exception e) {
			log.error("查询主订单" + mOrderId + "失败!");
			throw new SysException(e);
		}
	}

	@Override
	public Pager<MainOrderDto> pageByCondition(MainOrderQueryDto searchCondition, Integer pageSize,
			Integer pageNumber) {
		try {
			return baseDao.queryForPage("mainOrder.query", DacUtils.convertToMap(searchCondition), MainOrderDto.class,
					pageSize, pageNumber);
		} catch (Exception e) {
			log.error("分页查询主订单失败!");
			throw new SysException(e);
		}
	}

}
