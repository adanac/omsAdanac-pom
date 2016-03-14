package com.adanac.b2b.oms.common;

import java.io.Serializable;

/**
 * Dto基础类
 * @author adanac
 * @version 1.0
 */
public class BaseDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -544577673770251390L;
	private String status = "0";
	private String returnId = "";
	private String errorCode = "";
	private String errorMsg = "";
	public static final String WARN = "warn";
	public static final String SUCCESS = "1";
	public static final String ERROR = "0";

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReturnId() {
		return returnId;
	}

	public void setReturnId(String returnId) {
		this.returnId = returnId;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
