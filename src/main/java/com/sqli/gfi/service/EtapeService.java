package com.sqli.gfi.service;

import com.sqli.gfi.model.Etape;


public interface EtapeService {

	public void addEtape(Etape etape);

	public Etape getEtapeById(int idE);
	
	public void deleteEtape(int idE);
	
}
