package com.app.J2Dtech.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "User_Registration")
public class UserRegistration {

	@Id
	@Column(name = "User_Registration_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userRegistrationID;

	@Column(name = "Name")
	private String name;

	@Column(name = "Email")
	private String email;

	@Column(name = "Password")
	private String password;

	@Column(name = "Phone_Number")
	private String phoneNumber;

	public Long getUserRegistrationID() {
		return userRegistrationID;
	}

	public void setUserRegistrationID(Long userRegistrationID) {
		this.userRegistrationID = userRegistrationID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
