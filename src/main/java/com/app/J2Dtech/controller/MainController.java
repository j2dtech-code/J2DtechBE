package com.app.J2Dtech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.J2Dtech.entity.ApiResponse;
import com.app.J2Dtech.entity.InstructorRegistration;
import com.app.J2Dtech.entity.OfferRequest;
import com.app.J2Dtech.entity.UserRegistration;
import com.app.J2Dtech.service.MainService;

import jakarta.mail.MessagingException;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.Document;


import java.io.*;

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
	
	@GetMapping("/updatePassword")
	public ResponseEntity<ApiResponse>  updatePassword(@RequestParam String email, @RequestParam String password) {
		ApiResponse res=mainService.updatePassword(email, password);
		return ResponseEntity.ok(res);

	}
	
	@GetMapping("/enroll")
	public ResponseEntity<ApiResponse>  enroll(@RequestParam String name, @RequestParam String phoneNumber) {
		ApiResponse res=mainService.enroll(name, phoneNumber);
		return ResponseEntity.ok(res);

	}
	
	@PostMapping("/registerInstructor")
	private ResponseEntity<ApiResponse> registerInstructor(@RequestBody InstructorRegistration data) {

		ApiResponse res = mainService.registerInstructor(data);

		return ResponseEntity.ok(res);

	}
	
	@PostMapping("/generate")
	public ResponseEntity<byte[]> generateOffer(@RequestBody OfferRequest offerRequest) {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PdfWriter writer = new PdfWriter(outputStream);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // Company Name & Offer Heading
            document.add(new Paragraph("XYZ Corporation")
                    .setBold()
                    .setFontSize(18)
                    .setTextAlignment(TextAlignment.CENTER));

            document.add(new Paragraph("Official Offer Letter")
                    .setBold()
                    .setFontSize(16)
                    .setTextAlignment(TextAlignment.CENTER));

            document.add(new Paragraph("\n\n"));

            // Greeting & Intro
            document.add(new Paragraph("Dear " + offerRequest.getName() + ","));
            document.add(new Paragraph("We are pleased to offer you the position of "
                    + offerRequest.getDesignation()
                    + " at XYZ Corporation. We were highly impressed with your skills and experience, and we believe that you will be a valuable addition to our team."));

            document.add(new Paragraph("\n"));

            // Job Details
            document.add(new Paragraph("Job Title: " + offerRequest.getDesignation()));
            document.add(new Paragraph("Salary Package: $" + offerRequest.getAmount() + " per annum"));
            document.add(new Paragraph("Joining Date: To be mutually decided"));

            document.add(new Paragraph("\n"));

            // Terms & Conditions
            document.add(new Paragraph("Terms and Conditions")
                    .setBold()
                    .setFontSize(14));

            document.add(new Paragraph("1. Your employment will be subject to the policies and rules of XYZ Corporation."));
            document.add(new Paragraph("2. You will be required to sign a confidentiality agreement before your joining."));
            document.add(new Paragraph("3. This offer is contingent upon successful completion of background verification."));
            document.add(new Paragraph("4. Your performance will be reviewed periodically, and salary increments will be based on company policies."));

            document.add(new Paragraph("\n"));

            // Closing Statement
            document.add(new Paragraph("We are excited to have you on board and look forward to working with you. Please confirm your acceptance of this offer by signing and returning a copy of this letter."));

            document.add(new Paragraph("\n\n"));

            document.add(new Paragraph("Best Regards,"));
            document.add(new Paragraph("HR Manager"));
            document.add(new Paragraph("J2d Technologies"));

            document.close();

            byte[] pdfBytes = outputStream.toByteArray();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.attachment()
                    .filename(offerRequest.getName() + "_Offer_Letter.pdf")
                    .build());

            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    }


