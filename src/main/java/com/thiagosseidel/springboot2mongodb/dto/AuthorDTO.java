package com.thiagosseidel.springboot2mongodb.dto;

import java.io.Serializable;

import com.thiagosseidel.springboot2mongodb.domain.User;

public class AuthorDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	
	public AuthorDTO() {
		super();
	}

	public AuthorDTO(User obj) {
		super();
		
		this.id = obj.getId();
		this.name = obj.getName();
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
}
