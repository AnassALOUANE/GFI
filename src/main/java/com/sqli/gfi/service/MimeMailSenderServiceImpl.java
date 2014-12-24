package com.sqli.gfi.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.sqli.gfi.model.Collaborateur;
import com.sqli.gfi.model.Inscription;
import com.sqli.gfi.model.ResponsableFormation;

@Service
public class MimeMailSenderServiceImpl implements MimeMailSenderService {
	 @Autowired
	 private JavaMailSender mailSender;
	 @Autowired
	 private VelocityEngine velocityEngine;
	 
	 
	public void confirmeInscription(final Collaborateur c, final Inscription insc,final ResponsableFormation resp_f, final String serverUrl) {
		
		
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
				public void prepare(MimeMessage mimeMessage) throws Exception {
					MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
					
					helper.setFrom("sqli.gfi@gmail.com");
					helper.setTo(c.getEmail());
					helper.setSubject("Confirmation d'inscription au session de formation");
					helper.setSentDate(new Date());
					
					Map model = new HashMap();
					model.put("collaborateur", c);
					model.put("inscription", insc);
					model.put("resp_f", resp_f);
					model.put("serverUrl", serverUrl);
                    
                    String text = VelocityEngineUtils.mergeTemplateIntoString(
                       velocityEngine, "confirmMessage.vm", "UTF-8", model);
                    helper.setText(text, true);
                    
				//	helper.setText(String.format(msg_confirmation));
					
//					helper.setText("<html><body><a href='req.getServerName() + ':' + req.getServerPort() + ''  +req.getContextPath()+'/'+insc.getId_insc()+'/confirmation_insc/'+c.getId_u()+'/confirm'> confirmer </a></body></html>", true);
					
				/*
				 *  FileSystemResource file = new FileSystemResource(new File("C:/Users/karim/Desktop/world.jpg"));
					helper.addAttachment("CoolImage.jpg", file);
				 */
				}
			};
			try {
				mailSender.send(preparator);
			}
	        catch (MailException ex) {
	            System.err.println(ex.getMessage());
	        }
		
	}
	

}
