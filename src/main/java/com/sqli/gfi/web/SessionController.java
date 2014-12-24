package com.sqli.gfi.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sqli.gfi.model.Formateur;
import com.sqli.gfi.model.Formation;
import com.sqli.gfi.model.SessionF;
import com.sqli.gfi.service.FormationService;
import com.sqli.gfi.service.SessionService;
import com.sqli.gfi.service.UtilisateurService;

@Controller
@RequestMapping("/{idF}/session/*")
public class SessionController {

	@Autowired
	private SessionService sessionService;
	
	@Autowired
	private FormationService formationService;
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	/** la liste de sessions d'une formation */
	@RequestMapping(value = "index", method = RequestMethod.GET)
    public String indexEtape(@PathVariable("idF") Integer idF,@ModelAttribute("sessionf") SessionF sessionf, Model model) {
        Formation formation = formationService.getFormationById(idF);
        model.addAttribute("formation", formation); 
        model.addAttribute("formateurs", utilisateurService.getAllFormateurs()); 
        return "index_session";
    }
	
	/** Créer une session de formation */
	@RequestMapping(value = "add", method = RequestMethod.POST)
    public String addEtape(@PathVariable("idF") Integer idF,@Valid @ModelAttribute("sessionf") SessionF sessionf,  BindingResult result, Model model) {
		 if(result.hasErrors()) {
			 Formation formation = formationService.getFormationById(idF);
		     model.addAttribute("formation", formation); 
		     model.addAttribute("formateurs", utilisateurService.getAllFormateurs()); 
		     return "index_session";
		 }		 
		 
		 sessionf.setDate_debut(sessionf.getDate_debut());
		 sessionf.setDate_fin(sessionf.getDate_fin());
		 /** affectation d'un formateur à la session*/
		 Integer id_formateur = sessionf.getFormateur().getId_u();
		 Formateur formateur = utilisateurService.getFormateurById(id_formateur);
		 sessionf.setFormateur(formateur);
		 
		 Formation formation =  formationService.getFormationById(idF);
		 sessionf.setFormation(formation);
		 sessionService.addSession(sessionf);
        return "redirect:index";
    }
	
	/** modifier une session de formation */
	@RequestMapping(value = "update/{idS}", method = RequestMethod.GET)
    public String updateEtapePage(@PathVariable("idS") Integer idS, Model model) {
		model.addAttribute("sessionf", sessionService.getSessionById(idS));
		model.addAttribute("formateurs", utilisateurService.getAllFormateurs()); 
    	return "session_update";
    }
	
	@RequestMapping(value = "update/{idS}", method = RequestMethod.POST)
    public String updateEtape(@PathVariable("idF") Integer idF, @PathVariable("idS") Integer idS, @Valid @ModelAttribute("sessionf") SessionF sessionf, BindingResult result, Model model) {
    	if(result.hasErrors()) {
    		model.addAttribute("sessionf", sessionService.getSessionById(idS));
    		model.addAttribute("formateurs", utilisateurService.getAllFormateurs());
    		return "session_update";	
    	}
		
    	sessionf.setId_session(idS);
    	sessionf.setDate_debut(sessionf.getDate_debut());
		sessionf.setDate_fin(sessionf.getDate_fin());
		
		Integer id_formateur = sessionf.getFormateur().getId_u();
		Formateur formateur = utilisateurService.getFormateurById(id_formateur);
		sessionf.setFormateur(formateur);
		/** affectation d'un formateur à la session*/
    	Formation form =  formationService.getFormationById(idF);
		sessionf.setFormation(form);
		
		sessionService.addSession(sessionf);
    	
    	return "redirect:/"+idF+"/session/index";
    }
	
	/** supprimer une session de formation */
    @RequestMapping(value = "delete/{idS}", method = RequestMethod.GET)
    public String deleteEtape(@PathVariable("idF") Integer idF, @PathVariable("idS") Integer idS) {
    	sessionService.deleteSession(idS);
    	return "redirect:/"+idF+"/session/index";
    }
	
	
	
}
