package com.adanac.b2b.oms.utils;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.dubbo.common.utils.StringUtils;

public class MethodUtil {

	/**
	 * 返回处理结果
	 * @param count
	 * @return
	 */
	public static Boolean isTrue(int count) {
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 处理传入的参数(添加')
	 * @param key 
	 * @param value
	 * @return
	 */
	public static Map<String, Object> getParamMap(String key, String value) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		if (StringUtils.isEmpty(value)) {
			paramMap.put(key, "");
		} else {
			if (value.contains(",")) {
				String[] splitIds = value.split(",");
				for (int i = 0; i < splitIds.length; i++) {
					splitIds[i] = "'" + splitIds[i] + "'";
				}
				String ids = StringUtils.join(splitIds, ",");
				paramMap.put(key, ids);
			} else {
				paramMap.put(key, "'" + value + "'");
			}
		}
		return paramMap;
	}

}
