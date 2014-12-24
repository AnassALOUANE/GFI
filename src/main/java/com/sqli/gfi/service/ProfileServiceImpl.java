package com.sqli.gfi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sqli.gfi.dao.ProfileDao;
import com.sqli.gfi.model.Profile;

@Service
@Transactional
public class ProfileServiceImpl implements ProfileService {
	@Autowired 
	private ProfileDao profileDao;

	 
	public List<Profile> getAllProfiles() {
		return profileDao.getAllProfiles();
	}

	 
	public Profile getByProfileById(int idP) {
		return profileDao.getByProfileById(idP);
	}

	 
	public void addProfile(Profile p) {
		profileDao.addProfile(p);
	}

	 
	public void deleteProfile(int idP) {
		profileDao.deleteProfile(idP);
		
	}
	

}
