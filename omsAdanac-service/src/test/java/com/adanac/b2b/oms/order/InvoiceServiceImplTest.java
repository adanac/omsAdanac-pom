package com.adanac.b2b.oms.order;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.adanac.b2b.oms.order.dto.InvoiceDto;
import com.adanac.b2b.oms.order.service.saleorder.InvoiceService;

/**
 * 订单对应的发票测试用例
 * @author adanac
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring/spring-impl-test.xml",
		"classpath:conf/spring/spring-res-test.xml", "classpath:conf/spring/spring-dubbo.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class InvoiceServiceImplTest {

	@Autowired
	private InvoiceService invoiceService;

	@Test
	public void testAddInvoice() {
		InvoiceDto invInfo = new InvoiceDto();
		invInfo.setBankAccount("100000011");
		System.err.println(invoiceService.addInvoice(invInfo));
	}

	@Test
	public void testFindById() {
		String invoiceId = "6696ca8a8cef4ea9ab1795d2b1adf03b";
		InvoiceDto invoiceDto = invoiceService.findById(invoiceId);
		System.err.println(invoiceDto.toString());
		Assert.assertNotNull(invoiceDto);
	}

	@Test
	public void testListByOrderId() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateInvoice() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteInvoice() {
		fail("Not yet implemented");
	}

}
