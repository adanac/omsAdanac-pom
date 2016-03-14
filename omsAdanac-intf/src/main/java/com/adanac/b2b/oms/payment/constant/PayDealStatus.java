package com.adanac.b2b.oms.payment.constant;

public final class PayDealStatus {
	
	//未处理
	public static int UNDEALED = 1;
	
	//已处理
	public static int DEALED = 2;
	
	//支付失败,需要再检测
	public static int NEED_CHECK = 3;
}
