package com.adanac.b2b.oms.order;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.adanac.b2b.oms.order.dto.WaybillDto;
import com.adanac.b2b.oms.order.service.saleorder.WaybillService;

/**
 * 订单对应的运单测试用例
 * @author adanac
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring/spring-impl-test.xml",
		"classpath:conf/spring/spring-res-test.xml", "classpath:conf/spring/spring-dubbo.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class WaybillServiceImplTest {

	@Autowired
	private WaybillService waybillService;

	@Test
	public void testCreateWaybill() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindWaybillList() {
		String orderId = "078557b24dab4239adf4c59d58851465";
		List<WaybillDto> waybillList = waybillService.findWaybillList(orderId);
		System.out.println(waybillList.size());
	}

	@Test
	public void testUpdateWaybill() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteWaybills() {
		fail("Not yet implemented");
	}

}
