package com.sqli.gfi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sqli.gfi.model.CollaborateurSession;
import com.sqli.gfi.model.Inscription;

@Repository
public class InscriptionDaoImpl implements InscriptionDao {

	@PersistenceContext
	private EntityManager em;
	
	 
	public void inscrire(Inscription insc) {
		em.merge(insc);
		em.flush();
	}
	
	 
	public void inscrirevalid(CollaborateurSession collaborateur_session) {
		em.merge(collaborateur_session);
		em.flush();
	}	

	 
	public Inscription getInscriptionById(int idInsc) {		
		return em.find(Inscription.class, idInsc);
	}
	
	 
	public Inscription getInscriptionByCollaborateurSession(int idC, int idS) {
		Query query = em.createQuery("select insc from Inscription as insc where insc.collaborateur.id_u=:idC and insc.session.id_session=:idS");
		query.setParameter("idC", idC);
		query.setParameter("idS", idS);
		return (Inscription) query.getSingleResult();
	}
		
	 
	public List<Inscription> getInscriptionByIdSession(int idS) {
		Query query = em.createQuery("select insc from Inscription as insc where insc.session.id_session=:idS");
		query.setParameter("idS", idS);
		return query.getResultList();
	}

	 
	public void deleteInscription(int idInsc) {
		Inscription insc_from_db = getInscriptionById(idInsc);
		if(insc_from_db != null) {
			em.remove(insc_from_db);
			em.flush();
		}
		
	}

}
