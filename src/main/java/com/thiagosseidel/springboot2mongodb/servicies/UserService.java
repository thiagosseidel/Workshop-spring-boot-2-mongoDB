package com.thiagosseidel.springboot2mongodb.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagosseidel.springboot2mongodb.domain.User;
import com.thiagosseidel.springboot2mongodb.dto.UserDTO;
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
	
	public User insert(User obj) {
		
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		
		findById(id);
		
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		
		Optional<User> optUser = repo.findById(obj.getId()); 
		
		User newObj = optUser.get();
		
		updateData(newObj, obj);
		
		return repo.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {

		newObj.setId(obj.getId());
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO objDto) {
		
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
