package com.sqli.gfi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sqli.gfi.dao.EtapeDao;
import com.sqli.gfi.model.Etape;

@Service
@Transactional
public class EtapeServiceImpl implements EtapeService {

	@Autowired
	private EtapeDao etapeDao;
	
	 
	public void addEtape(Etape etape) {
		etapeDao.addEtape(etape);
	}

	 
	@Transactional(readOnly = true)
	public Etape getEtapeById(int idE) {
		return etapeDao.getEtapeById(idE);
	}

	 
	public void deleteEtape(int idE) {
		etapeDao.deleteEtape(idE);		
	}

}
