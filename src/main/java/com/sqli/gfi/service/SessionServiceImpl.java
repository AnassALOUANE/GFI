package com.sqli.gfi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sqli.gfi.dao.SessionDao;
import com.sqli.gfi.model.SessionF;

@Service
@Transactional
public class SessionServiceImpl implements SessionService {

	@Autowired
	private SessionDao sessionDao; 
	
	 
	public void addSession(SessionF s) {
		sessionDao.addSession(s);
	}

	 
	@Transactional(readOnly = true)
	public SessionF getSessionById(int idS) {
		return sessionDao.getSessionById(idS);
	}
	
	 
	public List<SessionF> getAllSessionByFormateur(int idFormateur) {
		return sessionDao.getAllSessionByFormateur(idFormateur);
	}

	 
	public void deleteSession(int idS) {
		sessionDao.deleteSession(idS);
	}

}
