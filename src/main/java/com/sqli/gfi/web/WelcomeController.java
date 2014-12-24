/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqli.gfi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sqli.gfi.service.UtilisateurService;

/**
 *
 * @author karim
 */
@Controller
@RequestMapping("/welcome/*")
public class WelcomeController {
    @Autowired 
    private UtilisateurService utilisateurService;
    
    @RequestMapping(value = "/index", method =RequestMethod.GET)
    public String welcome(Model model) {
//        Collaborateur col = new Collaborateur("dahdouh", "karim", "adresse karim", "karim.dahdoh@gmail.com", "06666666666");
//        ResponsableFormation res = new ResponsableFormation("anass", "alouane", "adresse de anass", "anass.alouane@gmail.com", "065555555555");
//        Administrateur admin = new Administrateur("yassine", "akasbi", "adress admin", "admin_yassine@yahoo.fr", "05673827632");
//        Formateur f = new Formateur("yassine", "akasbi", "adress admin", "admin_yassine@yahoo.fr", "05673827632","Bac+5","Debutant");
//        if(1==1)
//            throw new RuntimeException();
//        Formateur f = (Formateur) utilisateurService.getUserById(5);
//        f.setExperience("5 ans d'expérience formateur jee");
//        utilisateurService.addUser(f);
//        model.addAttribute("user", "everybody");
//        model.addAttribute("utilisateurs", utilisateurService.getAllUsers());
        return "index_welcome";
    }
    
    @RequestMapping(value="/anonymous",method =RequestMethod.GET)
    public String AnonymousPage(Model model) {
        return "ROLE_anonymous";
    }
    @RequestMapping
    public String DefaultPage(Model model) {
        return "ROLE_anonymous";
    }
    
}
