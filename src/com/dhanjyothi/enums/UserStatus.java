package com.dhanjyothi.enums;

public enum UserStatus {
	ACTIVE("active"), IN_ACTIVE("inactive");
	private String desc;
	
	private UserStatus(String desc) {
		this.desc = desc;
	}
	
	public String getDesc() {
		return desc;
	}
	
}
