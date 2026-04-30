package com.purnima.jain.messenger;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.purnima.jain.messenger.controller.MessageResource;
import com.purnima.jain.messenger.controller.ProfileResource;

import io.muserver.MuServer;
import io.muserver.MuServerBuilder;
import io.muserver.rest.RestHandlerBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessengerApplication {

	public static void main(String[] args) {

		MessageResource messageResource = new MessageResource();
		ProfileResource profileResource = new ProfileResource();

		MuServer server = MuServerBuilder.httpServer().withHttpPort(8080)
				.addHandler(
						RestHandlerBuilder.restHandler(messageResource)
						.addCustomWriter(new JacksonJaxbJsonProvider())
						.addCustomReader(new JacksonJaxbJsonProvider())
				)
				.addHandler(
						RestHandlerBuilder.restHandler(profileResource)
						.addCustomWriter(new JacksonJaxbJsonProvider())
						.addCustomReader(new JacksonJaxbJsonProvider())
				)
				.start();

		log.info("API example: " + server.uri().resolve("/messenger/api/messages"));
	}

}