package com.app.J2Dtech.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Instructor_Registration")
public class InstructorRegistration {

	@Id
	@Column(name = "User_Registration_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long instructorRegistrationID;

	@Column(name = "Name")
	private String name;

	@Column(name = "Email")
	private String email;

	@Column(name = "Course")
	private String course;

	@Column(name = "Phone_Number")
	private String phoneNumber;

	public Long getInstructorRegistrationID() {
		return instructorRegistrationID;
	}

	public void setInstructorRegistrationID(Long instructorRegistrationID) {
		this.instructorRegistrationID = instructorRegistrationID;
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

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
