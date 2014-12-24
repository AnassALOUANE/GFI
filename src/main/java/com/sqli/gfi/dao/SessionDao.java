package com.sqli.gfi.dao;

import java.util.List;

import com.sqli.gfi.model.SessionF;

public interface SessionDao {
	
	public void addSession(SessionF s);

	public SessionF getSessionById(int idS);
	
	public List<SessionF> getAllSessionByFormateur(int idFormateur);

	public void deleteSession(int idS);

}
