package com.sqli.gfi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sqli.gfi.dao.ActionDao;
import com.sqli.gfi.model.Action;

@Service
@Transactional	
public class ActionServiceImpl implements ActionService {

	@Autowired
	private ActionDao actionDao; 
	
	 
	public List<Action> getAllAction() {
		return actionDao.getAllAction() ;
	}
	
	 
	public List<String> getAllActionLibelle() {
		return actionDao.getAllActionLibelle();
	}

	 
	public Action getActionById(int idA) {
		return actionDao.getActionById(idA);
	}

	 
	public void addAction(Action action) {
		actionDao.addAction(action);
	}

	 
	public void deleteAction(int idA) {
		actionDao.deleteAction(idA);
	}

}
