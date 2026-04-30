package com.purnima.jain.messenger.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.purnima.jain.messenger.model.Message;
import com.purnima.jain.messenger.service.MessageService;

@Path("/messenger/api/messages")
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	private MessageService messageService = new MessageService();

	// While JAX-RS does not typically dispatch to different methods based purely on the presence of query parameters, 
	// you can use a single @GET method and retrieve parameters using the @QueryParam annotation to branch logic internally.	
	@GET
	public List<Message> getMessages(@QueryParam("year") Integer year, @QueryParam("start") Integer start, @QueryParam("size") Integer size) {
		
		if(year != null && year > 0) {
			return messageService.getAllMessagesForYear(year);
		}
		
		if(start != null && start > 0 && size != null && size > 0) {
			return messageService.getAllMessagesPaginated(start, size);
		}

		return messageService.getAllMessages();
	}

//	// This does not work deterministically, you can only have one method annotated with @GET.
//	@GET
//	public List<Message> getAllMessagesForYear(@QueryParam("year") Integer year) {
//		log.info("Inside getAllMessagesForYear()....Year :: {}", year);
//		return messageService.getAllMessagesForYear(year);
//	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message) {
		return messageService.addMessage(message);
	}

	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") Long messageId, Message message) {
		message.setId(messageId);
		return messageService.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") Long messageId) {
		messageService.removeMessage(messageId);
	}

	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") Long messageId) {
		return messageService.getMessage(messageId);
	}

}
