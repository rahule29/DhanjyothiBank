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
@Table(name = "KYC")
public class KYC implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7741225605265064400L;
	
	private long kycId;
	private String kycType;
	private String docDescription;
	private User user;
	
	public KYC() {
		super();
	}

	public KYC(long kycId, String kycType, String docDescription, User user) {
		super();
		this.kycId = kycId;
		this.kycType = kycType;
		this.docDescription = docDescription;
		this.user = user;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "KYC_ID", unique = true, nullable = false)
	public long getKycId() {
		return kycId;
	}

	public void setKycId(long kycId) {
		this.kycId = kycId;
	}

	@Column(name = "KYC_TYPE")
	public String getKycType() {
		return kycType;
	}

	public void setKycType(String kycType) {
		this.kycType = kycType;
	}

	@Column(name = "DOC_DESCRIPTION")
	public String getDocDescription() {
		return docDescription;
	}

	public void setDocDescription(String docDescription) {
		this.docDescription = docDescription;
	}

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "KYC [kycId=" + kycId + ", kycType=" + kycType + ", docDescription=" + docDescription + ", user=" + user
				+ "]";
	}
	
}
