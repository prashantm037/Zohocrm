package com.zohocrm.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	private JavaMailSender mailsend;
	

	@Override
	public void SendEmail(String to, String sub, String emailBody) {
		SimpleMailMessage message =new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(sub);
		message.setText(emailBody);
		
		mailsend.send(message);

	}

}
