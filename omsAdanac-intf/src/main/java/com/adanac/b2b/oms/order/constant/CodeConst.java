package com.adanac.b2b.oms.order.constant;

public final class CodeConst {
	/**
	 * 供应商编码长度
	 */
	public static final int SPULIER_CODE_LENTH = 8;

	/**
	 * 订单类型
	 *
	 */
	public final class SaleOrderType {

		/**
		 * 整单退款
		 */
		public static final int ORDER_REFUND = 1;
		/**
		 * 售后退款
		 */
		public static final int RETURN_REFUND = 2;
		/**
		 * 售后退货
		 */
		public static final int ITEM_REFUND = 3;
		/**
		 * 订单拒收
		 */
		public static final int ORDER_REJECT = 4;

		/**
		 * 订单类型:销售订单
		 */
		public static final int SALE = 5;
	}

	public final class OrderChannel {
		/**
		 * 订单渠道:手机
		 */
		public static final int MOBILE = 1;

		/**
		 * 订单渠道:pad
		 */
		public static final int PAD = 2;
	}

	/**
	 * 销售订单状态
	 *
	 */
	public final class OrderStatus {
		/**
		 * 待支付
		 */
		public static final int UNPAY = 0;
		/**
		 * 已支付
		 */
		public static final int PAYED = 1;
		/**
		 * 已确认（供应商确认订单，准备发货）
		 */
		public static final int CHECKED = 2;
		/**
		 * 已送达（物流）
		 */
		public static final int ARRIVED = 3;
		/**
		 * 已退款
		 */
		public static final int REFUNDED = 4;
		/**
		 * 已发货(待收货)
		 */
		public static final int OUTSTORE = 5;
		/**
		 * 已关闭
		 */
		public static final int CLOSED = 6;
		/**
		 * 已取消
		 */
		public static final int CANCLED = 7;

		/**
		 * 已完成
		 */
		public static final int RECEIVED = 8;

		/**
		 * 已拒收
		 */
		public static final int REJECTED = 10;
	}

	/**
	 * 售后订单状态
	 *
	 */
	public final class AsOrderStatus {
		/**
		 * 待支付
		 */
		public static final int UNPAY = 0;
		/**
		 * 已支付
		 */
		public static final int PAYED = 1;

		/**
		 * 已取消
		 */
		public static final int CANCLED = 2;

	}

	/**
	 * 售后申请类型
	 * @author Administrator
	 *
	 */
	public final class SaleApplyType {
		/**
		 * 订单项退款申请
		 */
		public static final int ITEM_REFUND = 0;
		/**
		 * 订单项退货申请
		 */
		public static final int RETURN_GOODS = 1;
		/**
		 * 整单退款申请
		 */
		public static final int ORDER_REFUND = 2;
		/**
		 * 订单拒收申请
		 */
		public static final int ORDER_REJECT = 3;

		/**
		 * 售后部分退款
		 */
		public static final int AFTER_SLAE_REFUND = 4;
	}

	/**
	 * 售后申请状态
	 */
	public final class SaleApplyStatus {
		/**
		 * 申请中(待审核)
		 */
		public static final int UNCHECKED = 0;
		/**
		 * 已通过(审核)
		 */
		public static final int CHECKED = 1;
		/**
		 * 已驳回
		 */
		public static final int REJECT = 2;
		/**
		 * 已完成
		 */
		public static final int CLOSED = 3;

		/**
		 * 已取消
		 */
		public static final int CANCLED = 4;
	}

	/**
	 * 订单项评价状态
	 */
	public final class OrderItemEvaluated {
		/**
		 * 已评价
		 */
		public static final int EVALUATED = 1;
		/**
		 * 未评价
		 */
		public static final int UNEVALUATE = 0;
	}

	/**
	 * 售后申请审核类型
	 */
	public final class ApplyApproveType {
		/**
		 * 供应商审核
		 */
		public static final int MERCHANT_AUDIT = 1;
		/**
		 * 平台审核
		 */
		public static final int PLATFORM_AUDIT = 2;
	}

	/**
	 * 售后申请审核状态
	 */
	public final class ApproveStatus {
		/**
		 * 拒绝
		 */
		public static final int REJECT = 0;
		/**
		 * 同意
		 */
		public static final int ACCEPT = 1;
		/**
		 * 取消
		 */
		public static final int CANCLED = 2;
	}

	/**
	 * 物流状态
	 */
	public final class LgsStatus {

		/**
		 * 发货
		 */
		public static final int SEND_OUT = 1;

		/**
		 * 途中
		 */
		public static final int DELIVERING = 2;

		/**
		 * 已送达
		 */
		public static final int ARRIVED = 9;
	}

	public final class LgsMode {
		/**
		 * 快递
		 */
		public static final int KD = 0;
		/**
		 * 货运
		 */
		public static final int HY = 1;
	}

	/**
	 * 线上支付平台
	 */
	public final class PayPlatform {
		/**
		 * 支付宝平台
		 */
		public static final int ALI_PAY = 1;
		/**
		 * 微信支付
		 */
		public static final int WIXIN_PAY = 2;
		/**
		 * 银联支付
		 */
		public static final int BANK_PAY = 3;
		/**
		 * 信用支付
		 */
		public static final int CREDIT_PAY = 4;
	}

	/**
	 * 支付者类型
	 * @author Administrator
	 *
	 */
	public final class PayerType {
		/**
		 * 供应商
		 */
		public static final int SUPPLIER = 1;
		/**
		 * 运营平台
		 */
		public static final int PLATFORM = 2;
		/**
		 * 宝宝店
		 */
		public static final int CLIENT = 3;
	}

	/**
	 * 主订单状态
	 * @author Administrator
	 *
	 */
	public final class MainOrderStatus {
		/**
		 * 未支付
		 */
		public static final int PAY_NO = 1;
		/**
		 * 已支付
		 */
		public static final int PAY_YES = 2;
		/**
		 * 已取消
		 */
		public static final int CANCEL = 3;

		/**
		 * 异常
		 */
		public static final int EXCEPTION = 4;
	}

	/**
	 * 返回值0
	 */
	public static final int RESULT_0 = 0;

	/**
	 * 返回值1
	 */
	public static final int RESULT_1 = 1;

}
