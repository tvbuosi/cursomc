package com.thiagobuosi.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.thiagobuosi.cursomc.domain.Cliente;
import com.thiagobuosi.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Cliente cliente, String newPass);
	
}
