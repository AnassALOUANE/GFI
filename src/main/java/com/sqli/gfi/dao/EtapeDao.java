package com.sqli.gfi.dao;

import com.sqli.gfi.model.Etape;

public interface EtapeDao {
	
	public void addEtape(Etape etape);

	public Etape getEtapeById(int idE);
	
	public void deleteEtape(int idE);

}
