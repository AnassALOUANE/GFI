package com.sqli.gfi.service;

public interface MailSenderService {

	public void sendPassword(String email, String login, String password, Boolean active);
	public void sendUpdatePassword(String email, String login, String password, Boolean active);
	public void inscriptionConfirmation(String email, String resp_f, String formation);
	
}
