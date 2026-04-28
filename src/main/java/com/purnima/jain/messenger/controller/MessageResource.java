package com.purnima.jain.messenger.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.purnima.jain.messenger.model.Message;
import com.purnima.jain.messenger.service.MessageService;

@Path("messenger/api/messages")
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	private MessageService messageService = new MessageService();

	@GET
	public List<Message> getAllMessages() {
		return messageService.getAllMessages();
	}
	


}
