package com.adanac.b2b.oms.utils;

import java.util.List;
import java.util.UUID;

/**
 * 通用工具类
 * @author adanac
 * @version 1.0
 */
public class CommonUtil {
	private static final String SEP = ",";

	/**
	 * 用逗号作为分隔符拼接列表里的元素
	 * @param list 
	 * @return 字符串，如："1,2,3"
	 */
	public static String ListToString(List<?> list) {
		StringBuffer sb = new StringBuffer();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) == null || list.get(i) == "") {
					continue;
				} else {
					sb.append("'");
					sb.append(list.get(i));
					sb.append("'");
					if (i < list.size() - 1) {
						sb.append(SEP);
					}
				}
			}
		}
		return sb.toString();
	}

	public static String getUUID() {
		String uuid = UUID.randomUUID().toString();
		return uuid.replaceAll("-", "");
	}
}
