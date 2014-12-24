package com.sqli.gfi.web;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.org.eclipse.jdt.core.compiler.IScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sqli.gfi.model.Collaborateur;
import com.sqli.gfi.model.CollaborateurSession;
import com.sqli.gfi.model.CollaborateurSessionId;
import com.sqli.gfi.model.Inscription;
import com.sqli.gfi.service.InscriptionService;
import com.sqli.gfi.service.UtilisateurService;

@Controller
@RequestMapping("/{idInsc}/confirmation_insc/{idC}/*")
public class ConfirmationInscription {

	@Autowired
	private InscriptionService inscriptionService;
	@Autowired
	private UtilisateurService utilisateurService;
	
	/** confirmation d'inscription d'un collaborateur*/
	@RequestMapping(value = "confirm", method = RequestMethod.GET)
    public String confirm(@PathVariable("idInsc") Integer idInsc, @PathVariable("idC") Integer idC, Model model) {
		Inscription insc = inscriptionService.getInscriptionById(idInsc);
		insc.setConfirmer(true);
		inscriptionService.inscrire(insc);
        /** entregistrer le collaborateur aprés confirmation par email dans la table CollaborateurSession  */
        CollaborateurSession collaborateur_session = new CollaborateurSession(new CollaborateurSessionId(insc.getCollaborateur(), insc.getSession()));
        inscriptionService.inscrirevalid(collaborateur_session);
        
        model.addAttribute("collaborateur", insc.getCollaborateur()); 
        model.addAttribute("msg_confirm"," votre inscription bien confirmer, merci");
        
        return "index_confirmation";
    }
	
	/** confirmation d'inscription d'un collaborateur*/
	@RequestMapping(value = "cancel", method = RequestMethod.GET)
    public String cancel(@PathVariable("idInsc") Integer idInsc, @PathVariable("idC") Integer idC, Model model) {
		Inscription insc = inscriptionService.getInscriptionById(idInsc);
		insc.setConfirmer(false);
		inscriptionService.inscrire(insc);
		model.addAttribute("collaborateur", utilisateurService.getCollaborateurById(idC)); 
        model.addAttribute("msg_confirm","votre inscription est annulé");
        return "index_confirmation";
    }
	
}
