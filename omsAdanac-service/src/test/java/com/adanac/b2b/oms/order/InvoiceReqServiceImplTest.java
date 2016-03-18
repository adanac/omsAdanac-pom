package com.adanac.b2b.oms.order;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.adanac.b2b.oms.order.dto.InvoiceReqDto;
import com.adanac.b2b.oms.order.service.saleorder.InvoiceReqService;

/**
 * 订单对应的发票要求测试用例
 * @author adanac
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring/spring-impl-test.xml",
		"classpath:conf/spring/spring-res-test.xml", "classpath:conf/spring/spring-dubbo.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class InvoiceReqServiceImplTest {

	@Autowired
	private InvoiceReqService invoiceReqService;

	@Test
	public void testFindByOrderId() {
		String orderId = "2128941302234f9e8938de62a4571223";
		InvoiceReqDto invoiceReqDto = invoiceReqService.findByOrderId(orderId);
		System.err.println(invoiceReqDto.toString());
	}

	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

}
