package com.thiagosseidel.springboot2mongodb.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagosseidel.springboot2mongodb.domain.User;
import com.thiagosseidel.springboot2mongodb.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public UserService() {
		super();
	}
	
	public List<User> findAll() {
		
		return repo.findAll();
	}

}
