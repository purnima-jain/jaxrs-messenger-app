package com.purnima.jain.messenger.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("messenger/api/messages")
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	@GET
	public String getMessages() {
		return "Hello World!!";
	}

}
