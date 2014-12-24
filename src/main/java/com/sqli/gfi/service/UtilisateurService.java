/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqli.gfi.service;

import com.sqli.gfi.model.Collaborateur;
import com.sqli.gfi.model.Formateur;
import com.sqli.gfi.model.ResponsableFormation;
import com.sqli.gfi.model.Utilisateur;

import java.util.List;

/**
 *
 * @author karim
 */
public interface UtilisateurService {
    
	public void updateUtilisateurCompte(Utilisateur u_compte);
    public void addCollaborateur(Collaborateur c);
    public void addFormateur(Formateur f);
    public void addResponsableFormation(ResponsableFormation resp_f);
    
    public List<Utilisateur> getAllUtilisateur();
    public List<Collaborateur> getAllCollaborateurs();
    public List<Collaborateur> getAllCollaborateursNotInscribeSession(int idS);
    public List<Collaborateur> getCollaborateurInscriptionConfirm(int idS);
    public List<Formateur> getAllFormateurs();
    public List<ResponsableFormation> getAllResponsableFormation();

    public Utilisateur getUtilisateurById(int idU);
    public Utilisateur getUtilisateurByIdCompte(int idCompte);
    public Collaborateur getCollaborateurById(int idC);
    public Formateur getFormateurById(int idF);
    public ResponsableFormation getResponsableFormationById(int idResp_f);

    public void deleteCollaborateur(int idC);
    public void deleteFormateur(int idF);
    public void deleteResponsableFormation(int idResp_f);
}
