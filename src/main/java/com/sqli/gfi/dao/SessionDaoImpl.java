package com.sqli.gfi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sqli.gfi.model.SessionF;

@Repository
public class SessionDaoImpl implements SessionDao {

	@PersistenceContext 
    private EntityManager em;
	
	 
	public void addSession(SessionF s) {
		em.merge(s);
		em.flush();
	}

	 
	public SessionF getSessionById(int idS) {
		return em.find(SessionF.class, idS);
	}
	
	 
	public List<SessionF> getAllSessionByFormateur(int idFormateur) {
		Query query = em.createQuery("SELECT s FROM SessionF AS s WHERE s.formateur.id_u=:idFormateur");
		query.setParameter("idFormateur", idFormateur);
        return query.getResultList(); 
	}

	 
	public void deleteSession(int idS) {
		SessionF s_form_db = getSessionById(idS);
		if(s_form_db != null){
			em.remove(s_form_db);
			em.flush();
		}
		
	}

}
