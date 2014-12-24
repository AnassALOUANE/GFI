package com.sqli.gfi.dao;

import java.util.List;

import com.sqli.gfi.model.Formation;

public interface FormationDao {
	
	public void addFormation(Formation f);

	public List<Formation> getAllFormations();

	public Formation getFormationById(int idF);

	public void deleteFormation(int idF);

}
