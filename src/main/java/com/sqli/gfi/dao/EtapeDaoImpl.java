package com.sqli.gfi.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.sqli.gfi.model.Etape;

@Repository
public class EtapeDaoImpl implements EtapeDao {

	@PersistenceContext
	private EntityManager em;
	
	 
	public void addEtape(Etape etape) {
		em.merge(etape);
		em.flush();
	}

	 
	public Etape getEtapeById(int idE) {
		return em.find(Etape.class, idE);
	}

	 
	public void deleteEtape(int idE) {
		Etape e_from_db = getEtapeById(idE);
		if(e_from_db != null) {
			em.remove(e_from_db);
			em.flush();
		}
		
	}

}
