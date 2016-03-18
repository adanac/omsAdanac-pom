package com.adanac.b2b.oms.order.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adanac.b2b.oms.dao.BaseDao;
import com.adanac.b2b.oms.order.dto.WaybillDto;
import com.adanac.b2b.oms.order.service.saleorder.WaybillService;
import com.adanac.b2b.oms.utils.CommonUtil;
import com.adanac.b2b.oms.utils.uuid.DefaultSequenceGenerator;
import com.adanac.framework.exception.SysException;
import com.adanac.framework.log.MyLogger;
import com.adanac.framework.log.MyLoggerFactory;
import com.adanac.framework.utils.DateUtils;

/**
 * 运单服务接口
 * @author adanac
 * @version 1.0
 */
@Component("waybillServiceImpl")
@com.alibaba.dubbo.config.annotation.Service(protocol = { "dubbo" })
public class WaybillServiceImpl implements WaybillService {

	@Autowired
	private BaseDao baseDao;

	private MyLogger log = MyLoggerFactory.getLogger(WaybillServiceImpl.class);

	@Override
	public String createWaybill(WaybillDto deliveryInfo) {
		try {
			String id = DefaultSequenceGenerator.getInstance().uuid();

			deliveryInfo.setCreateTime(DateUtils.format(new Date(), DateUtils.DEFAULT_YEAR_MONTH_DAY_HMS));
			deliveryInfo.setUpdateTime(deliveryInfo.getCreateTime());
			deliveryInfo.setId(id);
			baseDao.execute("waybill.createWaybill", deliveryInfo);
			return id;
		} catch (Exception e) {
			log.error("WaybillServiceImpl-->createWaybill: " + deliveryInfo + e);
			throw new SysException("创建运单失败", e);
		}
	}

	@Override
	public List<WaybillDto> findWaybillList(String orderId) {
		Map<String, Object> temp = new HashMap<String, Object>();
		try {
			temp.put("orderId", orderId);
			return baseDao.queryForList("waybill.findWaybillList", temp, WaybillDto.class);
		} catch (Exception e) {
			log.error("WaybillServiceImpl-->findWaybillList: " + temp + e);
			throw new SysException("查询运单信息失败", e);
		}
	}

	@Override
	public Boolean updateWaybill(WaybillDto deliveryInfo) {
		try {
			int rst = baseDao.execute("waybill.updateWaybill", deliveryInfo);
			return rst > 0;
		} catch (Exception e) {
			log.error("WaybillServiceImpl-->updateWaybill: " + deliveryInfo + e);
			throw new SysException("修改运单信息失败", e);
		}
	}

	@Override
	public Boolean deleteWaybills(ArrayList<String> ids) {
		Map<String, Object> temp = new HashMap<String, Object>();
		try {
			String deliveryIds = CommonUtil.ListToString(ids);
			temp.put("deliveryIds", deliveryIds);
			int rst = baseDao.execute("waybill.deleteWaybills", temp);
			return rst > 0;
		} catch (Exception e) {
			log.error("WaybillServiceImpl-->deleteWaybills-->入参: " + ids + e);
			throw new SysException("删除运单信息失败", e);
		}
	}

}
