package com.sqli.gfi.web;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sqli.gfi.model.Etape;
import com.sqli.gfi.model.Formation;
import com.sqli.gfi.service.EtapeService;
import com.sqli.gfi.service.FormationService;

@Controller
@RequestMapping("/{idF}/etape/*")
public class EtapeController {
	
	@Autowired
	private FormationService formationService;
	
	@Autowired
	private EtapeService etapeService;
	
	/** liste les  étapes d'une formation donnée */
	@RequestMapping(value = "index", method = RequestMethod.GET)
    public String indexEtape(@PathVariable("idF") Integer idF,@ModelAttribute Etape etape, Model model) {
		 
        Formation formation = formationService.getFormationById(idF);
        model.addAttribute("formation", formation); 
        return "index_etape";
    }
	
	/** ajouter une etape de formation */
	@RequestMapping(value = "add", method = RequestMethod.POST)
    public String addEtape(@PathVariable("idF") Integer idF,@Valid @ModelAttribute Etape etape,  BindingResult result, Model model) {
		 if(result.hasErrors()) {
			 Formation formation = formationService.getFormationById(idF);
		     model.addAttribute("formation", formation);
			 return "index_etape";
		 }
		 
		 Formation form =  formationService.getFormationById(idF);
		 etape.setFormation(form);
		 etapeService.addEtape(etape);
        return "redirect:index";
    }
	/** modifier une etape de formation */
	@RequestMapping(value = "update/{idE}", method = RequestMethod.GET)
    public String updateEtapePage(@PathVariable("idE") Integer idE, Model model) {
		model.addAttribute("etape", etapeService.getEtapeById(idE));
    	return "etape_update";
    }
	
	@RequestMapping(value = "update/{idE}", method = RequestMethod.POST)
    public String updateEtape(@Valid @ModelAttribute Etape etape,BindingResult result, @PathVariable("idF") Integer idF, @PathVariable("idE") Integer idE, Model model) {
    	if(result.hasErrors()) {
    		model.addAttribute("etape", etapeService.getEtapeById(idE));
    		return "etape_update";	
    	}
    	etape.setId_etape(idE);
    	Formation form =  formationService.getFormationById(idF);
		etape.setFormation(form);
    	etapeService.addEtape(etape);
    	
    	return "redirect:/"+idF+"/etape/index";
    }
	
	/** supprimer  une etape de formation */
    @RequestMapping(value = "delete/{idE}", method = RequestMethod.GET)
    public String deleteEtape(@PathVariable("idF") Integer idF, @PathVariable("idE") Integer idE) {
    	etapeService.deleteEtape(idE);
    	return "redirect:/"+idF+"/etape/index";
    }

}
