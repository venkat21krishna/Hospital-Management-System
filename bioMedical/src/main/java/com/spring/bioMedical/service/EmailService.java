package com.spring.bioMedical.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service("emailService")
public class EmailService {

	private JavaMailSender mailSender;
	@Autowired
	public EmailService(JavaMailSender mailSenders) {
		// System.out.println("hello inside the mailservice");
		this.mailSender = mailSenders;
	}
	
	@Async
	public void sendEmail(SimpleMailMessage email) {
		// System.out.println("hello inside the sendmail");
		mailSender.send(email);
	}
}
