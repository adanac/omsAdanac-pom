package com.adanac.b2b.oms.payment.constant;

public final class AliPayConst {
	/**
     * 支付宝提供给商户的服务接入网关URL(新)
     */
    public static final String ALIPAY_GATEWAY_NEW = "https://mapi.alipay.com/gateway.do?";
    
    /**
     * 支付宝消息验证地址
     */
    public static final String HTTPS_VERIFY_URL = "https://mapi.alipay.com/gateway.do?service=notify_verify&";
    
    /**
     * 支付宝同步支付通知URL
     */
    public static final String ALIPAY_RETURN_RUL = "http://192.168.1.181:8080/omsApp-web/omsapp/order/android/aliReturn.do";
    
    /**
     * 支付宝异步支付通知URL
     */
    public static final String ALIPAY_NOTIFY_URL = "http://192.168.1.181:8080/omsApp-web/omsapp/order/android/aliNotify.do";
    
    /**
	 * 
	 */
	public static final String PARTNER = "2088121403794827";
	
	public static final String SELLER_EMAIL = "babypay@bizcent.com";
	
	public static final String INPUT_CHARSET = "utf-8";
	
	public static final String SERVICE = "create_direct_pay_by_user";
	
	public static final String KEY = "li7qm9lq4qxo1ob8zn5jjjogyzj6ephd";
	
	public static final String SIGN_TYPE = "MD5";
	
	//收款类型, 1:商品购买
	public static final String PAYMENT_TYPE = "1";
	
	public static final String DELAY_TIME = "30m";
	
	public static final String TRADE_FINISHED = "TRADE_FINISHED";
	
	public static final String TRADE_SUCCESS = "TRADE_SUCCESS";
	
	public static final String TRADE_CLOSED = "TRADE_CLOSED";
}
