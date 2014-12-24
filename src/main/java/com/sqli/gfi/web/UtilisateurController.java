/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqli.gfi.web;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sqli.gfi.model.Collaborateur;
import com.sqli.gfi.model.Formateur;
import com.sqli.gfi.model.Profile;
import com.sqli.gfi.model.ResponsableFormation;
import com.sqli.gfi.service.UtilisateurService;

/**
 *
 * @author karim
 */
@Controller
@RequestMapping("/users/**/*")
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;
    
    /****************************************************************************************
	l'ensembles de méthodes traitent les requetes ayant pour but de gérer les collaborateurs 								  
    *****************************************************************************************/
    
    @RequestMapping(value = "c/index", method = RequestMethod.GET)
    public String indexCollaborateur(Model model) {
        List<Collaborateur> collaborateurs = utilisateurService.getAllCollaborateurs();
        model.addAttribute("collaborateurs", collaborateurs);
        return "index_c";
    }
    @ModelAttribute("collaborateur")
    public Collaborateur populateCollaborateur() {
    	Collaborateur collaborateur = new Collaborateur();
    	Profile p = new Profile();
    	p.setId_profile(3);
    	p.setTitre("collaborateur");
    	collaborateur.setProfile(p);
      return collaborateur;
    }
    
     /* ajouter un nouveau COLLABORATEUR */
    @RequestMapping(value = "c/add", method = RequestMethod.GET)
    public String addCollaborateurPage(@ModelAttribute Collaborateur collaborateur) {
    	return "collaborateur_add";
    }

    @RequestMapping(value = "c/add", method = RequestMethod.POST)
    public String addCollaborateur(@ModelAttribute("collaborateur") Collaborateur c, @Valid Collaborateur collaborateur, BindingResult result) {
    	if (result.hasErrors()) {
			return "collaborateur_add";
		} else {
			utilisateurService.addCollaborateur(c);
	        return "redirect:users/c/index";
		}		
    }
    /* modifier un COLLABORATEUR */
    @RequestMapping(value = "c/update/{idC}", method = RequestMethod.GET)
    public String updateCollaborateurPage(@PathVariable("idC") Integer idC, Model model) {
        Collaborateur c = utilisateurService.getCollaborateurById(idC);
        model.addAttribute("collaborateur", c);
        return "collaborateur_update";
    }

    @RequestMapping(value = "c/update/{idC}", method = RequestMethod.POST)
    public String updateCollaborateur(@ModelAttribute("collaborateur") Collaborateur c, @PathVariable("idC") Integer idC, Model model, @Valid Collaborateur collaborateur, BindingResult result) {
        
    	if (result.hasErrors()) {
    		collaborateur.setId_u(idC);
            model.addAttribute("collaborateur", collaborateur);
			return "collaborateur_update";
		} else {
			c.setId_u(idC);
	    	utilisateurService.addCollaborateur(c);
	        return "redirect:/users/c/index";
		}
    }
    /* supprimer un COLLABORATEUR */
    @RequestMapping(value = "c/delete/{idC}", method = RequestMethod.GET)
    public String deleteCollaborateur(@PathVariable("idC") Integer idC) {
        utilisateurService.deleteCollaborateur(idC);
        return "redirect:users/c/index";
    }
    
    /************************************************************************************
	l'ensembles de méthodes traitent les requetes ayant pour but de gérer les formateurs 								  
    *************************************************************************************/
    @RequestMapping(value = "f/index", method = RequestMethod.GET)
    public String indexFormateur(Model model) {
        List<Formateur> formateurs = utilisateurService.getAllFormateurs();
        model.addAttribute("formateurs", formateurs);
        return "index_f";
    }
    
    @ModelAttribute("formateur")
    public Formateur populateFormateur() {
    	Formateur formateur = new Formateur();
    	Profile p = new Profile();
    	p.setId_profile(4);
    	p.setTitre("fomateur");
    	formateur.setProfile(p);
      return formateur;
    }
    private Map<String,String>  niveau_etude() {
    	Map<String,String> niveau_e_map = new LinkedHashMap<String,String>();
    	niveau_e_map.put("bac+2", "bac+2");
    	niveau_e_map.put("bac+3", "bac+3");
    	niveau_e_map.put("bac+4", "bac+4");
    	niveau_e_map.put("bac+5", "bac+5");
    	niveau_e_map.put("bac+8", "bac+8");
    	return niveau_e_map;
    }
    
    /* ajouter un nouveau FORMATEUR */
    @RequestMapping(value = "f/add", method = RequestMethod.GET)
    public String addFormateurPage(@ModelAttribute("formateur") Formateur formateur, Model model) {	
    	model.addAttribute("niveau_etudeList",niveau_etude());
    	return "formateur_add";
    }

    @RequestMapping(value = "f/add", method = RequestMethod.POST)
    public String addFormateur(@ModelAttribute("formateur") Formateur f, @Valid Formateur formateur, BindingResult result, Model model) {
    	if (result.hasErrors()) {
    		model.addAttribute("niveau_etudeList",niveau_etude());
			return "formateur_add";
		} else {
			utilisateurService.addFormateur(f);
	        return "redirect:users/f/index";
		}		
    }
    
    /* modifier un FORMATEUR  */
    @RequestMapping(value = "f/update/{idF}", method = RequestMethod.GET)
    public String updateFormateurPage(@PathVariable("idF") Integer idF, Model model) {
        Formateur f = utilisateurService.getFormateurById(idF);
        model.addAttribute("formateur", f);
        model.addAttribute("niveau_etudeList",niveau_etude());
        return "formateur_update";
    }

    @RequestMapping(value = "f/update/{idF}", method = RequestMethod.POST)
    public String updateFormateur(@ModelAttribute("formateur") Formateur f, @PathVariable("idF") Integer idF, Model model, @Valid Formateur formateur, BindingResult result) {
    	if (result.hasErrors()) {
    		formateur.setId_u(idF);
            model.addAttribute("formateur", formateur);
            model.addAttribute("niveau_etudeList",niveau_etude());
			return "formateur_update";
		} else {
			f.setId_u(idF);
	    	utilisateurService.addFormateur(f);;
	        return "redirect:/users/f/index";
		}
    }
    
    /* supprimer un FORMATEUR */
    @RequestMapping(value = "f/delete/{idF}", method = RequestMethod.GET)
    public String deleteFormateur(@PathVariable("idF") Integer idF) {
        utilisateurService.deleteFormateur(idF);
        return "redirect:users/f/index";
    }
    
    /*************************************************************************************************
	l'ensembles de méthodes traitent les requetes ayant pour but de gérer les responsable de formation 								  
    **************************************************************************************************/
    
    @RequestMapping(value = "resp_f/index", method = RequestMethod.GET)
    public String indexResponsableFormation(Model model) {
        List<ResponsableFormation> responsablesformations = utilisateurService.getAllResponsableFormation();
        model.addAttribute("responsablesformations", responsablesformations);
        return "index_resp_f";
    }
    
    @ModelAttribute("responsableformation")
    public ResponsableFormation populateResponsableFormation() {
    	ResponsableFormation resp_f = new ResponsableFormation();
    	Profile p = new Profile();
    	p.setId_profile(2);
    	p.setTitre("responsable formation");
    	resp_f.setProfile(p);
      return resp_f;
    }
    
    /* ajouter un nouveau RESPONSABLE DE FORMATION */
    @RequestMapping(value = "resp_f/add", method = RequestMethod.GET)
    public String addResponsableFormationPage(@ModelAttribute("responsableformation") ResponsableFormation resp_f) {	
    	return "resp_f_add";
    }

    @RequestMapping(value = "resp_f/add", method = RequestMethod.POST)
    public String addResponsableFormation(@ModelAttribute("responsableformation") ResponsableFormation resp_f, @Valid ResponsableFormation responsableFormation, BindingResult result) {
    	if (result.hasErrors()) {
			return "resp_f_add";
		} else {
			utilisateurService.addResponsableFormation(resp_f);;
	        return "redirect:users/resp_f/index";
		}		
    }
    
    /* modifier un RESPONSABLE DE FORMATION */
    @RequestMapping(value = "resp_f/update/{idResp_f}", method = RequestMethod.GET)
    public String updateResponsableFormationPage(@PathVariable("idResp_f") Integer idResp_f, Model model) {
        ResponsableFormation resp_f = utilisateurService.getResponsableFormationById(idResp_f);
        model.addAttribute("responsableformation", resp_f);
        return "resp_f_update";
    }

    @RequestMapping(value = "resp_f/update/{idResp_f}", method = RequestMethod.POST)
    public String updateResponsableFormation(@ModelAttribute("responsableformation") ResponsableFormation resp_f, @PathVariable("idResp_f") Integer idResp_f, Model model, @Valid ResponsableFormation responsableformation, BindingResult result) {
        
    	if (result.hasErrors()) {
    		responsableformation.setId_u(idResp_f);
            model.addAttribute("responsableformation", responsableformation);
			return "resp_f_update";
		} else {
			resp_f.setId_u(idResp_f);
	    	utilisateurService.addResponsableFormation(resp_f);;
	        return "redirect:/users/resp_f/index";
		}
    }
    
    /* supprimer  un RESPONSABLE DE FORMATION */
    @RequestMapping(value = "resp_f/delete/{idResp_f}", method = RequestMethod.GET)
    public String deleteResponsableFormation(@PathVariable("idResp_f") Integer idResp_f) {
        utilisateurService.deleteResponsableFormation(idResp_f);;
        return "redirect:users/resp_f/index";
    }
    
    
    /******************************************************************************
	this methode handling all reques in case if request is not mapping in controller 								  
    *******************************************************************************/
    @RequestMapping(method = RequestMethod.GET)
	public String defaultPage() {
		return "defaultPage";
    }
    
    
}
