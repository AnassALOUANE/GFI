package com.sqli.gfi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class MailSenderServiceImpl implements MailSenderService {
	@Autowired
	private MailSender mailSender;

	 
	public void sendPassword(String email, String login, String password, Boolean active) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("sqli.gfi@gmail.com");
		message.setTo(email);
		message.setSubject("Nouveau compte");
		String etat = (active)?"activer":"désactiver";
		message.setText(
		"Bonjour Monsieur,\n\n" +
		"l'adminisrateur de l'application de gestion de formation interne créer un compte pour vous:\n" +
		"login : " + login + "\n" +
		"password : " + password + "\n\n" +
		"l'etat de votre compte est : " + etat + "\n\n" +
		"merci \n\n "
		+ "Administrateur de GFI \n\n"
		+ "Cordialement");
		mailSender.send(message);
	}
	
	 
	public void sendUpdatePassword(String email, String login, String password, Boolean active) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("sqli.gfi@gmail.com");
		message.setTo(email);
		message.setSubject("Modification de Compte");
		String etat = (active)?"activer":"désactiver";
		message.setText(
		"Bonjour Monsieur,\n\n" +
		"la modification de votre comte à été bien éffectuée:\n" +
		"login : " + login + "\n" +
		"password : " + password + "\n\n" +
		"l'etat de votre compte est : " + etat + "\n\n" +
		"merci \n\n "
		+ "Administrateur de GFI \n\n"
		+ "Cordialement");
		mailSender.send(message);
	}

	 
	public void inscriptionConfirmation(String email, String resp_f, String formation) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("sqli.gfi@gmail.com");
		message.setTo(email);
		message.setSubject("Modification de Compte");
		message.setText(
		"Bonjour Monsieur,\n\n" +
		"Monsieur "+ resp_f +" vous inviter pour une nouvelle formtion de :"+ formation +"\n" +
		"merci \n\n "
		+ "Administrateur de GFI \n\n"
		+ "Cordialement");
		mailSender.send(message);
	}
	
	

}
