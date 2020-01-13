package com.dhanjyothi.enums;

public enum UserRole {
	ADMIN("admin"), CUSTOMER("customer"), EMPLOYEE("employee");
	private String desc;
	
	private UserRole(String desc) {
		this.desc = desc;
	}
	
	public String getDesc() {
		return desc;
	}
	
}
