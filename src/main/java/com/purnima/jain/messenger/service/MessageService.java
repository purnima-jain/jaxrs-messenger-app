package com.purnima.jain.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.purnima.jain.messenger.model.Message;
import com.purnima.jain.messenger.repo.MapDatabase;

public class MessageService {

	private Map<Long, Message> messages = MapDatabase.getMessages();

	public MessageService() {
		messages.put(1L, new Message(1L, "Hello World!", new Date(), "John"));
		messages.put(2L, new Message(2L, "Hello Jersey!", new Date(), "Jane"));
	}

	public List<Message> getAllMessages() {
		return new ArrayList<>(messages.values());
	}

	public List<Message> getAllMessagesForYear(Integer year) {
		List<Message> messagesForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for (Message message : messages.values()) {
			cal.setTime(message.getCreated());
			if (cal.get(Calendar.YEAR) == year) {
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}

	public List<Message> getAllMessagesPaginated(Integer start, Integer size) {
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		if(start + size > list.size()) return new ArrayList<>(); // This is incorrect code
		return list.subList(start, start + size);
	}

	public Message getMessage(Long id) {
		return messages.get(id);
	}

	public Message addMessage(Message message) {
		message.setId(Long.valueOf(messages.size() + 1));
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

	public Message removeMessage(Long id) {
		return messages.remove(id);
	}

}
