package com.admin.model;
// Generated 2015-10-11 11:37:50 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * WebCategoryConf generated by hbm2java
 */
public class WebCategoryConf implements java.io.Serializable {

	private Integer id;
	private int categoryId;
	private int type;
	private String paramCode;
	private String paramName;
	private String paramValue;
	private String rootCode;
	private String des;
	private int rank;
	private String iseff;
	private Date createTime;
	private Date lastUpdate;

	public WebCategoryConf() {
	}

	public WebCategoryConf(int categoryId, int type, String paramCode,
			String paramName, int rank, String iseff, Date createTime,
			Date lastUpdate) {
		this.categoryId = categoryId;
		this.type = type;
		this.paramCode = paramCode;
		this.paramName = paramName;
		this.rank = rank;
		this.iseff = iseff;
		this.createTime = createTime;
		this.lastUpdate = lastUpdate;
	}
	public WebCategoryConf(int categoryId, int type, String paramCode,
			String paramName, String paramValue, String rootCode, String des,
			int rank, String iseff, Date createTime, Date lastUpdate) {
		this.categoryId = categoryId;
		this.type = type;
		this.paramCode = paramCode;
		this.paramName = paramName;
		this.paramValue = paramValue;
		this.rootCode = rootCode;
		this.des = des;
		this.rank = rank;
		this.iseff = iseff;
		this.createTime = createTime;
		this.lastUpdate = lastUpdate;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}
	public String getParamCode() {
		return this.paramCode;
	}

	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	}
	public String getParamName() {
		return this.paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	public String getParamValue() {
		return this.paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}
	public String getRootCode() {
		return this.rootCode;
	}

	public void setRootCode(String rootCode) {
		this.rootCode = rootCode;
	}
	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}
	public int getRank() {
		return this.rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getIseff() {
		return this.iseff;
	}

	public void setIseff(String iseff) {
		this.iseff = iseff;
	}
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}