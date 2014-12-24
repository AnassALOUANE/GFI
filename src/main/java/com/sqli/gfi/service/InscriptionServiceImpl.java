package com.sqli.gfi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sqli.gfi.dao.InscriptionDao;
import com.sqli.gfi.model.CollaborateurSession;
import com.sqli.gfi.model.Inscription;

@Service
@Transactional
public class InscriptionServiceImpl implements InscriptionService {
	
	@Autowired
	private InscriptionDao inscriptionDao;

	 
	public void inscrire(Inscription insc) {
		inscriptionDao.inscrire(insc);
	}
	
	 
	public void inscrirevalid(CollaborateurSession collaborateur_session) {
		inscriptionDao.inscrirevalid(collaborateur_session);
	}

	 
	@Transactional(readOnly = true)
	public Inscription getInscriptionById(int idInsc) {
		return inscriptionDao.getInscriptionById(idInsc);
	}
	
	 
	@Transactional(readOnly = true)
	public Inscription getInscriptionByCollaborateurSession(int idC, int idS) {
		return inscriptionDao.getInscriptionByCollaborateurSession(idC, idS);
	}
	
	 
	@Transactional(readOnly = true)
	public List<Inscription> getInscriptionByIdSession(int idS) {
		return inscriptionDao.getInscriptionByIdSession(idS);
	} 

	 
	public void deleteInscription(int idInsc) {
		inscriptionDao.deleteInscription(idInsc);
	}

}
