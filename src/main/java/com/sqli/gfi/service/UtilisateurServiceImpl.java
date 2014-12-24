/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqli.gfi.service;

import com.sqli.gfi.dao.UtilisateurDao;
import com.sqli.gfi.model.Collaborateur;
import com.sqli.gfi.model.Formateur;
import com.sqli.gfi.model.ResponsableFormation;
import com.sqli.gfi.model.Utilisateur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author karim
 */
@Service
@Transactional
public class UtilisateurServiceImpl implements UtilisateurService{

    @Autowired 
    private UtilisateurDao utilisateurDao;
    
     
	public void updateUtilisateurCompte(Utilisateur u_compte) {
		utilisateurDao.updateUtilisateurCompte(u_compte);
	}
    
     
    public void addCollaborateur(Collaborateur c) {
        utilisateurDao.addCollaborateur(c);
    }
    
     
	public void addFormateur(Formateur f) {
		utilisateurDao.addFormateur(f);	
	}
     
	public void addResponsableFormation(ResponsableFormation resp_f) {
		utilisateurDao.addResponsableFormation(resp_f);		
	}
   
     
    @Transactional(readOnly = true)
	public List<Utilisateur> getAllUtilisateur() {
		return utilisateurDao.getAllUtilisateur();
	}
    
     
    @Transactional(readOnly = true)
    public List<Collaborateur> getAllCollaborateurs() {
        return utilisateurDao.getAllCollaborateurs();
    }
    
     
    @Transactional(readOnly = true)
	public List<Collaborateur> getAllCollaborateursNotInscribeSession(int idS) {
		return utilisateurDao.getAllCollaborateursNotInscribeSession(idS);
	}
    
     
	public List<Collaborateur> getCollaborateurInscriptionConfirm(int idS) {
		return utilisateurDao.getCollaborateurInscriptionConfirm(idS);
	}
    
     
    @Transactional(readOnly = true)
	public List<Formateur> getAllFormateurs() {
		return utilisateurDao.getAllFormateurs();
	}
    
     
    @Transactional(readOnly = true)
	public List<ResponsableFormation> getAllResponsableFormation() {
		return utilisateurDao.getAllResponsableFormation();
	}
    
     
    @Transactional(readOnly = true)
	public Utilisateur getUtilisateurById(int idU) {
		return utilisateurDao.getUtilisateurById(idU);
	}
    
     
    @Transactional(readOnly = true)
	public Utilisateur getUtilisateurByIdCompte(int idCompte) {
		return utilisateurDao.getUtilisateurByIdCompte(idCompte);
	}
    
     
    @Transactional(readOnly = true)
    public Collaborateur getCollaborateurById(int idC) {
        return utilisateurDao.getCollaborateurById(idC);
    }
    
     
    @Transactional(readOnly = true)
	public Formateur getFormateurById(int idF) {
		return utilisateurDao.getFormateurById(idF);
	}
    
     
    @Transactional(readOnly = true)
	public ResponsableFormation getResponsableFormationById(int idResp_f) {
		return utilisateurDao.getResponsableFormationById(idResp_f);
	}

     
    public void deleteCollaborateur(int idC) {
        utilisateurDao.deleteCollaborateur(idC);
    }
    
     
	public void deleteFormateur(int idF) {
		utilisateurDao.deleteFormateur(idF);
	}

	 
	public void deleteResponsableFormation(int idResp_f) {
		utilisateurDao.deleteResponsableFormation(idResp_f);
	}
       
}
