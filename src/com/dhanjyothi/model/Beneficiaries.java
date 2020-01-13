package com.dhanjyothi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BENEFICIARIES")
public class Beneficiaries implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7765985257624385654L;
	
	private long beneficiaryId;
	private User user;
	private String beneficiaryNickName;
	private String beneficiaryName;
	private int beneficiaryAccountNo;
	
	
	public Beneficiaries() {
		super();
	}

	public Beneficiaries(long beneficiaryId, User user, String beneficiaryNickName, String beneficiaryName,
			int beneficiaryAccountNo) {
		super();
		this.beneficiaryId = beneficiaryId;
		this.user = user;
		this.beneficiaryNickName = beneficiaryNickName;
		this.beneficiaryName = beneficiaryName;
		this.beneficiaryAccountNo = beneficiaryAccountNo;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BENEFICIARY_ID", unique = true, nullable = false)
	public long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	@ManyToOne
	@JoinColumn(name = "USER_ID", nullable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "BENEFICIARY_NICK_NAME", unique = true, nullable = false)
	public String getBeneficiaryNickName() {
		return beneficiaryNickName;
	}

	public void setBeneficiaryNickName(String beneficiaryNickName) {
		this.beneficiaryNickName = beneficiaryNickName;
	}

	@Column(name = "BENEFICIARY_NAME", nullable = false)
	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}
	
	@Column(name = "BENEFICIARY_ACCOUNT_NO", nullable = false)
	public int getBeneficiaryAccountNo() {
		return beneficiaryAccountNo;
	}

	public void setBeneficiaryAccountNo(int beneficiaryAccountNo) {
		this.beneficiaryAccountNo = beneficiaryAccountNo;
	}

	@Override
	public String toString() {
		return "Beneficiaries [beneficiaryId=" + beneficiaryId + ", user=" + user + ", beneficiaryNickName="
				+ beneficiaryNickName + ", beneficiaryName=" + beneficiaryName + ", beneficiaryAccountNo="
				+ beneficiaryAccountNo + "]";
	}

}
