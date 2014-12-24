package com.sqli.gfi.service;

import java.util.List;

import com.sqli.gfi.model.Absence;

public interface AbsenceService {
	
	public void addAbsance(Absence abs);
	
	public List<Absence> getAllAbsenceBySession(int idS);
	
	public Absence getAbsenceById(int idAbs);
	
	public void deleteAbsence(int idAbs);

}
