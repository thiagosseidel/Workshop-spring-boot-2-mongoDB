package com.thiagosseidel.springboot2mongodb.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagosseidel.springboot2mongodb.domain.Post;
import com.thiagosseidel.springboot2mongodb.repository.PostRepository;
import com.thiagosseidel.springboot2mongodb.servicies.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public PostService() {
		super();
	}
	
	public List<Post> findAll() {
		
		return repo.findAll();
	}

	public Post findById(String id) {
		
		Optional<Post> optPost = repo.findById(id); 
		
		return optPost.orElseThrow(() -> new ObjectNotFoundException("Object not found."));
	}
	
	public List<Post> findByTitle(String text) {
		
		return repo.findByTitleContaining(text);
	}
	
	public List<Post> findByTitleIgnoreCase(String text) {
		
		return repo.findByTitleContainingIgnoreCase(text);
	}
}
