package com.sqli.gfi.web;

import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.sqli.gfi.model.Absence;
import com.sqli.gfi.model.Collaborateur;
import com.sqli.gfi.model.CollaborateurSession;
import com.sqli.gfi.model.CollaborateurSessionId;
import com.sqli.gfi.model.Formateur;
import com.sqli.gfi.model.Formation;
import com.sqli.gfi.model.ResponsableFormation;
import com.sqli.gfi.model.SessionF;
import com.sqli.gfi.service.AbsenceService;
import com.sqli.gfi.service.SessionService;
import com.sqli.gfi.service.UtilisateurService;

@Controller
@RequestMapping("/{idFormateur}/absence/*")
public class AbsenceController {
	
	@Autowired
	private SessionService sessionService;
	@Autowired
	private  UtilisateurService utilisateurService;
	@Autowired
	private  AbsenceService absenceService;
	
	/**
	 *  lister les formateur inscrivent à la session de formation 
	 */
	@RequestMapping(value = "index", method = RequestMethod.GET)
    public String indexInscription(@PathVariable("idFormateur") Integer idFormateur, Model model) {
		List<SessionF> list_sessions = sessionService.getAllSessionByFormateur(idFormateur);
        model.addAttribute("sessions", list_sessions); 
                	
        return "index_absence";
    }
	
	/**
	 *  gerer l'absence des collaborateurs 
	 */
	@RequestMapping(value = "/{idS}/manage", method = RequestMethod.GET)
    public String AddCollaborateurPage(@PathVariable("idFormateur") Integer idFormateur, @PathVariable("idS") Integer idS, Model model) {
        model.addAttribute("collaborateurs", utilisateurService.getCollaborateurInscriptionConfirm(idS)); 
        model.addAttribute("absences", absenceService.getAllAbsenceBySession(idS));
        model.addAttribute("idS",idS);
        return "absence_manage";
    }
	
	@RequestMapping(value = "/{idS}/manage", method = RequestMethod.POST)
    public String AddCollaborateur(@PathVariable("idFormateur") Integer idFormateur, @PathVariable("idS") Integer idS,
    		@RequestParam(value="checkBox_coll_abs", required = false) Integer [] checkBox_coll_abs, HttpSession session, Model model) {
       
		 if(checkBox_coll_abs==null) {
			 model.addAttribute("collaborateurs", utilisateurService.getCollaborateurInscriptionConfirm(idS)); 
		     model.addAttribute("absences", absenceService.getAllAbsenceBySession(idS));
		     return "absence_manage";
		 }	
		 /** 
		  * get responsable formation connécté 
		  */
		 Formateur formateur = (Formateur) session.getAttribute("user_connecte");
		 Absence absence = new Absence();
		 Collaborateur collaborateur = new Collaborateur();
		 CollaborateurSession collaborateurSession = new CollaborateurSession();
		 CollaborateurSessionId pk = new CollaborateurSessionId();
		 SessionF sessionf = sessionService.getSessionById(idS);
		 
		 /** 
		  * effectuer l'absence pour chacun de collaborateurs sélectionner par le Formateur  
		  */
		 Integer[] checkBox_collaborateur_abs = checkBox_coll_abs;		 
		 for(Integer id_c : checkBox_collaborateur_abs)
		 {
			 collaborateur = utilisateurService.getCollaborateurById(id_c);
			 absence.setFormateur(formateur);
			 pk.setCollaborateur(collaborateur);
			 pk.setSession(sessionf);
			 collaborateurSession.setPk(pk);
			 absence.setCollaborateurSession(collaborateurSession);
			 absence.setDate_abs(new Date());
			 absenceService.addAbsance(absence);
		 }	 
        return "redirect:/"+idFormateur+"/absence/"+ idS +"/manage";
    }
	/**
	 *  Modifier L'absence d'un collaborateur 
	 */
	@RequestMapping(value = "/{idS}/update/{idAbs}", method = RequestMethod.GET)
    public String updateAbsencePage(@PathVariable("idFormateur") Integer idFormateur, @PathVariable("idS") Integer idS, @PathVariable("idAbs") Integer idAbs, @ModelAttribute Absence absence,  Model model) {
		model.addAttribute("absenceUpdate",absenceService.getAbsenceById(idAbs));
        model.addAttribute("idS",idS);
        return "absence_update";
    }
	
	@RequestMapping(value = "/{idS}/update/{idAbs}", method = RequestMethod.POST)
    public String updateAbsence(@PathVariable("idFormateur") Integer idFormateur, @PathVariable("idS") Integer idS, @PathVariable("idAbs") Integer idAbs,@Valid @ModelAttribute("absence") Absence absence, BindingResult result, Model model) {
		if(absence.getCause().equals("")) {
			
			model.addAttribute("absenceUpdate", absenceService.getAbsenceById(idAbs));
	        model.addAttribute("idS",idS); 
	        model.addAttribute("causeAbsenceError", "veuillez entrer la cause de l'absence");
	        
		     return "absence_update";
		 }	
		
		Absence abs_update = absenceService.getAbsenceById(idAbs);
		abs_update.setCause(absence.getCause());
		absenceService.addAbsance(abs_update);
		
		return "redirect:/"+idFormateur+"/absence/"+ idS +"/manage";
    }
	
	
	
	
	 /** 
	  * supprimer  l'absence d'un collaborateur  
	  */
    @RequestMapping(value = "/{idS}/delete/{idAbs}", method = RequestMethod.GET)
    public String deleteProfleAction(@PathVariable("idFormateur") Integer idFormateur, @PathVariable("idS") Integer idS, @PathVariable("idAbs") Integer idAbs) {
        absenceService.deleteAbsence(idAbs);
        return "redirect:/"+idFormateur+"/absence/"+ idS +"/manage";
    }
	

}
