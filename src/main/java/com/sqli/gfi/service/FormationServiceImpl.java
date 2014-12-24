package com.sqli.gfi.service;

import java.util.List;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sqli.gfi.dao.FormationDao;
import com.sqli.gfi.model.Formation;

@Service
@Transactional
public class FormationServiceImpl implements FormationService {

	@Autowired
	private FormationDao formationDao; 
	
	 
	public void addFormation(Formation f) {
 		formationDao.addFormation(f);
	}

	 
	@Transactional(readOnly = true)
	public List<Formation> getAllFormations() {
 		return formationDao.getAllFormations();
	}

	 
	@Transactional(readOnly = true)
	public Formation getFormationById(int idF) {
 		return formationDao.getFormationById(idF);
	}

	 
	public void deleteFormation(int idF) {
 		formationDao.deleteFormation(idF);
	}

}
