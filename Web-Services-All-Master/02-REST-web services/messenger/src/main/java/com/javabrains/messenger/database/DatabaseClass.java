package com.javabrains.messenger.database;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.javabrains.messenger.model.Message;
import com.javabrains.messenger.model.Profile;

public class DatabaseClass {

	private static Map<Long, Message> messages= new HashMap<>();
	private static Map<String, Profile> profiles= new HashMap<>();
	
	
	public static Map<String, Profile> getProfiles(){
		return profiles;
	}
	
	public static Map<Long, Message> getMessages(){
		messages.put(1L, new Message(1, "First Message", new Date(), "sagar"));
		messages.put(2L, new Message(2, "Second Message", new Date(100, 12, 02), "Murali"));
		System.out.println(" DatabaseClass is getting called");
		return messages;
	}
	
}
