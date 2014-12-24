package com.sqli.gfi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sqli.gfi.model.Absence;

@Repository
public class AbsenceDaoImpl implements AbsenceDao {

	@PersistenceContext 
    private EntityManager em;
	
	 
	public void addAbsance(Absence abs) {
		em.merge(abs);
		em.flush();
	}

	 
	public List<Absence> getAllAbsenceBySession(int idS) {
		Query query = em.createQuery("SELECT abs FROM Absence AS abs WHERE abs.collaborateurSession.pk.session.id_session=:idS AND abs.date_abs like CONCAT(CURDATE(),'%')");	
		query.setParameter("idS", idS);
		List<Absence> list_abs = query.getResultList();
        return list_abs; 
	}

	 
	public Absence getAbsenceById(int idAbs) {
		return em.find(Absence.class, idAbs);
	}

	 
	public void deleteAbsence(int idAbs) {
		Absence abs_from_db = getAbsenceById(idAbs);
		if(abs_from_db != null) {
			em.remove(abs_from_db);
			em.flush();
		}
		
	}

}
