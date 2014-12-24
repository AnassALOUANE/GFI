package com.sqli.gfi.service;

import java.util.List;

import com.sqli.gfi.model.Compte;

public interface CompteService {
	
	public void updateCompte(Compte c);

	public List<Compte> getAllCompte();
	
	public Compte getCompteById(int idC);
	
	public Integer getIdCompteByLogin(String login);
	
	public void deleteCompte(int idC);
	
	
	

}
