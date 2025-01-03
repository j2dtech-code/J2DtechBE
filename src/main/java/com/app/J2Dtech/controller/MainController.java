package com.app.J2Dtech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.J2Dtech.entity.ApiResponse;
import com.app.J2Dtech.entity.UserRegistration;
import com.app.J2Dtech.service.MainService;

import jakarta.mail.MessagingException;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/j2Dtech")
public class MainController {

	@Autowired
	MainService mainService;

	@PostMapping("/registerUser")
	private ResponseEntity<ApiResponse> registerUser(@RequestBody UserRegistration userRegistration) {

		ApiResponse res = mainService.registerUser(userRegistration);

		return ResponseEntity.ok(res);

	}

	@GetMapping("/send-email")
	public ResponseEntity<ApiResponse>  sendEmail(@RequestParam String email) throws MailException, MessagingException {
		ApiResponse res=mainService.sendEmail(email);
			return ResponseEntity.ok(res);
		
	}

	@GetMapping("/login")
	public ResponseEntity<ApiResponse>  login(@RequestParam String email, @RequestParam String password) {
		ApiResponse res=mainService.login(email, password);
		return ResponseEntity.ok(res);

	}

}
