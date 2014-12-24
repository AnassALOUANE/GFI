package com.sqli.gfi.web;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;

import com.sqli.gfi.service.MailSenderService;
import com.sqli.gfi.service.MailSenderServiceImpl;


public class PasswordEncodeGenerator {
	
	
	 public static void main(String[] args) {

	
			int i = 0;
			while (i < 10) {
				String password = "admin";
				PasswordEncoder encoder = new Md5PasswordEncoder();
			    String hashedPassword = encoder.encodePassword(password, null);
				System.out.println(hashedPassword);
				i++;
			}
		 
		 
//		    	ApplicationContext context =  new ClassPathXmlApplicationContext("spring-email.xml");
//		 
//		    	MailSenderService ms = (MailSenderServiceImpl) context.getBean("springMail");
//
//		 
//		        ms.sendPassword("karim.dahdoh@gmail.com", "aaaa", "bbbbb", true);
//	
		 
		  }

}
