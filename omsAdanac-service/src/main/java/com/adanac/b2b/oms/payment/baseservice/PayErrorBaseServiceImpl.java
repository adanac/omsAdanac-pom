package com.adanac.b2b.oms.payment.baseservice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adanac.b2b.oms.dao.BaseDao;
import com.adanac.b2b.oms.order.constant.ErrorCodeConst;
import com.adanac.b2b.oms.payment.bo.PayErrorInfoBo;
import com.adanac.b2b.oms.payment.constant.ConstNumber;
import com.adanac.b2b.oms.payment.dto.PayErrorInfoDto;
import com.adanac.b2b.oms.payment.dto.PayErrorInfoScDto;
import com.adanac.b2b.oms.utils.uuid.DefaultSequenceGenerator;
import com.adanac.framework.exception.SysException;

@Service("payErrorBaseService")
public class PayErrorBaseServiceImpl implements PayErrorBaseService {

	@Autowired
	private BaseDao dao;

	@Override
	public String addPayErrorInfo(PayErrorInfoBo payErrorInfo) {
		try {
			String id = DefaultSequenceGenerator.getInstance().uuid();
			payErrorInfo.setId(id);
			dao.execute("payErrorInfo.create", payErrorInfo);
			return id;
		} catch (Exception e) {
			throw new SysException(ErrorCodeConst.CODE_ERROR, e);
		}
	}

	@Override
	public Boolean moidfyPayErrorInfo(PayErrorInfoBo payErrorInfo) {
		try {
			int rslt = dao.execute("payErrorInfo.modifyById", payErrorInfo);
			return rslt != ConstNumber.ZERO;
		} catch (Exception e) {
			throw new SysException(ErrorCodeConst.CODE_ERROR, e);
		}
	}

	@Override
	public PayErrorInfoDto findById(String id) {
		try {
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("id", id);
			return dao.queryForObject("payErrorInfo.query", condition, PayErrorInfoDto.class);
		} catch (Exception e) {
			throw new SysException(ErrorCodeConst.CODE_ERROR, e);
		}
	}

	@Override
	public List<PayErrorInfoDto> listByCondition(PayErrorInfoScDto searchCondition) {
		try {
			return dao.queryForList("payErrorInfo.query", searchCondition, PayErrorInfoDto.class);
		} catch (Exception e) {
			throw new SysException(ErrorCodeConst.CODE_ERROR, e);
		}
	}

	@Override
	public Boolean moidfyOrderCode(PayErrorInfoBo payErrorInfo) {
		try {
			int rslt = dao.execute("payErrorInfo.modifyByOrderCode", payErrorInfo);
			return rslt != ConstNumber.ZERO;
		} catch (Exception e) {
			throw new SysException(ErrorCodeConst.CODE_ERROR, e);
		}
	}

}
