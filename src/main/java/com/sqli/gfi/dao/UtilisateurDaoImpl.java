/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqli.gfi.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sqli.gfi.model.Collaborateur;
import com.sqli.gfi.model.Formateur;
import com.sqli.gfi.model.ResponsableFormation;
import com.sqli.gfi.model.Utilisateur;

/**
 *
 * @author karim and Anass
 */
@Repository
public class UtilisateurDaoImpl implements UtilisateurDao {
    
    @PersistenceContext 
    private EntityManager em;
 
     
	public void updateUtilisateurCompte(Utilisateur u_compte) {
		em.merge(u_compte);
		em.flush();
	}
    
     
    public void addCollaborateur(Collaborateur c) {
        em.merge(c);
        em.flush();
    }
    
     
	public void addFormateur(Formateur f) {
		em.merge(f);
		em.flush();
	}
    
     
	public void addResponsableFormation(ResponsableFormation resp_f) {
		em.merge(resp_f);
		em.flush();
	}
    
     
	public List<Utilisateur> getAllUtilisateur() {
    	Query query = em.createQuery("SELECT u FROM Utilisateur AS u WHERE u.compte.id_compte IS NULL ORDER BY u.nom");
        return query.getResultList(); 
	}
    
     
    public List<Collaborateur> getAllCollaborateurs() {
        Query query = em.createQuery("select c from Collaborateur as c ORDER BY c.nom");
        return query.getResultList(); 
    }
    
     
	public List<Collaborateur> getAllCollaborateursNotInscribeSession(int idS) {
		
    	Query query = em.createQuery("SELECT insc.collaborateur.id_u FROM Inscription insc WHERE insc.session.id_session=:idSession");
    	query.setParameter("idSession", idS);
    	List<Integer> list_collaborateurs_inscrit = query.getResultList();
    	
    	List<Collaborateur> list_collaborateurs = new ArrayList<Collaborateur>();
    	if(!list_collaborateurs_inscrit.isEmpty()) {
	    	Query q = em.createQuery("SELECT c FROM Collaborateur c WHERE c.id_u NOT IN (:list_collaborateurs_inscrit)");
	    	q.setParameter("list_collaborateurs_inscrit", list_collaborateurs_inscrit);
	    	list_collaborateurs = q.getResultList();
    	} else {
    		list_collaborateurs = getAllCollaborateurs();
    	}
    	
       return list_collaborateurs;
	}

     
	public List<Collaborateur> getCollaborateurInscriptionConfirm(int idS) {
/**    	
    	Query query = em.createQuery("SELECT insc_confirm.pk.collaborateur FROM CollaborateurSession insc_confirm WHERE insc_confirm.pk.session.id_session=:idSession");
    	query.setParameter("idSession", idS);
    	List<Collaborateur> list_collaborateurs_absent = query.getResultList();
*/   	
    	/** recuperer la liste des collaborateurs enregistrer comme absent aujourd'hui*/
    	Query query = em.createQuery("SELECT abs.collaborateurSession.pk.collaborateur.id_u FROM Absence abs WHERE abs.date_abs like CONCAT(CURDATE(),'%')");
    	List<Integer> list_collaborateurs_absent = query.getResultList();
    	
    	/** recuperer la liste des collaborateurs dont leurs absences pas encore effectue*/
    	List<Collaborateur> list_abs_current = new ArrayList<Collaborateur>();
    	if(!list_collaborateurs_absent.isEmpty()) {
    		Query q1 = em.createQuery("SELECT insc_confirm.pk.collaborateur FROM CollaborateurSession insc_confirm WHERE insc_confirm.pk.session.id_session=:idSession AND insc_confirm.pk.collaborateur.id_u NOT IN (:list_collaborateurs_absent)");
    		q1.setParameter("idSession", idS);
    		q1.setParameter("list_collaborateurs_absent", list_collaborateurs_absent);
	    	list_abs_current = q1.getResultList();
    	} else {
    		 Query q2 = em.createQuery("SELECT insc_confirm.pk.collaborateur FROM CollaborateurSession insc_confirm WHERE insc_confirm.pk.session.id_session=:idSession");
    		 q2.setParameter("idSession", idS);
    		 list_abs_current = q2.getResultList();
    	}
    	    	
		return list_abs_current;
	}
    
     
	public List<Formateur> getAllFormateurs() {
    	Query query = em.createQuery("select f from Formateur as f ORDER BY f.nom");
		return query.getResultList();
	}
    
     
	public List<ResponsableFormation> getAllResponsableFormation() {
		Query query = em.createQuery("from ResponsableFormation");
		return query.getResultList();
	}
    
     
	public Utilisateur getUtilisateurById(int idU) {
		return em.find(Utilisateur.class, idU);
	}
    
     
   	public Utilisateur getUtilisateurByIdCompte(int idCompte) {
       	Query query = em.createQuery("SELECT u FROM Utilisateur AS u WHERE u.compte.id_compte=:idCompte");
       	  query.setParameter("idCompte", idCompte);
       	  return (Utilisateur) query.getSingleResult();
   	}
    
     
    public Collaborateur getCollaborateurById(int idC) {
        return em.find(Collaborateur.class, idC);
    }
    
     
	public Formateur getFormateurById(int idF) {
		return em.find(Formateur.class, idF);
	}
    
     
	public ResponsableFormation getResponsableFormationById(int idResp_f) {
		return em.find(ResponsableFormation.class, idResp_f);
	}
    
     
    public void deleteCollaborateur(int idC) {
        Collaborateur c_from_db = getCollaborateurById(idC);
        if(c_from_db != null) {
            em.remove(c_from_db);
            em.flush();
        } else {
            System.out.println("le collaborateur n'est existe pas dans la base de données");
        }
    }
    
     
	public void deleteFormateur(int idF) {
    	Formateur f_from_db = getFormateurById(idF);
        if(f_from_db != null) {
            em.remove(f_from_db);
            em.flush();
        } else {
            System.out.println("le formateur n'est existe pas dans la base de données");
        }	
	}

	 
	public void deleteResponsableFormation(int idResp_f) {
		ResponsableFormation resp_f_from_db = getResponsableFormationById(idResp_f);
		if(resp_f_from_db != null) {
			em.remove(resp_f_from_db);
			em.flush();
		}else {
			System.out.println("le Responsable de formation n'existe pas dans la base de données");
		}
		
	}
	

}
