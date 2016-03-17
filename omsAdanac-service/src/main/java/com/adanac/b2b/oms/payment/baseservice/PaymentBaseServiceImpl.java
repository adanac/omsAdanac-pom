package com.adanac.b2b.oms.payment.baseservice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adanac.b2b.oms.dao.BaseDao;
import com.adanac.b2b.oms.order.constant.ErrorCodeConst;
import com.adanac.b2b.oms.payment.bo.PaymentInfoBo;
import com.adanac.b2b.oms.payment.constant.ConstNumber;
import com.adanac.b2b.oms.payment.dto.PaymentInfoDto;
import com.adanac.b2b.oms.payment.dto.PaymentScDto;
import com.adanac.b2b.oms.utils.uuid.DefaultSequenceGenerator;
import com.adanac.framework.exception.SysException;

@Service("paymentBaseService")
public class PaymentBaseServiceImpl implements PaymentBaseService {

	@Autowired
	private BaseDao dao;

	@Override
	public String addPaymentInfo(PaymentInfoBo paymetInfo) {
		try {
			String id = DefaultSequenceGenerator.getInstance().uuid();
			paymetInfo.setId(id);
			dao.execute("pay.create", paymetInfo);
			return id;
		} catch (Exception e) {
			throw new SysException(ErrorCodeConst.CODE_ERROR, e);
		}
	}

	@Override
	public Boolean modifyPaymentInfo(PaymentInfoBo paymentInfo) {
		try {
			int rslt = dao.execute("pay.modifyById", paymentInfo);
			return rslt != ConstNumber.ZERO;
		} catch (Exception e) {
			throw new SysException(ErrorCodeConst.CODE_ERROR, e);
		}
	}

	@Override
	public PaymentInfoDto findById(String id) {
		try {
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id", id);
			return dao.queryForObject("pay.query", condition, PaymentInfoDto.class);
		} catch (Exception e) {
			throw new SysException(ErrorCodeConst.CODE_ERROR, e);
		}
	}

	@Override
	public List<PaymentInfoDto> listByCondition(PaymentScDto searchCondition) {
		try {
			return dao.queryForList("pay.query", searchCondition, PaymentInfoDto.class);
		} catch (Exception e) {
			throw new SysException(ErrorCodeConst.CODE_ERROR, e);
		}
	}

}
