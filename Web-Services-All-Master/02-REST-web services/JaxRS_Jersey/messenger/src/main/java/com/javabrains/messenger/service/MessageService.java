package com.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.javabrains.messenger.database.DatabaseClass;
import com.javabrains.messenger.exception.DataNotFoundException;
import com.javabrains.messenger.model.Message;

public class MessageService {

	public static Map<Long, Message> messages = DatabaseClass.getMessages();

//	{
//		messages.put(1L, new Message(1, "First Message", new Date(), "sagar"));
//		messages.put(2L, new Message(2, "Second Message", new Date(), "Murali"));
//		System.out.println(" MessageService constrctor is getting called");
//	}

	public List<Message> getAllMessages(){		
		return  new ArrayList<Message>(messages.values());
	}

	public List<Message> getAllmessagesForYear(int year) {
		List<Message> messagesYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for (Message message : messages.values()) {
			System.out.println("year :" +year);
			cal.setTime(message.getCreated());
			System.out.println("cal.get(Calendar.YEAR) :" +cal.get(Calendar.YEAR));
			if (cal.get(Calendar.YEAR) == year) {				
				messagesYear.add(message);
				System.out.println("year add: "+year);
			}
		}
		return messagesYear;	
	}

	public List<Message> getAllmessagesPaginated(int start, int size) {
		int count = 0;
		List<Message> messagesPaged = new ArrayList<>();
		for (Message message : messages.values()) {
			if (message.getId() >= start) {
				if (count < size) {
					messagesPaged.add(message);
					count++;
				}
			}
		}
		return messagesPaged;
	}	
//		or
		
//		List<Message> messagesPaged = new ArrayList<>(messages.values());
//		if (start + size > messagesPaged.size() ) {
//			return messagesPaged;
//		}
//		return messagesPaged.subList(start, size);
		
//	}

	public Message getMessage(long id) {
		Message message = messages.get(id);
		if (message == null) {
			throw new DataNotFoundException("Message with id : "+id+ " not found");
		}
		return message;
	}

	public Message removeMessage(long id) {
		System.out.println("removing.....");
		return messages.remove(id);
	}

	public Message addMessage(Message msg) {
		msg.setId(messages.size()+1);
		messages.put(msg.getId(), msg);
		return msg;
	}

	public Message updateMessage(Message msg) {
		if (msg.getId() <=0) {
			return null;
		}
		messages.put(msg.getId(), msg);
		return msg;
	}

}
