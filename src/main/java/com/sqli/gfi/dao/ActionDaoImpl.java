package com.sqli.gfi.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sqli.gfi.model.Action;
@Repository
public class ActionDaoImpl implements ActionDao {

	@PersistenceContext 
	private EntityManager em;
	
	 
	public List<Action> getAllAction() {
		Query query = em.createQuery("SELECT ac FROM Action AS ac ORDER BY ac.profile");
		List<Action> listAction = query.getResultList();
		return listAction;
	}
	
	 
	public List<String> getAllActionLibelle() {
		Query query = em.createQuery("SELECT DISTINCT ac.libelle FROM Action AS ac ORDER BY ac.libelle");
		List<String> listDestintAction = query.getResultList();
		return listDestintAction;
	}
//	SELECT DISTINCT c.currency FROM Country AS c
//	SELECT c.name FROM Country AS c
	 
	public Action getActionById(int idA) {
		return em.find(Action.class, idA);
	}

	 
	public void addAction(Action action) {
		em.merge(action);
		em.flush();
	}

	 
	public void deleteAction(int idA) {
		Action action_from_db = getActionById(idA);
		if(action_from_db != null) {
			em.remove(action_from_db);
			em.flush();
		} else {
			System.out.println("l'action demandée n'existe pas dans la base de données");
		}
	}	

}
