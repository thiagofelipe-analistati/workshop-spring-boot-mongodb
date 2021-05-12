package com.thiagofelipe.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.thiagofelipe.workshopmongo.dominio.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	List<Post> findByTituloContainingIgnoreCase(String texto);
	@Query("{'titulo': {$regex: ?0, $options: 'i'}}")
	List<Post> SearchTitulo(String texto);
}
