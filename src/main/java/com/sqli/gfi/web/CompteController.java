package com.sqli.gfi.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sqli.gfi.model.Compte;
import com.sqli.gfi.model.Utilisateur;
import com.sqli.gfi.service.CompteService;
import com.sqli.gfi.service.MailSenderService;
import com.sqli.gfi.service.UtilisateurService;

@Controller
@RequestMapping("/compte/*")
public class CompteController {
	
	@Autowired
	private CompteService compteService;
	@Autowired
	private MailSenderService  mailSenderService;
	@Autowired
	private UtilisateurService utilisateurService;

	@RequestMapping(value = "index", method = RequestMethod.GET)
    public String indexAction(Model model) {
        List<Compte> comptes = compteService.getAllCompte();
        model.addAttribute("comptes", comptes); 
        return "index_compte";
    }
	
	 /* ajouter un nouveau COMPTE */
	@ModelAttribute("hutilisateur")
	public List<Utilisateur> UtilisateursList(){
		List<Utilisateur> selectItems = new ArrayList<Utilisateur>();
	    List<Utilisateur> userList = utilisateurService.getAllUtilisateur();
	    for (Utilisateur u : userList) {
	    	selectItems.add(new Utilisateur(u.getId_u(), u.getNom(), u.getPrenom(), null, null, null, null, null));
	    }
	    return selectItems;
	}
	@ModelAttribute("compte")
	public Compte populateCompte(){
	    return new Compte("","",true);
	}
	
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addComptePage(@ModelAttribute Compte compte, Model model) {
    	model.addAttribute("utilisateurs", UtilisateursList());
    	return "compte_add";
    }
    
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addCompte(@Valid @ModelAttribute Compte compte, BindingResult result,  Model model) {
		if (result.hasErrors()) {			
			model.addAttribute("utilisateurs", UtilisateursList());
			return "compte_add";
		} 
			String login = compte.getLogin();
			String password = compte.getPassword();
			Boolean active = compte.getActive();
			Integer id_u = compte.getUtilisateur().getId_u();
			
			PasswordEncoder encoder = new Md5PasswordEncoder();
		    String hashedPassword = encoder.encodePassword(password, null);
		    		    
			Utilisateur ut_compte = utilisateurService.getUtilisateurById(id_u);
			compte.setPassword(hashedPassword);
			Compte nouveau_comte = new Compte(login, hashedPassword, active);
			ut_compte.setCompte(nouveau_comte);
			utilisateurService.updateUtilisateurCompte(ut_compte);
			
			/** envoyer le login et mot de passe au utilisateur */			
			mailSenderService.sendPassword(ut_compte.getEmail(), login, password, active);
			
			return "redirect:index";		 		
    }
    
    @RequestMapping(value = "update/{idCompte}", method = RequestMethod.GET)
    public String updateComptePage(@PathVariable("idCompte") Integer idCompte, Model model) {
    	model.addAttribute("compte", compteService.getCompteById(idCompte));
    	return "compte_update";
    }
    
    @RequestMapping(value = "update/{idCompte}", method = RequestMethod.POST)
    public String updateCompte(@PathVariable("idCompte") Integer idCompte, @Valid @ModelAttribute Compte compte, BindingResult result, Model model) {
    	
    	if(result.hasErrors()) {
    		model.addAttribute("compte", compteService.getCompteById(idCompte));
    		return "compte_update";
    	}
    	
    	String password = compte.getPassword();
    	PasswordEncoder encoder = new Md5PasswordEncoder();
	    String hashedPassword = encoder.encodePassword(password, null);
	    
	    compte.setId_compte(idCompte);
	    compte.setPassword(hashedPassword);
	    compteService.updateCompte(compte);
	    
	    /* envoyer le login et mot de passe au utilisateur */	
	    Utilisateur u = utilisateurService.getUtilisateurByIdCompte(idCompte);
		mailSenderService.sendUpdatePassword(u.getEmail(), compte.getLogin(), password, compte.getActive());
    	return "redirect:/compte/index";
    }
    
    /* supprimer  un Compte */
    @RequestMapping(value = "delete/{idCompte}", method = RequestMethod.GET)
    public String deleteCompte(@PathVariable("idCompte") Integer idCompte) {
    	Utilisateur u = utilisateurService.getUtilisateurByIdCompte(idCompte);
    	u.setCompte(null);
    	utilisateurService.updateUtilisateurCompte(u);
    	compteService.deleteCompte(idCompte);
        return "redirect:/compte/index";
    }
    
    /******************************************************************************
	this methode handling all reques in case if request is not mapping in this controller 								  
    *******************************************************************************/
    @RequestMapping(method = RequestMethod.GET)
	public String defaultPage() {
		return "defaultPage";
    }
    
    
    
    
    
}
