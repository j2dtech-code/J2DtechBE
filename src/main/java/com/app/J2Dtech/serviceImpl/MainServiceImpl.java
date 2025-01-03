package com.app.J2Dtech.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.app.J2Dtech.entity.ApiResponse;
import com.app.J2Dtech.entity.UserRegistration;
import com.app.J2Dtech.repository.UserRegistrationRepo;
import com.app.J2Dtech.service.MainService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	private UserRegistrationRepo userRegistrationRepo;

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public ApiResponse sendEmail(String to) throws MailException, MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);

		messageHelper.setFrom("sagarchidre5@gmail.com");
		messageHelper.setTo(to);
		messageHelper.setSubject("Password Reset Request");
		int otp = generateOtp();
		messageHelper.setText(getBody("", generateOtp()), true); // 'true' enables HTML content in the body

		javaMailSender.send(mimeMessage);
		return new ApiResponse(200, String.valueOf(otp));
	}

	private int generateOtp() {
		int randomNumber = 1000 + (int) (Math.random() * 9000);
		return randomNumber;
	}

	private String getBody(String recipientName, int otp) {
		String emailContent = "Hi " + recipientName + ",\n\n"
				+ "To complete your login, please use the One-Time Password (OTP) below.\n\n" + "Your OTP is: " + otp
				+ "\n\n"
				+ "This OTP is valid for 10 minutes. Please do not share it with anyone for security purposes.\n\n"
				+ "If you did not request this, please contact our support team immediately at support@example.com.\n\n"
				+ "Thank you,\n" + "Your Company Name\n" + "www.example.com\n\n";
		return emailContent;
	}

	@Override
	public ApiResponse registerUser(UserRegistration userRegistration) {
		// TODO Auto-generated method stub
		try {
			userRegistrationRepo.save(userRegistration);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return new ApiResponse(200, "Registration successful");
	}

	@Override
	public ApiResponse login(String email, String password) {
		UserRegistration userData = userRegistrationRepo.getUserDataByEmail(email);
		if (userData != null) {
			if (userData.getPassword().equals(password)) {
				 return new ApiResponse(200, "Login successful");
			} else {
				return new ApiResponse(500, "Login successful");
			}
		}
		return null;
		
	}

}
