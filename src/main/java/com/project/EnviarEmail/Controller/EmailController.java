package com.project.EnviarEmail.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    
	@Autowired private JavaMailSender mailSender;
	
	@RequestMapping(path = "/enviar-email", method = RequestMethod.GET)
	 public String sendEmail() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setText("Ola sou uma aplicação Springboot");
		message.setTo("seu gmail-  ou para quem quer enviar");
		message.setFrom("seu gmail-  ou para quem quer enviar");
		
		try { 
			mailSender.send(message);
			return "Email enviado com sucesso";
		}catch (Exception e) {
			e.printStackTrace();
			return "erro ao enviar email.";
		}
		
	}
	
}

