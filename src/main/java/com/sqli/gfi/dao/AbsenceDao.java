package com.sqli.gfi.dao;

import java.util.List;

import com.sqli.gfi.model.Absence;

public interface AbsenceDao {

	public void addAbsance(Absence abs);

	public List<Absence> getAllAbsenceBySession(int idS);

	public Absence getAbsenceById(int idAbs);

	public void deleteAbsence(int idAbs);
	
}
