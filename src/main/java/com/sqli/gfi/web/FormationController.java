package com.sqli.gfi.web;


import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sqli.gfi.model.Formation;
import com.sqli.gfi.model.ResponsableFormation;
import com.sqli.gfi.service.FormationService;


@Controller
@RequestMapping("/formation/*")
public class FormationController {
	
	@Autowired
	private FormationService formationService;
	
	/**  lister toutes les formations  */
	@RequestMapping(value = "index", method = RequestMethod.GET)
    public String indexAction(Model model) {
		 
        List<Formation> formations = formationService.getAllFormations();
        model.addAttribute("formations", formations); 
        return "index_formation";
    }
	
	/** ajouter  une nouvelle Formation */	
	@RequestMapping(value = "add", method = RequestMethod.GET)
    public String addFormationPage(@ModelAttribute Formation formation) {
    	return "formation_add";
    }
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
    public String addFormation(@Valid @ModelAttribute Formation formation, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {			
			return "formation_add";
		} 
			String titre = formation.getTitre();
			String desc = formation.getDesc();
			ResponsableFormation resp_f_connecte = (ResponsableFormation) session.getAttribute("resp_f_connecte");
		    formationService.addFormation(new Formation(titre, desc, resp_f_connecte));
		    
			return "redirect:index";		 		
    }
	
	/** modifier  une Formation */
	@RequestMapping(value = "update/{idF}", method = RequestMethod.GET)
    public String updateFormationPage(@PathVariable("idF") Integer idF, Model model) {
    	model.addAttribute("formation", formationService.getFormationById(idF));
    	return "formation_update";
    }
	
	@RequestMapping(value = "update/{idF}", method = RequestMethod.POST)
    public String updateFormation(@PathVariable("idF") Integer idF, @Valid @ModelAttribute Formation formation, BindingResult result, Model model,  HttpSession session) {
    	
    	if(result.hasErrors()) {
    		model.addAttribute("formation", formationService.getFormationById(idF));
    		return "formation_update";
    	}
    	
    	String titre = formation.getTitre();
		String desc = formation.getDesc();
		ResponsableFormation resp_f_connecte = (ResponsableFormation) session.getAttribute("resp_f_connecte");
	    formationService.addFormation(new Formation(idF,titre, desc, resp_f_connecte));
    	
    	return "redirect:/formation/index";
    }
	
	/** supprimer  une Formation */
    @RequestMapping(value = "delete/{idF}", method = RequestMethod.GET)
    public String deleteFormation(@PathVariable("idF") Integer idF) {
    	formationService.deleteFormation(idF);
        return "redirect:/formation/index";
    }
	
	
	/******************************************************************************
	this methode handling all reques in case if request is not mapping in this controller 								  
    *******************************************************************************/
    @RequestMapping(method = RequestMethod.GET)
	public String defaultPage() {
		return "defaultPage";
    }
	

}
