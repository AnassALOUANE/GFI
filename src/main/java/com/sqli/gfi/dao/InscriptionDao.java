package com.sqli.gfi.dao;

import java.util.List;

import com.sqli.gfi.model.CollaborateurSession;
import com.sqli.gfi.model.Inscription;

public interface InscriptionDao {

	public void inscrire(Inscription insc);
	
	public void inscrirevalid(CollaborateurSession collaborateur_session);
	
	public Inscription getInscriptionById(int idInsc);
	
	public Inscription getInscriptionByCollaborateurSession(int idC, int idS);
	
	public  List<Inscription>  getInscriptionByIdSession(int idS);
	
	public void deleteInscription(int idInsc);
	
}
