package com.sqli.gfi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sqli.gfi.model.Compte;
import com.sqli.gfi.model.Utilisateur;

@Repository
public class CompteDaoImpl implements CompteDao {

	@PersistenceContext 
	private EntityManager em;
	
	 
	public void updateCompte(Compte c) {
		em.merge(c);
		em.flush();
	}
	
	 
	public List<Compte> getAllCompte() {
		Query query = em.createQuery("from Compte");
		List<Compte> listCompte = query.getResultList();
		for(Compte c : listCompte)
			System.out.println(c);
		return listCompte;
	}

	 
	public Compte getCompteById(int idC) {
		return em.find(Compte.class, idC);
	}
	
	 
	public Integer getIdCompteByLogin(String login) {
		Query query = em.createQuery("SELECT c.id_compte FROM Compte AS c WHERE c.login=:login");
     	query.setParameter("login", login);
     	return (Integer) query.getSingleResult();
	}


	 
	public void deleteCompte(int idC) {
		Compte c_from_db = getCompteById(idC);
		if(c_from_db != null) {
			em.remove(c_from_db);
		}
	}


}
