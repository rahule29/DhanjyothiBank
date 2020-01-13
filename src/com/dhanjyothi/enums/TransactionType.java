package com.dhanjyothi.enums;

public enum TransactionType {
	CREDIT("Credit"), DEBIT("Debit");
	private String desc;
	
	private TransactionType(String desc) {
		this.desc = desc;
	}
	
	public String getDesc() {
		return desc;
	}
	
}
