package com.sqli.gfi.dao;

import java.util.List;
import java.util.Map;

import com.sqli.gfi.model.Action;

public interface ActionDao {
	
	public List<Action> getAllAction();
	public List<String> getAllActionLibelle();

	public Action getActionById(int idA);

	public void addAction(Action action);

	public void deleteAction(int idA);

}
