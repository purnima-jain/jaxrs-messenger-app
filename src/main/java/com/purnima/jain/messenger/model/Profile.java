package com.purnima.jain.messenger.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profile {

	private Long id;
	private String profileName;
	private String firstName;
	private String lastName;
	private String created;

}
