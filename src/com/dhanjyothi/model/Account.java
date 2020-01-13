package com.dhanjyothi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6907950074573545410L;
	private int accountId;
	private String accountType;
	private long accountDeposit;
	private float interestRate;
	private Date accountCreatedDate;
	private Date accountUpdatedDate;
	private long maturityAmount;
	private User user;
	
	public Account() {
		super();
	}
	
	public Account(int accountId, String accountType, long accountDeposit, float interestRate, Date accountCreatedDate,
			Date accountUpdatedDate, long maturityAmount, User user) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.accountDeposit = accountDeposit;
		this.interestRate = interestRate;
		this.accountCreatedDate = accountCreatedDate;
		this.accountUpdatedDate = accountUpdatedDate;
		this.maturityAmount = maturityAmount;
		this.user = user;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACCOUNT_ID", unique = true, nullable = false)
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	@Column(name = "ACCOUNT_TYPE", unique = false, nullable = false, length = 30)
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	@Column(name = "ACCOUNT_DEPOSIT")
	public long getAccountDeposit() {
		return accountDeposit;
	}
	public void setAccountDeposit(long accountDeposit) {
		this.accountDeposit = accountDeposit;
	}
	
	@Column(name = "INTEREST_RATE")
	public float getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}
	
	@Column(name = "ACCOUNT_CREATED_DATE")
	public Date getAccountCreatedDate() {
		return accountCreatedDate;
	}
	public void setAccountCreatedDate(Date accountCreatedDate) {
		this.accountCreatedDate = accountCreatedDate;
	}
	
	@Column(name = "ACCOUNT_UPDATED_DATE")
	public Date getAccountUpdatedDate() {
		return accountUpdatedDate;
	}
	public void setAccountUpdatedDate(Date accountUpdatedDate) {
		this.accountUpdatedDate = accountUpdatedDate;
	}
	
	@Column(name = "MATURITY_AMOUNT")
	public long getMaturityAmount() {
		return maturityAmount;
	}
	public void setMaturityAmount(long maturityAmount) {
		this.maturityAmount = maturityAmount;
	}
	
	@ManyToOne
	@JoinColumn(name = "USER_ID", updatable = true)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountType=" + accountType + ", accountDeposit=" + accountDeposit
				+ ", interestRate=" + interestRate + ", accountCreatedDate=" + accountCreatedDate
				+ ", accountUpdatedDate=" + accountUpdatedDate + ", maturityAmount=" + maturityAmount + ", user=" + user
				+ "]";
	}

}
