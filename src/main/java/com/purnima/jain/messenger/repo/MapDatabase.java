package com.purnima.jain.messenger.repo;

import java.util.HashMap;
import java.util.Map;

import com.purnima.jain.messenger.model.Message;
import com.purnima.jain.messenger.model.Profile;

public class MapDatabase {

	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();

	public static Map<Long, Message> getMessages() {
		return messages;
	}

	public static Map<String, Profile> getProfiles() {
		return profiles;
	}

}
