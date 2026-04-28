package com.purnima.jain.messenger.service;

import java.util.Date;
import java.util.List;

import com.purnima.jain.messenger.model.Message;

public class MessageService {

	public List<Message> getAllMessages() {
		Message m1 = new Message(1L, "Hello World!", new Date(), "John");
		Message m2 = new Message(2L, "Hello Jersey!", new Date(), "Jane");

		List<Message> messages = List.of(m1, m2);

		return messages;
	}

}
