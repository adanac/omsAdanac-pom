package com.adanac.b2b.oms.order;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.adanac.b2b.oms.order.dto.OrderItemDto;
import com.adanac.b2b.oms.order.service.saleorder.SaleOrderItemService;

/**
 * 订单项测试用例
 * @author adanac
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring/spring-impl-test.xml",
		"classpath:conf/spring/spring-res-test.xml", "classpath:conf/spring/spring-dubbo.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class SaleOrderItemServiceImplTest {

	@Autowired
	private SaleOrderItemService saleOrderItemService;

	@Test
	public void testListByOrderId() {
		String orderId = "29a99e25960842269cc6837dcfedc5c4";
		List<OrderItemDto> orderItemList = saleOrderItemService.listByOrderId(orderId);
		System.err.println(orderItemList.size());
	}

	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

}
