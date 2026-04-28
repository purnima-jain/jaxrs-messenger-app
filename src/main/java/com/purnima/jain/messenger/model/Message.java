package com.purnima.jain.messenger.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

	private long id;
	private String message;
	private Date created;
	private String author;

}
