package com.adanac.b2b.oms.order.dto;

import java.io.Serializable;

import com.adanac.b2b.oms.order.bo.SkuEvaluatePicBo;

/**
 * 评价图片dto
 * @author lfz
 * @version 2.0
 */
public class SkuEvaluatePicDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2489360291608317981L;

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

	public SkuEvaluatePicDto() {
	}

	public SkuEvaluatePicDto(SkuEvaluatePicBo bo) {
		this.id = bo.getId();
		this.createTime = bo.getCreateTime();
		this.evaluateId = bo.getEvaluateId();
		this.remark = bo.getRemark();
		this.url = bo.getUrl();
	}

	@Override
	public String toString() {
		return "SkuEvaluatePicDto [id=" + id + ", evaluateId=" + evaluateId + ", url=" + url + ", remark=" + remark
				+ ", createTime=" + createTime + "]";
	}

}
