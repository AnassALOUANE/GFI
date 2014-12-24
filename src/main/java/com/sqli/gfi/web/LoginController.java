package com.sqli.gfi.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	private Log log = LogFactory.getLog(this.getClass());
	
	@RequestMapping("login")
	 public String getLoginForm(
	 @RequestParam(required = false) String authfailed, String logout, String denied, Model model) {
		  String message = "";
		  if (authfailed != null) {
		   message = "login et mot de passe est incorrect.veuillez ressayer !";
		  } if (logout != null) {
		   message = "déconnexion avec succés , s'authentifier à nouveau pour continue !";
		  } if (denied != null) {
		   message = "vous n'avez pas la permission pour continue !";
		  }
		  
		  model.addAttribute("message", message);
	  return "login";
	 }

	 @RequestMapping("403")
	 public String ge403denied() {
	  return "redirect:/login?denied";
//	  return "403";
	 }
	 
	 /******************************************************************************
		this methode handling all reques in case if request is not mapping in this controller 								  
	    *******************************************************************************/
	    @RequestMapping(method = RequestMethod.GET)
		public String defaultPage() {
			return "defaultPage";
	    }

}
