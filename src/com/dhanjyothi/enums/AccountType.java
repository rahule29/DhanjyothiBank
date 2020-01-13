package com.dhanjyothi.enums;

public enum AccountType {
	SA("Savings Account"), LA("Loan Account");
	private String desc;
	
	private AccountType(String desc) {
		this.desc = desc;
	}
	
	public String getDesc() {
		return desc;
	}
	
}
