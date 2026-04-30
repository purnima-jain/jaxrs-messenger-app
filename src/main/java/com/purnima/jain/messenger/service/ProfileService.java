package com.purnima.jain.messenger.service;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.purnima.jain.messenger.model.Profile;
import com.purnima.jain.messenger.repo.MapDatabase;

public class ProfileService {

	private Map<String, Profile> profiles = MapDatabase.getProfiles();
	
	public ProfileService() {
		profiles.put("jane_doe", new Profile(1L, "jane_doe", "Jane", "Doe", new Date()));
	}

	public List<Profile> getAllProfiles() {
		return new ArrayList<>(profiles.values());
	}

	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}

	public Profile addProfile(Profile profile) {
		profile.setId(Long.valueOf(profiles.size() + 1));
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile updateProfile(Profile profile) {
		if (profile.getId() <= 0) {
			return null;
		}

		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}

}
