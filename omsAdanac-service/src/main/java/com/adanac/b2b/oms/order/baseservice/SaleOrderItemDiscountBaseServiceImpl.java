package com.adanac.b2b.oms.order.baseservice;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adanac.b2b.oms.dao.BaseDao;
import com.adanac.b2b.oms.order.baseservice.saleorder.SaleOrderItemDiscountBaseService;
import com.adanac.b2b.oms.order.bo.OrderItemDiscountBo;
import com.adanac.b2b.oms.utils.uuid.DefaultSequenceGenerator;
import com.adanac.framework.log.MyLogger;
import com.adanac.framework.log.MyLoggerFactory;
import com.adanac.framework.utils.DateUtils;

@Service("saleOrderItemDiscountBaseServiceImpl")
public class SaleOrderItemDiscountBaseServiceImpl implements SaleOrderItemDiscountBaseService {

	@Autowired
	private BaseDao baseDao;

	private MyLogger log = MyLoggerFactory.getLogger(SaleOrderItemDiscountBaseServiceImpl.class);

	@Override
	public String createOrderItemDiscount(OrderItemDiscountBo itemPrmt) {
		String id = DefaultSequenceGenerator.getInstance().uuid();

		itemPrmt.setId(id);
		itemPrmt.setCreateTime(DateUtils.format(new Date(), DateUtils.DEFAULT_YEAR_MONTH_DAY_HMS));
		itemPrmt.setUpdateTime(itemPrmt.getCreateTime());

		baseDao.execute("order_discount_detail.createOrderItemDiscount", itemPrmt);

		return id;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Integer createOrderItemDiscounts(String itemId, List<OrderItemDiscountBo> itemPrmts) {
		Map[] batchValues = new HashMap[itemPrmts.size()];
		for (int i = 0; i < itemPrmts.size(); ++i) {
			String id = DefaultSequenceGenerator.getInstance().uuid();
			batchValues[i] = new HashMap<String, Object>();
			batchValues[i].put("activity", itemPrmts.get(i).getActivity());
			batchValues[i].put("discountDesc", itemPrmts.get(i).getDiscountDesc());
			batchValues[i].put("distcountType", itemPrmts.get(i).getDistcountType());
			batchValues[i].put("id", id);
			batchValues[i].put("orderItemId", itemId);
			batchValues[i].put("prmtAmount", itemPrmts.get(i).getPrmtAmount());
			batchValues[i].put("prmtType", itemPrmts.get(i).getPrmtType());
			batchValues[i].put("promotionId", itemPrmts.get(i).getPromotionId());
			batchValues[i].put("createTime", itemPrmts.get(i).getCreateTime());
			batchValues[i].put("updateTime", itemPrmts.get(i).getUpdateTime());
			batchValues[i].put("lastOperator", itemPrmts.get(i).getLastOperator());
			batchValues[i].put("fskuid", itemPrmts.get(i).getFskuid());
		}

		int[] rest = baseDao.batchUpdate("order_discount_detail.createOrderItemDiscount", batchValues);

		return rest.length;
	}

	@Override
	public List<OrderItemDiscountBo> listByOrderItemId(String itemId) {
		Map<String, Object> temp = new HashMap<String, Object>();
		temp.put("orderItemId", itemId);
		return baseDao.queryForList("order_discount_detail.listByOrderItemId", temp, OrderItemDiscountBo.class);
	}
}
