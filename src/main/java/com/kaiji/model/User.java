package com.kaiji.model;

import javax.persistence.Table;

@Table(name ="s_user")
public class User extends BaseModel {

	private static final long serialVersionUID = 1690503266973603908L;

	private String name;
	private String phone;
	private String ipAddress;
	private int lock;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public int getLock() {
		return lock;
	}

	public void setLock(int lock) {
		this.lock = lock;
	}
}
