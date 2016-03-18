package com.adanac.b2b.oms.order;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.adanac.b2b.oms.common.ConvertUtil;
import com.adanac.b2b.oms.order.constant.CodeConst;
import com.adanac.b2b.oms.order.dto.OrderSearchConditionDto;
import com.adanac.b2b.oms.order.dto.SaleOrderDto;
import com.adanac.b2b.oms.order.service.saleorder.SaleOrderService;
import com.adanac.framework.page.Pager;
import com.adanac.framework.page.PagerParam;

/**
 * 子订单测试用例
 * @author adanac
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring/spring-impl-test.xml",
		"classpath:conf/spring/spring-res-test.xml", "classpath:conf/spring/spring-dubbo.xml" })
@TransactionConfiguration(defaultRollback = false)
public class SaleOrderServiceImplTest {

	@Autowired
	private SaleOrderService saleOrderService;
	OrderSearchConditionDto searchCondition;
	PagerParam pagerParam;

	@Test
	public void testPageByCondition() {
		searchCondition = new OrderSearchConditionDto();
		pagerParam = new PagerParam();
		searchCondition.setStatus(ConvertUtil.String2Int(CodeConst.OrderStatus.UNPAY));
		Pager<SaleOrderDto> saleOrderPager = saleOrderService.pageByCondition(searchCondition, pagerParam.getPageSize(),
				pagerParam.getPageNumber());
		System.out.println(saleOrderPager.getTotalDataCount());
		Assert.assertNotNull(saleOrderPager);
	}

	@Test
	public void testListByCondition() {
		fail("Not yet implemented");
	}

	@Test
	public void testCancleByOrderId() {
		fail("Not yet implemented");
	}

	@Test
	public void testCancleByOrderCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testReceiveByOrderId() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeliveryByOrderId() {
		fail("Not yet implemented");
	}

	@Test
	public void testSumUserOrders() {
		fail("Not yet implemented");
	}

	@Test
	public void testSumEvaluatedUserOrders() {
		fail("Not yet implemented");
	}

	@Test
	public void testListByMainOrderId() {
		fail("Not yet implemented");
	}

	@Test
	public void testRejectByOrderId() {
		fail("Not yet implemented");
	}

}
