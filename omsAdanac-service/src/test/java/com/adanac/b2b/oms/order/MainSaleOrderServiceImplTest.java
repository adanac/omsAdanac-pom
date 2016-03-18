package com.adanac.b2b.oms.order;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.adanac.b2b.oms.order.bo.DeliveryReqBo;
import com.adanac.b2b.oms.order.bo.MainOrderBo;
import com.adanac.b2b.oms.order.bo.OrderItemBo;
import com.adanac.b2b.oms.order.bo.SaleOrderBo;
import com.adanac.b2b.oms.order.dto.MainOrderDetailDto;
import com.adanac.b2b.oms.order.dto.OrderItemDetailDto;
import com.adanac.b2b.oms.order.dto.SaleOrderDetailDto;
import com.adanac.b2b.oms.order.service.saleorder.MainSaleOrderService;
import com.adanac.b2b.oms.utils.uuid.DefaultSequenceGenerator;

/**
 * 主订单测试用例
 * @author adanac
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring/spring-impl-test.xml",
		"classpath:conf/spring/spring-res-test.xml", "classpath:conf/spring/spring-dubbo.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true) // 这里的事务关联到配置文件中的事务控制器（transactionManager
																								// =
																								// "transactionManager"），同时指定自动回滚（defaultRollback
																								// =
																								// true）。这样做操作的数据才不会污染数据库
public class MainSaleOrderServiceImplTest {

	@Autowired
	private MainSaleOrderService mainSaleOrderService;

	MainOrderDetailDto mainOrderDetail;

	@Before
	public void setUp() throws Exception {
		System.out.println("创建主订单实例");
		mainOrderDetail = new MainOrderDetailDto();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateOrder() {
		MainOrderBo mainOrder = new MainOrderBo();
		mainOrderDetail.setMainOrder(mainOrder);
		List<SaleOrderDetailDto> orderDetailList = new ArrayList<SaleOrderDetailDto>();
		for (int i = 0; i < 2; i++) {
			SaleOrderDetailDto saleOrderDetailDto = new SaleOrderDetailDto();
			SaleOrderBo order = new SaleOrderBo();
			order.setOrderId(DefaultSequenceGenerator.getInstance().uuid());
			order.setOrderCode("1000000000" + i);
			order.setIsReceipt(0);// 不需要发票
			order.setSupplierId("10086");// 供应商id
			saleOrderDetailDto.setOrder(order);// 订单

			List<OrderItemDetailDto> itemDetails = new ArrayList<OrderItemDetailDto>();
			for (int j = 0; j < 2; j++) {
				OrderItemDetailDto orderItemDetail = new OrderItemDetailDto();
				OrderItemBo orderItem = new OrderItemBo();
				orderItem.setLeaveMessage("orderItem" + i + j);
				orderItemDetail.setOrderItem(orderItem);// 订单项
				itemDetails.add(orderItemDetail);
			}
			saleOrderDetailDto.setItemDetails(itemDetails);// 订单项列表

			DeliveryReqBo deliveryReq = new DeliveryReqBo();
			deliveryReq.setPhone("1865189");
			saleOrderDetailDto.setDeliveryReq(deliveryReq);// 发货要求
			orderDetailList.add(saleOrderDetailDto);
		}

		mainOrderDetail.setOrderDetailList(orderDetailList);
		String mainSaleOrder = mainSaleOrderService.createOrder(mainOrderDetail);
		System.out.println(mainSaleOrder);
		Assert.assertNotNull(mainSaleOrder);
	}

	@Test
	public void testMorderPayment() {
		fail("Not yet implemented");
	}

	@Test
	public void testPayById() {
		fail("Not yet implemented");
	}

	@Test
	public void testCancleById() {
		fail("Not yet implemented");
	}

	@Test
	public void testPageByCondition() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	public void testOrderPayment() {
		fail("Not yet implemented");
	}

}
