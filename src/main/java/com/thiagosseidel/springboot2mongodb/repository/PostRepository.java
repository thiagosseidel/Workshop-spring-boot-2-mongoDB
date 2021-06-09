package com.thiagosseidel.springboot2mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.thiagosseidel.springboot2mongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	List<Post> findByTitleContaining(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitleIgnoreCase(String text);
}
