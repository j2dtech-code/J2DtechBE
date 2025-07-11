package com.app.J2Dtech.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.app.J2Dtech.entity.ApiResponse;
import com.app.J2Dtech.entity.InstructorRegistration;
import com.app.J2Dtech.entity.UserRegistration;
import com.app.J2Dtech.repository.InstructorRegistrationRepo;
import com.app.J2Dtech.repository.UserRegistrationRepo;
import com.app.J2Dtech.service.MainService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	private UserRegistrationRepo userRegistrationRepo;
	
	@Autowired
	private InstructorRegistrationRepo instructorRegistrationRepo;

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public ApiResponse sendEmail(String to) throws MailException, MessagingException {
		UserRegistration userDataByEmail = userRegistrationRepo.getUserDataByEmail(to);
		if(userDataByEmail==null) {
			return new ApiResponse(500, String.valueOf(000));
		}
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);

		messageHelper.setFrom("sagarchidre5@gmail.com");
		messageHelper.setTo(to);
		messageHelper.setSubject("Password Reset Request");
		int otp = generateOtp();
		messageHelper.setText(getBody(userDataByEmail.getName(), otp), true); // 'true' enables HTML content in the body

		javaMailSender.send(mimeMessage);
		return new ApiResponse(200, String.valueOf(otp));
	}

	private int generateOtp() {
		int randomNumber = 100000 + (int) (Math.random() * 9000);
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
			UserRegistration userDataByEmail = userRegistrationRepo.getUserDataByNumber(userRegistration.getPhoneNumber());
			if(userDataByEmail==null) {
			userRegistrationRepo.save(userRegistration);
			} else {
				return new ApiResponse(501, "User Already Exists");
			}
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

	@Override
	public ApiResponse updatePassword(String email, String password) {
		try {
			userRegistrationRepo.updatePassword(email, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return new ApiResponse(200, "Password Updated Successfully");
	}

	@Override
	public ApiResponse enroll(String name, String phoneNumber) {
		try {
			UserRegistration userDataByNumber = userRegistrationRepo.getUserDataByNumber(phoneNumber);
			if(userDataByNumber != null) {
				userDataByNumber.setEnroll(true);
				userRegistrationRepo.save(userDataByNumber);
			} else {
				UserRegistration user =new UserRegistration();
				user.setName(name);
				user.setPhoneNumber(phoneNumber);
				user.setEnroll(true);
				userRegistrationRepo.save(user);
			}
		} catch (Exception e) {
            e.printStackTrace();
		}
		
		return new ApiResponse(200, "User Enrolled Successfully");
	}

	@Override
	public ApiResponse registerInstructor(InstructorRegistration data) {
		try {
			instructorRegistrationRepo.save(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ApiResponse(200, "Instructor Registered Successfully");
	}

}
