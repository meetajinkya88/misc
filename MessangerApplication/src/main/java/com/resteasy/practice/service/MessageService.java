package com.resteasy.practice.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.jboss.resteasy.logging.Logger;

import com.resteasy.practice.database.DatabaseClass;
import com.resteasy.practice.exception.DataNotFoundException;
import com.resteasy.practice.model.Message;



public class MessageService {

	private Map<Long, Message> messages = DatabaseClass.getMessages();
	private Logger log = Logger.getLogger(MessageService.class);

	public MessageService() {
		messages.put(1L, new Message(1, "This is Message 1", "Ajinkya"));
		messages.put(2L, new Message(2, "This is Message 2", "Raj"));
		messages.put(3L, new Message(3, "This is Message 3", "RK"));
		messages.put(4L, new Message(4, "This is Message 4", "Radhe"));
		messages.put(5L, new Message(5, "This is Message 5", "Shekar"));
	
	}
	
	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values()); 
	}
	
	public List<Message> getAllMessagesForYear(int year) {
		List<Message> messagesForYear = new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		for (Message message : messages.values()) {
			cal.setTime(message.getCreated());
			if (cal.get(Calendar.YEAR) == year) {
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size) {
		
		log.info("Start index is :" + start);
		log.info("Size is: " + size);
		System.out.println("Size is: " + size);
		
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		if (start + size > list.size()) return new ArrayList<Message>();
		return list.subList(start, start + size); 
	}
	
	
	public Message getMessage(long id) {
		Message message = messages.get(id);
		if (message == null) {
			throw new DataNotFoundException("Message with id " + id + " not found");
		}
		return message;
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
	

	
	
	
}
