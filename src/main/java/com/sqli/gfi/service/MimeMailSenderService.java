package com.sqli.gfi.service;

import javax.servlet.http.HttpServletRequest;

import com.sqli.gfi.model.Collaborateur;
import com.sqli.gfi.model.Inscription;
import com.sqli.gfi.model.ResponsableFormation;

public interface MimeMailSenderService {
	
	public void confirmeInscription(Collaborateur c, Inscription insc,  ResponsableFormation resp_f, String serverUrl);

}
