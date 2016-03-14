package com.adanac.b2b.oms.cart;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.adanac.b2b.oms.cart.dto.CartDto;
import com.adanac.b2b.oms.cart.service.CartService;

/**
 * 购物车测试用例
 * @author adanac
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring/spring-impl-test.xml",
		"classpath:conf/spring/spring-res-test.xml", "classpath:conf/spring/spring-dubbo.xml" })
@TransactionConfiguration(defaultRollback = false)
public class CartServiceImplTest {

	long userId = 9091l;
	long merchantId = 23l;
	long supplierId = 26l;
	long supplierId2 = 27l;
	String skuId = "17AC57EE9F1511E586D94A6F817B86A5";
	String skuId2 = "17B112AC9F1511E586D94A6F817B86A5";
	CartDto cartIn, cartOut;

	@Autowired
	private CartService cartService;

	@Before
	public void setUp() throws Exception {
		System.out.println("创建购物车实例...");
		cartIn = new CartDto();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddCart() {
		cartIn.setUserId(userId);
		cartIn.setFskuId(skuId);
		cartIn.setMerchantId(merchantId);
		cartIn.setNumber(1001);
		cartIn.setSupplierName("孩子王");
		cartIn.setLastOperator(userId);
		cartOut = cartService.addCart(cartIn);
		System.out.println(cartOut.toString());
	}

	@Test
	public void testDelCarts() {
		fail("Not yet implemented");
	}

	@Test
	public void testModifyCartNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindCarts() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindCartsCount() {
		fail("Not yet implemented");
	}

}
