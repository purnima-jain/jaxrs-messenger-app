package com.purnima.jain.messenger.service;

import java.util.ArrayList;
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
