package com.adanac.b2b.oms.order.bo;

import java.io.Serializable;

import com.adanac.b2b.oms.order.dto.SkuEvaluatePicDto;

/**
 * 评价图片实体
 * @author lfz
 * @version 2.0
 */
public class SkuEvaluatePicBo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2353726665771751019L;

	/**
	 * 主键id
	 */
	private String id;

	/**
	 * 评价单id
	 */
	private String evaluateId;

	/**
	 * 图片地址
	 */
	private String url;

	/**
	 *备注
	 */
	private String remark;

	/**
	 * 创建时间
	 */
	private String createTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEvaluateId() {
		return evaluateId;
	}

	public void setEvaluateId(String evaluateId) {
		this.evaluateId = evaluateId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public SkuEvaluatePicBo() {
	}

	public SkuEvaluatePicBo(SkuEvaluatePicDto dto) {
		this.id = dto.getId();
		this.createTime = dto.getCreateTime();
		this.evaluateId = dto.getEvaluateId();
		this.remark = dto.getRemark();
		this.url = dto.getUrl();

	}

}
