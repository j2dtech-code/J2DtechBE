package com.app.J2Dtech.entity;

public class OfferRequest {
	private String name;
	private String email;
	private String designation;
	private double amount;

	// Constructors
	public OfferRequest() {
	}

	public OfferRequest(String name, String email, String designation, double amount) {
		this.name = name;
		this.email = email;
		this.designation = designation;
		this.amount = amount;
	}

	// Getters and Setters
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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
