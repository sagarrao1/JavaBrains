package com.javabrains.messenger.database;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.javabrains.messenger.model.Comment;
import com.javabrains.messenger.model.Message;
import com.javabrains.messenger.model.Profile;

public class DatabaseClass {

	public static Map<Long,Message> messages= new HashMap<Long, Message>();
	public static Map<Long,Comment> comments= new HashMap<Long, Comment>();
	public static Map<String,Profile> profiles= new HashMap<String, Profile>();
	
	public static Map<Long,Message> getMessages(){
		messages.put(1L, new Message(1, "First Message", new Date(), "sagar"));
		messages.put(2L, new Message(2, "Second Message", new Date(100, 12, 02), "Murali"));
		System.out.println(" DatabaseClass is getting called");
		return messages;
	}
	
	public static Map<String,Profile> getProfiles(){
		profiles.put("Sagar", new Profile(1L,"Sagar", new Date()));
		profiles.put("Ram", new Profile(2L,"Ram", new Date()));
		return profiles;
	}
	
	public static Map<Long,Comment> getComments(){
		comments.put(1L, new Comment(1, "First Comment", new Date())  );
		comments.put(2L, new Comment(2, "Second Comment", new Date(100, 12, 02)));		
		return comments;
	}
	
}
