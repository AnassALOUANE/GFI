package com.sqli.gfi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sqli.gfi.model.Formation;

@Repository
public class FormationDaoImpl implements FormationDao {

	@PersistenceContext 
	private EntityManager em;
	
	 
	public void addFormation(Formation f) {
		em.merge(f);
		em.flush();
	}

	 
	public List<Formation> getAllFormations() {
		Query query = em.createQuery("select f from Formation as f");
 		return query.getResultList();
	}

	 
	public Formation getFormationById(int idF) {
 		return em.find(Formation.class, idF);
	}

	 
	public void deleteFormation(int idF) {
 		Formation f_from_db = getFormationById(idF);
 		if(f_from_db != null) {
 			em.remove(f_from_db);
 			em.flush();
 		}
	}

}
