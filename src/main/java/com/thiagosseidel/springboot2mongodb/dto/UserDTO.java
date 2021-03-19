package com.thiagosseidel.springboot2mongodb.dto;

import java.io.Serializable;

import com.thiagosseidel.springboot2mongodb.domain.User;

public class UserDTO  implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String email;
	
	
	public UserDTO() {
		super();
	}
	
	public UserDTO(User user) {
		super();
		
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
