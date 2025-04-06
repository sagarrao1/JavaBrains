package com.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.javabrains.messenger.database.DatabaseClass;
import com.javabrains.messenger.model.Profile;

public class ProfileService {

public static Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
//		profiles.put("Sagar", new Profile(1L,"Sagar", new Date()));
//		profiles.put("Ram", new Profile(2L,"Ram", new Date()));
	}

	public List<Profile> getProfiles(){	
		return new ArrayList<Profile>( profiles.values()); 
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public void removeProfile(String profileName) {	
		System.out.println("removing.....");
		profiles.remove(profileName);
	}
	
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() +1);
		profiles.put(profile.getProfileName(), profile);
		return profile;		
	}
	
	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			System.out.println("in if condition");
			return null;
		}				
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

}