package com.sqli.gfi.service;

import java.util.List;

import com.sqli.gfi.model.Action;

public interface ActionService {
	
	public List<Action> getAllAction();
	public List<String> getAllActionLibelle();

	public Action getActionById(int idA);

	public void addAction(Action action);

	public void deleteAction(int idA);

}
