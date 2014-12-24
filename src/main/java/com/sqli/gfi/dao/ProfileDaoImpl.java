package com.sqli.gfi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sqli.gfi.model.Profile;

@Repository
public class ProfileDaoImpl implements ProfileDao {
	@PersistenceContext 
	private EntityManager em;

	 
	public List<Profile> getAllProfiles() {
		Query query = em.createQuery("select p from Profile p ORDER BY p.titre");
		return query.getResultList();
	}

	 
	public Profile getByProfileById(int idP) {
		
		return em.find(Profile.class, idP);
	}

	 
	public void addProfile(Profile p) {
		em.merge(p);
		em.flush();		
	}

	 
	public void deleteProfile(int idP) {
		Profile p_from_db = getByProfileById(idP);
		if(p_from_db != null) {
			em.remove(p_from_db);
			em.flush();
		} else {
			System.out.println("le profile n'existe pas dans la base de données");
		}
				
	} 
	
}
