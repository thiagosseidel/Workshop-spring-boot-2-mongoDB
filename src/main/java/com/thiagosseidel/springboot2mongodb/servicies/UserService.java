package com.thiagosseidel.springboot2mongodb.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagosseidel.springboot2mongodb.domain.User;
import com.thiagosseidel.springboot2mongodb.repository.UserRepository;
import com.thiagosseidel.springboot2mongodb.servicies.exception.ObjectNotFoundException;

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

	public User findById(String id) {
		
		Optional<User> optUser = repo.findById(id); 
		
		return optUser.orElseThrow(() -> new ObjectNotFoundException("Object not found."));
	}
}
