package com.resteasy.practice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.resteasy.practice.database.DatabaseClass;
import com.resteasy.practice.model.Profile;



public class ProfileService {

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("Ajinkya", new Profile(1L, "Ajinkya", "Ajinkya", "Bambal"));
		profiles.put("Raj", new Profile(1L, "Raj", "Raj", "Kamal"));

	}
	
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values()); 
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
	
	
}
