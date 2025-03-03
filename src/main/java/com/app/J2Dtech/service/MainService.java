package com.app.J2Dtech.service;

import org.springframework.mail.MailException;

import com.app.J2Dtech.entity.ApiResponse;
import com.app.J2Dtech.entity.UserRegistration;

import jakarta.mail.MessagingException;

public interface MainService {

	ApiResponse registerUser(UserRegistration userRegistration);
	
	public ApiResponse sendEmail(String to) throws MailException, MessagingException;

	ApiResponse login(String email, String password);

	ApiResponse updatePassword(String email, String password);

}
