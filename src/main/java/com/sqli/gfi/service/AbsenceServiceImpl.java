package com.sqli.gfi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sqli.gfi.dao.AbsenceDao;
import com.sqli.gfi.model.Absence;

@Service
@Transactional
public class AbsenceServiceImpl implements AbsenceService{

	@Autowired
	private AbsenceDao absenceDao;
	
	 
	public void addAbsance(Absence abs) {
		absenceDao.addAbsance(abs);
	}

	 
	@Transactional(readOnly = true)
	public List<Absence> getAllAbsenceBySession(int idS) {
		return absenceDao.getAllAbsenceBySession(idS);
	}

	 
	@Transactional(readOnly = true)
	public Absence getAbsenceById(int idAbs) {
		return absenceDao.getAbsenceById(idAbs);
	}

	 
	public void deleteAbsence(int idAbs) {
		absenceDao.deleteAbsence(idAbs);
	}

}
