package com.dhanjyothi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author RBADIGER
 *
 */
@Entity
@Table(name = "TRANSACTION")
public class Transaction implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1411304874104715100L;

	private int transactionId;
	private String transactionType;
	private long transactionAmount;
	private Date transactionDate;
	private String transactionDescription;
	private Account account;
	private Beneficiaries benificiary;
	private Set<Beneficiaries> beneficiaries;
	private byte[] file;
	
	public Transaction() {
		super();
	}

	public Transaction(int transactionId, String transactionType, long transactionAmount, Date transactionDate,
			String transactionDescription, Account account, Beneficiaries benificiary, Set<Beneficiaries> beneficiaries,
			byte[] file) {
		super();
		this.transactionId = transactionId;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
		this.transactionDescription = transactionDescription;
		this.account = account;
		this.benificiary = benificiary;
		this.beneficiaries = beneficiaries;
		this.file = file;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRANSACTION_ID", unique = true, nullable = false)
	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	@Column(name = "TRANSACTION_TYPE")
	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	@Column(name = "TRANSACTION_AMOUNT")
	public long getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(long transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	@Column(name = "TRANSACTION_DATE")
	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	@Column(name = "TRANSACTION_DESCRIPTION")
	public String getTransactionDescription() {
		return transactionDescription;
	}

	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	@ManyToOne
	@JoinColumn(name = "ACCOUNT_ID")
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@ManyToOne()
	@JoinColumn(name = "BENIFICIARY_ID")
	public Beneficiaries getBenificiary() {
		return benificiary;
	}

	public void setBenificiary(Beneficiaries benificiary) {
		this.benificiary = benificiary;
	}

	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY, mappedBy = "beneficiaryId")
	public Set<Beneficiaries> getBeneficiaries() {
		return beneficiaries;
	}

	public void setBeneficiaries(Set<Beneficiaries> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}

	@Column(name = "FILE")
	@Lob
	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionType=" + transactionType
				+ ", transactionAmount=" + transactionAmount + ", transactionDate=" + transactionDate
				+ ", transactionDescription=" + transactionDescription + ", account=" + account + ", benificiary="
				+ benificiary + ", beneficiaries=" + beneficiaries + ", file=" + file + "]";
	}

}
