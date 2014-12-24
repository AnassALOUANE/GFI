package com.sqli.gfi.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sqli.gfi.model.Collaborateur;
import com.sqli.gfi.model.Inscription;
import com.sqli.gfi.model.ResponsableFormation;
import com.sqli.gfi.model.SessionF;
import com.sqli.gfi.service.InscriptionService;
import com.sqli.gfi.service.MimeMailSenderService;
import com.sqli.gfi.service.SessionService;
import com.sqli.gfi.service.UtilisateurService;

@Controller
@RequestMapping("/{idS}/inscription/*")
public class InscriptionController {
	
	@Autowired
	private InscriptionService inscriptionService;
	@Autowired
	private SessionService sessionService;
	@Autowired
	private UtilisateurService utilisateurService;
	@Autowired
	private MimeMailSenderService  mimeMailSenderService;
	

	/** la liste des collaborateurs inscrivent à la session de formation */
	@RequestMapping(value = "index", method = RequestMethod.GET)
    public String indexInscription(@PathVariable("idS") Integer idS, Model model) {
        model.addAttribute("session", sessionService.getSessionById(idS));
        List<Collaborateur> list_collaborateurs_not_inscrit = utilisateurService.getAllCollaborateursNotInscribeSession(idS);
        model.addAttribute("collaborateurs", list_collaborateurs_not_inscrit); 
//        for(Collaborateur cc : list_collaborateurs_not_inscrit) 
//        	System.out.println(" ###### __________*********-----------*********------ "+ cc);
        	
        return "index_inscription";
    }
	
	/** Créer une session de formation */
	@RequestMapping(value = "add", method = RequestMethod.POST)
    public String inscrireCollaborateurs(@PathVariable("idS") Integer idS, @RequestParam(value="checkBox_collaborateurs", required = false) Integer [] checkBox_collaborateurs, Model model, HttpSession session, HttpServletRequest req) {
		 if(checkBox_collaborateurs==null) {
			 model.addAttribute("session", sessionService.getSessionById(idS)); 
		     model.addAttribute("collaborateurs", utilisateurService.getAllCollaborateurs()); 
		     model.addAttribute("errors", "veuillez selectionner les collaborateurs qui vous voulez inscrire dans la session de formation"); 
		     return "index_inscription";
		 }		 
		 
		 /** get responsable formation connécté */
		 ResponsableFormation resp_f_connecte = (ResponsableFormation) session.getAttribute("resp_f_connecte");
		 SessionF sessionf = sessionService.getSessionById(idS);	 
		 Collaborateur collaborateur = new Collaborateur();
		 Integer[] checkBox = checkBox_collaborateurs;
		 Inscription inscription = new Inscription();
		 for(Integer id_c : checkBox)
		 {
			 inscription.setSession(sessionf);
			 inscription.setResponsableFormation(resp_f_connecte);
			 collaborateur = utilisateurService.getCollaborateurById(id_c);
			 inscription.setCollaborateur(collaborateur);
			 inscription.setConfirmer(false);
			 inscriptionService.inscrire(inscription);
			 
			 Inscription insc = inscriptionService.getInscriptionByCollaborateurSession(id_c, idS);			 
			 String serverUrl= req.getServerName()+":"+req.getServerPort()+""+req.getContextPath();
			 
			 String msg = envoyerMailAuCollaborateur(collaborateur, insc,resp_f_connecte, serverUrl);
			 System.out.println(msg);
			 			 
			 /** envoyer la confirmation au collaborateur */
			 mimeMailSenderService.confirmeInscription(collaborateur, insc,resp_f_connecte, serverUrl);
		 }
		

        return "redirect:index";
    }

	
	public String envoyerMailAuCollaborateur(Collaborateur collaborateur,Inscription insc, ResponsableFormation resp_f, String serverUrl) {
		
		/* 
		 * Post traitement 
		 * AspectJ va s'occupe d'envoi d'email au colaborateur inscrit à la session de formation 
		 */
		return "email bien envoyé";
	}
	

}
