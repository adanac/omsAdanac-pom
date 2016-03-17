package com.adanac.b2b.oms.order.constant;

/**
 * 异常错误代码错误信息常量类
 * @author jiangchao
 *
 */
public class ErrorCodeConst {

	/**
	 * 异常
	 */
	public static String CODE_ERROR = "0";
	
	/**
	 * 成功
	 */
	public static String CODE_SUCCESS = "1";
	
	/**
	 * 系统未知异常
	 */
	public static String ERROR_MESSAGE_UNKNOWN_EXCEPTION = "未知异常！";
	
	/**
	 * 订单状态修改提示信息
	 */
	public static String ERROR_MESSAGE_MODIFY_ORDER_STATUS_ERROR = "订单状态不可以修改";
	
	/**
	 * 新增异常提示信息
	 */
	public static String ERROR_MESSAGE_UPDATE_1 = "新增失败！";
	
	/**
	 * 删除异常提示信息
	 */
	public static String ERROR_MESSAGE_DElETE_1 = "删除失败！";
	
	/**
	 * 新增商品活动信息历史记录失败！
	 */
	public static String ERROR_MESSAGE_ADD_1 = "新增商品活动信息历史记录失败！";
	
	/**
	 * 新增商品价格历史记录失败！
	 */
	public static String ERROR_MESSAGE_ADD_2 = "新增商品价格历史记录失败！";
	
	/**
	 * 该结算单已经确认
	 */
	public static String CODE_CREDIT_OKED = "0001";
	
	/**
	 * 该结算单已经作废
	 */
	public static String CODE_CREDIT_KILLED = "0002";
	/**
	 * 找不到该结算单
	 */
	public static String CODE_CREDIT_NOTFIND = "0003";


	/**
	 * 参数缺失.
	 */
	public static String PARAM_LOST= "0004";


/*=============== 供应商运费模板   ===============*/
	/**
	 *供应商运费模板不存在
	 */
	public static String FREIGHT_ISEMPTY = "0005";

	/**
	 * 同一供应商同一计价方式同一运送方式下存在重复供应商运费模板.
	 */
	public static String FREIGHT_DUMPLICT = "0006";

	/**
	 * 分区域运费默认模板为空.
	 */
	public static String AREA_TEMPLATE_ISEMPTY = "0007";
	/**
	 * 分区域运费默认模板存在重复.
	 */
	public static String AREA_TEMPLATE_DUMPLICT = "0008";
	/**
	 * 供货商不支持的计价方式，可能是在某一计价方式下，没有相应的数值传递.
	 */
	public static String SUPPLIER_NOT_SUPPORT_PRICING = "0009";

	
/*===========  售后申请   =========================*/
	/**
	 * 售后申请不存在
	 */
	public static String AFTERSALE_APPLY_NOT_EXIST = "0001";
		
	/**
	 * 售后申请状态不可以修改
	 */
	public static String AFTERSALE_APPLY_STATUS_FOBIDDEN = "0002";
		
	/**
	 * 售后申请不可重复提交
	 */
	public static String AFTERSALE_APPLY_REPEAT = "0003";
	
	/**
	 * 售后申请不可被取消
	 */
	public static String AFTERSALE_APPLY_REJECT_CANCLE = "0004";
	
	/**
	 * 售后类型不存在
	 */
	public static String AFTERSALE_TYPE_NOT_EXIST = "0005";
	
	/**
	 * 售后退款金额超出订单总金额
	 */
	public static String AFTERSALE_REFUND_AMOUNT_MORE = "0006";
	
	/**
	 * 售后退货数量超出销售数量
	 */
	public static String AFTERSALE_REFUND_NUMBER_MORE = "0007";
	
	/**
	 * 不允许拒收
	 */
	public static String AFTERSALE_REJECT_FORBIDDEN = "0008";
	

/*=============== 	商品评价错误码    ===============*/
	/**
	 * 商品评价不存在.
	 */
	public static String SKU_EVALUATE_NOT_EXIST = "0010";

/*=================    订单     ===================*/

	/**
	 * 订单不存在.
	 */
	public static String ORDER_NOT_EXIST = "0011";
	
/*=================    售后订单     ===================*/
	/**
	 * 售后订单不存在.
	 */
	public static String AFTERORDER_NOT_EXIST = "0012";


}
