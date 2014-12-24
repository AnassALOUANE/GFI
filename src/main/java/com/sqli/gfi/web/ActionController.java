package com.sqli.gfi.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sqli.gfi.model.Action;
import com.sqli.gfi.model.Profile;
import com.sqli.gfi.service.ActionService;
import com.sqli.gfi.service.ProfileService;


@Controller
@RequestMapping("/action/*")
public class ActionController {
	
	@Autowired
	private ActionService actionService;
	@Autowired
	private ProfileService profileService;
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
    public String indexAction(Model model) {
        List<Action> actions = actionService.getAllAction();
        model.addAttribute("actions", actions); 
        return "index_action";
    }
	
	@ModelAttribute("profile")
	public List<Profile> profileList(){
	    List<Profile> selectItems = new ArrayList<Profile>();
	    List<Profile> profileList = profileService.getAllProfiles();
	    for (Profile pf : profileList) {
	    	selectItems.add(new Profile(pf.getId_profile(),pf.getTitre()));
	    }
	    return selectItems;
	}
	
	/** assigner Profles à des actions */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String assignerProfleActionPage(@ModelAttribute Action action, Model model) {
    	model.addAttribute("actions",actionService.getAllActionLibelle());
    	model.addAttribute("profiles",profileList()); 
    	return "action_add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String assignerProfleAction(@ModelAttribute Action ac, @Valid Action action, BindingResult result, Model model) {
    	if (result.hasErrors()) {
    		model.addAttribute("actions",actionService.getAllActionLibelle());
        	model.addAttribute("profiles",profileList());
			return "action_add";
		} else {
			Integer id_profile = Integer.parseInt(ac.getProfile().getTitre());
			ac.getProfile().setId_profile(id_profile);
			System.out.println(ac);
			actionService.addAction(ac);
	        return "redirect:index";
		}		
    }
    
    /** modifier l'action d'un profile  */
    @RequestMapping(value = "update/{idA}", method = RequestMethod.GET)
    public String updateProfleActionPage(@PathVariable("idA") Integer idA, Model model) {
        Action action = actionService.getActionById(idA);
        model.addAttribute("action", action);
        model.addAttribute("actions",actionService.getAllActionLibelle());
    	model.addAttribute("profiles",profileList());
        return "action_update";
    }

    @RequestMapping(value = "update/{idA}", method = RequestMethod.POST)
    public String  updateProfleAction(@ModelAttribute("action") Action ac, @PathVariable("idA") Integer idA, Model model, @Valid Action action, BindingResult result) {
    	if (result.hasErrors()) {
    		action.setId_action(idA);;
    		model.addAttribute("action", action);
    		model.addAttribute("actions",actionService.getAllActionLibelle());
        	model.addAttribute("profiles",profileList());
			return "action_update";
		} else {
			Integer id_profile = Integer.parseInt(ac.getProfile().getTitre());
			ac.getProfile().setId_profile(id_profile);
			ac.setId_action(idA);
	    	actionService.addAction(ac);
			return "redirect:/action/index";
		}
    }
    
    /** supprimer  un Action */
    @RequestMapping(value = "delete/{idA}", method = RequestMethod.GET)
    public String deleteProfleAction(@PathVariable("idA") Integer idA) {
        actionService.deleteAction(idA);
        return "redirect:/action/index";
    }
    
    
    /******************************************************************************
	this methode handling all reques in case if request is not mapping in controller 								  
    *******************************************************************************/
    @RequestMapping(method = RequestMethod.GET)
	public String defaultPage() {
		return "defaultPage";
    }

}
