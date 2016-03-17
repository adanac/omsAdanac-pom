package com.adanac.b2b.oms.payment.baseservice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adanac.b2b.oms.dao.BaseDao;
import com.adanac.b2b.oms.order.constant.ErrorCodeConst;
import com.adanac.b2b.oms.payment.bo.PayNotifyInfoBo;
import com.adanac.b2b.oms.payment.constant.ConstNumber;
import com.adanac.b2b.oms.payment.dto.PayNotifyInfoDto;
import com.adanac.b2b.oms.payment.dto.PayNotifyInfoScDto;
import com.adanac.b2b.oms.utils.uuid.DefaultSequenceGenerator;
import com.adanac.framework.exception.SysException;

@Service("payNotifyBaseService")
public class PayNotifyBaseServiceImpl implements PayNotifyBaseService {

	@Autowired
	private BaseDao dao;

	@Override
	public String addPayNotifyInfo(PayNotifyInfoBo payNotifyInfo) {
		try {
			String id = DefaultSequenceGenerator.getInstance().uuid();
			payNotifyInfo.setId(id);
			dao.execute("payNotifyLog.create", payNotifyInfo);
			return id;
		} catch (Exception e) {
			throw new SysException(ErrorCodeConst.CODE_ERROR, e);
		}
	}

	@Override
	public Boolean modifyPayNotifyInfo(PayNotifyInfoBo payNotifyInfo) {
		try {
			int rslt = dao.execute("payNotifyLog.modifyById", payNotifyInfo);
			return rslt != ConstNumber.ZERO;
		} catch (Exception e) {
			throw new SysException(ErrorCodeConst.CODE_ERROR, e);
		}
	}

	@Override
	public PayNotifyInfoDto findById(String id) {
		try {
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id", id);
			return dao.queryForObject("payNotifyLog.query", condition, PayNotifyInfoDto.class);
		} catch (Exception e) {
			throw new SysException(ErrorCodeConst.CODE_ERROR, e);
		}
	}

	@Override
	public List<PayNotifyInfoDto> listByCondition(PayNotifyInfoScDto searchCondition) {
		try {
			return dao.queryForList("payNotifyLog.query", searchCondition, PayNotifyInfoDto.class);
		} catch (Exception e) {
			throw new SysException(ErrorCodeConst.CODE_ERROR, e);
		}
	}

	@Override
	public Boolean dealWithPayment(String id) {
		try {
			PayNotifyInfoDto payNotify = findById(id);
			return true;
		} catch (Exception e) {
			throw new SysException(ErrorCodeConst.CODE_ERROR, e);
		}
	}

}
