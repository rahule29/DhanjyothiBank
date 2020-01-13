package com.dhanjyothi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4198577598170065498L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID", unique = true, nullable = false)
	private int userId;
	@Column(name = "USER_ROLE")
	private String userRole;
	@Column(name = "USER_STATUS")
	private String userStatus;
	@Column(name = "FIRST_NAME", length = 100, nullable = false)
	private String firstName;
	@Column(name = "LAST_NAME", length = 100, nullable = false)
	private String lastName;
	@Column(name = "USER_NAME", unique = true)
	private String userName;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "DOB")
	private String dob;
	@Column(name = "ADDRESS_LINE1")
	private String addressLine1;
	@Column(name = "ADDRESS_LINE2")
	private String addressLine2;
	@Column(name = "CITY")
	private String city;
	@Column(name = "STATE")
	private String state;
	@Column(name = "PIN")
	private String pin;
	@Column(name = "EMAIL", unique = true)
	private String email;
	@Column(name = "MOBILE_NUMBER", unique = true)
	private String mobileNumber;
	@Column(name = "AADHAR", unique = true)
	private String aadhar;
	@Column(name = "PAN", unique = true)
	private String pan;
	
	
	public User() {
		super();
	}
	
	public User(int userId, String userRole, String userStatus, String firstName, String lastName, String userName,
			String password, String dob, String addressLine1, String addressLine2, String city, String state,
			String pin, String email, String mobileNumber, String aadhar, String pan) {
		super();
		this.userId = userId;
		this.userRole = userRole;
		this.userStatus = userStatus;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.dob = dob;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.aadhar = aadhar;
		this.pan = pan;
	}



	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userRole=" + userRole + ", userStatus=" + userStatus + ", firstName="
				+ firstName + ", lastName=" + lastName + ", userName=" + userName + ", password=" + password + ", dob="
				+ dob + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city
				+ ", state=" + state + ", pin=" + pin + ", email=" + email + ", mobileNumber=" + mobileNumber
				+ ", aadhar=" + aadhar + ", pan=" + pan + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
	

}
