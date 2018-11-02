package com.kaiji.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

import tk.mybatis.mapper.annotation.KeySql;

public class BaseModel implements Serializable {

	private static final long serialVersionUID = -7899624407722581926L;
	
	@Id
	@KeySql(useGeneratedKeys=true)
	private String id;
	@Column(insertable=true)
	private Date createDate;
	@Column(updatable=true)
	private Date modifyDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	
}
