package com.sqli.gfi.service;

import java.util.List;
import com.sqli.gfi.model.Profile;

public interface ProfileService {

	public List<Profile> getAllProfiles();

	public Profile getByProfileById(int idP);

	public void addProfile(Profile p);

	public void deleteProfile(int idP);

}
